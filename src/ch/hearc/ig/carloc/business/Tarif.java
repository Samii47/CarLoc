package ch.hearc.ig.carloc.business;

/**
 * Classe représentant un tarif de location journalier
 * Contient un montant et une devise
 */
public class Tarif {
    private int montantJournalier;
    private String devise;

    /**
     * Constructeur pour créer un tarif
     *
     * @param montantJournalier Le montant journalier de location
     * @param devise La devise du tarif (ex: CHF, EUR)
     */
    public Tarif(int montantJournalier, String devise) {
        this.montantJournalier = montantJournalier;
        this.devise = devise;
    }

    /**
     * Retourne le montant journalier du tarif
     *
     * @return Le montant journalier
     */
    public int getMontantJournalier() {
        return montantJournalier;
    }

    /**
     * Retourne la devise du tarif
     *
     * @return La devise
     */
    public String getDevise() {
        return devise;
    }

    /**
     * Retourne une représentation textuelle du tarif
     *
     * @return Une chaîne au format "montant devise / jour"
     */
    @Override
    public String toString() {
        return montantJournalier + " " + devise + " / jour";
    }
}

