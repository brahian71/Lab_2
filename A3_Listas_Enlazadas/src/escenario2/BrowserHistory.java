
public class BrowserHistory {

    private PageNode head;
    private PageNode current;
    private int size;

    public BrowserHistory() {
        head = null;
        current = null;
        size = 0;
    }

    // Visita una nueva pagina
    public void visit(String url, String title) {
        PageNode newPage = new PageNode(url, title);

        if (head == null) {
            head = newPage;
            current = newPage;
            size = 1;
            System.out.println("Pagina visitada: " + newPage);
            return;
        }

        // Si estamos en medio del historial, borrar lo que sigue
        if (current.next != null) {
            PageNode temp = current.next;
            while (temp != null) {
                PageNode nextPage = temp.next;
                temp.prev = null;
                temp.next = null;
                temp = nextPage;
                size--;
            }
            current.next = null;
        }

        newPage.prev = current;
        current.next = newPage;
        current = newPage;
        size++;
        System.out.println("Pagina visitada: " + newPage);
    }

    // Elimina una pagina por URL
    public void removePage(String url) {
        if (head == null) {
            System.out.println("El historial esta vacio.");
            return;
        }

        PageNode temp = head;

        while (temp != null) {
            if (temp.url.equals(url)) {

                if (size == 1) {
                    head = null;
                    current = null;
                    size = 0;
                } else {
                    if (temp.prev != null) {
                        temp.prev.next = temp.next;
                    }
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }

                    if (temp == head) {
                        head = temp.next;
                    }
                    if (temp == current) {
                        current = (temp.prev != null) ? temp.prev : temp.next;
                    }
                    size--;
                }

                System.out.println("Pagina eliminada: " + temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Pagina no encontrada: " + url);
    }

    // Busca una pagina por URL
    public PageNode search(String url) {
        PageNode temp = head;

        while (temp != null) {
            if (temp.url.equals(url)) {
                System.out.println("Pagina encontrada: " + temp);
                return temp;
            }
            temp = temp.next;
        }

        System.out.println("Pagina no encontrada: " + url);
        return null;
    }

    // Muestra el historial completo
    public void displayHistory() {
        if (head == null) {
            System.out.println("El historial esta vacio.");
            return;
        }

        System.out.println("Historial (" + size + " paginas):");
        PageNode temp = head;
        int i = 1;

        while (temp != null) {
            if (temp == current) {
                System.out.println("  " + i + ". " + temp + " <- actual");
            } else {
                System.out.println("  " + i + ". " + temp);
            }
            temp = temp.next;
            i++;
        }
    }

    // Retrocede una pagina
    public PageNode back() {
        if (current == null) {
            System.out.println("No hay historial.");
            return null;
        }
        if (current.prev == null) {
            System.out.println("Ya estas en la primera pagina.");
            return current;
        }

        current = current.prev;
        System.out.println("Retrocediendo a: " + current);
        return current;
    }

    // Avanza una pagina
    public PageNode forward() {
        if (current == null) {
            System.out.println("No hay historial.");
            return null;
        }
        if (current.next == null) {
            System.out.println("Ya estas en la ultima pagina.");
            return current;
        }

        current = current.next;
        System.out.println("Avanzando a: " + current);
        return current;
    }

    // Devuelve la pagina actual
    public PageNode getCurrentPage() {
        return current;
    }

    // Verifica si se puede retroceder
    public boolean canGoBack() {
        return current != null && current.prev != null;
    }

    // Verifica si se puede avanzar
    public boolean canGoForward() {
        return current != null && current.next != null;
    }
}
