
public class BrowserApp {

    public static void main(String[] args) {

        BrowserHistory history = new BrowserHistory();

        System.out.println("----- VISITANDO PAGINAS -----");
        history.visit("https://google.com", "Google");
        history.visit("https://youtube.com", "YouTube");
        history.visit("https://github.com", "GitHub");
        history.visit("https://stackoverflow.com", "Stack Overflow");
        history.visit("https://wikipedia.org", "Wikipedia");

        System.out.println();
        System.out.println("----- HISTORIAL COMPLETO -----");
        history.displayHistory();

        System.out.println();
        System.out.println("----- BUSCAR PAGINAS -----");
        history.search("https://github.com");
        history.search("https://reddit.com");

        System.out.println();
        System.out.println("----- RETROCEDER 2 PAGINAS -----");
        history.back();
        history.back();

        System.out.println();
        System.out.println("----- HISTORIAL TRAS RETROCEDER -----");
        history.displayHistory();

        System.out.println();
        System.out.println("----- AVANZAR 1 PAGINA -----");
        history.forward();

        System.out.println();
        System.out.println("----- VISITAR NUEVA PAGINA (TRUNCA FUTURO) -----");
        history.visit("https://reddit.com", "Reddit");

        System.out.println();
        System.out.println("----- INTENTAR AVANZAR -----");
        history.forward();

        System.out.println();
        System.out.println("----- HISTORIAL ACTUALIZADO -----");
        history.displayHistory();

        System.out.println();
        System.out.println("----- ELIMINAR YOUTUBE -----");
        history.removePage("https://youtube.com");

        System.out.println();
        System.out.println("----- HISTORIAL TRAS ELIMINAR -----");
        history.displayHistory();

        System.out.println();
        System.out.println("----- RETROCEDER HASTA EL INICIO -----");
        while (history.canGoBack()) {
            history.back();
        }

        System.out.println();
        System.out.println("----- INTENTAR RETROCEDER EN EL INICIO -----");
        history.back();
    }
}
