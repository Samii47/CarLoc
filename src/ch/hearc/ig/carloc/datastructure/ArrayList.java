package ch.hearc.ig.carloc.datastructure;

/**
 * Une structure de données qui fonctionne comme un tableau dynamique. Elle est générique
 * et peut contenir des éléments de tout types.
 * Fonctionnalités de base comme ajouter, supprimer et accéder à des éléments de la liste
 *
 * @param <E> type d'élément que l'ArrayList peut contenir
 */
public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10; // Capacité initiale du tableau
    private E[] elements; // Tableau interne pour stocker les éléments de type E
    private int size = 0; // Nombre actuel d’éléments

    // Constructeurs
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Renvoie le nombre d’éléments actuellement stockés dans le tableau.
     * @return la taille actuelle du tableau
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Vérifie si le tableau est vite
     * @return true si il est vide, sinon false
     */
    @Override
    public boolean isEmpty() {
        return  size == 0;
    }

    /**
     * Recupere l'élément à l'index indiqué
     * @param i L’index de l’élément à retourner
     * @return l'élément de l'index spécifié
     * @throws IndexOutOfBoundsException si l'index est hors limite
     */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return elements[i];
    }

    /**
     * Remplace l’élément à l’index spécifié par un nouvel élément
     * @param i L’index de l’élément à remplacer
     * @param element Le nouvel élément à stocker à l’index
     * @return L’ancien élément qui a été remplacé
     */
    @Override
    public E set(int i, E element) {
        checkIndex(i, size);
        E temp = elements[i];
        elements[i] = element;
        return temp;
    }

    /**
     * Insère un élément à l’index spécifié et décale les éléments suivants vers la droite
     * @param i L’index où insérer le nouvel élément
     * @param element L'élément à insérer
     */
    @Override
    public void add(int i, E element) {
        checkIndex(i, size + 1);
        checkCapacity();
        for(int j = size - 1; j >= i; j--) {
            elements[j + 1] = elements[j];
        }
        elements[i] = element;
        size++;
    }

    /**
     * Ajoute un élément à la fin du tableau
     * @param element L'élément à ajouter
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * Supprime l’élément à l’index spécifié et décale les éléments suivants vers la gauche
     * @param i L'index de l'élément qu'on veut supprimer
     * @return L’élément supprimé
     */
    @Override
    public E remove(int i) {
        checkIndex(i, size);
        E temp = elements[i];

        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null;
        size--;
        return temp;
    }

    /**
     * Méthode utilitaire pour vérifier si l’index est dans la plage valide
     * @param i L’index à vérifier
     * @param n La limite supérieure pour l’index (taille du tableau)
     * @throws IndexOutOfBoundsException si l’index n’est pas valide
     */
    protected void checkIndex(int i, int n) {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * Méthode utilitaire pour vérifier si le tableau est plein. Si c’est le cas, ça lance une exception
     * @throws IllegalStateException si le tableau est plein
     */
    protected void checkCapacity() {
        if(size == elements.length) {
            throw new IllegalStateException("Array is full");
        }
    }
}
