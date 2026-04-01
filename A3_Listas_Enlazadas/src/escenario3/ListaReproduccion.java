package laboratorio2.A3_Listas_Enlazadas.src.escenario3;

public class ListaReproduccion {


    private Nodo<Cancion> nodoPrimero;
    private Nodo<Cancion> nodoUltimo;
    private Nodo<Cancion> cancionActual;
    private int tamano;

    public ListaReproduccion() {
        nodoPrimero = null;
        nodoUltimo = null;
        cancionActual = null;
        tamano = 0;
    
}

public void agregarCancion(Cancion valorNodo){

    Nodo<Cancion> nuevoNodo = new Nodo<Cancion>(valorNodo);

    if(estaVacia())
		{
			nodoPrimero = nodoUltimo = nuevoNodo;
            nuevoNodo.setSiguienteNodo(nuevoNodo);
		}
		else
		{
			Nodo<Cancion> aux = nodoUltimo.getSiguienteNodo();
			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nuevoNodo.setSiguienteNodo(aux);
			nodoUltimo = nuevoNodo;
            cancionActual = nodoPrimero;
		}
		tamano++;
}

public void siguiente() {
    if(estaVacia()) {
        System.out.println("La lista está vacía");
        return;
    }
    System.out.println("Reproduciendo: " + cancionActual.getValorNodo());
    cancionActual = cancionActual.getSiguienteNodo();
}

public boolean estaVacia() {
	return(nodoPrimero == null)?true:false;
}

public void imprimirLista() {
		
	Nodo<Cancion> aux = nodoPrimero;

    int cont = 0;
		
	while(cont < tamano) {
		System.out.print( aux.getValorNodo()+"\t" );
		aux = aux.getSiguienteNodo();	
        cont++;
	}

	System.out.println();
}


public void eliminarCancion(String titulo) {

    if(estaVacia()) {
        System.out.println("La lista está vacía");
        return;
    }


    Nodo<Cancion> actual = nodoPrimero;
    Nodo<Cancion> anterior = null;
    int cont = 0;

    if(anterior == null) {
        
        if(tamano == 1) { 
            nodoPrimero = null;
            nodoUltimo = null;
    } else {
        nodoPrimero = actual.getSiguienteNodo();
        nodoUltimo.setSiguienteNodo(nodoPrimero);
        }
    }

    while(cont < tamano) {
        if(actual.getValorNodo().getTitulo().equals(titulo)) {
            
            if(anterior == null) {
                nodoPrimero = actual.getSiguienteNodo();
                nodoUltimo.setSiguienteNodo(nodoPrimero);
            } else {
                anterior.setSiguienteNodo(actual.getSiguienteNodo());
            }
            
            tamano--;
            return;
        }
        anterior = actual;
        actual = actual.getSiguienteNodo();
        cont++;
    }
    System.out.println("Canción no encontrada");
}

public Nodo<Cancion> buscar(String titulo ){

    if(estaVacia()) {
        System.out.println("La lista está vacía");
        return null;
    }

    Nodo<Cancion> actual = nodoPrimero;
    int cont = 0;

    while(cont < tamano){

        if (actual.getValorNodo().getTitulo().equals(titulo)) {

            return actual;
            }
        cont++;
        actual = actual.getSiguienteNodo();
    }

    System.out.println("no esta esa cancion");
        return null;

}




}

