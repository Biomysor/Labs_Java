import java.util.Arrays;
import java.util.Comparator;
public class Lab3 {
    public static void main(String[] args) throws Exception {
        System.out.println("Лабораторна робота №3 з Java\n Виконавець: Чулiй Михайло\n Варiант №24\n");
        System.out.println("Завдання :Визначити клас літак, який складається як мінімум з 5-и полів.\n");
        try{
            Plane[] planes = Plane.createPlaneArray();

            System.out.println("Початковий масив літаків");
            for (Plane p : planes) {
                System.out.println(p);
            }

            Plane.sortPlanes(planes);

            System.out.println("\nВідсортований масив літаків");
            for (Plane p : planes) {
                System.out.println(p);
            }

            Plane target = new Plane("Airbus A320", 828, 2018, 6100, 180);

            System.out.println("\nПошук ідентичного літака");
            boolean found = false;
            for (Plane p : planes) {
                if (p.equals(target)) {
                    System.out.println("Знайдено ідентичний літак: " + p);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Ідентичного літака не знайдено.");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }
}

class Plane{
    // поля літака (модель, швидкість, рік випуску, дальність польоту, пасажиромісткість)
    String model;
    int speed;
    int year;
    int range;
    int capacity; 

    // конструктор класу Plane проініціалізовуємо поля
    public Plane(String model, int speed, int year, int range, int capacity) {
        this.model = model;
        this.speed = speed;
        this.year = year;
        this.range = range;
        this.capacity = capacity;
    }

    // методи доступу до наших полів (get та set)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // метод створення тестового масиву літаків
    public static Plane[] createPlaneArray() {
        Plane[] planes = new Plane[3];
        planes[0] = new Plane("Boeing 737", 876, 2015, 5600, 189);
        planes[1] = new Plane("Airbus A320", 828, 2018, 6100, 180);
        planes[2] = new Plane("Cessna 172", 226, 2000, 1289, 4);
        return planes;
    }
 
    /* Сортує масив літаків за швидкістю (зростанням)
     і пасажиромісткістю (спаданням).*/
    public static void sortPlanes(Plane[] planes) {
        Arrays.sort(planes, Comparator
                .comparingInt(Plane::getSpeed)
                .thenComparing(Comparator.comparingInt(Plane::getCapacity).reversed())
        );
    }

    // метод який перевіряє ідентичність двох літаків
       @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Plane)) return false;
        Plane other = (Plane) obj;
        return speed == other.speed
                && year == other.year
                && range == other.range
                && capacity == other.capacity
                && model.equals(other.model);
    }

    // повертає рядкове представлення літака
        @Override
    public String toString() {
        return String.format("Plane{model='%s', speed=%d, year=%d, range=%d, capacity=%d}",
                model, speed, year, range, capacity);
    }


}
