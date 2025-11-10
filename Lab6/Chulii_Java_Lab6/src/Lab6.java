import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class Lab6 {
    public static void main(String[] args) throws Exception {
        System.out.println("Лабораторна робота №6 з Java\n Виконавець: Чулiй Михайло\n Варiант №24\n");

        try{
            List<Coffee> coffeeCollection = Arrays.asList(
                new GrainCoffee("Arabica Special", 250, 40000, 5),
                new GroundCoffee("Lavazza Gold", 200, 30000, 4)
            );

            MyList<Coffee> list = new MyList<>(coffeeCollection);

            list.add(new GrainCoffee("Arabica",200, 30000, 5));
            list.add(new GroundCoffee("Lavazza",150, 25000, 4));
            list.add(new InstantCoffee("Jacobs Mini",100, 20000, 3));
            list.add(new GrainCoffee("Lavazza",100, 30000, 5));
            list.add(new GroundCoffee("Supremo",100, 100000, 4));
            list.add(new InstantCoffee("Jacobs",100, 25000, 3));

           

            System.out.println("Список кави:");
            System.out.println(list.toString());

            System.out.println("Перший елемент: " + list.get(0));
            list.remove(1);
            System.out.println("Після видалення другого елемента:");
            System.out.println(list);
        }
        catch(Exception e){
            System.out.println("Помилка: " + e.getMessage());
        }

    }
}

/* Власна реалізація списку */
class MyList<T> implements List<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    /* Конструктори */
    public MyList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public MyList(T item) {
        this();
        add(item);
    }

    public MyList(Collection<? extends T> collection) {
        this();
        for (T item : collection) {
            add(item);
        }
    }

    /* Додати елемент до списку */
    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
        return true;
    }

    /* Отримати елемент за індексом */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс поза межами списку");
        }
        return (T) elements[index];
    }

    /* Повернути розмір списку */
    @Override
    public int size() {
        return size;
    }

    /* Збільшити розмір масиву на 30% */
    private void resize() {
        int newCapacity = (int) (elements.length * GROWTH_FACTOR);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < size; i++) {
            sb.append("  ").append(elements[i]).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    /* Перевірити, чи список порожній */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* Видалити елемент за індексом */
    @Override
    public T remove(int index) {
        if(index < 0 || index >= size){
             throw new IndexOutOfBoundsException();
        }
        T old = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return old;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
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

