
public class TurnQueue {

    private TurnNode head;
    private TurnNode tail;
    private int size;
    private int nextTurnNumber;

    public TurnQueue() {
        head = null;
        tail = null;
        size = 0;
        nextTurnNumber = 1;
    }

    // Registra un nuevo cliente
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

    // Atiende al cliente del frente
    public TurnNode dequeue() {
        if (isEmpty()) {
            System.out.println("  No hay clientes en la cola.");
            return null;
        }

        TurnNode attended = head;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        attended.next = null;
        return attended;
    }

    // Busca un cliente por nombre
    public TurnNode search(String customerName) {
        TurnNode current = head;

        while (current != null) {
            if (current.customerName.equals(customerName)) {
                System.out.println("  Cliente encontrado: " + current);
                return current;
            }
            current = current.next;
        }

        System.out.println("  Cliente \"" + customerName + "\" no encontrado.");
        return null;
    }

    // Muestra la cola completa
    public void display() {
        if (isEmpty()) {
            System.out.println("  La cola esta vacia.");
            return;
        }

        System.out.println("  Cola de turnos (" + size + " en espera):");
        TurnNode current = head;

        while (current != null) {
            System.out.println("    -> " + current);
            current = current.next;
        }
    }

    // Consulta el siguiente sin sacarlo
    public TurnNode peek() {
        if (isEmpty()) {
            System.out.println("  La cola esta vacia.");
            return null;
        }

        System.out.println("  Siguiente en ser atendido: " + head);
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}
