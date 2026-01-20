public class BookNode{
    String title;
    String author;
    int bookId;
    BookNode next,prev;
    boolean bookAvailable=true;

    public BookNode(String title, String author, int bookId, boolean bookAvailable) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.next = null;
        this.prev = null;
        this.bookAvailable = bookAvailable;
    }
    @Override
    public String toString(){
        return "Title: " + title + ", Author: " + author + ", Book ID: " + bookId + ", Available: " + bookAvailable;
    }
}