public class BorrowRequest {
    int requestId;
    int bookId;
    String requestDate;
    BorrowRequest next;
    public BorrowRequest(int requestId, int bookId, String requestDate) {
        this.requestId = requestId;
        this.bookId = bookId;
        this.requestDate = requestDate;
    }

}