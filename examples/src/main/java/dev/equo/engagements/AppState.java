package dev.equo.engagements;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import dev.equo.engagements.model.Client;
import dev.equo.engagements.model.Deliverable;
import dev.equo.engagements.model.DeliverableStatus;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.EngagementStatus;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.model.TimeEntry;

/**
 * In-memory store + notifier for the whole POC. Screens observe {@link #addListener}
 * and get called back whenever any mutator runs. Every mutation records a single
 * undo step so a SnackBar action can revert it.
 */
public class AppState {

  private final LinkedHashMap<String, Client> clients = new LinkedHashMap<>();
  private final LinkedHashMap<String, Person> people = new LinkedHashMap<>();
  private final LinkedHashMap<String, Engagement> engagements = new LinkedHashMap<>();
  private final LinkedHashMap<String, Deliverable> deliverables = new LinkedHashMap<>();
  private final ArrayList<TimeEntry> timeEntries = new ArrayList<>();

  private final LinkedHashSet<String> openTabs = new LinkedHashSet<>();
  private int activeTabIndex = 0;
  private boolean darkMode = false;

  private final Deque<UndoOp> undoStack = new ArrayDeque<>();
  private final List<Runnable> dataListeners = new ArrayList<>();
  private final List<Runnable> structuralListeners = new ArrayList<>();

  private long ids = 1000;

  public String nextId(String prefix) { return prefix + "-" + (++ids); }

  /** Called on any mutation. Screens use this to rebuild their content. */
  public void addDataListener(Runnable r) { dataListeners.add(r); }
  public void removeDataListener(Runnable r) { dataListeners.remove(r); }

  /**
   * Called on changes that alter tab structure or theme — i.e. things the
   * root shell must re-render. Kept separate so a deliverable status flip
   * doesn't rebuild the AppShell and reset the visible tab.
   */
  public void addStructuralListener(Runnable r) { structuralListeners.add(r); }
  public void removeStructuralListener(Runnable r) { structuralListeners.remove(r); }

  private void notifyData() {
    for (Runnable r : new ArrayList<>(dataListeners)) r.run();
  }
  private void notifyStructural() {
    for (Runnable r : new ArrayList<>(structuralListeners)) r.run();
    notifyData();
  }

  // --- seed helpers (used by SeedData) -------------------------------------

  public void putClient(Client c) { clients.put(c.id(), c); }
  public void putPerson(Person p) { people.put(p.id(), p); }
  public void putEngagement(Engagement e) { engagements.put(e.id(), e); }
  public void putDeliverable(Deliverable d) { deliverables.put(d.id(), d); }
  public void addTimeEntryRaw(TimeEntry t) { timeEntries.add(t); }

  // --- read side -----------------------------------------------------------

  public List<Client> clients() {
    return clients.values().stream()
        .sorted(Comparator.comparing(Client::name, String.CASE_INSENSITIVE_ORDER))
        .toList();
  }
  public Client client(String id) { return clients.get(id); }

  public List<Person> people() {
    return people.values().stream()
        .sorted(Comparator.comparing(Person::name, String.CASE_INSENSITIVE_ORDER))
        .toList();
  }
  public Person person(String id) { return people.get(id); }

  public List<Engagement> engagements() {
    return engagements.values().stream()
        .sorted(Comparator.comparing(Engagement::name, String.CASE_INSENSITIVE_ORDER))
        .toList();
  }
  public Engagement engagement(String id) { return engagements.get(id); }

  public List<Engagement> engagementsForClient(String clientId) {
    return engagements.values().stream()
        .filter(e -> e.clientId().equals(clientId))
        .sorted(Comparator.comparing(Engagement::start).reversed())
        .toList();
  }

  public List<Deliverable> deliverablesFor(String engagementId) {
    return deliverables.values().stream()
        .filter(d -> d.engagementId().equals(engagementId))
        .sorted(Comparator.comparing(Deliverable::due))
        .toList();
  }

  public List<Deliverable> deliverablesDue(LocalDate from, LocalDate toInclusive) {
    return deliverables.values().stream()
        .filter(d -> !d.due().isBefore(from) && !d.due().isAfter(toInclusive))
        .sorted(Comparator.comparing(Deliverable::due))
        .toList();
  }

  public List<TimeEntry> timeEntriesFor(String engagementId) {
    return timeEntries.stream()
        .filter(t -> t.engagementId().equals(engagementId))
        .sorted(Comparator.comparing(TimeEntry::day).reversed())
        .toList();
  }

  public List<TimeEntry> allTimeEntries() {
    return timeEntries.stream()
        .sorted(Comparator.comparing(TimeEntry::day).reversed())
        .toList();
  }

  public double hoursOnEngagement(String engagementId) {
    return timeEntries.stream()
        .filter(t -> t.engagementId().equals(engagementId))
        .mapToDouble(TimeEntry::hours).sum();
  }

  public double hoursBilledOn(String engagementId) {
    return timeEntries.stream()
        .filter(t -> t.engagementId().equals(engagementId) && t.billed())
        .mapToDouble(TimeEntry::hours).sum();
  }

  public double weekHours(String personId, boolean billedOnly) {
    LocalDate mon = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    LocalDate sun = mon.plusDays(6);
    return timeEntries.stream()
        .filter(t -> t.personId().equals(personId))
        .filter(t -> !t.day().isBefore(mon) && !t.day().isAfter(sun))
        .filter(t -> !billedOnly || t.billed())
        .mapToDouble(TimeEntry::hours).sum();
  }

