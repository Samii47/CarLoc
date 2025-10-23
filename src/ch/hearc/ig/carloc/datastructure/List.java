package ch.hearc.ig.carloc.datastructure;

/**
 * Cette interface définit les opérations de base pour une structure de données
 * de type liste qui peut stocker des éléments de tout type (générique).
 * Elle a des méthodes pour ajouter, supprimer, vérification,...
 * @param <E> est le type d'éléments qui sont stockés
 */

public interface List<E> {
    /**
     *
     * @return la taille actuelle de la liste
     */
    int size();

    /**
     * Vérifie si la liste est vide
     * @return true si la liste ne contient pas d'élement,
     * au cas contraire false
     */
    boolean isEmpty();

    /**
     * Récupère l’élément à l’index spécifié
     * @param i L’index de l’élément à récupérer
     * @return L’élément à l’index spécifié
     * @throws IndexOutOfBoundsException si l’index est hors limites
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Remplace l’élément à l’index spécifié par un nouvel élément
     * @param i L’index de l’élément à remplacer
     * @param element Le nouvel élément à stocker
     * @return L’ancien élément qui a été remplacé
     */
    E set(int i, E element);

    /**
     * Insère un élément à l’index spécifié et décale les éléments suivants vers la droite.
     * @param i L’index où on veut insérer le nouvel élément.
     * @param element Le nouvel élément à stocker
     */
    void add(int i, E element);


    /**
     * Ajout d'un élément à la fin de la liste
     * @param element Le nouvel élément à stocker
     */
    void add(E element);

    /**
     * Supprime un élément à l'index spécifié et décale les éléments à gauche
     * @param i L'index de l'élément qu'on veut supprimer
     * @return L'élément supprimé
     */
    E remove(int i);
}
