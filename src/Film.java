public class Film {
    public String name;
    public int year;
    public String country;
    public String genre;
    protected float cost;

    /**
     * Конструктор
     */
    public Film(String name, int year, String country, String genre, float cost){
        this.name = name;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.cost = cost;
    }

    /**
     * Вывод информации о фильме
     */
    public Object info(){
        System.out.println("Название фильма: " + name);
        System.out.println("Год выпуска: " + year + " г.");
        System.out.println("Страна: " + country);
        System.out.println("Жанр: " + genre);
        System.out.println("Стоимость проката: " + String.format("%.2f", cost) + " руб.");
        return null;
    }

    /**
     * Получение года выпуска
     */
    public Integer getYear(){
        return year;
    }

    /**
     * Получение названия фильма
     */
    public String getName(){
        return name;
    }

    /**
     * Получение стоимости проката
     */
    public Float getCost(){
        return cost;
    }
}
