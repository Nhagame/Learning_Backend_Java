import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();
    private HashSet<String> StudentIds = new HashSet<>();

    // thêm sinh viên
    public void AddStudent(String ID, String Name, int Age, double Point){
        try{
            if(StudentIds.contains(ID)){
                throw new IllegalArgumentException("Học sinh có ID " + ID + " đã tồn tại.");
            }
            Student student = new Student(Name, Age, ID, Point);
            students.add(student);
            StudentIds.add(ID);
            System.out.println("học sinh đã được thêm vào thành công");
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    //Xóa sinh viên
    public void DeleteStudent(String ID){
        try {
            boolean Removed = false;
            for (int i = 0; i<students.size(); i++){
                if(students.get(i).GetID().equals(ID)){
                    students.remove(i);
                    StudentIds.remove(ID);
                    Removed = true;
                    break;
                }
            }
            if(!Removed){
                throw new NoSuchElementException("Học sinh có mã ID " + ID + " Không tồn tại.");
            }
            System.out.println("Học sinh đã được xóa thành công.");
        }catch (NoSuchElementException e){
                System.err.println(e.getMessage());
        }
    }

    // hiện sinh viên
    public void ShowStudent(){
        if(students.isEmpty()){
            System.out.println("Không có sinh viên trong danh sách. ");
        } else {
            for(Student studentItem : students){
                System.out.println(studentItem);
            }
        }
    }

    // tìm kiếm sinh viên
    public void FindStudent(String Name){
        try {
            ArrayList<Student> FoundStudent = new ArrayList<>();
            for(Student studentItem : students){
                if(studentItem.GetName().equalsIgnoreCase(Name)){
                    FoundStudent.add(studentItem);
                }
            }
            if(FoundStudent.isEmpty()){
                throw new NoSuchElementException("không tìm được học sinh có tên đó." + Name + ".");
            }
            for (Student studentItem : FoundStudent){
                System.out.println(studentItem);
            }
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    // sắp xếp sinh viên theo điểm
    public void SortStudentPoint(){
        try{
            if(students.isEmpty()){
                throw new NoSuchElementException("Không có sinh viên nào.");
            }
            students.sort(Comparator.comparingDouble(Student::GetPoint));
            System.out.println("Đã sắp xếp thành công");
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    // Kiểm tra sinh viên có tồn tại không
    public void CheckStudent(String ID){
        if(students.contains(ID)){
            System.out.println("Sinh Viên có mã ID: " + ID + " tồn tại.");
        }else {
            System.out.println("Sinh viên có mã số ID: " + ID + " không tồn tại.");
        }
    }
}
