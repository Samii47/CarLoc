package ch.hearc.ig.carloc.business;

public class Voiture extends Vehicule {

    public Voiture(String immatriculation, String marque, int annee, String categorie, Statut statut, Tarif tarif, TypeMotorisation typeMotorisation) {
        super(immatriculation, marque, annee, categorie, statut, tarif, typeMotorisation);
    }

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
