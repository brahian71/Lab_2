package A3_Listas_Enlazadas.src.escenario4;

public class Main {

    public static void main(String[] args) {

        TurnList list = new TurnList();

        list.add("Juan");
        list.add("Maria");
        list.add("Pedro");
        list.add("Luisa");

        System.out.println("----- LISTA INICIAL -----");
        list.show();

        System.out.println();
        System.out.println("----- JUGADOR ACTUAL -----");
        list.showCurrent();

        System.out.println();
        System.out.println("----- JUGADORES ALREDEDOR -----");
        list.showPlayersAround();

        System.out.println();
        System.out.println("----- SIGUIENTE TURNO -----");
        list.nextTurn();

        System.out.println();
        System.out.println("----- SIGUIENTE TURNO -----");
        list.nextTurn();

        System.out.println();
        System.out.println("----- TURNO ANTERIOR -----");
        list.previousTurn();

        System.out.println();
        System.out.println("----- BUSCAR JUGADOR -----");
        list.search("Pedro");
        list.search("Carlos");

        System.out.println();
        System.out.println("----- ELIMINAR JUGADOR -----");
        list.remove("Maria");

        System.out.println();
        System.out.println("----- LISTA ACTUALIZADA -----");
        list.show();

        System.out.println();
        System.out.println("----- CONTINUAR TURNOS -----");
        list.nextTurn();
        list.nextTurn();
        list.previousTurn();
    }
}