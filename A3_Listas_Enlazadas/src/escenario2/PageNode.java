/*
 * Escenario 2 - Historial de navegacion de un navegador web
 * Proposito: Nodo de lista doblemente enlazada que representa
 *            una pagina web visitada en el historial.
 * Autor: Brahian
 */

/**
 * Representa una pagina web dentro del historial de navegacion.
 * Cada nodo almacena la URL, el titulo de la pagina y referencias
 * al nodo anterior y siguiente en la lista doblemente enlazada.
 */
public class PageNode {

    String url;
    String title;
    PageNode next;
    PageNode prev;

    /**
     * Crea un nodo de pagina con la URL y titulo indicados.
     * Las referencias next y prev inician en null.
     *
     * @param url   direccion web de la pagina
     * @param title titulo visible de la pagina
     */
    public PageNode(String url, String title) {
        this.url = url;
        this.title = title;
        this.next = null;
        this.prev = null;
    }

    /**
     * Retorna una representacion legible de la pagina.
     *
     * @return cadena con formato "Titulo (url)"
     */
    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
}
