import java.util.ArrayList;

public class RisikoverwaltungV1 {

    private Risiko [] risikoveraltung;
    private int index;


    public RisikoverwaltungV1(int maxGroesse) {

        risikoveraltung = new Risiko[maxGroesse];
        index = 0;
    }
    public void aufnehmen(Risiko r) {
        if(index >= risikoveraltung.length) {
            System.out.println("Kein Platz mehr in der Risikoverwaltung.");
            return;
        }
        risikoveraltung[index++] = r;
    }

    public void zeigeRisiken() {
        System.out.println("Alle Risiken:");
        for(int i = 0; i < risikoveraltung.length; i++) {
            System.out.println(risikoveraltung[i]);
        }
    }

    public float sucheRisikoMitMaxRueckstellung() {
        if(index == 0) {
            System.out.println("Keine Risiken vorhanden");
        }
        Risiko maxRisiko = risikoveraltung[0];
        for(int i = 1; i < index; i++) {
            if(risikoveraltung[i].ermittleRueckstellung() > maxRisiko.ermittleRueckstellung()) {
                maxRisiko = risikoveraltung[i];
            }
        }
        return maxRisiko.ermittleRueckstellung();
    }

    public float berechneSummeRueckstellung() {
        float summe = 0;

        for(int i = 0; i < index; i++) {
            summe+= risikoveraltung[i].ermittleRueckstellung();
        }
        return summe;
    }
}
