public class ExtremesRisiko extends InakzeptablesRisiko {

    private float versicherungsbeitrag;

    public ExtremesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kostenImSchadensfall, String massnahme, float versicherungsbeitrag) {
        super(bezeichnung, eintrittswahrscheinlichkeit, kostenImSchadensfall, massnahme);
        this.versicherungsbeitrag = versicherungsbeitrag;
    }

    @Override
    public float ermittleRueckstellung() {
        return versicherungsbeitrag;
    }

    public float getVersicherungsbeitrag() {
        return this.versicherungsbeitrag;
    }
    public void druckeDaten() {
        System.out.println("Id " + super.getId() + " Extremes Risiko " + " \""+ super.getBezeichnung() + "\" aus " + super.getErstellungsdatumFormatted() + ";\n" + "Versicherungsbeitrag " + this.getVersicherungsbeitrag() + "; Maßnahme " + "\"" + super.getMassnahme() + "\"");
    }
}