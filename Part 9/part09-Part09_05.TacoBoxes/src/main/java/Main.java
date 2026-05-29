public class Main {

    public static void main(String[] args) {

        TacoBox box1 = new TripleTacoBox();

        System.out.println(box1.tacosRemaining());
        box1.eat();
        System.out.println(box1.tacosRemaining());

        TacoBox box2 = new CustomTacoBox(5);

        System.out.println(box2.tacosRemaining());
        box2.eat();
        System.out.println(box2.tacosRemaining());
    }
}