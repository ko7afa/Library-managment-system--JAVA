import java.util.Scanner;

public class main {
    private static bookDoublyList books = new bookDoublyList();
    private static memberList members = new memberList();
    private static BorrowQueue borrowQueue = new BorrowQueue();
    private static ReturnStack returnStack;
    private static Scanner scanner = new Scanner(System.in);
    private static int returnIdCounter = 1;

    public static void main(String[]args) {
        returnStack = new ReturnStack(books);
        
        System.out.println("=== نظام إدارة المكتبة ===");
        System.out.println("Library Management System\n");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    bookManagementMenu();
                    break;
                case 2:
                    memberManagementMenu();
                    break;
                case 3:
                    borrowingRequestMenu();
                    break;
                case 4:
                    returnManagementMenu();
                    break;
                case 5:
                    System.out.println("شكراً لاستخدامك النظام. مع السلامة!");
                    running = false;
                    break;
                default:
                    System.out.println("خيار غير صحيح. الرجاء المحاولة مرة أخرى.");
            }
        }
        scanner.close();
    }

    // عرض القائمة الرئيسية
    private static void displayMainMenu() {
        System.out.println("\n=== القائمة الرئيسية ===");
        System.out.println("1. إدارة الكتب ");
        System.out.println("2. إدارة الأعضاء ");
        System.out.println("3. إدارة طلبات الاستعارة ");
        System.out.println("4. إدارة إرجاع الكتب ");
        System.out.println("5. الخروج ");
        System.out.print("اختر الخيار: ");
    }

    // قائمة إدارة الكتب
    private static void bookManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== إدارة الكتب ===");
            System.out.println("1. إضافة كتاب");
            System.out.println("2. حذف كتاب");
            System.out.println("3. تعديل كتاب");
            System.out.println("4. البحث عن كتاب (بالعنوان أو المؤلف)");
            System.out.println("5. فرز الكتب حسب العنوان");
            System.out.println("6. فرز الكتب حسب المؤلف");
            System.out.println("7. عرض جميع الكتب");
            System.out.println("8. عرض الكتب المتاحة فقط");
            System.out.println("9. العودة للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    modifyBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    sortBooksByTitle();
                    break;
                case 6:
                    sortBooksByAuthor();
                    break;
                case 7:
                    displayAllBooks();
                    break;
                case 8:
                    displayAvailableBooks();
                    break;
                case 9:
                    back = true;
                    break;
                default:
                    System.out.println("خيار غير صحيح.");
            }
        }
    }

    // قائمة إدارة الأعضاء
    private static void memberManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("=== إدارة الأعضاء ===");
            System.out.println("1. إضافة عضو");
            System.out.println("2. حذف عضو");
            System.out.println("3. تعديل بيانات عضو");
            System.out.println("4. عرض بيانات الأعضاء");
            System.out.println("5. العودة للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    modifyMember();
                    break;
                case 4:
                    displayMembers();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("خيار غير صحيح.");
            }
        }
    }

    // قائمة إدارة طلبات الاستعارة
    private static void borrowingRequestMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== إدارة طلبات الاستعارة ===");
            System.out.println("1. إضافة طلب استعارة");
            System.out.println("2. إزالة طلب استعارة");
            System.out.println("3. عرض طلبات الاستعارة الحالية");
            System.out.println("4. العودة للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addBorrowRequest();
                    break;
                case 2:
                    removeBorrowRequest();
                    break;
                case 3:
                    displayBorrowRequests();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("خيار غير صحيح.");
            }
        }
    }

    // قائمة إدارة إرجاع الكتب
    private static void returnManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== إدارة إرجاع الكتب ===");
            System.out.println("1. إضافة إذن استرجاع");
            System.out.println("2. إزالة إذن استرجاع");
            System.out.println("3. عرض آخر 5 كتب تم إرجاعها");
            System.out.println("4. العودة للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addReturnPermission();
                    break;
                case 2:
                    removeReturnPermission();
                    break;
                case 3:
                    displayLastFiveReturns();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("خيار غير صحيح.");
            }
        }
    }

    // ========== دوال إدارة الكتب ==========
    
    private static void addBook() {
        System.out.print("أدخل رقم الكتاب: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل عنوان الكتاب: ");
        String title = scanner.nextLine();
        System.out.print("أدخل اسم المؤلف: ");
        String author = scanner.nextLine();
        books.addBook(title, author, bookId, true);
        System.out.println("تمت إضافة الكتاب بنجاح.");
    }

    private static void deleteBook() {
        System.out.print("أدخل رقم الكتاب المراد حذفه: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        books.removeBook(bookId);
        System.out.println("تم حذف الكتاب.");
    }

    private static void modifyBook() {
        System.out.print("أدخل رقم الكتاب المراد تعديله: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل العنوان الجديد: ");
        String newTitle = scanner.nextLine();
        System.out.print("أدخل اسم المؤلف الجديد: ");
        String newAuthor = scanner.nextLine();
        books.updateBook(newTitle, newAuthor, bookId);
        System.out.println("تم تعديل الكتاب.");
    }

    private static void searchBook() {
        System.out.println("اختر طريقة البحث:");
        System.out.println("1. البحث برقم الكتاب");
        System.out.println("2. البحث باسم المؤلف");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();
        
        if (searchChoice == 1) {
            System.out.print("أدخل رقم الكتاب: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();
            books.SearchByIdOrAuthor(bookId, "");
        } else if (searchChoice == 2) {
            System.out.print("أدخل اسم المؤلف: ");
            String author = scanner.nextLine();
            books.SearchByIdOrAuthor(-1, author);
        } else {
            System.out.println("خيار غير صحيح.");
        }
    }

    private static void sortBooksByTitle() {
        books.sortByTitle();
        System.out.println("تم فرز الكتب حسب العنوان.");
        books.displayBooks();
    }

    private static void sortBooksByAuthor() {
        books.sortByAuthor();
        System.out.println("تم فرز الكتب حسب المؤلف.");
        books.displayBooks();
    }

    private static void displayAllBooks() {
        System.out.println("\n=== جميع الكتب ===");
        books.displayBooks();
    }

    private static void displayAvailableBooks() {
        System.out.println("\n=== الكتب المتاحة ===");
        books.displayAvailableBooks();
    }

    // ========== دوال إدارة الأعضاء ==========
    
    private static void addMember() {
        System.out.print("أدخل رقم العضوية: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل اسم العضو: ");
        String name = scanner.nextLine();
        members.addMember(name, memberId);
    }

    private static void deleteMember() {
        System.out.print("أدخل رقم العضوية المراد حذفه: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        members.removeMember(memberId);
    }

    private static void modifyMember() {
        System.out.print("أدخل رقم العضوية المراد تعديله: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل الاسم الجديد: ");
        String newName = scanner.nextLine();
        members.updateMember(memberId, newName);
    }

    private static void displayMembers() {
        System.out.println("\n=== بيانات الأعضاء ===");
        members.displayMembers();
        System.out.println("\n=== عدد الكتب المستعارة لكل عضو ===");
        members.displayBorrowedBooksCount(borrowQueue);
    }

    // ========== دوال إدارة طلبات الاستعارة ==========
    
    private static void addBorrowRequest() {
        System.out.print("أدخل رقم العضوية: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        
        // التحقق من أن العضو لا يتجاوز الحد الأقصى (5 كتب)
        int borrowedCount = borrowQueue.countBorrowedBooksForMember(memberId);
        if (borrowedCount >= 5) {
            System.out.println("لا يمكن إضافة الطلب: العضو قد تجاوز الحد الأقصى لعدد الكتب المسموح (5 كتب).");
            return;
        }
        
        System.out.print("أدخل رقم الكتاب: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        // التحقق من أن الكتاب متاح
        BookNode book = books.SearchByIdOrAuthorNode(bookId, null);
        if (book == null) {
            System.out.println("الكتاب غير موجود.");
            return;
        }
        
        if (!book.bookAvailable) {
            System.out.println("لا يمكن إضافة الطلب: الكتاب غير متاح.");
            return;
        }
        
        System.out.print("أدخل تاريخ الطلب: ");
        String requestDate = scanner.nextLine();
        
        // تغيير حالة الكتاب إلى مستعار أولاً
        borrowQueue.setBookBorrowed(bookId, book.author, books);
        
        // إضافة الطلب إلى الطابور
        borrowQueue.enqueue(memberId, bookId, requestDate, true);
    }

    private static void removeBorrowRequest() {
        System.out.print("أدخل رقم الطلب المراد إزالته: ");
        int requestId = scanner.nextInt();
        scanner.nextLine();
        borrowQueue.removeRequestById(requestId);
    }

    private static void displayBorrowRequests() {
        System.out.println("\n=== طلبات الاستعارة الحالية ===");
        borrowQueue.displayRequests();
    }

    // ========== دوال إدارة إرجاع الكتب ==========
    
    private static void addReturnPermission() {
        System.out.print("أدخل رقم العضوية: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل رقم الكتاب: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("أدخل تاريخ الإرجاع: ");
        String returnDate = scanner.nextLine();
        
        returnStack.pushReturn(returnIdCounter++, memberId, bookId, returnDate);
        System.out.println("تمت إضافة إذن الاسترجاع بنجاح.");
        
        // تغيير حالة الكتاب إلى متاح
        books.setBookAvailable(bookId);
    }

    private static void removeReturnPermission() {
        returnNode returned = returnStack.pop();
        if (returned != null) {
            System.out.println("تمت إزالة إذن الاسترجاع: " + returned);
        }
    }

    private static void displayLastFiveReturns() {
        System.out.println("\n=== آخر 5 كتب تم إرجاعها ===");
        returnStack.displayLastFiveReturns();
    }
}
