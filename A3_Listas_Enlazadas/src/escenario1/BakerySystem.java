/*
 * Escenario 1 - Sistema de turnos en una panaderia
 * Proposito: Clase principal demostrativa. Ejecuta una secuencia de
 *            operaciones sobre la cola de turnos para evidenciar el
 *            comportamiento FIFO y el manejo de casos borde.
 * Autor: Brahian
 */

/**
 * Programa demostrativo (no interactivo) que simula el sistema
 * de turnos de una panaderia usando una cola FIFO enlazada.
 */
public class BakerySystem {

    /**
     * Ejecuta la demostracion completa del sistema de turnos.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        TurnQueue queue = new TurnQueue();

        printHeader("SISTEMA DE TURNOS — PANADERIA");

        registerInitialCustomers(queue);
        showFullQueue(queue);
        peekNextCustomer(queue);
        searchCustomers(queue);
        attendFirstTwoCustomers(queue);
        showUpdatedQueue(queue);
        registerAdditionalCustomers(queue);
        showFinalQueue(queue);
        attendAllRemaining(queue);
        attemptAttendOnEmptyQueue(queue);
    }

    // ---------------------------------------------------------------
    //  Metodos auxiliares para cada bloque de la demostracion
    // ---------------------------------------------------------------

    private static void registerInitialCustomers(TurnQueue queue) {
        printSection("Registrando clientes iniciales");
        queue.enqueue("Carlos");
        queue.enqueue("Maria");
        queue.enqueue("Andres");
        queue.enqueue("Lucia");
        queue.enqueue("Felipe");
    }

    private static void showFullQueue(TurnQueue queue) {
        printSection("Cola completa de turnos");
        queue.display();
    }

    private static void peekNextCustomer(TurnQueue queue) {
        printSection("Consultando siguiente turno (peek)");
        queue.peek();
    }

    private static void searchCustomers(TurnQueue queue) {
        printSection("Busqueda de clientes");
        System.out.println("  Buscando a Lucia:");
        queue.search("Lucia");
        System.out.println();
        System.out.println("  Buscando a Pedro:");
        queue.search("Pedro");
    }

    private static void attendFirstTwoCustomers(TurnQueue queue) {
        printSection("Atendiendo a los 2 primeros clientes");
        TurnNode attended;

        attended = queue.dequeue();
        System.out.println("  Atendido: " + attended);

        attended = queue.dequeue();
        System.out.println("  Atendido: " + attended);
    }

    private static void showUpdatedQueue(TurnQueue queue) {
        printSection("Cola actualizada tras atencion");
        queue.display();
    }

    private static void registerAdditionalCustomers(TurnQueue queue) {
        printSection("Registrando clientes adicionales");
        queue.enqueue("Valentina");
        queue.enqueue("Santiago");
    }

    private static void showFinalQueue(TurnQueue queue) {
        printSection("Cola final con nuevos registros");
        queue.display();
    }

    private static void attendAllRemaining(TurnQueue queue) {
        printSection("Atendiendo a todos los clientes restantes");

        while (!queue.isEmpty()) {
            TurnNode attended = queue.dequeue();
            System.out.println("  Atendido: " + attended);
        }

        System.out.println();
        System.out.println("  Todos los clientes han sido atendidos.");
    }

    private static void attemptAttendOnEmptyQueue(TurnQueue queue) {
        printSection("Intentando atender con cola vacia (caso borde)");
        queue.dequeue();
    }

    // ---------------------------------------------------------------
    //  Utilidades de formato para la salida por consola
    // ---------------------------------------------------------------

    /**
     * Imprime un encabezado principal con formato destacado.
     *
     * @param title texto del encabezado
     */
    private static void printHeader(String title) {
        System.out.println("=== " + title + " ===");
    }

    /**
     * Imprime un separador de seccion con titulo descriptivo.
     *
     * @param sectionName nombre de la seccion
     */
    private static void printSection(String sectionName) {
        System.out.println();
        System.out.println("--- " + sectionName + " ---");
    }
}
