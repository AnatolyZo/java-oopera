package showdata;

import persondata.Director;
import persondata.Person;

public class Ballet extends MusicalShow {
    Person choreographer;

    public Ballet(String title, int duration, Director director,
                  Person musicAuthor, String librettoText, Person choreographer) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }
}
