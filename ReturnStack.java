public class ReturnStack {
    private returnNode top;
    private bookDoublyList books;

    public ReturnStack(bookDoublyList books) {
        this.top = null;
        this.books = books;
    }
    
    public void pushReturn(int returnId, int memberId, int bookId, String date) {
        returnNode newReturn = new returnNode(returnId, memberId, bookId, date);
        if (top == null) {
            top = newReturn;
        } else {
            newReturn.next = top;
            top = newReturn;
        }
    }

    public returnNode pop() {
        if (top == null) {
            System.out.println("لا توجد عمليات إرجاع");
            return null;
        } else {
            returnNode temp = top;
            top = top.next;
            temp.next = null;
            // استدعاء دالة تغيير حالة الكتاب إلى متاح
            books.setBookAvailable(temp.bookId);

            return temp;
        }
    }

   public void displayLastFiveReturns() {
    returnNode q = top;
    int count = 0;
    if (q == null) {
        System.out.println("لا توجد عمليات إرجاع.");
    } else {
        System.out.println("آخر 5 عمليات استرجاع:");
        while (q != null && count < 5) {
            System.out.println("Return ID: " + q.returnId +
                               ", Member ID: " + q.memberId +
                               ", Book ID: " + q.bookId +
                               ", Date: " + q.date);
            q = q.next;
            count++;
        }
    }
}
}