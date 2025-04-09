public class AkzeptablesRisiko extends Risiko{


    public AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kostenImSchadensfall) {
        super(bezeichnung, eintrittswahrscheinlichkeit, kostenImSchadensfall);
    }
    public float ermittleRueckstellung(){
        return 0;
    }

    public void druckeDaten(){
        System.out.println("Id " + super.getId() + " Akzeptables Risiko " + super.getBezeichnung() + " aus " + super.getErstellungsdatumFormatted() + ";\n" + "Risikowert " + this.berechneRisikowert() + "; Rückstellung " + this.ermittleRueckstellung());
    }
}
