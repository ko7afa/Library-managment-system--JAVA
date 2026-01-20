public class memberList{
    private MemberNode head;

    // إضافة عضو جديد
    public void addMember(String name, int id) {
        MemberNode newMember = new MemberNode(name, id);
        if (head == null) {
            head = newMember;
        } else {
            MemberNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newMember;
        }
        System.out.println("تمت إضافة العضو بنجاح.");
    }

    // حذف عضو حسب رقم العضوية
    public void removeMember(int id) {
        if (head == null) {
            System.out.println("القائمة فارغة.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("تم حذف العضو.");
            return;
        }
        MemberNode current = head;
        while (current.next != null) {
            if (current.next.id == id) {
                current.next = current.next.next;
                System.out.println("تم حذف العضو.");
                return;
            }
            current = current.next;
        }
        System.out.println("لم يتم العثور على العضو.");
    }

    // تعديل بيانات عضو
    public void updateMember(int id, String newName) {
        MemberNode current = head;
        while (current != null) {
            if (current.id == id) {
                current.name = newName;
                System.out.println("تم تعديل بيانات العضو.");
                return;
            }
            current = current.next;
        }
        System.out.println("لم يتم العثور على العضو.");
    }

    // عرض بيانات جميع الأعضاء
    public void displayMembers() {
        MemberNode current = head;
        if (current == null) {
            System.out.println("لا يوجد أعضاء في القائمة.");
            return;
        }
        System.out.println("بيانات الأعضاء:");
        while (current != null) {
            System.out.println("الاسم: " + current.name + ", رقم العضوية: " + current.id);
            current = current.next;
        }
    }

    // حساب عدد الكتب المستعارة لكل عضو
    public void displayBorrowedBooksCount(BorrowQueue borrowQueue) {
        if (head == null) {
            System.out.println("لا يوجد أعضاء في القائمة.");
            return;
        }
        if (borrowQueue == null) {
            System.out.println("لا توجد قائمة استعارات.");
            return;
        }
        
        System.out.println("عدد الكتب المستعارة لكل عضو:");
        MemberNode current = head;
        while (current != null) {
            int count = borrowQueue.countBorrowedBooksForMember(current.id);
            System.out.println("الاسم: " + current.name + 
                             ", رقم العضوية: " + current.id + 
                             ", عدد الكتب المستعارة: " + count);
            current = current.next;
        }
    }

    // حساب عدد الكتب المستعارة لعضو محدد
    public int countBorrowedBooksForMember(int memberId, BorrowQueue borrowQueue) {
        if (borrowQueue == null) {
            return 0;
        }
        return borrowQueue.countBorrowedBooksForMember(memberId);
    }
}
