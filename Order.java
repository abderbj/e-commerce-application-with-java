import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class Order {
    private int id ;
    private Shopping_cart shopping_cart;
    private boolean payment_method;
    private String owner;
    private static List<Order> order_list;
    private int total_price;

    public static void afficher(String id) {
        for(Order o : order_list){
            if(o.getOwner().equals(id)){
                System.out.println(o.getId());
                if(o.get_payment()){
                    System.out.println("paid");
                }else{
                    System.out.println("not paid");
                }
                System.out.println(o.getTotal_price() + "$");
                System.out.println("_______________________________________________________________________________");
            }
        }
    }

    public Shopping_cart getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(Shopping_cart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static List<Order> getOrder_list() {
        return order_list;
    }

    public static void setOrder_list(List<Order> order_list) {
        Order.order_list = order_list;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    static void add_order(String user){
        System.out.println("Choose a shopping cart by picking an id");
        Shopping_cart.afficher(user);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Shopping_cart s = Shopping_cart.find_cart_by_id(n);
        Order o = new Order();
        o.setShopping_cart(s);
        o.setOwner(user);
        o.setPayment_method(false);
        if(order_list.size()==0){
            o.setId(0);}
        else{
            o.setId(order_list.get(order_list.size()-1).getId()+1);
        }
        int price = 0;
        for(Product p : s.getHome_electronic_product()){
            price += p.getPrice();
        }
        for(Product p : s.getClothes()){
            price += p.getPrice();
        }
        o.setTotal_price(price);
        order_list.add(o);
        String filePath = "Order.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String new_prod = o.getId() + " " + o.getOwner() + " " + o.getShopping_cart().getId() + " " + o.get_payment();
            if (Files.size(Paths.get(filePath)) == 0) {
                writer.write(new_prod);
            } else {
                writer.newLine();
                writer.write(new_prod);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean isPayment_method() {
        return payment_method;
    }

    public void setPayment_method(boolean payment_method) {
        this.payment_method = payment_method;
    }
    public boolean get_payment(){
        return payment_method;
    }
    static void confirm_order(int new_id) {
        System.out.println("Choose a payment method by picking an id");
        System.out.println("1. Credit card");
        System.out.println("2. Paypal");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n != 1 && n != 2) {
            System.out.println("Choose a payment method by picking an id");
            System.out.println("1. Credit card");
            System.out.println("2. Paypal");
            n = scanner.nextInt();
            scanner.nextLine();
        }
        if (n == 1) {
            CreditCardPayment.create();

        } else {
            PayPalPayment.create_paypal_cart();
        }
        Order o = Order.find_order_by_id(new_id);
        assert o != null;
        o.setPayment_method(true);
        for(Product p : o.getShopping_cart().getHome_electronic_product()){
            p.setStock_availibility(p.getStock_availibility()-1);
        }
        for(Product p : o.getShopping_cart().getClothes()){
            p.setStock_availibility(p.getStock_availibility()-1);
        }
        String filePath = "Order.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String new_prod = o.getId() + " " + o.getOwner() + " " + o.getShopping_cart().getId() + " " + o.get_payment() + " " + o.getTotal_price();
            if (Files.size(Paths.get(filePath)) == 0) {
                writer.write(new_prod);
            } else {
                writer.newLine();
                writer.write(new_prod);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    static Order find_order_by_id(int newId) {
        for(Order o : order_list){
            if(o.getId() == newId){
                return o;
            }
        }
        return null;
    }
    public static void initialise(){
        String filePath = "Order.txt";
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        order_list = new ArrayList<>();
        for (String s : lines) {
            String[] informations = s.split(" ");
            Order p = new Order();
            p.setId(Integer.parseInt(informations[0]));
            p.setOwner(informations[1]);
            p.setShopping_cart(Shopping_cart.find_cart_by_id(Integer.parseInt(informations[2])));
            p.setPayment_method(Boolean.parseBoolean(informations[3]));
            p.setTotal_price(Integer.parseInt(informations[4]));
            order_list.add(p);
        }
    }
}
