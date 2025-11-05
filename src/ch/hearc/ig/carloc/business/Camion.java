package ch.hearc.ig.carloc.business;

/**
 * Classe représentant un camion dans le parc de véhicules
 * Hérite de la classe abstraite Vehicule
 * Un camion nécessite un permis spécial (permis C) et a une capacité réduite
 */
public class Camion extends Vehicule {

    /**
     * Constructeur pour créer un camion
     *
     * @param immatriculation L'immatriculation unique du camion
     * @param marque La marque du camion
     * @param annee L'année de fabrication
     * @param categorie La catégorie du camion
     * @param statut Le statut actuel du camion
     * @param tarif Le tarif de location journalier
     * @param typeMotorisation Le type de motorisation du camion
     */
    public Camion(String immatriculation, String marque, int annee, Categorie categorie,
                  Statut statut, Tarif tarif, TypeMotorisation typeMotorisation) {
        super(immatriculation, marque, annee, categorie, statut, tarif, typeMotorisation);
    }

    /**
     * Retourne le type de véhicule
     *
     * @return "Camion"
     */
    @Override
    public String getTypeVehicule() {
        return "Camion";
    }

    /**
     * Un camion nécessite un permis spécial (permis C)
     *
     * @return true
     */
    @Override
    public boolean necessitePermisSpecial() {
        return true;
    }

    /**
     * Retourne la capacité d'un camion
     *
     * @return 3 passagers
     */
    @Override
    public int getCapacitePassagers() {
        return 3;
    }

    /**
     * Retourne une représentation textuelle du camion
     *
     * @return Une chaîne contenant toutes les informations du camion
     */
    @Override
    public String toString() {
        return "Camion [" +
                "Immatriculation: " + getImmatriculation() +
                ", Marque: " + getMarque() +
                ", Année: " + getAnnee() +
                ", Catégorie: " + getCategorie() +
                ", Statut: " + getStatut() +
                ", Tarif: " + getTarif() +
                ", Motorisation: " + getTypeMotorisation() +
                ", Permis spécial requis: " + (necessitePermisSpecial() ? "Oui" : "Non") +
                ", Capacité: " + getCapacitePassagers() + " passagers" +
                "]";
    }
}
