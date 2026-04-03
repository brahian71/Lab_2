package escenario4;

public class TurnList {

    Node head;
    Node current;

    public TurnList() {
        head = null;
        current = null;
    }

    // Agrega un jugador
    public void add(String player) {
        Node newNode = new Node(player);

        // Si la lista está vacía
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            current = head;
        } else {
            Node last = head.prev;

            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Elimina un jugador por nombre
    public void remove(String player) {
        if (head == null) {
            System.out.println("No hay jugadores.");
            return;
        }

        Node temp = head;

        do {
            if (temp.player.equalsIgnoreCase(player)) {

                // Si solo hay un jugador
                if (temp.next == temp) {
                    head = null;
                    current = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;

                    if (temp == head) {
                        head = temp.next;
                    }

                    if (temp == current) {
                        current = temp.next;
                    }
                }

                System.out.println("Jugador eliminado: " + player);
                return;
            }

            temp = temp.next;
        } while (temp != head);

        System.out.println("Jugador no encontrado.");
    }

    // Busca un jugador
    public void search(String player) {
        if (head == null) {
            System.out.println("No hay jugadores.");
            return;
        }

        Node temp = head;

        do {
            if (temp.player.equalsIgnoreCase(player)) {
                System.out.println("Jugador encontrado: " + temp.player);
                return;
            }

            temp = temp.next;
        } while (temp != head);

        System.out.println("Jugador no encontrado.");
    }

    // Muestra todos los jugadores
    public void show() {
        if (head == null) {
            System.out.println("No hay jugadores.");
            return;
        }

        Node temp = head;

        System.out.println("Jugadores en la partida:");

        do {
            if (temp == current) {
                System.out.println(temp.player + " <- turno actual");
            } else {
                System.out.println(temp.player);
            }

            temp = temp.next;
        } while (temp != head);
    }

    // Pasa al siguiente turno
    public void nextTurn() {
        if (current == null) {
            System.out.println("No hay jugadores.");
            return;
        }

        current = current.next;
        System.out.println("Turno actual: " + current.player);
    }

    // Vuelve al turno anterior
    public void previousTurn() {
        if (current == null) {
            System.out.println("No hay jugadores.");
            return;
        }

        current = current.prev;
        System.out.println("Turno actual: " + current.player);
    }

    // Muestra el jugador actual
    public void showCurrent() {
        if (current == null) {
            System.out.println("No hay jugador actual.");
        } else {
            System.out.println("Jugador actual: " + current.player);
        }
    }

    // Muestra el jugador anterior y el siguiente
    public void showPlayersAround() {
        if (current == null) {
            System.out.println("No hay jugadores.");
            return;
        }

        System.out.println("Jugador anterior: " + current.prev.player);
        System.out.println("Jugador actual: " + current.player);
        System.out.println("Jugador siguiente: " + current.next.player);
    }
}