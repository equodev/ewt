package dev.equo.engagements.data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Random;

import dev.equo.engagements.AppState;
import dev.equo.engagements.model.Client;
import dev.equo.engagements.model.Deliverable;
import dev.equo.engagements.model.DeliverableStatus;
import dev.equo.engagements.model.Engagement;
import dev.equo.engagements.model.EngagementStatus;
import dev.equo.engagements.model.Person;
import dev.equo.engagements.model.TimeEntry;

/** Populates an AppState with a plausible professional-services dataset. */
public final class SeedData {

  private SeedData() {}

  public static AppState build() {
    AppState s = new AppState();
    LocalDate today = LocalDate.now();
    LocalDate mondayThisWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

    // --- clients ---
    Client c1 = new Client("c-01", "Aureliano Vineyards", "Agriculture", "Pedro Aureliano", "pedro@aureliano.example");
    Client c2 = new Client("c-02", "Northline Logistics", "Logistics", "Anna Fenwick", "anna.fenwick@northline.example");
    Client c3 = new Client("c-03", "Petraeus Legal", "Legal", "Constanza Vidal", "cvidal@petraeus.example");
    Client c4 = new Client("c-04", "Sable & Roche Accounting", "Finance", "Miguel Roche", "miguel@sableroche.example");
    Client c5 = new Client("c-05", "Cordillera Health", "Healthcare", "Elena Salaverry", "esalaverry@cordillera.example");
    for (Client c : List.of(c1, c2, c3, c4, c5)) s.putClient(c);

    // --- people ---
    Person p1 = new Person("p-01", "Marta Álvarez", "Managing Partner", 40);
    Person p2 = new Person("p-02", "Diego Herrera", "Senior Consultant", 40);
    Person p3 = new Person("p-03", "Sofía Ríos", "Consultant", 40);
    Person p4 = new Person("p-04", "Julián Ferreyra", "Analyst", 35);
    Person p5 = new Person("p-05", "Camila Duarte", "Senior Consultant", 40);
    Person p6 = new Person("p-06", "Ignacio Vera", "Consultant", 40);
    Person p7 = new Person("p-07", "Renata López", "Analyst", 30);
    Person p8 = new Person("p-08", "Bruno Salgado", "Practice Manager", 35);
    for (Person p : List.of(p1, p2, p3, p4, p5, p6, p7, p8)) s.putPerson(p);

    // --- engagements ---
    List<Engagement> es = List.of(
        eng("e-201", c1.id(), "Harvest Ops Rework",         EngagementStatus.active,    today.minusDays(35), today.plusDays(30),  p2.id(), List.of(p2.id(), p3.id(), p4.id()), 240),
        eng("e-202", c1.id(), "Q3 Board Deck",              EngagementStatus.completed, today.minusDays(90), today.minusDays(10), p1.id(), List.of(p1.id(), p5.id()),          80),
        eng("e-203", c2.id(), "Fleet TMS Migration",        EngagementStatus.active,    today.minusDays(45), today.plusDays(60),  p5.id(), List.of(p5.id(), p6.id(), p7.id()), 420),
        eng("e-204", c2.id(), "Cost Audit",                 EngagementStatus.active,    today.minusDays(20), today.plusDays(14),  p8.id(), List.of(p8.id(), p4.id()),         120),
        eng("e-205", c3.id(), "Case Management Rollout",    EngagementStatus.active,    today.minusDays(28), today.plusDays(45),  p2.id(), List.of(p2.id(), p6.id(), p7.id()), 300),
        eng("e-206", c3.id(), "Records Retention Policy",   EngagementStatus.paused,    today.minusDays(60), today.plusDays(10),  p1.id(), List.of(p1.id(), p3.id()),         100),
        eng("e-207", c4.id(), "Year-End Close Automation",  EngagementStatus.active,    today.minusDays(21), today.plusDays(40),  p5.id(), List.of(p5.id(), p3.id(), p8.id()), 260),
        eng("e-208", c4.id(), "Client Portal MVP",          EngagementStatus.proposed,  today.plusDays(7),   today.plusDays(90),  p2.id(), List.of(p2.id(), p6.id()),         180),
        eng("e-209", c5.id(), "Patient Intake Redesign",    EngagementStatus.active,    today.minusDays(30), today.plusDays(35),  p5.id(), List.of(p5.id(), p4.id(), p7.id()), 220),
        eng("e-210", c5.id(), "Compliance Gap Analysis",    EngagementStatus.completed, today.minusDays(120), today.minusDays(30),p1.id(), List.of(p1.id(), p2.id(), p8.id()), 160),
        eng("e-211", c1.id(), "Distribution Analytics",     EngagementStatus.proposed,  today.plusDays(14),  today.plusDays(120), p8.id(), List.of(p8.id(), p3.id()),         140),
        eng("e-212", c2.id(), "Driver Retention Study",     EngagementStatus.active,    today.minusDays(10), today.plusDays(50),  p3.id(), List.of(p3.id(), p7.id(), p4.id()), 150));
    for (Engagement e : es) s.putEngagement(e);

    // --- deliverables ---
    // 3-4 for active / paused, 1-2 for completed / proposed. Statuses are spread
    // across the four states so the Home rhythm view has visible variety.
    int dSeq = 500;
    for (Engagement e : es) {
      int count = switch (e.status()) {
        case active, paused -> 4;
        case completed -> 2;
        case proposed -> 2;
      };
      for (int i = 0; i < count; i++) {
        String title = deliverableTitleFor(e, i);
        LocalDate due;
        DeliverableStatus st;
        // spread due dates around the current week for interesting home view
        int week = i - 1; // -1, 0, 1, 2
        due = mondayThisWeek.plusDays(week * 7L + (i * 2L));
        st = switch (e.status()) {
          case completed -> DeliverableStatus.done;
          case proposed -> DeliverableStatus.notStarted;
          case paused -> (i == 0 ? DeliverableStatus.blocked : DeliverableStatus.notStarted);
          case active -> switch (i) {
            case 0 -> DeliverableStatus.done;
            case 1 -> DeliverableStatus.inProgress;
            case 2 -> DeliverableStatus.notStarted;
            default -> DeliverableStatus.notStarted;
          };
        };
        String owner = e.teamPersonIds().get(i % e.teamPersonIds().size());
        s.putDeliverable(new Deliverable("d-" + (++dSeq), e.id(), title, due, st, owner));
      }
    }

    // --- time entries (~150 across last 4 weeks) ---
    Random rng = new Random(4711);
    int tSeq = 900;
    for (int day = -28; day <= 0; day++) {
      LocalDate d = today.plusDays(day);
      if (d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY) continue;
      // 5-7 entries per weekday
      int perDay = 5 + rng.nextInt(3);
      for (int i = 0; i < perDay; i++) {
        Engagement e = es.get(rng.nextInt(es.size()));
        if (e.status() == EngagementStatus.proposed) continue;
        String personId = e.teamPersonIds().get(rng.nextInt(e.teamPersonIds().size()));
        double hours = 1.0 + rng.nextInt(6) * 0.5; // 1.0 .. 3.5
        boolean billed = e.status() != EngagementStatus.paused && rng.nextInt(3) != 0;
        s.addTimeEntryRaw(new TimeEntry("t-" + (++tSeq), e.id(), personId, d, hours,
            noteFor(e, rng), billed));
      }
    }

    return s;
  }

  private static Engagement eng(String id, String clientId, String name, EngagementStatus st,
                                LocalDate start, LocalDate end, String lead,
                                List<String> team, double budget) {
    return new Engagement(id, clientId, name, st, start, end, team, lead, budget);
  }

  private static final String[] DELIVERABLES = {
      "Discovery interviews",
      "Current-state assessment",
      "Requirements catalogue",
      "Solution architecture",
      "Vendor short-list",
      "Migration plan",
      "Change-management brief",
      "Pilot rollout",
      "Training kit",
      "Final report",
  };

  private static String deliverableTitleFor(Engagement e, int i) {
    return DELIVERABLES[(Math.abs(e.id().hashCode()) + i) % DELIVERABLES.length];
  }

  private static final String[] NOTES = {
      "Client workshop", "Doc review", "Data extract", "Model tuning",
      "Stakeholder sync", "QA pass", "Slide draft", "Interview prep",
      "Config work", "Regression fix", "Approval routing",
  };

  private static String noteFor(Engagement e, Random rng) {
    return NOTES[rng.nextInt(NOTES.length)];
  }
}
