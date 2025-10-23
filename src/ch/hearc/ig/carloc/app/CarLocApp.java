package ch.hearc.ig.carloc.app;

import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.business.Tarif;
import ch.hearc.ig.carloc.business.TypeMotorisation;
import ch.hearc.ig.carloc.business.Voiture;
import ch.hearc.ig.carloc.service.VehiculeService;
import ch.hearc.ig.carloc.datastructure.ArrayList;
import ch.hearc.ig.carloc.datastructure.List;

public class CarLocApp {
    public static void main(String[] args) {

        VehiculeService service = new VehiculeService();

        Voiture voiture1 = new Voiture(
                "BE9351",
                "Audi",
                2015,
                "CITADINE",
                Statut.DISPONIBLE,
                new Tarif(45, "CHF"),
                TypeMotorisation.THERMIQUE);

        Voiture voiture2 = new Voiture(
                "JU24491",
                "BMW",
                2025,
                "SUV",
                Statut.LOUEE,
                new Tarif(60, "CHF"),
                TypeMotorisation.HYBRIDE);

        Voiture voiture3 = new Voiture(
                "NE4567",
                "DACIA",
                2018,
                "UTILITAIRE",
                Statut.EN_MAINTENANCE,
                new Tarif(30, "CHF"),
                TypeMotorisation.ELECTRIQUE);
        try {
            service.ajouterVoiture(voiture1);
            service.ajouterVoiture(voiture2);
            service.ajouterVoiture(voiture3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        // Affichage de toutes les voitures
        System.out.println("\nAffichage de toutes les voitures :");
        service.afficherVoitures(null);

        // Affichage des voitures DISPONIBLE
        System.out.println("\nAffichage des voitures DISPONIBLE :");
        service.afficherVoitures(Statut.DISPONIBLE);

        // Test ajout d'une voiture existante (uniquement même immatriculation)
        try {
            Voiture voitureDupliquee = new Voiture("BE9351", "Tesla", 2022, "SUV", Statut.DISPONIBLE, new Tarif(110, "CHF"), TypeMotorisation.ELECTRIQUE);
            service.ajouterVoiture(voitureDupliquee);
        } catch (IllegalArgumentException e) {
            System.out.println("\nException attrapée : " + e.getMessage());
        }

        // Suppression d'une voiture (selon immatriculation)
        try {
            service.supprimerVoiture("JU24491");
        } catch (IllegalArgumentException e) {
            System.out.println("\nException attrapée : " + e.getMessage());
        }

        // Affichage après suppression
        System.out.println("\nAprès suppression d'une voiture :");
        service.afficherVoitures(null);

        // Test suppression d'une voiture qui n'existe pas
        try {
            service.supprimerVoiture("XX9999");
        } catch (IllegalArgumentException e) {
            System.out.println("\nException attrapée : " + e.getMessage());
        }
        // Test d'index invalide sur ArrayList (IndexOutOfBoundsException)
        List<Voiture> listeTest = new ArrayList<>();
        try {
            // Tentative d'ajout à l'index 1 dans une liste vide (seul index valide: 0)
            listeTest.add(1, new Voiture(
                    "TEST123",
                    "Voiture Test",
                    2020,
                    "TEST",
                    Statut.DISPONIBLE,
                    new Tarif(50, "CHF"),
                    TypeMotorisation.THERMIQUE));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception attrapée : " + e.getMessage());
        }
    }
}
