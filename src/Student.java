//модель описывающая сущность - Студент
import java.util.ArrayList;

public class Student {
    String name;
    String fio;
    //по сути - это матрица (три строки под предметы, каждая строка - это оценки студента по одному предмету)
    ArrayList<ArrayList<Integer>> marcs; //0 строка оценка матем, 1 строка-русс, 2 строка-физика

    public Student(String name, String fio) {
        this.name=name;
        this.fio=fio;
        marcs=new ArrayList<>();
        marcs.add(new ArrayList<>()); //в 0-строку создали список для оценок по матем:   marcs.get(0)
        marcs.add(new ArrayList<>()); //в 1-строку создали список для оценок по русс
        marcs.add(new ArrayList<>()); //в 2-строку создали список для оценок по физ
    }

    //методы добавления оценки в список предмета
    public void addMarcMath(int cifr){
        marcs.get(0).add(cifr);
   }
    public void addMarcRuss(int cifr){ marcs.get(1).add(cifr); }
    public void addMarcFiz(int cifr) { marcs.get(2).add(cifr); }

    //методы запроса списка оценок по предмету
    public ArrayList<Integer> getMath(){
        return marcs.get(0);
    }
    public ArrayList<Integer> getRuss(){
        return marcs.get(1);
    }
    public ArrayList<Integer> getFiz()  { return marcs.get(2); }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fio='" + fio + '\'' +
                '}';
    }
    //метод - расчет среднего балла по предмету (вх. параметр i-порядковый номер списка предмета студента)
    //0-матем, 1-русс, 2-физика
    public double srBall(int i){
        double sum=0;
        //перебор оценок по предмету
        for (Integer marc:marcs.get(i)) {
            sum += marc;
        }
        //System.out.printf("Student sum=%f \n",sum);
        //System.out.println();
        return sum/marcs.get(i).size();
    }

}
