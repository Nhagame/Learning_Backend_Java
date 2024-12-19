import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHệ thống quản lý học sinh.");
            System.out.println("1. Thêm học sinh.");
            System.out.println("2. Xóa học sinh.");
            System.out.println("3. hiện thị học sinh.");
            System.out.println("4. tìm kiếm tên học sinh.");
            System.out.println("5. Sắp xếp học sinh theo điểm số.");
            System.out.println("6. kiểm tra xem có học sinh ấy không.");
            System.out.println("7. Dừng chương trình.");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String ID = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String Name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int Age = scanner.nextInt();
                    System.out.print("Enter Point: ");
                    double Point = scanner.nextDouble();
                    sm.AddStudent(ID, Name, Age, Point);
                    break;
                case 2:
                    System.out.println("Nhập ID của sinh viên cần xóa: ");
                    String DeleteID = scanner.nextLine();
                    sm.DeleteStudent(DeleteID);
                    break;
                case 3:
                    sm.ShowStudent();
                    break;
                case 4:
                    System.out.println("Nhập tên sinh viên mà bạn muốn tìm: ");
                    String FindName = scanner.nextLine();
                    sm.FindStudent(FindName);
                case 5:
                    sm.SortStudentPoint();
                    break;
                case 6:
                    System.out.println("Nhập mã số ID để tìm kiếm học sinh:");
                    String CheckIDStudent = scanner.nextLine();
                    sm.CheckStudent(CheckIDStudent);
                    break;
                case 7:
                    System.out.println("Thoát...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
