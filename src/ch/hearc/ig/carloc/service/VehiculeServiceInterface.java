package ch.hearc.ig.carloc.service;

import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.business.Vehicule;
import ch.hearc.ig.carloc.business.ImmatriculationInvalideException;

/**
 * Interface définissant les fonctionnalités principales du service de gestion des véhicules
 *
 * @author Sami.Cögür
 */

public interface VehiculeServiceInterface {

    /**
     * Ajoute un véhicule au parc de véhicules
     *
     * @param vehicule Le véhicule à ajouter
     */
    void ajouterVehicule(Vehicule vehicule) throws ImmatriculationInvalideException;

    /**
     * Supprime un véhicule du parc en se basant sur son immatriculation
     *
     * @param immatriculation L'immatriculation du véhicule à supprimer
     */
    void supprimerVehicule(String immatriculation);

    /**
     * Affiche les véhicules du parc, avec possibilité de filtrer par statut
     *
     * @param statut Le statut pour filtrer (null pour afficher tous les véhicules)
     */
    void afficherVehicules(Statut statut);
}