  /** Monday of the current week (client-clock). */
  public LocalDate weekStart() {
    return LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
  }

  /** Hours logged per day (Mon..Sun, length 7) for one person, current week. */
  public double[] weeklyHoursPerDay(String personId) {
    LocalDate mon = weekStart();
    double[] out = new double[7];
    for (TimeEntry t : timeEntries) {
      if (!t.personId().equals(personId)) continue;
      int idx = (int) java.time.temporal.ChronoUnit.DAYS.between(mon, t.day());
      if (idx >= 0 && idx < 7) out[idx] += t.hours();
    }
    return out;
  }

  /** Hours logged this week per engagement, ordered by hours desc. */
  public Map<String, Double> weekHoursByEngagement(String personId) {
    LocalDate mon = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    LocalDate sun = mon.plusDays(6);
    LinkedHashMap<String, Double> out = new LinkedHashMap<>();
    timeEntries.stream()
        .filter(t -> t.personId().equals(personId))
        .filter(t -> !t.day().isBefore(mon) && !t.day().isAfter(sun))
        .sorted(Comparator.comparingDouble(TimeEntry::hours).reversed())
        .forEach(t -> out.merge(t.engagementId(), t.hours(), Double::sum));
    return out;
  }

  // --- tab management ------------------------------------------------------

  public List<String> openEngagementIds() { return List.copyOf(openTabs); }
  public int activeTabIndex() { return activeTabIndex; }
  public void setActiveTab(int idx) {
    if (idx < 0 || idx > openTabs.size()) return;
    activeTabIndex = idx;
    notifyStructural();
  }
  /** 0 = Home; 1..n = engagement tab in {@link #openEngagementIds()} order. */
  public void openEngagementTab(String engagementId) {
    openTabs.add(engagementId);
    activeTabIndex = new ArrayList<>(openTabs).indexOf(engagementId) + 1;
    notifyStructural();
  }
  public void closeEngagementTab(String engagementId) {
    List<String> ids = new ArrayList<>(openTabs);
    int idx = ids.indexOf(engagementId);
    if (idx < 0) return;
    openTabs.remove(engagementId);
    activeTabIndex = Math.min(idx, openTabs.size());
    notifyStructural();
  }
  public void closeActiveTab() {
    if (activeTabIndex == 0) return;
    List<String> ids = new ArrayList<>(openTabs);
    if (activeTabIndex - 1 < ids.size()) closeEngagementTab(ids.get(activeTabIndex - 1));
  }

  // --- theme ---------------------------------------------------------------

  public boolean darkMode() { return darkMode; }
  public void toggleDarkMode() { darkMode = !darkMode; notifyStructural(); }

  // --- mutations (each records one undo op) --------------------------------

  public void setDeliverableStatus(String deliverableId, DeliverableStatus next) {
    Deliverable d = deliverables.get(deliverableId);
    if (d == null || d.status() == next) return;
    DeliverableStatus prev = d.status();
    deliverables.put(deliverableId, d.withStatus(next));
    pushUndo("Deliverable status", () -> {
      Deliverable cur = deliverables.get(deliverableId);
      if (cur != null) deliverables.put(deliverableId, cur.withStatus(prev));
    });
    notifyData();
  }

  public void setEngagementStatus(String engagementId, EngagementStatus next) {
    Engagement e = engagements.get(engagementId);
    if (e == null || e.status() == next) return;
    EngagementStatus prev = e.status();
    engagements.put(engagementId, e.withStatus(next));
    pushUndo("Engagement status", () -> {
      Engagement cur = engagements.get(engagementId);
      if (cur != null) engagements.put(engagementId, cur.withStatus(prev));
    });
    notifyData();
  }

  public TimeEntry logTime(String engagementId, String personId, LocalDate day, double hours, String note) {
    TimeEntry t = new TimeEntry(nextId("t"), engagementId, personId, day, hours, note, false);
    timeEntries.add(t);
    pushUndo("Time entry", () -> timeEntries.removeIf(x -> x.id().equals(t.id())));
    notifyData();
    return t;
  }

  public Engagement createEngagement(String clientId, String name,
                                     LocalDate start, LocalDate targetEnd,
                                     String leadPersonId, List<String> teamIds,
                                     double budgetHours) {
    Engagement e = new Engagement(nextId("e"), clientId, name, EngagementStatus.proposed,
        start, targetEnd, List.copyOf(teamIds), leadPersonId, budgetHours);
    engagements.put(e.id(), e);
    pushUndo("Engagement", () -> {
      engagements.remove(e.id());
      openTabs.remove(e.id());
      activeTabIndex = Math.min(activeTabIndex, openTabs.size());
    });
    notifyData();
    return e;
  }

  // --- undo ----------------------------------------------------------------

  private record UndoOp(String label, Runnable undo) {}
  private void pushUndo(String label, Runnable r) { undoStack.push(new UndoOp(label, r)); }
  public Optional<String> peekUndoLabel() {
    return undoStack.isEmpty() ? Optional.empty() : Optional.of(undoStack.peek().label());
  }
  public void undoLast() {
    if (undoStack.isEmpty()) return;
    undoStack.pop().undo().run();
    notifyData();
  }

  // --- misc ---------------------------------------------------------------

  public static String titleCase(Enum<?> e) {
    String s = e.name().replaceAll("([a-z])([A-Z])", "$1 $2");
    return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase(Locale.ROOT);
  }
}
