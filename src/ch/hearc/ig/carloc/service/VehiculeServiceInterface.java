package ch.hearc.ig.carloc.service;

import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.business.Voiture;

/**
 * Interface définissant les fonctionnalités principales du service de gestion des véhicules
 *
 * @author Sami.Cögür
 */

public interface VehiculeServiceInterface {

    /**
     * Ajoute une voiture au parc de véhicules
     *
     * @param voiture La voiture à ajouter
     */
    void ajouterVoiture(Voiture voiture);

    /**
     * Supprime une voiture du parc en se basant sur son immatriculation
     *
     * @param immatriculation L'immatriculation de la voiture à supprimer
     */
    void supprimerVoiture(String immatriculation);

    /**
     * Affiche les voitures du parc, avec possibilité de filtrer par statut
     *
     * @param statut Le statut pour filtrer (null pour afficher toutes les voitures)
     */
    void afficherVoitures(Statut statut);
}
