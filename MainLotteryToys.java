public class MainLotteryToys {
    public static void main(String[] args) {
        Store store = new Store();
        Counter_id counter = new Counter_id(0);
        UI ui = new UI();

        ui.userMenu(store, counter, null);
    }
}
