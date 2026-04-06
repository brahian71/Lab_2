
public class BakerySystem {

    public static void main(String[] args) {

        TurnQueue queue = new TurnQueue();

        System.out.println("----- REGISTRANDO CLIENTES -----");
        queue.enqueue("Carlos");
        queue.enqueue("Maria");
        queue.enqueue("Andres");
        queue.enqueue("Lucia");
        queue.enqueue("Felipe");

        System.out.println();
        System.out.println("----- COLA COMPLETA -----");
        queue.display();

        System.out.println();
        System.out.println("----- SIGUIENTE TURNO -----");
        queue.peek();

        System.out.println();
        System.out.println("----- BUSCAR CLIENTES -----");
        queue.search("Lucia");
        queue.search("Pedro");

        System.out.println();
        System.out.println("----- ATENDIENDO 2 CLIENTES -----");
        TurnNode attended;
        attended = queue.dequeue();
        System.out.println("  Atendido: " + attended);
        attended = queue.dequeue();
        System.out.println("  Atendido: " + attended);

        System.out.println();
        System.out.println("----- COLA ACTUALIZADA -----");
        queue.display();

        System.out.println();
        System.out.println("----- REGISTRANDO MAS CLIENTES -----");
        queue.enqueue("Valentina");
        queue.enqueue("Santiago");

        System.out.println();
        System.out.println("----- COLA FINAL -----");
        queue.display();

        System.out.println();
        System.out.println("----- ATENDIENDO TODOS -----");
        while (!queue.isEmpty()) {
            attended = queue.dequeue();
            System.out.println("  Atendido: " + attended);
        }
        System.out.println("  Todos los clientes han sido atendidos.");

        System.out.println();
        System.out.println("----- COLA VACIA -----");
        queue.dequeue();
    }
}
