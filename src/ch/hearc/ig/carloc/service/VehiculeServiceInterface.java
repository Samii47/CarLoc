package ch.hearc.ig.carloc.service;

import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.business.Voiture;

public interface VehiculeServiceInterface {

    void ajouterVoiture(Voiture voiture);

    void supprimerVoiture(String immatriculation);

    void afficherVoitures(Statut statut);
}
