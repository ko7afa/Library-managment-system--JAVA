public class BorrowQueue {
    
    private  BorrowRequest front, rear;
    private int size = 0;
    private final int MAX_REQUESTS = 5;

    // إضافة طلب استعارة
    public void enqueue(int requestId, int bookId, String requestDate, boolean isBookAvailable) {
        if (!isBookAvailable) {
            System.out.println("لا يمكن إضافة الطلب: الكتاب غير متاح.");
            return;
        }
        if (size >= MAX_REQUESTS) {
            System.out.println("تم تجاوز الحد الأقصى للطلبات (5).");
            return;
        }
        BorrowRequest newRequest = new BorrowRequest(requestId, bookId, requestDate);
        if (rear == null) {
            front = rear = newRequest;
        } else {
            rear.next = newRequest;
            rear = newRequest;
        }
        size++;
        System.out.println("تمت إضافة طلب الاستعارة.");
    }

    // تغيير حالة الكتاب إلى مستعار
    public void setBookBorrowed(int bookId, String author, bookDoublyList books) {
        BookNode book = books.SearchByIdOrAuthorNode(bookId, author);
        if (book != null) {
            book.bookAvailable = false;
            System.out.println("تم تغيير حالة الكتاب إلى مستعار.");
        } else {
            System.out.println("لم يتم العثور على الكتاب.");
        }
    }

    // إزالة طلب استعارة
    public void dequeue() {
        if (front == null) {
            System.out.println("لا توجد طلبات استعارة.");
            return;
        }
        System.out.println("تمت إزالة طلب الاستعارة رقم: " + front.requestId);
        front = front.next;
        size--;
        if (front == null) rear = null;
    }

    // عرض الطلبات الحالية
    public void displayRequests() {
        if (front == null) {
            System.out.println("لا توجد طلبات استعارة.");
            return;
        }
        System.out.println("الطلبات الحالية:");
        BorrowRequest current = front;
        while (current != null) {
            System.out.println("رقم الطلب: " + current.requestId +
                               ", رقم الكتاب: " + current.bookId +
                               ", تاريخ الطلب: " + current.requestDate);
            current = current.next;
        }
    }

    // إزالة طلب حسب رقم الطلب
    public void removeRequestById(int requestId) {
        if (front == null) {
            System.out.println("لا توجد طلبات استعارة.");
            return;
        }
        if (front.requestId == requestId) {
            front = front.next;
            size--;
            if (front == null) rear = null;
            System.out.println("تم حذف الطلب.");
            return;
        }
        BorrowRequest current = front;
        while (current.next != null) {
            if (current.next.requestId == requestId) {
                current.next = current.next.next;
                size--;
                if (current.next == null) rear = current;
                System.out.println("تم حذف الطلب.");
                return;
            }
            current = current.next;
        }
        System.out.println("لم يتم العثور على الطلب.");
    }

    // حساب عدد الكتب المستعارة لعضو محدد (يفترض أن requestId = memberId)
    public int countBorrowedBooksForMember(int memberId) {
        int count = 0;
        BorrowRequest current = front;
        while (current != null) {
            if (current.requestId == memberId) {
                count++;
            }
            current = current.next;
        }
        return count;
    }
}