import java.util.ArrayList;

public class Store {
    private ArrayList<Toy> toys;

    public Store() {
        toys = new ArrayList<Toy>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);

    }

    public ArrayList<Toy> getToys() {
        return toys;
    }


    public void deleteToyFromStore(ArrayList<Toy> toys, String name) {
        int i = 0;
        for (Toy t : toys) {
            if (t.getName().contains(name)) {
                toys.remove(t);
                i++;
                break;
            }
        }

        if (i > 0) {
            System.out.println("the toy  " + name + "  was successfully removed ");

        } else {
            System.out.println("the toy  " + name + "  does not exist");

        }
    }

    public boolean changeToy(String name, double frequency) {
        boolean flag = false;
        for (Toy t : toys) {
            if (t.getName().contains(name)) {
                t.setName(name);
                t.setFrequency(frequency);
                flag = true;
            }
        }
        return flag;
    }

}
