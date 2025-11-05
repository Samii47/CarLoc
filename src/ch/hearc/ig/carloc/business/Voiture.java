package ch.hearc.ig.carloc.business;

/**
 * Classe représentant une voiture dans le parc de véhicules
 * Hérite de la classe abstraite Vehicule
 */
public class Voiture extends Vehicule {

    /**
     * Constructeur pour créer une voiture
     *
     * @param immatriculation L'immatriculation unique de la voiture
     * @param marque La marque de la voiture
     * @param annee L'année de fabrication
     * @param categorie La catégorie de la voiture
     * @param statut Le statut actuel de la voiture
     * @param tarif Le tarif de location journalier
     * @param typeMotorisation Le type de motorisation de la voiture
     */
    public Voiture(String immatriculation, String marque, int annee, Categorie categorie, Statut statut, Tarif tarif, TypeMotorisation typeMotorisation) {
        super(immatriculation, marque, annee, categorie, statut, tarif, typeMotorisation);
    }

    /**
     * Retourne le type de véhicule
     *
     * @return "Voiture"
     */
    @Override
    public String getTypeVehicule() {
        return "Voiture";
    }

    /**
     * Une voiture standard ne nécessite pas de permis spécial
     *
     * @return false
     */
    @Override
    public boolean necessitePermisSpecial() {
        return false;
    }

    /**
     * Retourne la capacité standard d'une voiture
     *
     * @return 5 passagers
     */
    @Override
    public int getCapacitePassagers() {
        return 5;
    }

    /**
     * Retourne une représentation textuelle de la voiture
     *
     * @return Une chaîne contenant toutes les informations de la voiture
     */
    @Override
    public String toString() {
        return "Voiture [" +
                "Immatriculation: " + getImmatriculation() +
                ", Marque: " + getMarque() +
                ", Année: " + getAnnee() +
                ", Catégorie: " + getCategorie() +
                ", Statut: " + getStatut() +
                ", Tarif: " + getTarif() +
                ", Motorisation: " + getTypeMotorisation() +
                "]";
    }
}
