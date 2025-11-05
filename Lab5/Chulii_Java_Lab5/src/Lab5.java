import java.util.Arrays;
public class Lab5 {
    public static void main(String[] args) throws Exception {
        System.out.println("Лабораторна робота №5 з Java\n Виконавець: Чулiй Михайло\n Варiант №24\n");

        try{
            Truck truck = new Truck(1000);

            truck.addCoffee(new GrainCoffee("Arabica",200, 30000, 5));
            truck.addCoffee(new GroundCoffee("Lavazza",150, 25000, 4));
            truck.addCoffee(new InstantCoffee("Jacobs Mini",100, 20000, 3));
            truck.addCoffee(new GrainCoffee("Lavazza",100, 30000, 5));
            truck.addCoffee(new GroundCoffee("Supremo",100, 100000, 4));
            truck.addCoffee(new InstantCoffee("Jacobs",100, 25000, 3));

            System.out.println("Вміст фургона до сортування:");
            System.out.println(truck.toString());

            truck.sortByPricePerKg();
            System.out.println("Вміст фургона після сортування за ціною за кг:");
            System.out.println(truck.toString());

            int minQuality = 4;
            int maxQuality = 5;
            Coffee[] filteredCoffees = truck.filterByQuality(minQuality, maxQuality);
            System.out.println("Кави з якістю від " + minQuality + " до " + maxQuality + ":");
            for(Coffee coffee : filteredCoffees) {
                System.out.println(coffee.toString());
            }
        }
        catch(Exception e){
            System.out.println("Помилка: " + e.getMessage());
        }

    }
}

/**
 * Клас фургона, що містить каву та виконує операції завантаження,
 * сортування та фільтрації.
 */
class Truck{
    double capacity;
    Coffee[] coffees;

    public Truck(double capacity) {
        this.capacity = capacity;
        this.coffees = new Coffee[0];
    }

    public void addCoffee(Coffee coffee) throws Exception {
        double currentWeight = Arrays.stream(coffees).mapToDouble(Coffee::getWeight).sum();

        if(currentWeight + coffee.getWeight() <= capacity) {
            Coffee[] newCoffees = Arrays.copyOf(coffees, coffees.length + 1);
            newCoffees[newCoffees.length - 1] = coffee;
            coffees = newCoffees;
        } else {
            throw new Exception("Перевищено місткість фургона!!!");
        }
    }

    public void sortByPricePerKg() {
        Arrays.sort(coffees, (c1, c2) -> Double.compare(c1.pricePerKg(), c2.pricePerKg()));
    }

    public Coffee[] filterByQuality(int minQuality, int maxQuality) {
        return Arrays.stream(coffees)
                     .filter(c -> c.getQuality() >= minQuality && c.getQuality() <= maxQuality)
                     .toArray(Coffee[]::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Фургон (місткість: ").append(capacity).append(" кг)\n");
        sb.append("Вміст фургона:\n");
        for(Coffee coffee : coffees) {
            sb.append(coffee.toString()).append("\n");
        }
        return sb.toString();
    }
}

/*  Батьківський клас кава */
abstract class Coffee{
    String sort;
    String name;
    double weight;
    double price;
    int quality; // 1-5

    public Coffee(String sort, String name, double weight, double price, int quality) {
        if (weight <= 0 || price <= 0 || quality < 1 || quality > 5) {
            throw new IllegalArgumentException("Невірні параметри кави!");
        }
        this.sort = sort;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public int getQuality() {
        return quality;
    }

    public  double pricePerKg() {
        return price / weight;
    }

     @Override
    public String toString() {
        return sort + " | вага: " + weight + " кг | ціна: " + price + " грн | якість: " + quality + " | ціна за кг: " + String.format("%.2f", pricePerKg()) + " грн/кг";
    }
}

/* Класи наслідники
 * поліморфізм у нас проявляється перевизначенням методу pricePerKg(),
 * тобто в кожного виду кафи своя форма по визначенню ціни.
*/
class GrainCoffee extends Coffee{
    public GrainCoffee(String name, double weight, double price, int quality) {
        super("Зернова", name, weight, price, quality);
    }   

    @Override
    public double pricePerKg(){
        if(weight > 100){
            return price / weight / 2.0;
        }
        else{
            return price /weight;
        }
    }
}

class GroundCoffee extends Coffee{
    public GroundCoffee(String name, double weight, double price, int quantity) {
        super("Мелена", name, weight, price, quantity);
    }

    @Override
    public double pricePerKg(){
        if(weight > 150){
            return price / weight / 1.5;
        }
        else{
            return price /weight;
        }
    }
}

class InstantCoffee extends Coffee{
    public InstantCoffee(String name, double weight, double price, int quality) {
        super("Розчинна", name, weight, price, quality);
    }

    @Override
    public double pricePerKg(){
        if(weight > 50){
            return price / weight / 1.3;
        }
        else{
            return price /weight;
        }
    }
}

