public class Bot extends Player {

    public Bot(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Bot plays");
    }

    public void addMove(String move) {
        // no implementation needed
    }
}