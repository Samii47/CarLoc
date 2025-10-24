package ch.hearc.ig.carloc.service;

import ch.hearc.ig.carloc.business.Voiture;
import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.datastructure.ArrayList;
import ch.hearc.ig.carloc.datastructure.List;

/**
 * Service de gestion du parc de véhicules
 * Fournit les fonctionnalités pour ajouter, supprimer et afficher des voitures
 * Implémente l'interface VehiculeServiceInterface
 */

public class VehiculeService implements VehiculeServiceInterface {

    // Liste contenant toutes les voitures du parc
    private List<Voiture> voitures = new ArrayList<>();


    /**
     * Ajoute une voiture au parc
     * Vérifie que la voiture n'est pas nulle et qu'elle n'existe pas déjà (selon immatriculation)
     *
     * @param voiture La voiture à ajouter
     * @throws IllegalArgumentException si la voiture est null ou si une voiture
     * avec la même immatriculation existe déjà
     */
    @Override
    public  void ajouterVoiture(Voiture voiture) {
        // Vérification : voiture null
        if (voiture == null) {
            throw new IllegalArgumentException("Impossible d'ajouter une voiture nulle.");
        }

        // Vérification : voiture déjà existante (même immatriculation)
        for (int i = 0; i < voitures.size(); i++) {
            if (voitures.get(i).getImmatriculation().equals(voiture.getImmatriculation())) {
                throw new IllegalArgumentException("Une voiture avec l'immatriculation " +
                        voiture.getImmatriculation() + " existe déjà dans le parc.");
            }
        }

        voitures.add(voiture);
        System.out.println("Voiture ajoutée : " + voiture.getImmatriculation() +
                " (" + voiture.getMarque() + ")");
    }

    /**
     * Supprime une voiture du parc en se basant sur son immatriculation.
     *
     * @param immatriculation L'immatriculation de la voiture à supprimer
     * @throws IllegalArgumentException si aucune voiture avec cette immatriculation est trouvée dans le parc
     */
    @Override
    public void supprimerVoiture(String immatriculation) {
        // Recherche de la voiture par immatriculation
        for (int i = 0; i < voitures.size(); i++) {
            if (voitures.get(i).getImmatriculation().equals(immatriculation)) {
                Voiture voitureSuppr = voitures.remove(i);
                System.out.println("\nVoiture supprimée : " + voitureSuppr.getImmatriculation() +
                        " (" + voitureSuppr.getMarque() + ")");
                return;
            }
        }
        throw new IllegalArgumentException("\nAucune voiture avec l'immatriculation " +
                immatriculation + " n'a été trouvée dans le parc.");
    }

    /**
     * Affiche les voitures du parc, avec possibilité de filtrer par statut
     * Si le statut est null, affiche toutes les voitures sans filtre.
     *
     * @param statut Le statut pour filtrer les voitures ou null pour afficher toutes les voitures
     */
    @Override
    public void afficherVoitures(Statut statut) {
        if (voitures.isEmpty()) {
            System.out.println("\nAucune voiture dans le parc.");
            return;
        }

        System.out.println("--- Parc de Voiture ---");

        int compteur = 0;

        for (int i = 0; i < voitures.size(); i++) {
            Voiture v = voitures.get(i);

            // Si pas de filtre OU si le statut correspond
            if (statut == null || v.getStatut() == statut) {
                System.out.println(v);
                compteur++;
            }
        }
        if (compteur == 0 && statut != null) {
            System.out.println("\nAucune voiture avec le statut : " + statut);
        }

        System.out.println("--------------");
    }

    /**
     * Retourne la liste complète de toutes les voitures du parc
     *
     * @return La liste des voitures
     */
    public List<Voiture> getToutesLesVoitures() {
        return voitures;
    }

}
