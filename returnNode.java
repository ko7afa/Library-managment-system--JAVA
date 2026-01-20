public class returnNode {
    int returnId;
    int memberId;
    int bookId;
    String date;
    returnNode next;

    public returnNode(int returnId, int memberId, int bookId, String date) {
        this.returnId = returnId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.date = date;
        this.next = null;
    }
    @Override
    public String toString() {
        return "Return ID: " + returnId + ", Member ID: " + memberId + ", Book ID: " + bookId + ", Date: " + date;
    }
}