package ch.hearc.ig.carloc.business;

/**
 * Enumération représentant les différents statuts possibles d'un véhicule dans le parc de location
 */
public enum Statut {
    DISPONIBLE, // Le véhicule est disponible pour la location
    LOUEE, // Le véhicule est actuellement loué par un client
    EN_MAINTENANCE // Le véhicule est en maintenance et n'est pas disponible
}
