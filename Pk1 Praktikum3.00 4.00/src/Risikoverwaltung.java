import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Risikoverwaltung {

    LinkedList<Risiko> risikoverwaltung;

    public Risikoverwaltung() {
        risikoverwaltung = new LinkedList<>();
    }

    public void aufnehmen(Risiko neu) {
        risikoverwaltung.add(neu);
    }

    public void zeigeRisiken() {
        if(risikoverwaltung.isEmpty()) {
            System.out.println("Es sind keine Risiken vorhanden.");
        }
        Iterator<Risiko> it = risikoverwaltung.iterator();
        Collections.sort(risikoverwaltung);
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public float sucheRisikoMitMaxRueckstellung() {
        if(risikoverwaltung.isEmpty()){
            return 0;
        }
        Risiko current = risikoverwaltung.getFirst();
        float rueckstellung = current.ermittleRueckstellung();
        Iterator<Risiko> it =  risikoverwaltung.iterator();
        while(it.hasNext()){
            Risiko after = it.next();
            if(current.ermittleRueckstellung() < after.ermittleRueckstellung()) {
                rueckstellung = after.ermittleRueckstellung();
            }
            current = after;
        }
        return rueckstellung;
    }

    public float berechneSummeRueckstellung() {
        if(risikoverwaltung.isEmpty()) {
            return 0;
        }
        float summe = 0;
        for(Risiko risiko : risikoverwaltung) {
            summe += risiko.ermittleRueckstellung();
        }
        return summe;
    }
}
