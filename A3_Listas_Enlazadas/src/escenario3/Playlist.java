
public class Playlist {

    private Node<Song> head;
    private Node<Song> tail;
    private Node<Song> currentSong;
    private int size;


    public Playlist() {
        
        head = null;
        tail = null;
        currentSong = null;
        size = 0;
    }

    public void addSong(Song song) {
        Node<Song> newNode = new Node<>(song);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;

            newNode.setNextNode(newNode);
            currentSong = newNode;
        } else {

            newNode.setNextNode(head);
            tail.setNextNode(newNode);
            tail = newNode;
        }

        size++;
    }

    public void playNext() {
        if (isEmpty()) {
            System.out.println("  La lista esta vacia.");
            return;
        }

        System.out.println("  Reproduciendo: " + currentSong.getValue());
        currentSong = currentSong.getNextNode();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  La lista esta vacia. No hay canciones.");
            return;
        }

        System.out.println("  Lista de reproduccion (" + size + " canciones):");
        Node<Song> current = head;
        int count = 0;

        while (count < size) {
            System.out.println("    -> " + current.getValue());
            current = current.getNextNode();
            count++;
        }
    }


    public void removeSong(String title) {
        if (isEmpty()) {
            System.out.println("  La lista esta vacia.");
            return;
        }

        Node<Song> current = head;
        Node<Song> previous = tail;
        int count = 0;

        while (count < size) {
            if (current.getValue().getTitle().equals(title)) {
                if (size == 1) {
                    // Era la unica cancion
                    head = null;
                    tail = null;
                    currentSong = null;
                } else if (current == head) {
                    head = head.getNextNode();

                    tail.setNextNode(head);
                    if (currentSong == current) {
                        currentSong = head;
                    }
                } else if (current == tail) {
                    tail = previous;
                    tail.setNextNode(head);
                    if (currentSong == current) {
                        currentSong = head;
                    }
                } else {
                    previous.setNextNode(current.getNextNode());
                    if (currentSong == current) {
                        currentSong = current.getNextNode();
                    }
                }

                size--;
                System.out.println("  Cancion eliminada: " + current.getValue());
                return;
            }

            previous = current;
            current = current.getNextNode();
            count++;
        }

        System.out.println("  Cancion \"" + title + "\" no encontrada.");
    }

    public Node<Song> search(String title) {
        if (isEmpty()) {
            System.out.println("  La lista esta vacia.");
            return null;
        }

        Node<Song> current = head;
        int count = 0;

        while (count < size) {
            if (current.getValue().getTitle().equals(title)) {
                System.out.println("  Cancion encontrada: " + current.getValue());
                return current;
            }
            current = current.getNextNode();
            count++;
        }

        System.out.println("  Cancion \"" + title + "\" no se encuentra en la lista.");
        return null;
    }
}
