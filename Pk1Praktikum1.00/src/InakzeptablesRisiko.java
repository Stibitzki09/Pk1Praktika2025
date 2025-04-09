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
@Override
    public void druckeDaten(){
        System.out.println("Id " + super.getId() + " Inakzeptables Risiko " + "\"" + super.getBezeichnung() + "\" aus " + super.getErstellungsdatumFormatted() +"; \n" + "Risikowert " + this.berechneRisikowert() + "; Rückstellung " + this.ermittleRueckstellung() + ";\n" + "Maßnahme " + "\"" + this.getMassnahme() + "\"");
    }
}
