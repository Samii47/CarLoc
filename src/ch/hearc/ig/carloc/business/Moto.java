package ch.hearc.ig.carloc.business;

/**
 * Classe représentant une moto dans le parc de véhicules
 * Hérite de la classe abstraite Vehicule
 * Une moto nécessite un permis spécial (permis A) et a une capacité limitée
 */
public class Moto extends Vehicule {

    /**
     * Constructeur pour créer une moto
     *
     * @param immatriculation L'immatriculation unique de la moto
     * @param marque La marque de la moto
     * @param annee L'année de fabrication
     * @param categorie La catégorie de la moto
     * @param statut Le statut actuel de la moto
     * @param tarif Le tarif de location journalier
     * @param typeMotorisation Le type de motorisation de la moto
     */
    public Moto(String immatriculation, String marque, int annee, Categorie categorie,
                Statut statut, Tarif tarif, TypeMotorisation typeMotorisation) {
        super(immatriculation, marque, annee, categorie, statut, tarif, typeMotorisation);
    }

    /**
     * Retourne le type de véhicule
     *
     * @return "Moto"
     */
    @Override
    public String getTypeVehicule() {
        return "Moto";
    }

    /**
     * Une moto nécessite un permis spécial (permis A)
     *
     * @return true
     */
    @Override
    public boolean necessitePermisSpecial() {
        return true;
    }

    /**
     * Retourne la capacité d'une moto
     *
     * @return 2 passagers
     */
    @Override
    public int getCapacitePassagers() {
        return 2;
    }

    /**
     * Retourne une représentation textuelle de la moto
     *
     * @return Une chaîne contenant toutes les informations de la moto
     */
    @Override
    public String toString() {
        return "Moto [" +
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
