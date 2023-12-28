import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class Shopping_cart {
    private int id;
    private List<Home_electronic_product> home_electronic_product;
    private List<Clothes> clothes;
    private String owner;
    private int total_price;
    private static List<Shopping_cart> shopping_cart_list;
    public static int get_element_by_id(int ID){
        for(Shopping_cart p : shopping_cart_list){
            if(p.getId() == ID){
                return(shopping_cart_list.indexOf(p));
            }
        }
        return(-1);
    }
    public static int create_shopping_cart(String owner){
        Shopping_cart s = new Shopping_cart();
        s.setClothes(new ArrayList<>());
        s.setHome_electronic_product(new ArrayList<>());
        s.setOwner(owner);
        s.setTotal_price(0);
        if(!shopping_cart_list.isEmpty()){
            s.setId(shopping_cart_list.get(shopping_cart_list.size() - 1).getId() + 1);
        }else{
            s.setId(0);
        }
        shopping_cart_list.add(s);
        String filePath = "Shopping carts.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String new_prod = s.getId() + " " + s.getOwner() + " " + s.getTotal_price();
            if (Files.size(Paths.get(filePath)) == 0) {
                writer.write(new_prod);
            } else {
                writer.newLine();
                writer.write(new_prod);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.getId();
    }
    public static void add_product(int id_of_shopping_cart){
        Scanner scanner = new Scanner(System.in);
        while(Shopping_cart.get_element_by_id(id_of_shopping_cart) == -1){
            System.out.println("this id doesn't exist");
            System.out.println("please enter a valid id");
            id_of_shopping_cart = scanner.nextInt();
            scanner.nextLine();
        }
        int i = Shopping_cart.get_element_by_id(id_of_shopping_cart);
        System.out.println("what is the product category");
        System.out.println("1- Home electronic product");
        System.out.println("2- Clothes");
        int choice = scanner.nextInt();

        while(choice != 1 && choice != 2){
            System.out.println("please enter a valid choice");
            choice = scanner.nextInt();
        }
        Home_electronic_product p ;
        Clothes c;
        if(choice == 1) {
            Home_electronic_product.afficher();
            System.out.println("please enter the product id");
            int product_id = scanner.nextInt();
            scanner.nextLine();
            while (Home_electronic_product.get_element_by_id(product_id) == -1) {
                System.out.println("this id doesn't exist");
                System.out.println("please enter a valid id");
                product_id = scanner.nextInt();
                scanner.nextLine();
            }
            p = Home_electronic_product.find_product_by_id(product_id);
            if (p.getStock_availibility() > 0) {
                p.setStock_availibility(p.getStock_availibility() - 1);
                shopping_cart_list.get(i).getHome_electronic_product().add(p);
                shopping_cart_list.get(i).setTotal_price(shopping_cart_list.get(i).getTotal_price() + p.getPrice());
                String filePath = "Shopping carts.txt";
                List<String> lines = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                lines.set(i, lines.get(i) + " 1 " + p.getId());
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (String updatedLine : lines) {
                        writer.write(updatedLine);
                        if(updatedLine != lines.get(lines.size() - 1)){
                            writer.newLine();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            } else {
                System.out.println("this product is out of stock");
            }
        if(choice == 2){
            Clothes.afficher();
            System.out.println("please enter the product id");
            int product_id = scanner.nextInt();
            while (Clothes.get_element_by_id(product_id) == -1) {
                System.out.println("this id doesn't exist");
                System.out.println("please enter a valid id");
                product_id = scanner.nextInt();
            }
            int j = Clothes.get_element_by_id(product_id);
            c = Clothes.find_product_by_id(product_id);
            if (c.getStock_availibility() > 0) {
                c.setStock_availibility(c.getStock_availibility() - 1);
                shopping_cart_list.get(i).getClothes().add(c);
                shopping_cart_list.get(i).setTotal_price(shopping_cart_list.get(i).getTotal_price() + c.getPrice());
                String filePath = "Shopping carts.txt";
                List<String> lines = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                lines.set(i, lines.get(i) + " 2 " + c.getId());
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (String updatedLine : lines) {
                        writer.write(updatedLine);
                        if(!updatedLine.equals(lines.get(lines.size() - 1))) {
                            writer.newLine();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("this product is out of stock");
            }
        }
    }
    public static void delete_product(int id_of_shopping_cart){
        while(Shopping_cart.get_element_by_id(id_of_shopping_cart) == -1){
            System.out.println("this id doesn't exist");
            System.out.println("please enter a valid id");
            Scanner scanner = new Scanner(System.in);
            id_of_shopping_cart = scanner.nextInt();
        }
        int i = Shopping_cart.get_element_by_id(id_of_shopping_cart);
        System.out.println("what is the product category");
        System.out.println("1- Home electronic product");
        System.out.println("2- Clothes");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while(choice != 1 && choice != 2){
            System.out.println("please enter a valid choice");
            choice = scanner.nextInt();
        }
        Home_electronic_product p;
        Clothes c;
        if(choice == 1) {
            Home_electronic_product.afficher();
            System.out.println("please enter the product id");
            int product_id = scanner.nextInt();
            while (Home_electronic_product.get_element_by_id(product_id) == -1) {
                System.out.println("this id doesn't exist");
                System.out.println("please enter a valid id");
                product_id = scanner.nextInt();
            }
            p = Home_electronic_product.find_product_by_id(product_id);
            shopping_cart_list.get(i).getHome_electronic_product().add(p);
            shopping_cart_list.get(i).setTotal_price(shopping_cart_list.get(i).getTotal_price() + p.getPrice());
            String filePath = "Shopping carts.txt";
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            List<String> informations = new ArrayList<>(List.of(lines.get(i).split(" ")));
            for(String mm : informations){
                System.out.println(mm);
            }
            for(int ch = 0; ch < informations.size() - 1; ch++){
                if(informations.get(ch).equals("1") && informations.get(ch+1).equals(String.valueOf(product_id))){
                    informations.remove(ch);
                    informations.remove(ch );
                    break;
                }
            }
            lines.set(i, String.join(" ", informations));
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    if(updatedLine != lines.get(lines.size() - 1)){
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Clothes.afficher();
            System.out.println("please enter the product id");
            int product_id = scanner.nextInt();
            while (Clothes.get_element_by_id(product_id) == -1) {
                System.out.println("this id doesn't exist");
                System.out.println("please enter a valid id");
                product_id = scanner.nextInt();
            }
            c = Clothes.find_product_by_id(product_id);
            int j = shopping_cart_list.get(i).getClothes().indexOf(c);
            shopping_cart_list.get(i).getClothes().add(c);
            shopping_cart_list.get(i).setTotal_price(shopping_cart_list.get(i).getTotal_price() + c.getPrice());
            String filePath = "Shopping carts.txt";
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            List<String> informations = new ArrayList<>(List.of(lines.get(i).split(" ")));
            for(String mm : informations){
                System.out.println(mm);
            }
            for(int ch = 0; ch < informations.size() - 1; ch++){
                if(informations.get(ch).equals("2") && informations.get(ch+1).equals(String.valueOf(product_id))){
                    informations.remove(ch);
                    informations.remove(ch);
                    break;
                }
            }
            lines.set(i, String.join(" ", informations));
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    if(updatedLine != lines.get(lines.size() - 1)){
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Home_electronic_product> getHome_electronic_product() {
        return home_electronic_product;
    }

    public void setHome_electronic_product(List<Home_electronic_product> home_electronic_product) {
        this.home_electronic_product = home_electronic_product;
    }

    public List<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public static List<Shopping_cart> getShopping_cart_list() {
        return shopping_cart_list;
    }

    public static void setShopping_cart_list(List<Shopping_cart> shopping_cart_list) {
        Shopping_cart.shopping_cart_list = shopping_cart_list;
    }
    public static void initialise_shopping_cart(){
        String filePath = "Shopping carts.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        shopping_cart_list = new ArrayList<>();
        for (String s : lines) {
            String[] informations = s.split(" ");
            Shopping_cart p = new Shopping_cart();
            p.setId(Integer.parseInt(informations[0]));
            p.setOwner(informations[1]);
            int k = 2;
            while(k < informations.length){
                if(informations[k].equals("1")){
                    p.getHome_electronic_product().add(Home_electronic_product.find_product_by_id(Integer.parseInt(informations[k+1])));
                }
                if(informations[k].equals("2")){
                    p.getClothes().add(Clothes.find_product_by_id(Integer.parseInt(informations[k+1])));
                }
                k = k + 2;
            }
            shopping_cart_list.add(p);
        }
    }
    public static void afficher(String user_id){
        for(Shopping_cart u : shopping_cart_list){
            if(Objects.equals(u.getOwner(), user_id)){
                System.out.println("the cart id is " + u.getId());
                for(Home_electronic_product p : u.getHome_electronic_product()){
                    System.out.println(p.getName());
                }
                for(Clothes c : u.getClothes()){
                    System.out.println(c.getName());
                }
                System.out.println("total price : " + u.getTotal_price());
                System.out.println("________________________________________________________________________________________");
            }
        }
    }
}