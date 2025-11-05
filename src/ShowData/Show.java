package ShowData;

import PersonData.Actor;
import PersonData.Director;
import java.util.ArrayList;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private ArrayList<Actor> listOfActors = new ArrayList<>();

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
    }

    public void addActor(Actor newActor) {
        boolean isActorExist = false;

        for (Actor actor : listOfActors) {
            if (newActor.equals(actor)) {
                isActorExist = true;
                break;
            }
        }

        if (isActorExist) {
            System.out.println("Актер " + newActor + " уже заявлен в спектакле.");
        } else {
            listOfActors.add(newActor);
        }
    }

    public void replaceActor(Actor newActor, String surname) {
        boolean isActorExist = false;
        int index = 0;

        for (Actor actor : listOfActors) {
            if (surname.equals(actor.getSurname())) {
                System.out.println("В спектакле произведена замена: актер " + actor + " заменен на актера " + newActor);
                listOfActors.set(index, newActor);
                isActorExist = true;
                break;
            }
            index++;
        }

        if (!isActorExist) {
            System.out.println("Актера с фамилией " + surname + " нет в спектакле.");
        }
    }
}
