
public class MusicPlayerApp {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();


        System.out.println("--- Agregando canciones ---");
        
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen", 354));
        playlist.addSong(new Song("Hotel California", "Eagles", 321));
        playlist.addSong(new Song("Stairway to Heaven", "Led Zeppelin", 290));
        playlist.addSong(new Song("Imagine", "John Lennon", 401));
        playlist.addSong(new Song("Smells Like Teen Spirit", "Nirvana", 379));

        System.out.println("--- Lista de reproduccion ---");
        playlist.display();

        System.out.println("--- Buscar cancion existente ---");
        Node<Song> result = playlist.search("Stairway to Heaven");

        System.out.println("--- Buscar cancion inexistente ---");
        playlist.search("Yesterday");

        System.out.println("--- Reproduciendo siguiente ---");
        playlist.playNext();

        System.out.println("--- Eliminando cancion ---");
        playlist.removeSong("Bohemian Rhapsody");

        System.out.println("--- Reproduciendo siguiente ---");
        playlist.playNext();

        System.out.println("--- Lista actualizada ---");
        playlist.display();
    }
}
