import javax.swing.*;
import java.util.Scanner;

public class Menu {

    private Risikoverwaltung risiko;

    private static final float LIMIT = 10000;
    private static final float KOSTENLIMIT = 1000000;

    private JDialog frame;


    public Menu() {
        risiko = new Risikoverwaltung();
        frame = new JDialog();
        frame.setModal(true);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    public void printMenu() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        printMenuPrompt();
        while (true) {
            try {
                n = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Bitte geben Sie eine gültige Zahl ein!");
                sc.nextLine();
            }
            switch (n) {
                case 1:
                    risikoAufnehmen();
                    break;
                case 2:
                    risiko.zeigeRisiken();
                    break;
                case 3:
                    System.out.println(risiko.sucheRisikoMitMaxRueckstellung());
                    break;
                case 4:
                    System.out.println(risiko.berechneSummeRueckstellung());
                    break;
                case 5:
                    frame.dispose();
                    return;
                default:
                    printMenuPrompt();
                    break;
            }
        }
    }

    public void printMenuPrompt() {
        System.out.println("Risikoverwaltung\n \n");
        System.out.println("1. Risiko aufnehmen\n" +
                "2. Zeige alle Risiken\n" +
                "3. Zeige Risiko mit maximaler R¨uckstellung\n" +
                "4. Berechne Summe aller R¨uckstellungen\n" +
                "5. Beenden\n\n" +
                "Bitte Menüpunkt wählen: ");
    }

    public void risikoAufnehmen() {
        String bezeichnung = JOptionPane.showInputDialog(frame, "Geben Sie eine Bezeichnung ein:");
        if (bezeichnung == null) {
            printMenuPrompt();
            return;
        }
        String eintrittswahrscheinlichkeitString = "";
        float eintrittswahrscheinlichkeit = 0;
        while (true) {
            eintrittswahrscheinlichkeitString = JOptionPane.showInputDialog(frame, "Geben Sie die Eintrittswahrscheinlichkeit ein. (Der Wert soll zwischen 0.0 un 1.0 liegen)");
            try {
                if (eintrittswahrscheinlichkeitString != null) {
                    eintrittswahrscheinlichkeit = Float.parseFloat(eintrittswahrscheinlichkeitString);
                    if (eintrittswahrscheinlichkeit < 0.0 || eintrittswahrscheinlichkeit > 1.0) {
                        JOptionPane.showMessageDialog(frame, "Bitte geben Sie einen Wert zwischen 0.0 und 1.0 an");
                        continue;
                    }
                } else {
                    printMenuPrompt();
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Bitte geben Sie eine gültige Zshl ein!");
                continue;
            }
            break;
        }
        String kostenString = "";
        float kosten = 0;
        while (true) {
            kostenString = JOptionPane.showInputDialog(frame, "Geben Sie die Kosten im Schadensfall ein.");
            try {
                if (kostenString != null) {
                    kosten = Float.parseFloat(kostenString);
                } else {
                    printMenuPrompt();
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Bitte geben Sie eine gültige Zahl ein.");
                continue;
            }
            break;
        }
        if ((eintrittswahrscheinlichkeit * kosten) < LIMIT) {
            AkzeptablesRisiko risiko1 = new AkzeptablesRisiko(bezeichnung, eintrittswahrscheinlichkeit, kosten);
            risiko.aufnehmen(risiko1);
        } else if (kosten > KOSTENLIMIT) {
            String massnahme = JOptionPane.showInputDialog(frame, "Es handelt sich hierbei um ein extremes Risiko. Bitte geben Sie eine entsprechende Maßnahme ein.");
            if (massnahme == null) {
                printMenuPrompt();
                return;
            }
            float versicherungsbeitrag = 0;
            while (true) {
                String versicherungsbeitragString = JOptionPane.showInputDialog(frame, "Bitte geben Sie den Versicherungsbeitrag ein.");
                try {
                    if (versicherungsbeitragString != null) {
                        versicherungsbeitrag = Float.parseFloat(versicherungsbeitragString);
                    } else {
                        printMenuPrompt();
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Bitte geben Sie eine gültige Zahl ein.");
                    continue;
                }
                break;
            }
            ExtremesRisiko risiko2 = new ExtremesRisiko(bezeichnung, eintrittswahrscheinlichkeit, kosten, massnahme, versicherungsbeitrag);
            risiko.aufnehmen(risiko2);
        } else {
            String massnahme = JOptionPane.showInputDialog(frame, "Es handelt sich hierbei um ein inakzeptables Risiko. Bitte geben Sie noch eine entsprechende Maßnahme ein.");
            if (massnahme == null) {
                printMenuPrompt();
                return;
            }
            InakzeptablesRisiko risiko3 = new InakzeptablesRisiko(bezeichnung, eintrittswahrscheinlichkeit, kosten, massnahme);
            risiko.aufnehmen(risiko3);
        }
        JOptionPane.showMessageDialog(frame, "Ihr Risiko wurde aufgenommen!");
        printMenuPrompt();
    }
}