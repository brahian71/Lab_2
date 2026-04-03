package escenario4;

public class Node {

    String player;
    Node next;
    Node prev;

    public Node(String player) {
        this.player = player;
        next = null;
        prev = null;
    }
}