package showdata;

import persondata.Actor;
import persondata.Director;
import java.util.ArrayList;
import java.util.Scanner;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director/*, ArrayList<Actor> listOfActors*/) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }

    public void printListOfActors() {
        for (Actor actor : listOfActors) {
            System.out.println(actor);
        }
        System.out.println();
    }

    public void addActor(Actor newActor) {
        if (listOfActors.contains(newActor)) {
            System.out.println("Актер " + newActor + " уже заявлен в спектакле.");
        } else {
            listOfActors.add(newActor);
        }
    }

    public void replaceActor(Actor newActor, String surname) {
        //Введен список, который будет содержать номера однофамильцев списка listOfActors
        ArrayList<Integer> listOfNamesakesIndexes = new ArrayList<>();

        for (Actor actor : listOfActors) {
            if (surname.equals(actor.getSurname())) {
                listOfNamesakesIndexes.add(listOfActors.indexOf(actor));
            }
        }

        //Реализуется порядок замены актера для случая, если однофамильцев больше 2
        if (listOfNamesakesIndexes.size() >= 2) {
            System.out.println("В спектакле участвуют " + listOfNamesakesIndexes.size() + " актер(-ов) с фамилией " +
                    surname + "\nКоторого из актеров Вы хотите заменить?");

            for (int i = 0; i < listOfNamesakesIndexes.size(); i++) {
                System.out.println(listOfActors.get(listOfNamesakesIndexes.get(i)) + " порядковый номер - " +
                        listOfNamesakesIndexes.get(i));
            }

            System.out.println("Введите порядковый номер актера для замены:");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                //Проверка на целочисленность ввода порядкового номера актера
                if (scanner.hasNextInt()) {
                    int namesakeNumber = scanner.nextInt();

                    //Проверка введенного порядкового номера на наличие в списке listOfNamesakesIndexes
                    if (listOfNamesakesIndexes.contains(namesakeNumber)) {
                        listOfActors.set(namesakeNumber, newActor);
                        break;
                    } else {
                        System.out.println("Пожалуйста повторите ввод и выберите" +
                                " порядковый номер из предложенного списка");
                    }
                } else {
                    System.out.println("Вводимые данные должны быть целым числом, повторите ввод.");
                    scanner.nextLine();
                }
            }

        //В случае, если нет однофамильцев, происходит обычная замена
        } else if (listOfNamesakesIndexes.size() == 1) {
            System.out.println("В спектакле произведена замена: актер " +
                    listOfActors.get(listOfNamesakesIndexes.getFirst()) + " заменен на актера " + newActor);
            listOfActors.set(listOfNamesakesIndexes.getFirst(), newActor);
        } else {
            System.out.println("Актера с фамилией " + surname + " нет в спектакле.\n");
        }
    }
}
