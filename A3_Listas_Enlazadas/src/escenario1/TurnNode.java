
public class TurnNode {

    String customerName;
    int turnNumber;
    TurnNode next;

    public TurnNode(String customerName, int turnNumber) {
        this.customerName = customerName;
        this.turnNumber = turnNumber;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Turno #" + turnNumber + " - " + customerName;
    }
}
