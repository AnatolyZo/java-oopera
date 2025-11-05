package ShowData;

import PersonData.Director;
import PersonData.Person;

public class Opera extends MusicalShow {
    int choirSize;

    public Opera(String title, int duration, Director director,
                 Person musicAuthor, String librettoText, int choirSize) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }
}
