import java.util.Objects;

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

    public boolean equals(Object o) {
        if(!(super.equals(o))) {
            return false;
        }
        ExtremesRisiko a = (ExtremesRisiko) o;
        if(this.getVersicherungsbeitrag() != ((ExtremesRisiko) o).getVersicherungsbeitrag()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(super.getBezeichnung(), super.getEintrittswahrscheinlichkeit(), super.getKostenImSchadensfall(), super.getErstellungsdatumFormatted(), this.getMassnahme(), this.getVersicherungsbeitrag());
    }
    public void druckeDaten() {
        System.out.println("Id " + super.getId() + " Extremes Risiko " + " \""+ super.getBezeichnung() + "\" aus " + super.getErstellungsdatumFormatted() + ";\n" + "Versicherungsbeitrag " + this.getVersicherungsbeitrag() + "; Maßnahme " + "\"" + super.getMassnahme() + "\"");
    }
}