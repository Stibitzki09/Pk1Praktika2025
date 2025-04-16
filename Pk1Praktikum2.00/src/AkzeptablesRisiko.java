import java.util.Objects;

public class AkzeptablesRisiko extends Risiko{


    public AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kostenImSchadensfall) {
        super(bezeichnung, eintrittswahrscheinlichkeit, kostenImSchadensfall);
    }
    public float ermittleRueckstellung(){
        return 0;
    }

    public boolean equals(Object o) {
        if(!(super.equals(o))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(super.getBezeichnung(), super.getEintrittswahrscheinlichkeit(), super.getKostenImSchadensfall(), super.getErstellungsdatumFormatted());
    }

    public void druckeDaten(){
        System.out.println("Id " + super.getId() + " Akzeptables Risiko " + super.getBezeichnung() + " aus " + super.getErstellungsdatumFormatted() + ";\n" + "Risikowert " + this.berechneRisikowert() + "; Rückstellung " + this.ermittleRueckstellung());
    }
}
