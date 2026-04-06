
public class PageNode {

    String url;
    String title;
    PageNode next;
    PageNode prev;

    public PageNode(String url, String title) {
        this.url = url;
        this.title = title;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
}
