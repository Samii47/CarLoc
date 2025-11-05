package ch.hearc.ig.carloc.service;

import ch.hearc.ig.carloc.business.Vehicule;
import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.datastructure.ArrayList;
import ch.hearc.ig.carloc.datastructure.List;

/**
 * Service de gestion du parc de véhicules
 * Fournit les fonctionnalités pour ajouter, supprimer et afficher des voitures
 * Implémente l'interface VehiculeServiceInterface
 */

public class VehiculeService implements VehiculeServiceInterface {

    // Liste contenant tout les véhicules du parc
    private List<Vehicule> vehicules = new ArrayList<>();


    /**
     * Ajoute une voiture au parc
     * Vérifie que la voiture n'est pas nulle et qu'elle n'existe pas déjà (selon immatriculation)
     *
     * @param vehicule La voiture à ajouter
     * @throws IllegalArgumentException si la voiture est null ou si une voiture
     * avec la même immatriculation existe déjà
     */
    @Override
    public void ajouterVehicule(Vehicule vehicule) {
        // Vérification : vehicule null
        if (vehicule == null) {
            throw new IllegalArgumentException("Impossible d'ajouter un véhicule nul.");
        }

        // Vérification : véhicule déjà existant (même immatriculation)
        for (int i = 0; i < vehicules.size(); i++) {
            if (vehicules.get(i).getImmatriculation().equals(vehicule.getImmatriculation())) {
                throw new IllegalArgumentException("Un véhicule avec l'immatriculation " +
                        vehicule.getImmatriculation() + " existe déjà dans le parc.");
            }
        }

        vehicules.add(vehicule);
        System.out.println("Véhicule ajouté : " + vehicule.getImmatriculation() +
                " (" + vehicule.getMarque() + " - " + vehicule.getTypeVehicule() + ")");
    }

    /**
     * Supprime une voiture du parc en se basant sur son immatriculation.
     *
     * @param immatriculation L'immatriculation de la voiture à supprimer
     * @throws IllegalArgumentException si aucune voiture avec cette immatriculation est trouvée dans le parc
     */
    @Override
    public void supprimerVehicule(String immatriculation) {
        // Recherche du véhicule par immatriculation
        for (int i = 0; i < vehicules.size(); i++) {
            if (vehicules.get(i).getImmatriculation().equals(immatriculation)) {
                Vehicule vehiculeSuppr = vehicules.remove(i);
                System.out.println("\nVéhicule supprimé : " + vehiculeSuppr.getImmatriculation() +
                        " (" + vehiculeSuppr.getMarque() + " - " + vehiculeSuppr.getTypeVehicule() + ")");
                return;
            }
        }
        throw new IllegalArgumentException("\nAucun véhicule avec l'immatriculation " +
                immatriculation + " n'a été trouvé dans le parc.");
    }

    /**
     * Affiche les voitures du parc, avec possibilité de filtrer par statut
     * Si le statut est null, affiche toutes les voitures sans filtre.
     *
     * @param statut Le statut pour filtrer les voitures ou null pour afficher toutes les voitures
     */
    @Override
    public void afficherVehicules(Statut statut) {
        if (vehicules.isEmpty()) {
            System.out.println("\nAucun véhicule dans le parc.");
            return;
        }

        System.out.println("--- Parc de Véhicules ---");

        int compteur = 0;

        for (int i = 0; i < vehicules.size(); i++) {
            Vehicule v = vehicules.get(i);

            // Si pas de filtre OU si le statut correspond
            if (statut == null || v.getStatut() == statut) {
                System.out.println(v);
                compteur++;
            }
        }
        if (compteur == 0 && statut != null) {
            System.out.println("\nAucun véhicule avec le statut : " + statut);
        }

        System.out.println("--------------");
    }

    /**
     * Retourne la liste complète de toutes les voitures du parc
     *
     * @return La liste des voitures
     */
    public List<Vehicule> getTousLesVehicules() {
        return vehicules;
    }

}
