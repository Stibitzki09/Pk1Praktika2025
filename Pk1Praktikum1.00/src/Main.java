public class Main {
    public static void main(String[] args) {
        AkzeptablesRisiko risiko1 = new AkzeptablesRisiko("Lizenzkosten der IDE steigt", 2, 2000);
        ExtremesRisiko risiko2 = new ExtremesRisiko("Hauptauftraggeber meldet Insolvenz an", 100, 1000000, "Versicherung abschließen", 5000);
        InakzeptablesRisiko risiko3 = new InakzeptablesRisiko("DB Experte verlässt das Projekt", 4, 4000, "Ersatz bei Dienstleister reservieren");

        risiko1.druckeDaten();
        risiko2.druckeDaten();
        risiko3.druckeDaten();
    }
}