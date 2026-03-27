/*
 * Escenario 2 - Historial de navegacion de un navegador web
 * Proposito: Clase principal demostrativa que ejercita todas las
 *            operaciones del historial de navegacion (visitar,
 *            retroceder, avanzar, buscar, eliminar y mostrar).
 * Autor: Brahian
 */

/**
 * Aplicacion demostrativa (no interactiva) que simula el uso
 * del historial de navegacion de un navegador web, mostrando
 * el comportamiento de cada operacion disponible.
 */
public class BrowserApp {

    /**
     * Ejecuta la secuencia demostrativa del historial de navegacion.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();

        printHeader("HISTORIAL DE NAVEGACION");

        // --- 1. Visitar 5 paginas ---
        printSection("1. Visitando paginas");
        history.visit("https://google.com", "Google");
        history.visit("https://youtube.com", "YouTube");
        history.visit("https://github.com", "GitHub");
        history.visit("https://stackoverflow.com", "Stack Overflow");
        history.visit("https://wikipedia.org", "Wikipedia");

        // --- 2. Mostrar historial completo ---
        printSection("2. Historial completo");
        history.displayHistory();

        // --- 3. Buscar paginas ---
        printSection("3. Busqueda de paginas");
        history.search("https://github.com");
        history.search("https://reddit.com");

        // --- 4. Retroceder 2 veces ---
        printSection("4. Retrocediendo 2 paginas");
        history.back();
        printCurrentPage(history);
        history.back();
        printCurrentPage(history);

        // --- 5. Mostrar historial (GitHub debe ser actual) ---
        printSection("5. Historial tras retroceder");
        history.displayHistory();

        // --- 6. Avanzar 1 vez ---
        printSection("6. Avanzando 1 pagina");
        history.forward();
        printCurrentPage(history);

        // --- 7. Visitar nueva pagina (trunca futuro) ---
        printSection("7. Visitando nueva pagina (trunca futuro)");
        history.visit("https://reddit.com", "Reddit");

        // --- 8. Intentar avanzar (no es posible) ---
        printSection("8. Intentando avanzar (caso borde)");
        history.forward();

        // --- 9. Mostrar historial actualizado ---
        printSection("9. Historial actualizado");
        history.displayHistory();

        // --- 10. Eliminar pagina ---
        printSection("10. Eliminando YouTube del historial");
        history.removePage("https://youtube.com");

        // --- 11. Historial despues de eliminacion ---
        printSection("11. Historial tras eliminacion");
        history.displayHistory();

        // --- 12. Retroceder hasta el inicio ---
        printSection("12. Retrocediendo hasta el inicio");
        while (history.canGoBack()) {
            history.back();
            printCurrentPage(history);
        }

        // --- 13. Intentar retroceder en el inicio ---
        printSection("13. Intentando retroceder en el inicio");
        history.back();
    }

    // ---------------------------------------------------------------
    //  Metodos auxiliares de formato
    // ---------------------------------------------------------------

    /**
     * Imprime un encabezado principal con formato destacado.
     *
     * @param text texto del encabezado
     */
    private static void printHeader(String text) {
        System.out.println("=== " + text + " ===");
        System.out.println();
    }

    /**
     * Imprime un separador de seccion con titulo descriptivo.
     *
     * @param text texto descriptivo de la seccion
     */
    private static void printSection(String text) {
        System.out.println();
        System.out.println("--- " + text + " ---");
    }

    /**
     * Imprime la pagina actual del historial.
     *
     * @param history instancia del historial de navegacion
     */
    private static void printCurrentPage(BrowserHistory history) {
        PageNode currentPage = history.getCurrentPage();
        if (currentPage != null) {
            System.out.println("  Pagina actual: " + currentPage);
        } else {
            System.out.println("  No hay pagina actual.");
        }
    }
}
