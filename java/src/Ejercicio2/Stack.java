package Ejercicio2;

public interface Stack {

    /**
     * Precondición: La pila no este llena
     * Postcondición: El argumento queda en el tope
     * Estrategia: Tomo el valor, y en la estructura interna, que está indexada,
     * defino una posición destacada (que signifique nuestro tope) y coloque
     * el calor valor dado en el tope.
     * @param a es un valor a apilar
     */

    /**
     * - Postcondición: cada vez que se agrega un elemento nuevo, este se agrega al tope y se crea una nueva versión
     */
    void add(int a);

    /**
     * - Precondición: la pila no está vacía
     * - Postcondición: se elimina un elemento del tope y se genera una nueva versión
     */
    void remove();

    /**
     * - Precondición: la pila no está vacía
     * - Postcondición: se obtiene un elemento del tope
     */
    int getTop();
    boolean isEmpty();

}
