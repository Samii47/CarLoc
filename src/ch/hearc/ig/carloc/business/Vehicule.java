package ch.hearc.ig.carloc.business;

/**
 * Classe abstraite représentant un véhicule
 *
 * @author Sami.Cögür
 */
public abstract class Vehicule {
    private String immatriculation;
    private String marque;
    private int annee;
    private Categorie categorie;
    private Statut statut;
    private Tarif tarif;
    private TypeMotorisation typeMotorisation;


    /**
     * Constructeur de la classe Vehicule
     *
     * @param immatriculation L'immatriculation unique du véhicule
     * @param marque La marque du véhicule
     * @param annee L'année de fabrication
     * @param categorie La catégorie du véhicule (ex: CITADINE, SUV)
     * @param statut Le statut actuel du véhicule (ex: DISPONIBLE)
     * @param tarif Le tarif de location journalier
     * @param typeMotorisation Le type de motorisation du véhicule
     */
    public Vehicule(String immatriculation, String marque, int annee, Categorie categorie, Statut  statut, Tarif tarif, TypeMotorisation typeMotorisation) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.annee = annee;
        this.categorie = categorie;
        this.statut = statut;
        this.tarif = tarif;
        this.typeMotorisation = typeMotorisation;
    }

    /**
     * Valide l'immatriculation du véhicule selon les règles métier
     *
     * @throws ImmatriculationInvalideException si l'immatriculation ne respecte pas les règles
     */
    public void validerImmatriculation() throws ImmatriculationInvalideException {
        // Validation : immatriculation vide ou nulle
        if (immatriculation == null || immatriculation.trim().isEmpty()) {
            throw new ImmatriculationInvalideException("L'immatriculation ne peut pas être vide");
        }

        // Validation : longueur minimale
        if (immatriculation.length() < 4) {
            throw new ImmatriculationInvalideException("L'immatriculation doit contenir au moins 4 caractères (reçu: '" + immatriculation + "')");
        }

        // Validation : longueur maximale
        if (immatriculation.length() > 10) {
            throw new ImmatriculationInvalideException("L'immatriculation ne peut pas dépasser 10 caractères (reçu: '" + immatriculation + "')");
        }
    }

    /**
     * Retourne l'immatriculation du véhicule
     *
     * @return L'immatriculation
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Retourne la marque du véhicule
     *
     * @return La marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Retourne l'année de fabrication du véhicule
     *
     * @return L'année
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Retourne la catégorie du véhicule
     *
     * @return La catégorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Retourne le statut du véhicule
     *
     * @return Le statut
     */
    public Statut getStatut() {
        return statut;
    }

    /**
     * Modifie le statut du véhicule
     *
     * @param statut le nouveau statut
     */
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    /**
     * Retourne le tarif de location du véhicule
     *
     * @return Le tarif
     */
    public Tarif getTarif() {
        return tarif;
    }

    /**
     * Modifie le tarif de location du véhicule
     *
     * @param tarif Le nouveau tarif
     */
    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    /**
     * Retourne le type de motorisation du véhicule
     *
     * @return Le type de motorisation
     */
    public TypeMotorisation getTypeMotorisation() {
        return typeMotorisation;
    }

    /**
     * Retourne le type spécifique du véhicule
     *
     * @return Le type de véhicule (ex: "Voiture", "Camion", "Moto")
     */
    public abstract String getTypeVehicule();

    /**
     * Indique si le véhicule nécessite un permis de conduire spécial
     *
     * @return true si un permis spécial est requis, false sinon
     */
    public abstract boolean necessitePermisSpecial();

    /**
     * Retourne la capacité maximale de passagers du véhicule
     *
     * @return Le nombre maximum de passagers
     */
    public abstract int getCapacitePassagers();

    /**
     * Compare ce véhicule avec un autre objet pour vérifier l'égalité
     * Deux véhicules sont égaux s'ils ont la même immatriculation
     *
     * @param obj L'objet à comparer
     * @return true si les immatriculations sont identiques, sinon false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicule)) return false;
        Vehicule autre = (Vehicule) obj;
        return this.immatriculation.equals(autre.immatriculation);
    }

    /**
     * Génère un code de hachage pour ce véhicule basé sur son immatriculation
     *
     * @return Le code de hachage
     */
    @Override
    public int hashCode() {
        return immatriculation.hashCode();
    }

    /**
     * Retourne une représentation textuelle du véhicule
     *
     * @return Une chaîne contenant les informations du véhicule
     */
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
