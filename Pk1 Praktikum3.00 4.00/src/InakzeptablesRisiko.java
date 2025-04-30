import java.util.Objects;

public class InakzeptablesRisiko extends Risiko{

    private String massnahme;

    public InakzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kostenImSchadensfall, String massnahme) {
        super(bezeichnung, eintrittswahrscheinlichkeit, kostenImSchadensfall);
        this.massnahme = massnahme;
    }

    @Override
    public float ermittleRueckstellung() {
        return super.berechneRisikowert();
    }

    public String getMassnahme() {
        return this.massnahme;
    }

    public boolean equals(Object o) {
        if(!(super.equals(o))) {
            return false;
        }
        InakzeptablesRisiko a = (InakzeptablesRisiko) o;
        if(!(this.getMassnahme().equals(a.getMassnahme()))) {
            return false;
        }
        return true;

    }
    public int hashCode() {
        return Objects.hash(super.getBezeichnung(), super.getEintrittswahrscheinlichkeit(), super.getKostenImSchadensfall(), super.getErstellungsdatumFormatted(), this.getMassnahme());
    }
    @Override
    public void druckeDaten(){
        System.out.println("Id " + super.getId() + " Inakzeptables Risiko " + "\"" + super.getBezeichnung() + "\" aus " + super.getErstellungsdatumFormatted() +"; \n" + "Risikowert " + this.berechneRisikowert() + "; Rückstellung " + this.ermittleRueckstellung() + ";\n" + "Maßnahme " + "\"" + this.getMassnahme() + "\"");
    }

    public String toString() {
        return "Inakzeptables Risiko Risikowert: " + this.berechneRisikowert();
    }
}
