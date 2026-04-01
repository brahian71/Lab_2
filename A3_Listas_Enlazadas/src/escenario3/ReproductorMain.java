package laboratorio2.A3_Listas_Enlazadas.src.escenario3;

public class ReproductorMain {


    public static void main(String[] args) {

        ListaReproduccion lista = new ListaReproduccion();

        lista.agregarCancion(new Cancion("cancion1", "artista1", 354));
        lista.agregarCancion(new Cancion("cancion2", "artista2", 321));
        lista.agregarCancion(new Cancion("cancion3", "artista3", 290));
        lista.agregarCancion(new Cancion("cancion4", "artista4", 401));
        lista.agregarCancion(new Cancion("cancion5", "artista5", 379));

        System.out.println("=== Lista de reproducción ===");
        lista.imprimirLista();

        System.out.println("=== Buscar ===");
        
        Nodo<Cancion> resultado = lista.buscar("cancion3");

        if(resultado != null) {
            System.out.println("Encontrada: " + resultado.getValorNodo());
        }

        System.out.println("=== siguiente ===");
        lista.siguiente();

        System.out.println("=== Eliminar ===");
        lista.eliminarCancion("cancion1");

        System.out.println("=== siguiente ===");
        lista.siguiente();

        System.out.println("=== Lista actualizada ===");
        lista.imprimirLista();


    }

    
}
