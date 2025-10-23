package ch.hearc.ig.carloc.business;

public abstract class Vehicule {
    private String immatriculation;
    private String marque;
    private int annee;
    private String categorie;
    private Statut statut;
    private Tarif tarif;
    private TypeMotorisation typeMotorisation;

    public Vehicule(String immatriculation, String marque, int annee, String categorie, Statut  statut, Tarif tarif, TypeMotorisation typeMotorisation) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.annee = annee;
        this.categorie = categorie;
        this.statut = statut;
        this.tarif = tarif;
        this.typeMotorisation = typeMotorisation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public int getAnnee() {
        return annee;
    }

    public String getCategorie() {
        return categorie;
    }

    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    public Tarif getTarif() {
        return tarif;
    }
    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }
    public TypeMotorisation getTypeMotorisation() {
        return typeMotorisation;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicule)) return false;
        Vehicule autre = (Vehicule) obj;
        return this.immatriculation.equals(autre.immatriculation);
    }


    @Override
    public int hashCode() {
        return immatriculation.hashCode();
    }

    @Override
    public String toString() {
        return "Vehicule [" +
                "Immatriculation: " + immatriculation +
                ", Marque: " + marque +
                ", Année: " + annee +
                ", Catégorie: " + categorie +
                ", Statut: " + statut +
                ", Tarif: " + tarif +
                ", Motorisation: " + typeMotorisation +
                "]";
    }
}
