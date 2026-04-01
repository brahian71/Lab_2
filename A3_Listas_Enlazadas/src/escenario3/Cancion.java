package laboratorio2.A3_Listas_Enlazadas.src.escenario3;

public class Cancion {

    String titulo;
    String artista;
    int duracion;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Cancion [titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion + "]";
    }
    
}
