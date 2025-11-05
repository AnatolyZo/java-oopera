package PersonData;

import java.util.Objects;

public class Actor extends Person {
    private final int height;

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " (" + height + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getName(), actor.getName()) && Objects.equals(getSurname(), actor.getSurname()) &&
                height == actor.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), height);
    }

}
