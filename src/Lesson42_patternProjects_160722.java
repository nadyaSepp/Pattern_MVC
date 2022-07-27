//16.07.22
//Тема: Паттерны проектирования
//      Архитектурный паттерн проектирования - MVC

//Пример:
//Статическая страница на HTML не умеет реагировать на действия пользователя.
//Для двухстороннего взаимодействия нужны динамические веб-страницы.
//MVC — ключ к пониманию разработки динамических веб-приложений, поэтому разработчику нужно знать эту модель

//Model-View-Controller — схема разделения данных приложения и управляющей логики на три отдельных компонента:
//модель, представление и контроллер — таким образом,
//что модификация каждого компонента может осуществляться независимо.
//Модель предоставляет данные и реагирует на команды контроллера, изменяя своё состояние.

//Это способ организации кода, который предполагает выделение блоков, отвечающих за решение разных задач.
//Один блок отвечает за данные приложения, другой отвечает за внешний вид,
//а третий контролирует работу приложения.
// Компоненты MVC:
//Модель — этот компонент отвечает за данные, а также определяет структуру приложения.
//Например, если вы создаете To-Do приложение,
//код компонента model будет определять список задач и отдельные задачи.
//Представление — этот компонент отвечает за взаимодействие с пользователем.
//То есть код компонента view определяет внешний вид приложения и способы его использования.
//Контроллер — этот компонент отвечает за связь между model и view.
//Код компонента controller определяет, как сайт реагирует на действия пользователя. По сути, это мозг MVC-приложения.

//В нашей задаче:
// Модели: Student и Groop
// Контроллер - класс Controller
// Представления - пока у нас нет

import java.util.ArrayList;
import java.util.Scanner;

//Задание: Работа со студентами и группами

public class Lesson42_patternProjects_160722 {
    public static void main(String[] args){
//        Student stud=new Student("Petr","Ivanov");
//        stud.addMarcMath(4);
//        stud.addMarcFiz(2);
//        stud.addMarcRuss(5);
//        for (int i:stud.getMath()) {
//            System.out.println(i);
//        }
        Scanner sc=new Scanner(System.in);
        Scanner scName=new Scanner(System.in);
        Controller contr=new Controller();

        int choice=0;
        String name,fio;
        int idGroup, idStudent, marc;
        do{
            System.out.println("Введите 0-выход\n1-создать студ-а\n2-создать группу\n" +
                    "3-добавить студ-а к группе\n4-вывести ст-в без группы\n" +
                    "5-вывести все группы\n6-вывести студ-в по индексу группы\n" +
                    "7-ввести оценку студ-у\n8 - вывести все оценки студ-а\n" +
                    "9- вывести лучших студ-в группы по русс, мат,физ");
            choice=sc.nextInt();
            switch (choice){
                case 0: break;
                case 1:
                    System.out.println("Введите Имя");
                    name=scName.nextLine();
                    System.out.println("Введите Фамилию");
                    fio=scName.nextLine();
                    contr.createStudent(name,fio);
                    break;
                case 2:
                    System.out.println("Введите Имя Группы");
                    name=scName.nextLine();
                    contr.createGroup(name);
                    break;
                case 3:
                    System.out.println("Введите id Студента");
                    idStudent=sc.nextInt();
                    System.out.println("Введите id Группы");
                    idGroup=sc.nextInt();
                    contr.addStudentToGroupFromNoGroup(idStudent,idGroup);
                    break;
                case 4:
                    for(Student st: contr.noGroopStudents){
                        System.out.println(st);
                    }
                    break;
                case 5:
                    for(Groop gp: contr.groops) {
                        System.out.println(gp);
                    }
                    break;
                case 6:
                    System.out.println("Введите id Группы");
                    idGroup=sc.nextInt();
                    for(Student st: contr.getStudentsFromGroop(idGroup)){
                        System.out.println(st);
                    }
                    break;
                case 7:
                    System.out.println("Введите id Студента");
                    idStudent=sc.nextInt();
                    System.out.println("Введите id Группы");
                    idGroup=sc.nextInt();
                    System.out.println("Введите оценку по матем-ке");
                    marc=sc.nextInt();
                    contr.getStudentsFromGroop(idGroup).get(idStudent).addMarcMath(marc);
                    System.out.println("Введите оценку по русскому");
                    marc=sc.nextInt();
                    contr.getStudentsFromGroop(idGroup).get(idStudent).addMarcRuss(marc);
                    System.out.println("Введите оценку по физике");
                    marc=sc.nextInt();
                    contr.getStudentsFromGroop(idGroup).get(idStudent).addMarcFiz(marc);
                    break;
                case 8:
                    System.out.println("Введите id Студента");
                    idStudent=sc.nextInt();
                    System.out.println("Введите id Группы");
                    idGroup=sc.nextInt();
                    System.out.println(contr.getStudentsFromGroop(idGroup).get(idStudent).getMath());
                    System.out.println(contr.getStudentsFromGroop(idGroup).get(idStudent).getRuss());
                    System.out.println(contr.getStudentsFromGroop(idGroup).get(idStudent).getFiz());
                    break;
                case 9:
                    System.out.println("Введите id Группы");
                    idGroup=sc.nextInt();
                    ArrayList max=contr.getStudentsMaxSrBallFromGroup(contr.getStudentsFromGroop(idGroup));
                    System.out.println(max.get(0));
                    System.out.println(max.get(1));
                    System.out.println(max.get(2));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }while (choice != 0);
    }//m

}

////
//9 - вывести лучших студентов группы, по русскому, математике, физике.
//Передаете айди группы, в консоль пишется 3 студента, самых лучших.
//Вам нужно реализовать в классе студент, метод средний балл,
//по русскому языку, математике и физике. После этого вы проходитесь по всей группе
//узнаете средний балл всех студентов и находите лучшего студента
//по предмету. Использовать алгоритм поиска максимума в списке.