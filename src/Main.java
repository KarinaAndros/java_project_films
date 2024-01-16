import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    /**
     * Список для хранения фильмов
     */
    public static ArrayList<Film> films = new ArrayList<Film>();

    /**
     * Изменение данных о фильме
     */
    public static void editData() {

        for (int i = 0; i < films.toArray().length; i++) {
            System.out.println("\n");
            System.out.println("Фильм №" + (i + 1));
            ((Film) films.toArray()[i]).info();
            System.out.println("\n");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер фильма, который вы желаете изменить: ");
        int number = Integer.parseInt(sc.nextLine());

        System.out.println("\nВыберите что именно желаете изменить:\n1.Название\n2.Год выпуска\n3.Страну\n4.Жанр\n5.Стоимость проката\n");
        int number_value = Integer.parseInt(sc.nextLine());
        if (number_value < 1 || number_value > 5){
            System.out.println("Ошибка! Должно быть выбрано значение от 1 до 5.");
        }else {
            if (number > 0 && number <= films.toArray().length){
                for (int i = 0; i < films.toArray().length; i++) {
                    if (number - 1 == i) {
                        switch (number_value) {
                            case 1:
                                System.out.println("Введите новое название фильма: ");
                                try {
                                    String new_name = sc.nextLine();
                                    if (!new_name.isEmpty()){
                                        ((Film)films.toArray()[i]).name = new_name;
                                        System.out.println("\nДанные успешно изменены!");
                                    }else {
                                        System.out.println("Ошибка изменения данных. Было введено пустое значение.");
                                        editData();
                                    }
                                }catch (Exception e){
                                    System.out.println("Ошибка изменения данных. Повторите попытку.");
                                    editData();
                                }
                                break;
                            case 2:
                                System.out.println("Введите новый год выпуска: ");
                                try {
                                    int new_year = Integer.parseInt(sc.nextLine());
                                    ((Film)films.toArray()[i]).year = new_year;
                                    System.out.println("\nДанные успешно изменены!");
                                }catch (Exception e){
                                    System.out.println("Ошибка изменения данных. Повторите попытку.");
                                    editData();
                                }
                                break;
                            case 3:
                                System.out.println("Введите новую страну: ");
                                try {
                                    String new_country = sc.nextLine();
                                    if (!new_country.isEmpty()){
                                        ((Film)films.toArray()[i]).country = new_country;
                                        System.out.println("\nДанные успешно изменены!");
                                    }else {
                                        System.out.println("Ошибка изменения данных. Было введено пустое значение.");
                                        editData();
                                    }
                                }catch (Exception e){
                                    System.out.println("Ошибка изменения данных. Повторите попытку.");
                                    editData();
                                }
                                break;
                            case 4:
                                System.out.println("Введите новый жанр: ");
                                try {
                                    String new_genre = sc.nextLine();
                                    if (!new_genre.isEmpty()){
                                        ((Film)films.toArray()[i]).genre = new_genre;
                                        System.out.println("\nДанные успешно изменены!");
                                    }else {
                                        System.out.println("Ошибка изменения данных. Было введено пустое значение.");
                                        editData();
                                    }
                                }catch (Exception e){
                                    System.out.println("Ошибка изменения данных. Повторите попытку.");
                                    editData();
                                }
                                break;
                            case 5:
                                System.out.println("Введите новую стоимость проката: ");
                                try {
                                    int new_cost = Integer.parseInt(sc.nextLine());
                                    ((Film)films.toArray()[i]).cost = new_cost;
                                    System.out.println("\nДанные успешно изменены!");
                                }catch (Exception e){
                                    System.out.println("Ошибка изменения данных. Повторите попытку.");
                                    editData();
                                }
                                break;
                        }
                        System.out.println("\n");
                    }
                    ((Film) films.toArray()[i]).info();
                    menu();
                }
            }else {
                System.out.println("Ошибка! Фильма с таким номером нет.");
            }
        }
    }

    /**
     * Поиск фильма по названию
     */
    public static void searchName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название фильма: ");
        String name = sc.nextLine();
        if (!name.isEmpty()){
            for (int i = 0; i < films.toArray().length; i++) {
                if ((((Film) films.toArray()[i]).getName()).toLowerCase().contains(name.toLowerCase())) {
                    System.out.println("\nФильм №" + (i + 1));
                    ((Film) films.toArray()[i]).info();
                    System.out.println("\n");
                }
            }
        }else {
            System.out.println("Ошибка поиска! Введено пустое значение.");
        }
        menu();
    }

    /**
     * Сортировка фильмов в алфавитном порядке
     */
    public static void sortFilms() {

        Film[] new_array = films.toArray(new Film[films.size()]);
        Arrays.sort(new_array, Comparator.comparing(Film::getName));

        for (int i = 0; i < new_array.length; i++) {
            System.out.println("\nФильм №" + (i + 1));
            ((Film)new_array[i]).info();
            System.out.println("\n");
        }
        menu();

    }

    /**
     * Информация о фильме самого раннего года выпуска
     */
    public static void filmWithMinYear() {
        int min = ((Film)films.toArray()[0]).getYear();
        Film film_with_min_year = (Film)films.toArray()[0];

        for (int i = 1; i < films.toArray().length; i++) {
            if (((Film)films.toArray()[i]).getYear() < min) {
                min = ((Film)films.toArray()[i]).getYear();
                film_with_min_year = (Film)films.toArray()[i];
            }
        }

        System.out.println("\nФильм самого раннего года выпуска:\n");
        film_with_min_year.info();

        menu();
    }

    /**
     * Фильмы, стоимость проката которых выше средней
     */
    public static void aboveAverage() {

        float sum = 0;
        ArrayList<Film> new_array = new ArrayList<Film>();

        for (int i = 0; i < films.toArray().length; i++) {
            sum += ((Film) films.toArray()[i]).getCost();
        }

        float average = sum / films.toArray().length;

        System.out.println("\nСредняя стоимость проката: " + String.format("%.2f", average) + " руб.");
        System.out.println("Фильмы, стоимость проката которых выше средней:\n ");

        for (int i = 0; i < films.toArray().length; i++) {
            if (((Film) films.toArray()[i]).getCost() > average) {
                new_array.add((Film)films.toArray()[i]);
            }
        }
        if (new_array.toArray().length > 0){
            for (int i = 0; i < new_array.toArray().length; i++) {
                System.out.println("\nФильм №" + (i + 1));
                ((Film)new_array.toArray()[i]).info();
                System.out.println("\n");
            }
        }else {
            System.out.println("Таких фильмов нет.");
        }
        menu();
    }

    /**
     * Просмотр списка всех фильмов
     */
    public static void allFilms() {
        for (int i = 0; i < films.toArray().length; i++) {
            System.out.println("\nФильм №" + (i + 1));
            ((Film) films.toArray()[i]).info();
            System.out.println("\n");
        }
        menu();
    }

    /**
     * Добавление фильма
     */
    public static void addFilm() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\nВведите название фильма: ");
            String name = sc.nextLine();
            System.out.println("Введите название страны: ");
            String country = sc.nextLine();
            System.out.println("Введите жанр: ");
            String genre = sc.nextLine();
            System.out.println("Введите год выпуска фильма: ");
            int year = sc.nextInt();
            System.out.println("Введите стоимость проката: ");
            float cost = sc.nextFloat();
            Film new_film = new Film(name, year, country, genre, cost);
            films.add(new_film);
            System.out.println("\nДанные успешно добавлены!\n");
        } catch (Exception e) {
            System.out.println("Введены некорректные данные. Повторите попытку");
            addFilm();
        }

        System.out.println("\nДобавить ещё один фильм?\n1. Добавить\n2. Вернуться в главное меню");
        System.out.println("Выберите нужный вариант (1-2): ");
        int a = sc.nextInt();
        switch (a) {
            case 1:
                addFilm();
                break;
            case 2:
                menu();
        }

        sc.close();
    }

    /**
     * Вывод меню программы
     */
    public static void menu() {
        System.out.println(

                "\nДобро пожаловать в меню!\n" +
                        "--------------------------------\n" +
                        "1. Посмотреть список всех фильмов\n" +
                        "2. Добавить фильм\n" +
                        "3. Посмотреть список фильмов со стоимостью проката выше средней\n" +
                        "4. Посмотреть информацию о фильме самого раннего года выпуска\n" +
                        "5. Отсортировать фильмы по названию и вывести\n" +
                        "6. Найти фильм по названию\n" +
                        "7. Изменить данные о фильме\n" +
                        "8. Выйти из программы\n" +
                        "--------------------------------"
        );

        Scanner sc = new Scanner(System.in);
        System.out.println("\nВыберите что хотите сделать (1-8): ");
        int a = Integer.parseInt(sc.next());;
        if (a > 8 || a <= 0) {
            System.out.println("Должно быть выбрано значение от 1 до 8!");
            menu();
        } else if ((a == 1 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7) && films.toArray().length == 0) {
            System.out.println("Функция не доступна, так как в списке нет ни одного фильма. Для начала добавьте несколько фильмов.");
            menu();
        } else {
            switch (a) {
                case 1:
                    allFilms();
                    break;
                case 2:
                    addFilm();
                    break;
                case 3:
                    aboveAverage();
                    break;
                case 4:
                    filmWithMinYear();
                    break;
                case 5:
                    sortFilms();
                    break;
                case 6:
                    searchName();
                    break;
                case 7:
                    editData();
                    break;
                case 8:
                    System.out.println("\nДо свидания!");
                    System.exit(0);
                    break;
            }
        }
        sc.close();
    }

    /**
     * Главный метод
     */
    public static void main(String[] args) {
        menu();
    }
}
