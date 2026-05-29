public class Main {

    public static void main(String[] args) {

        Box box = new Box(10);

        box.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2));
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));

        System.out.println(box);
    }
}