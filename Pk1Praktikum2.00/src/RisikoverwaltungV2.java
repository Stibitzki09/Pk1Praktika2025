import java.util.Iterator;
import java.util.LinkedList;

public class RisikoverwaltungV2 {

    private LinkedList risikoverwaltung;

    public RisikoverwaltungV2() {
        risikoverwaltung = new LinkedList();
    }

    public void aufnehmen(Risiko r) {
        risikoverwaltung.add(r);
    }

    public void zeigeRisiken() {
        Iterator it = risikoverwaltung.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public float sucheRisikoMitMaxRueckstellung() {
        if(risikoverwaltung.isEmpty()) {
            return 0;
        }
        Risiko current = (Risiko) risikoverwaltung.getFirst();
        float rueckstellung = current.ermittleRueckstellung();
        Iterator it =  risikoverwaltung.iterator();
        while(it.hasNext()){
            Risiko after = (Risiko) it.next();
            if(current.ermittleRueckstellung() < after.ermittleRueckstellung()) {
                rueckstellung = after.ermittleRueckstellung();
            }
            current = after;
        }
        return rueckstellung;
    }

    public float berechneSummeRueckstellung() {
        float summe = 0.0f;
        for (Object obj : risikoverwaltung) {
            if (obj instanceof Risiko) {
                summe += ((Risiko) obj).ermittleRueckstellung();
            }
        }
        return summe;
    }

}
