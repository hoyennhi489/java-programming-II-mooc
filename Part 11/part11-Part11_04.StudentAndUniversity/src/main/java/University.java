import java.util.ArrayList;

public class University {

    private String name;
    private ArrayList<Student> students;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
}