import java.util.ArrayList;

//модель описывающая сущность - Группу
public class Groop {
    ArrayList<Student> allStudents;
    String name;

    //метод создания группы по наименованию
    public Groop(String name) {
        this.allStudents = new ArrayList<>();
        this.name=name;
    }
    //метод добавл студента в группу
    public void addStudents(Student st) {
       allStudents.add(st);
    }

    //переопределенный метод распечатки имени группы
    @Override
    public String toString() {
        return "Groop{" +
                "name='" + name + '\'' +
                '}';
    }
}
