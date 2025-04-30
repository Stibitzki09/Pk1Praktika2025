public class Main {
    public static void main(String[] args) {
        AkzeptablesRisiko risiko1 = new AkzeptablesRisiko("Lizenzkosten der IDE steigt", 2, 2000);
        ExtremesRisiko risiko2 = new ExtremesRisiko("Hauptauftraggeber meldet Insolvenz an", 100, 1000000, "Versicherung abschließen", 5000);
        InakzeptablesRisiko risiko3 = new InakzeptablesRisiko("DB Experte verlässt das Projekt", 4, 4000, "Ersatz bei Dienstleister reservieren");
/*
        risiko1.druckeDaten();
        risiko2.druckeDaten();
        risiko3.druckeDaten();

        AkzeptablesRisiko risiko4 = new AkzeptablesRisiko("Lizenzkosten der IDE steigt", 2, 2000);
        AkzeptablesRisiko risiko5 = new AkzeptablesRisiko("Lizenzkosten der IDE steigt", 2, 2000);
        System.out.println(risiko4.equals(risiko5));
        System.out.println(risiko4.hashCode());
        System.out.println(risiko5.hashCode());

        Risikoverwaltung risikoverwaltung3 = new Risikoverwaltung();

        risikoverwaltung3.aufnehmen(risiko1);
        risikoverwaltung3.aufnehmen(risiko2);
        risikoverwaltung3.aufnehmen(risiko3);
        risikoverwaltung3.zeigeRisiken();
        System.out.println(risikoverwaltung3.sucheRisikoMitMaxRueckstellung());
        System.out.println(risikoverwaltung3.berechneSummeRueckstellung());
*/
        Menu menu = new Menu();
        menu.printMenu();
    }
}