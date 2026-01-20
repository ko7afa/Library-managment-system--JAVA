public class bookDoublyList {
    
    private BookNode head;
    private BookNode p ;

    public bookDoublyList() {
        this.head = null;
        this.p = null;
    }

    public void addBook(String title, String author, int bookId, boolean bookAvailable) {
        BookNode newBook = new BookNode(title, author, bookId, bookAvailable);
        if (head == null) {
            head = newBook;
            p = newBook;
        } else {
            BookNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newBook;
            newBook.prev = current;
            p = newBook; 
        }
    }

    public void displayBooks() {
       BookNode p = head;
        if (p == null) {
            System.out.println("لا توجد كتب");
        }
        else{
            while (p != null) {
            System.out.println(p);
            p = p.next;
            }
        }
    }

    public void removeBook(int bookId) {
       BookNode p = head;
        while (p != null && p.bookId != bookId) {
            p = p.next;
        }
        if (p != null) {
            if (p.prev != null)
                p.prev.next = p.next;
            else
                head = p.next;
            if (p.next != null)
                p.next.prev = p.prev;
        }
    }

    public void SearchByIdOrAuthor(int bookId, String author) {
       BookNode p = head;
        boolean found = false;
        while (p != null) {
            if (p.bookId == bookId || p.author.equals(author)) {
                System.out.println(p);
                found = true;
            }
            p = p.next;
        }
        if (!found) 
        System.out.println("لا توجد كتب بهذا الرقم او المؤلف");
    }

    // دالة مساعدة لإرجاع عقدة الكتاب (للاستخدام الداخلي)
    public BookNode SearchByIdOrAuthorNode(int bookId, String author) {
       BookNode p = head;
        while (p != null) {
            if (p.bookId == bookId || (author != null && p.author != null && p.author.equals(author))) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void updateBook(String title, String author, int bookId) {
       BookNode p = head;
        while (p != null && p.bookId != bookId) {
            p = p.next;
        }
        if (p != null) {
            p.title = title;
            p.author = author;
        }
    }

    public void sortByTitle() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            BookNode p = head;
            while (p.next != null) {
                if (p.title.compareToIgnoreCase(p.next.title) > 0) {
                    // تبديل البيانات فقط
                    swapBookData(p, p.next);
                    swapped = true;
                }
                p = p.next;
            }
        } while (swapped);
    }

    public void sortByAuthor() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            BookNode p = head;
            while (p.next != null) {
                if (p.author.compareToIgnoreCase(p.next.author) > 0) {
                    swapBookData(p, p.next);
                    swapped = true;
                }
                p = p.next;
            }
        } while (swapped);
    }

    private void swapBookData(BookNode a, BookNode b) {
        String tempTitle = a.title;
        String tempAuthor = a.author;
        int tempBookId = a.bookId;
        boolean tempAvailable = a.bookAvailable;

        a.title = b.title;
        a.author = b.author;
        a.bookId = b.bookId;
        a.bookAvailable = b.bookAvailable;

        b.title = tempTitle;
        b.author = tempAuthor;
        b.bookId = tempBookId;
        b.bookAvailable = tempAvailable;
    }

    public void displayAvailableBooks() {
        BookNode p = head;
        boolean found = false;
        while (p != null) {
            if (p.bookAvailable == true) {
                System.out.println(p);
                found = true;
            }
            p = p.next;
        }
        if (!found) {
            System.out.println("لا توجد كتب متاحة حالياً.");
        }
    }
    public void setBookAvailable(int bookId) {
    BookNode p = head;
    while (p != null) {
        if (p.bookId == bookId) {
            p.bookAvailable = true;
            System.out.println("تم تغيير حالة الكتاب إلى متاح: " + p.title);
            return;
        }
        p = p.next;
    }
        System.out.println("لم يتم العثور على كتاب بهذا الرقم.");
    }
}

