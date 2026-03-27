/*
 * Escenario 1 - Sistema de turnos en una panaderia
 * Proposito: Nodo para la cola de turnos. Almacena el nombre del cliente,
 *            su numero de turno y la referencia al siguiente nodo.
 * Autor: Brahian
 */

/**
 * Representa un turno individual dentro de la cola de la panaderia.
 * Cada nodo contiene la informacion del cliente y un enlace al
 * siguiente turno en la fila.
 */
public class TurnNode {

    String customerName;
    int turnNumber;
    TurnNode next;

    /**
     * Crea un nuevo nodo de turno con el nombre del cliente y su numero.
     *
     * @param customerName nombre del cliente que solicita el turno
     * @param turnNumber   numero de turno asignado automaticamente
     */
    public TurnNode(String customerName, int turnNumber) {
        this.customerName = customerName;
        this.turnNumber = turnNumber;
        this.next = null;
    }

    /**
     * Devuelve una representacion legible del turno.
     *
     * @return cadena con formato "Turno #N - NombreCliente"
     */
    @Override
    public String toString() {
        return "Turno #" + turnNumber + " - " + customerName;
    }
}
