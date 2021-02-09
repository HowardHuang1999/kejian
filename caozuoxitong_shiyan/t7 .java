import java.util.ArrayList;
import java.util.List;

class Product {
  
   
}

 class Shop {
  
    private static List<Product> list = new ArrayList<Product>();
           public synchronized  void  produ() {
        while (list.size()== 10) {
            try {
                System.out.println(
                       "full,waiting fo produce");
                wait();
            }  catch(Exception e)
	 {e.printStackTrace();}

        } 
        Product product = new Product();
     
        list.add(product);
        System.out.println("producing"  );
        System.out.println("amount of product is " + list.size());
       
        notify();
    }
    
    public synchronized void cousu() {
        while (list.size() == 0) {
            System.out.println("empty ,waiting for comsume");
            try {
                wait();
            }  catch(Exception e)
	 {e.printStackTrace();}

        }
        list.remove(0);
        System.out.println("comsuming" );
        System.out.println("amount of product is " + list.size());
        notify();
    }
}

 class Cousumer implements Runnable {
    private Shop shop;
    public Cousumer(Shop shop) {
        this.shop = shop;
    }
    public void run() {
        while (true) {
            try {
        
                Thread.sleep(1000);
                shop.cousu();
                   }  catch(Exception e)
	 {e.printStackTrace();}

        }
    }
}

 class Producer implements Runnable {
    private Shop shop;
    public Producer(Shop shop) {
        this.shop = shop;
    }
    public void run() {
        while (true) {
            try {
                       Thread.sleep(1000);
                shop.produ();
                            }  catch(Exception e)
	 {e.printStackTrace();}
        }
    }
}
