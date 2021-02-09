public class t7 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Producer pro = new Producer(shop);
        Cousumer cou = new Cousumer(shop);
        new Thread(pro).start();
        new Thread(cou).start();

    }

}
