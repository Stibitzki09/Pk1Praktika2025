import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Risiko implements Comparable<Risiko>{
    private final int id;
    private static int counter = 0;
    private String bezeichnung;
    private float eintrittswahrscheinlichkeit;
    private float kostenImSchadensfall;
    private LocalDate erstellungsdatum;

    public Risiko (String bezeichnung, float eintrittswahrscheinlichkeit, float kostenImSchadensfall) {
        id = counter++;
        this.bezeichnung = bezeichnung;
        this.eintrittswahrscheinlichkeit = eintrittswahrscheinlichkeit;
        this.kostenImSchadensfall= kostenImSchadensfall;
        this.erstellungsdatum = LocalDate.now();
    }

    public float berechneRisikowert() {

        return this.eintrittswahrscheinlichkeit* this.kostenImSchadensfall;
    }

    public int getId(){
        return this.id;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public float getEintrittswahrscheinlichkeit() {
        return eintrittswahrscheinlichkeit;
    }

    public float getKostenImSchadensfall() {
        return this.kostenImSchadensfall;
    }
    public String getErstellungsdatumFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/yyyy");
        return this.erstellungsdatum.format(formatter);
    }

    public abstract float ermittleRueckstellung();

    public abstract void druckeDaten();

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(!(this.getClass().equals(o.getClass()))) {
            return false;
        }
        Risiko a = (Risiko) o;

        if(!(this.getBezeichnung().equals(a.getBezeichnung()))) {
            return false;
        }
        if(this.getEintrittswahrscheinlichkeit() != a.getEintrittswahrscheinlichkeit()) {
            return false;
        }
        if(this.getKostenImSchadensfall() != a.getKostenImSchadensfall()) {
            return false;
        }
        if(!(this.getErstellungsdatumFormatted().equals(a.getErstellungsdatumFormatted()))) {
            return false;
        }
        return true;
    }
    public int hashCode() {
        return Objects.hash(bezeichnung, eintrittswahrscheinlichkeit, kostenImSchadensfall, erstellungsdatum);
    }
    @Override
    public int compareTo(Risiko o) {
        return Float.compare(o.berechneRisikowert(), this.berechneRisikowert());
    }

    public abstract String toString();
}
