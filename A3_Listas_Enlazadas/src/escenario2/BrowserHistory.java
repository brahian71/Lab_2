/*
 * Escenario 2 - Historial de navegacion de un navegador web
 * Proposito: Lista doblemente enlazada que gestiona el historial
 *            de paginas visitadas, con navegacion hacia atras y
 *            adelante, similar a un navegador real.
 * Autor: Brahian
 */

/**
 * Historial de navegacion implementado con lista doblemente enlazada.
 * Mantiene un puntero {@code current} que indica la pagina activa,
 * permitiendo navegar hacia atras y adelante, visitar nuevas paginas
 * y truncar el historial futuro cuando se visita una pagina desde
 * un punto intermedio.
 */
public class BrowserHistory {

    private PageNode head;
    private PageNode current;
    private int size;

    /**
     * Crea un historial de navegacion vacio.
     */
    public BrowserHistory() {
        this.head = null;
        this.current = null;
        this.size = 0;
    }

    // ---------------------------------------------------------------
    //  Metodos publicos
    // ---------------------------------------------------------------

    /**
     * Visita una nueva pagina web. Si el usuario esta en un punto
     * intermedio del historial, las paginas posteriores se eliminan
     * antes de agregar la nueva (comportamiento estandar de navegador).
     *
     * @param url   direccion web de la pagina a visitar
     * @param title titulo de la pagina
     */
    public void visit(String url, String title) {
        PageNode newPage = new PageNode(url, title);

        if (head == null) {
            head = newPage;
            current = newPage;
            size = 1;
            System.out.println("Pagina visitada: " + newPage);
            return;
        }

        // Eliminar historial futuro si existe
        if (current.next != null) {
            truncateForward();
        }

        newPage.prev = current;
        current.next = newPage;
        current = newPage;
        size++;
        System.out.println("Pagina visitada: " + newPage);
    }

    /**
     * Elimina una pagina del historial buscandola por URL.
     * Reconecta los nodos vecinos para mantener la integridad
     * de la lista. Si la pagina eliminada es la actual, mueve
     * el puntero current a la pagina anterior o siguiente.
     *
     * @param url direccion web de la pagina a eliminar
     */
    public void removePage(String url) {
        PageNode target = findNode(url);

        if (target == null) {
            System.out.println("No se encontro la pagina con URL: "
                + url);
            return;
        }

        if (size == 1) {
            head = null;
            current = null;
            size = 0;
            System.out.println("Pagina eliminada: " + target);
            return;
        }

        reconnectNeighbors(target);
        adjustHeadAndCurrent(target);
        size--;
        System.out.println("Pagina eliminada: " + target);
    }

    /**
     * Busca una pagina en el historial por su URL.
     *
     * @param url direccion web a buscar
     * @return el nodo encontrado, o null si no existe
     */
    public PageNode search(String url) {
        PageNode result = findNode(url);

        if (result != null) {
            System.out.println("Pagina encontrada: " + result);
        } else {
            System.out.println("No se encontro pagina con URL: "
                + url);
        }
        return result;
    }

    /**
     * Muestra el historial completo desde la primera pagina
     * hasta la ultima, marcando la pagina actual con [ACTUAL].
     */
    public void displayHistory() {
        if (head == null) {
            System.out.println("El historial esta vacio.");
            return;
        }

        System.out.println("Historial de navegacion ("
            + size + " paginas):");

        PageNode walker = head;
        int index = 1;
        while (walker != null) {
            String marker = (walker == current) ? " [ACTUAL]" : "";
            System.out.println("  " + index + ". " + walker + marker);
            walker = walker.next;
            index++;
        }
    }

    /**
     * Retrocede una pagina en el historial.
     *
     * @return la pagina actual despues de retroceder
     */
    public PageNode back() {
        if (current == null) {
            System.out.println("No hay historial de navegacion.");
            return null;
        }
        if (current.prev == null) {
            System.out.println("No se puede retroceder: ya esta "
                + "en la primera pagina.");
            return current;
        }

        current = current.prev;
        System.out.println("Retrocediendo a: " + current);
        return current;
    }

    /**
     * Avanza una pagina en el historial.
     *
     * @return la pagina actual despues de avanzar
     */
    public PageNode forward() {
        if (current == null) {
            System.out.println("No hay historial de navegacion.");
            return null;
        }
        if (current.next == null) {
            System.out.println("No se puede avanzar: ya esta "
                + "en la ultima pagina.");
            return current;
        }

        current = current.next;
        System.out.println("Avanzando a: " + current);
        return current;
    }

    /**
     * Retorna la pagina actual del historial.
     *
     * @return nodo de la pagina actual, o null si no hay historial
     */
    public PageNode getCurrentPage() {
        return current;
    }

    /**
     * Indica si es posible retroceder en el historial.
     *
     * @return true si hay una pagina anterior disponible
     */
    public boolean canGoBack() {
        return current != null && current.prev != null;
    }

    /**
     * Indica si es posible avanzar en el historial.
     *
     * @return true si hay una pagina siguiente disponible
     */
    public boolean canGoForward() {
        return current != null && current.next != null;
    }

    // ---------------------------------------------------------------
    //  Metodos privados / auxiliares
    // ---------------------------------------------------------------

    /**
     * Elimina todos los nodos posteriores a current,
     * liberando referencias para facilitar la recoleccion
     * de basura. Ajusta el tamano de la lista.
     */
    private void truncateForward() {
        PageNode walker = current.next;
        int removedCount = 0;

        while (walker != null) {
            PageNode nextNode = walker.next;
            // Limpiar referencias del nodo descartado
            walker.prev = null;
            walker.next = null;
            walker = nextNode;
            removedCount++;
        }

        current.next = null;
        size -= removedCount;
    }

    /**
     * Busca un nodo por URL recorriendo la lista desde head.
     *
     * @param url direccion web a buscar
     * @return el nodo si se encuentra, null en caso contrario
     */
    private PageNode findNode(String url) {
        PageNode walker = head;
        while (walker != null) {
            if (walker.url.equals(url)) {
                return walker;
            }
            walker = walker.next;
        }
        return null;
    }

    /**
     * Reconecta los nodos vecinos de un nodo que sera eliminado.
     *
     * @param target nodo a desconectar de la lista
     */
    private void reconnectNeighbors(PageNode target) {
        if (target.prev != null) {
            target.prev.next = target.next;
        }
        if (target.next != null) {
            target.next.prev = target.prev;
        }
    }

    /**
     * Ajusta head y current si el nodo eliminado era alguno de ellos.
     *
     * @param target nodo que fue eliminado
     */
    private void adjustHeadAndCurrent(PageNode target) {
        if (target == head) {
            head = target.next;
        }
        if (target == current) {
            current = (target.prev != null)
                ? target.prev
                : target.next;
        }
    }
}
