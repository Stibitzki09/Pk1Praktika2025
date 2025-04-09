import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Risiko {
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
}
