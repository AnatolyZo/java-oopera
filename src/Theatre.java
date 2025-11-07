import showdata.*;
import persondata.*;

public class Theatre {

    public static void main(String[] args) {
        System.out.println("Поехали!");

        //Выполнение пункта №1 ТЗ - создание 3 актеров, 2 режиссеров, 1 автора музыки и 1 хореографа
        Actor firstActor = new Actor("Сергей", "Васильев", Gender.MALE, 170);
        Actor secondActor = new Actor("Григорий", "Дорофеев", Gender.MALE, 183);
        Actor thirdActor = new Actor("Елена", "Тимирязева", Gender.FEMALE, 165);
        //Четвертый актер введен для случая наличия однофамильца в спектакле при замене актера
        Actor fourthActor = new Actor("Кирилл", "Дорофеев", Gender.MALE, 187);
        Director firstDirector = new Director("Иван", "Дмитриев", Gender.MALE, 12);
        Director secondDirector = new Director("Марина", "Аксенова", Gender.FEMALE, 14);
        Person choreographer = new Person("Тамара", "Медведева", Gender.FEMALE);
        Person musicAuthor = new Person("Георгий", "Соколов", Gender.MALE);

        //Выполнение пункта №2 ТЗ - создание 3 спектаклей: обычный, оперный и балет
        Show show = new Show("Обычный спектакль", 210, firstDirector);
        Opera opera = new Opera("Опера", 170, secondDirector, musicAuthor,
                "Либретто для оперы", 20);
        Ballet ballet = new Ballet("Балет", 180, firstDirector, musicAuthor,
                "Либретто для балета", choreographer);

        //Выполнение пункта №3 ТЗ - распределение актеров по спектаклям
        show.addActor(firstActor);
        show.addActor(secondActor);

        opera.addActor(secondActor);
        opera.addActor(thirdActor);
        opera.addActor(fourthActor);

        ballet.addActor(firstActor);
        ballet.addActor(secondActor);
        ballet.addActor(thirdActor);

        //Выполнение пункта №4 ТЗ - вывод списка актеров для каждого спектакля
        System.out.println("Актеры, участвующие в обычном спектакле:");
        show.printListOfActors();
        System.out.println("Актеры, участвующие в опере:");
        opera.printListOfActors();
        System.out.println("Актеры, участвующие в балете:");
        ballet.printListOfActors();

        //Выполнение пункта №5 ТЗ - замена актера в одном изспектаклей
        opera.replaceActor(firstActor, "Дорофеев");
        System.out.println("Актеры, участвующие в опере:");
        opera.printListOfActors();

        //Выполнение пункта №6 ТЗ - попытка замены несуществующего актера
        ballet.replaceActor(firstActor, "Николаев");

        //Выполнение пункта №6 ТЗ - вывод текста либретто для оперы и балета
        opera.printLibretto();
        ballet.printLibretto();
    }
}
