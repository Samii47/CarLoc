package ch.hearc.ig.carloc.app;

import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.business.Tarif;
import ch.hearc.ig.carloc.business.TypeMotorisation;
import ch.hearc.ig.carloc.business.Voiture;
import ch.hearc.ig.carloc.business.Camion;
import ch.hearc.ig.carloc.business.Moto;
import ch.hearc.ig.carloc.business.Vehicule;
import ch.hearc.ig.carloc.service.VehiculeService;
import ch.hearc.ig.carloc.datastructure.ArrayList;
import ch.hearc.ig.carloc.datastructure.List;
import ch.hearc.ig.carloc.business.ImmatriculationInvalideException;
import ch.hearc.ig.carloc.business.Categorie;
import ch.hearc.ig.carloc.service.VehiculeServiceInterface;

/**
 * Classe principale de l'App CarLoc.
 * Permet de gérer un parc de véhicules de location avec les fonctionnalités
 * d'ajout, de suppression et d'affichage des véhicules.
 *
 * @author Sami.Cögür
 */
public class CarLocApp {
    public static void main(String[] args) {

        VehiculeServiceInterface service = new VehiculeService();

        // Création de différents types de véhicules (POLYMORPHISME !)
        Voiture voiture1 = new Voiture(
                "BE9351",
                "Audi",
                2015,
                Categorie.CITADINE,
                Statut.DISPONIBLE,
                new Tarif(45, "CHF"),
                TypeMotorisation.THERMIQUE);

        Voiture voiture2 = new Voiture(
                "JU24491",
                "BMW",
                2025,
                Categorie.SUV,
                Statut.LOUEE,
                new Tarif(60, "CHF"),
                TypeMotorisation.HYBRIDE);

        Camion camion1 = new Camion(
                "VD7788",
                "Volvo",
                2020,
                Categorie.POIDS_LOURD,
                Statut.DISPONIBLE,
                new Tarif(120, "CHF"),
                TypeMotorisation.THERMIQUE);

        Camion camion2 = new Camion(
                "FR3344",
                "MAN",
                2022,
                Categorie.UTILITAIRE,
                Statut.EN_MAINTENANCE,
                new Tarif(95, "CHF"),
                TypeMotorisation.THERMIQUE);

        Moto moto1 = new Moto(
                "GE5566",
                "Harley-Davidson",
                2023,
                Categorie.SPORTIVE,
                Statut.DISPONIBLE,
                new Tarif(75, "CHF"),
                TypeMotorisation.THERMIQUE);

        Moto moto2 = new Moto(
                "NE9988",
                "Yamaha",
                2024,
                Categorie.SPORTIVE,
                Statut.LOUEE,
                new Tarif(65, "CHF"),
                TypeMotorisation.ELECTRIQUE);

// Ajout des véhicules au parc (POLYMORPHISME : tous traités comme des Vehicule)
        try {
            service.ajouterVehicule(voiture1);
            service.ajouterVehicule(voiture2);
            service.ajouterVehicule(camion1);
            service.ajouterVehicule(camion2);
            service.ajouterVehicule(moto1);
            service.ajouterVehicule(moto2);
        } catch (ImmatriculationInvalideException e) {
            System.out.println("Exception attrapée : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Affichage de tous les véhicules
        System.out.println("\n=== Affichage de tous les véhicules ===");
        service.afficherVehicules(null);

        // Affichage des véhicules DISPONIBLES uniquement
        System.out.println("\n=== Affichage des véhicules DISPONIBLES ===");
        service.afficherVehicules(Statut.DISPONIBLE);

        // Test d'ajout d'un véhicule avec une immatriculation existante
        System.out.println("\n=== Test d'immatriculation dupliquée ===");
        try {
            Voiture voitureDupliquee = new Voiture(
                    "BE9351",
                    "Tesla",
                    2022,
                    Categorie.SUV,
                    Statut.DISPONIBLE,
                    new Tarif(110, "CHF"),
                    TypeMotorisation.ELECTRIQUE);
            service.ajouterVehicule(voitureDupliquee);
        } catch (ImmatriculationInvalideException e) {
            System.out.println("Exception attrapée : " + e.getMessage()); // MAIN
        } catch (IllegalArgumentException e) {
            System.out.println("Exception attrapée : " + e.getMessage()); // MAIN
        }

        // Test d'ajout d'un véhicule avec une immatriculation INVALIDE (pour tester l'exception)
        System.out.println("\n=== Test d'immatriculation invalide ===");
        try {
            Voiture voitureInvalide = new Voiture(
                    "AB",  // Immatriculation trop courte !
                    "Tesla",
                    2023,
                    Categorie.CITADINE,
                    Statut.DISPONIBLE,
                    new Tarif(100, "CHF"),
                    TypeMotorisation.ELECTRIQUE);
            service.ajouterVehicule(voitureInvalide);
        } catch (ImmatriculationInvalideException e) {
            System.out.println("Exception attrapée : " + e.getMessage()); // MAIN
        }

        // Suppression d'un camion
        try {
            service.supprimerVehicule("FR3344");
        } catch (IllegalArgumentException e) {
            System.out.println("\nException attrapée : " + e.getMessage());
        }

        // Affichage après suppression
        System.out.println("\n=== Après suppression d'un véhicule ===");
        service.afficherVehicules(null);

        // Test de suppression d'un véhicule inexistant
        try {
            service.supprimerVehicule("XX9999");
        } catch (IllegalArgumentException e) {
            System.out.println("\nException attrapée : " + e.getMessage());
        }

        // Test d'index invalide sur ArrayList (IndexOutOfBoundsException)
        List<Vehicule> listeTest = new ArrayList<>();
        try {
            listeTest.add(1, new Voiture(
                    "TEST123",
                    "Voiture Test",
                    2020,
                    Categorie.BERLINE,
                    Statut.DISPONIBLE,
                    new Tarif(50, "CHF"),
                    TypeMotorisation.THERMIQUE));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nException attrapée : " + e.getMessage());
        }
    }
}
