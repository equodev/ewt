package dev.equo;

import java.util.concurrent.Callable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.EwtWidget;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import dev.equo.ewt.Widget;

/**
 * WEB GAP-ANALYSIS harness for the standalone samples (siblings of the gallery harness, but in
 * the dev.equo package so it can reach each sample's package-private *Page). Mounts ONE sample's
 * page as a single EwtWidget web region — the samples' own main() runs desktop-native, this mounts
 * the same page subtree on the web path instead.
 *
 * Pick with {@code -Ddev.equo.sample=Fade|Calculator} (the {@code runSamplesWeb -Psample=...} task
 * wires it). Diagnostic only.
 */
public class EvolveSamples {

    public static void main(String[] args) {
        String sample = System.getProperty("dev.equo.sample", "Calculator");

        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("EWT web gap-analysis — " + sample);
        shell.setSize(760, 820);
        shell.setLayout(new GridLayout(1, false));

        Label heading = new Label(shell, SWT.WRAP);
        heading.setText("Sample: " + sample + "  (web region below)");
        heading.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        EwtWidget region = new EwtWidget(shell, SWT.NONE);
        region.setPreferredSize(SWT.DEFAULT, 720);
        region.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        region.setWidget(pageFor(sample));

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }

    private static Callable<Widget> pageFor(String sample) {
        switch (sample) {
            case "Calculator": return () -> new Calculator.CalculatorPage();
            case "Fade":       return () -> new FadeDemo.FadePage();
            case "TextInput":  return EwtTextInput::new;
            case "Login":      return () -> new LoginForm.LoginPage();
            default:
                throw new IllegalArgumentException(
                    "Unknown sample '" + sample + "'. Use one of: Calculator, Fade, TextInput, Login.");
        }
    }
}
