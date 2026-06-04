public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println(name + " plays");
    }

    public void printName() {
        System.out.println(name);
    }
}