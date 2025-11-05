package ch.hearc.ig.carloc.business;

/**
 * Exception jetée lorsqu'une immatriculation est invalide
 * Exception métier de la couche business
 */
public class ImmatriculationInvalideException extends Exception {

    /**
     * Constructeur avec message d'erreur
     *
     * @param message Le message décrivant pourquoi l'immatriculation est invalide
     */
    public ImmatriculationInvalideException(String message) {
        super(message);
    }
}