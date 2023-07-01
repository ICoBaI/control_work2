import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Counter_id counter;
    private Store store;
    private Lottery lottery;
    private ArrayList<Toy> toys;

    public void showStore(ArrayList<Toy> toys) {

        System.out.printf("%-5s%-15s%-22s\n", "Id", "Name", "Frequency");
        for (Toy toy : toys)
            System.out.printf("%-5d%-15s%-22f\n", toy.getId(), toy.getName(), toy.getFrequency());

    }

    public void userMenu(Store store, Counter_id counter, ArrayList<Toy> toys) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n         Выберите пункт меню\n" +
                    "1 - Показать список игрушек в магазине\n" +
                    "2 - Начать розыгрыш\n" +
                    "3 - Добавить игрушку\n" +
                    "4 - Удалить игрушку\n" +
                    "5 - Изменить параметры игрушки\n" +
                    "6 - exit");

            Scanner sc = new Scanner(System.in);

            String user_input = sc.next();

            if (user_input.contains("1")) {
                System.out.println("\nСписок игрушек: ");
                showStore(store.getToys());
            } else if (user_input.contains("2")) {
                Lottery lottery = new Lottery(store.getToys());
                lottery.choiceOfPrizesRandom(store.getToys());
                Toy priceToy = lottery.getPrizeToy();
                if (priceToy != null) {
                    System.out.println("\nПобедила: " + priceToy.getName() + "\n");
                }
            } else if (user_input.contains("3")) {
                System.out.println("Введите название игрушки: ");
                String name = sc.next();
                boolean flag1 = true;
                System.out.println("Введите шанс выподения: ");
                double frequency = Double.parseDouble(sc.next());
                while (flag1) {
                    if (frequency > 0 && frequency < 100) {
                        flag1 = false;
                    } else {
                        System.out.println("Шанс выподения от 0 до 100: ");
                        frequency = Double.parseDouble(sc.next());
                    }
                }
                store.addToy(new Toy(counter.getId(), name, frequency));
                System.out.println("Игрушка добавлена ");
            } else if (user_input.contains("4")) {
                System.out.println("Введите имя игрушки: ");
                String name = sc.next();
                store.deleteToyFromStore(toys, name);
            } else if (user_input.contains("5")) {
                System.out.println("Введите имя игрушки: ");
                String name = sc.next();
                boolean flag2 = true;
                System.out.println("Введите шанс выподения: ");
                double frequency = Double.parseDouble(sc.next());
                while (flag2) {
                    if (frequency > 0 && frequency < 100) {
                        flag2 = false;
                    } else {
                        System.out.println("Шанс выподения от 0 до 100: ");
                        frequency = Double.parseDouble(sc.next());
                    }
                }
                if (store.changeToy(name, frequency)) {
                    System.out.println("параметры  " + name + " изменены!");
                } else {
                    System.out.println(name + " нету");
                }
            }else if(user_input.contains("6")){
                break;
            }

        }
    }
}
