/*
 * Escenario 1 - Sistema de turnos en una panaderia
 * Proposito: Cola FIFO implementada con lista simplemente enlazada.
 *            Gestiona los turnos de atencion en la panaderia con
 *            operaciones de enqueue, dequeue, busqueda y consulta.
 * Autor: Brahian
 */

/**
 * Cola de turnos implementada con lista simplemente enlazada.
 * Mantiene punteros al frente (head) y al final (tail) para
 * garantizar operaciones de insercion y remocion en O(1).
 */
public class TurnQueue {

    private TurnNode head;
    private TurnNode tail;
    private int size;
    private int nextTurnNumber;

    /**
     * Crea una cola de turnos vacia. El contador de turnos
     * inicia en 1 y se autoincrementa con cada registro.
     */
    public TurnQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.nextTurnNumber = 1;
    }

    /**
     * Registra un nuevo cliente al final de la cola, asignandole
     * un numero de turno autoincremental.
     *
     * @param customerName nombre del cliente a registrar
     */
    public void enqueue(String customerName) {
        TurnNode newNode = new TurnNode(customerName, nextTurnNumber);
        nextTurnNumber++;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        System.out.println("  Cliente registrado: " + newNode);
    }

    /**
     * Atiende (remueve) al cliente que esta al frente de la cola.
     * Si la cola queda vacia tras la remocion, tail tambien se anula.
     *
     * @return el nodo del cliente atendido, o null si la cola esta vacia
     */
    public TurnNode dequeue() {
        if (isEmpty()) {
            System.out.println("  No hay clientes en la cola para atender.");
            return null;
        }

        TurnNode attended = head;
        head = head.next;
        size--;

        // Si la cola quedo vacia, tail debe reflejar ese estado
        if (head == null) {
            tail = null;
        }

        attended.next = null;
        return attended;
    }

    /**
     * Busca un cliente por nombre recorriendo toda la cola.
     * Imprime un mensaje indicando si el cliente fue encontrado o no.
     *
     * @param customerName nombre del cliente a buscar
     * @return el nodo del cliente si existe, null si no se encuentra
     */
    public TurnNode search(String customerName) {
        TurnNode current = head;

        while (current != null) {
            if (current.customerName.equals(customerName)) {
                System.out.println("  Cliente encontrado: " + current);
                return current;
            }
            current = current.next;
        }

        System.out.println("  Cliente \"" + customerName
                + "\" no se encuentra en la cola.");
        return null;
    }

    /**
     * Muestra todos los turnos en la cola, desde el frente hasta el final.
     * Si la cola esta vacia, lo indica con un mensaje.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("  La cola esta vacia. No hay turnos.");
            return;
        }

        System.out.println("  Cola de turnos (" + size + " en espera):");
        TurnNode current = head;

        while (current != null) {
            System.out.println("    -> " + current);
            current = current.next;
        }
    }

    /**
     * Consulta el cliente que esta al frente de la cola sin removerlo.
     *
     * @return el nodo del frente, o null si la cola esta vacia
     */
    public TurnNode peek() {
        if (isEmpty()) {
            System.out.println("  La cola esta vacia. No hay siguiente turno.");
            return null;
        }

        System.out.println("  Siguiente en ser atendido: " + head);
        return head;
    }

    /**
     * Verifica si la cola no tiene ningun turno registrado.
     *
     * @return true si la cola esta vacia, false en caso contrario
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Retorna la cantidad de turnos actualmente en la cola.
     *
     * @return numero de clientes esperando
     */
    public int getSize() {
        return size;
    }
}
