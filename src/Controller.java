//контроллер
import java.util.ArrayList;

public class Controller {
    ArrayList<Student> noGroopStudents=new ArrayList<>(); //список студентов без группы
    ArrayList<Groop> groops=new ArrayList<>();            //список групп

    //метод добавления студента (он конечно же не в группе и сначало попадает в список noGroopStudents)
    public void createStudent(String name,String fio){
         noGroopStudents.add(new Student(name,fio));
    }
    public void createGroup(String name){
        groops.add(new Groop(name));
    }

    //метод - добавить в группу с одновременным удалением из списка "Студенты без группы"
    public void addStudentToGroupFromNoGroup(int idStudent, int idGroup){
       groops.get(idGroup).addStudents(noGroopStudents.remove(idStudent));
    }

    //метод - выдать всех студентов группы
    public ArrayList<Student> getStudentsFromGroop(int idGroup){
        return groops.get(idGroup).allStudents;
    }

    public ArrayList getStudentsMaxSrBallFromGroup(ArrayList<Student> allStud){
        //создаем промежуточные переменные для поиска максимума
        double maxSrBallMath=0, maxSrBallRuss=0, maxSrBallFiz=0;
        String nameMath="", nameRuss="", nameFiz="";

        //цикл по студентам в группе
        for (Student st:allStud){
            //поиск лучшей оценки по математике (нашли лучше-сохраняем ср.балл и фамилию)
            if (maxSrBallMath < st.srBall(0)) {maxSrBallMath=st.srBall(0); nameMath= st.name;}
            //поиск лучшей оценки по русскому
            if (maxSrBallRuss < st.srBall(1)) {maxSrBallRuss=st.srBall(1); nameRuss= st.name;}
            //поиск лучшей оценки по физике
            if (maxSrBallFiz < st.srBall(2)) {maxSrBallFiz=st.srBall(2); nameFiz= st.name;}
            //System.out.println(st.name + st.srBall(0));
        }
        //сохраняем средний балл по всем предметам с фамилиями студентов
        ArrayList max=new ArrayList();
        max.add("Средний балл Математика: " + nameMath + " " +  maxSrBallMath);
        max.add("Средний балл Русский: " + nameRuss + " " + maxSrBallRuss);
        max.add("Средний балл Физика: " + nameFiz + " " + maxSrBallFiz);
        return max;
    }

}
