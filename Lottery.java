import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lottery {
    private ArrayList<Toy> toys;
    private ArrayList<Toy> prizes;

    public Lottery(ArrayList<Toy> toys) {
        this.prizes = new ArrayList<Toy>();
        this.toys = toys;
    }

    public ArrayList<Toy> getPrizes() {
        return prizes;
    }

    public ArrayList<Toy> choiceOfPrizesRandom(ArrayList<Toy> toys) {
        for (Toy toy : toys) {
            double random = Math.random() * 100;

            if (random < toy.getFrequency()) {
                prizes.add(toy);

            }
        }
        return prizes;
    }

    public Toy getPrizeToy() {
        if (!prizes.isEmpty()) {

            Toy prizeToy = prizes.remove(0);

            try {
                FileWriter writer = new FileWriter("prize_toys.txt");
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to the toy file");
            }

            return prizeToy;
        } else {
            System.out.println("All the toys are over");
            return null;
        }
    }
}