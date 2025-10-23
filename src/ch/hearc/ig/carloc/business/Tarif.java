package ch.hearc.ig.carloc.business;

public class Tarif {
    private int montantJournalier;
    private String devise;

    public Tarif(int montantJournalier, String devise) {
        this.montantJournalier = montantJournalier;
        this.devise = devise;
    }

    public int getMontantJournalier() {
        return montantJournalier;
    }

    public String getDevise() {
        return devise;
    }

    @Override
    public String toString() {
        return montantJournalier + " " + devise + " / jour";
    }
}

