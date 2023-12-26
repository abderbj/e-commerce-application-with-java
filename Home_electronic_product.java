import javax.swing.plaf.ProgressBarUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
public class Home_electronic_product extends Product{
    private static List<Home_electronic_product> elctronic_product_list;
    private int weight;
    private int power;
    private int voltage;

    /*public Home_electronic_product(String product_id, String product_name, int product_stock, String product_brand, String product_color) {
        super(product_id, product_name, product_stock, product_brand, product_color);
    }*/

    public static Home_electronic_product find_product_by_id(int ID){
        for(Home_electronic_product l : elctronic_product_list){
            if(l.getId() == ID){
                return(l);
            }
        }
        return(null);
    }
    public static void initialise_products(){
        String filePath = "Electronics.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        elctronic_product_list = new ArrayList<>();
        for (String s : lines) {
            String[] informations = s.split(" ");
            Home_electronic_product p = new Home_electronic_product();
            p.setId(Integer.parseInt(informations[0]));
            p.setName(informations[1]);
            p.setStock_availibility(Integer.parseInt(informations[2]));
            p.setBrand_name(informations[3]);
            p.setColor(informations[4]);
            p.setWeight(Integer.parseInt(informations[5]));
            p.setPower(Integer.parseInt(informations[6]));
            p.setVoltage(Integer.parseInt(informations[7]));
            p.setOwner_id(informations[8]);
            p.setPrice(Integer.parseInt(informations[9]));
            elctronic_product_list.add(p);
        }
    }
    /*public Home_electronic_product(String product_id, String product_name, int product_stock, String product_brand, String product_color, int product_weight, int product_power, int product_voltage){
        super(product_id, product_name, product_stock, product_brand, product_color);
        weight = product_weight;
        power = product_power;
        voltage = product_voltage;
        elctronic_product_list.add(this);
    }*/
    @Override
    public void update_product() {
        int i = 0;
        for (Home_electronic_product h : elctronic_product_list){
            if(Objects.equals(this.getId(), h.getId())){
                break;
            }
            i++;
        }
            String filePath = "Electronics.txt";
            String newContent = this.getId() + " " + this.getName() + " " + this.getStock_availibility() + " " + this.getBrand_name() + " " + this.getColor() + " " + weight + " " + power + " " + voltage + " " + this.getOwner_id() + " " + this.getPrice();
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

            if (lines.size() >= i) {
                lines.set(i, newContent);
            } else {
                return;
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static void add_product(String s){
        Home_electronic_product p = new Home_electronic_product();
        if(elctronic_product_list.size() > 0){
            p.setId(elctronic_product_list.get(elctronic_product_list.size() - 1).getId() + 1);
        }else{
            p.setId(0);
        }
        p.setOwner_id(s);
        System.out.println("give me the product name");
        Scanner scanner = new Scanner(System.in);
        String prod_name = scanner.nextLine();
        p.setName(prod_name);
        System.out.println("give me the product quantity");
        int product_stock = scanner.nextInt();
        p.setStock_availibility(product_stock);
        scanner.nextLine();
        System.out.println("enter the product's color");
        String product_color = scanner.nextLine();
        p.setColor(product_color);
        System.out.println("enter the product's brand");
        String product_brand = scanner.nextLine();
        p.setBrand_name(product_brand);
        System.out.println("give me the product's weight");
        int product_weight = scanner.nextInt();
        p.setWeight(product_weight);
        scanner.nextLine();
        System.out.println("give me the product's power");
        int product_power = scanner.nextInt();
        p.setPower(product_power);
        scanner.nextLine();
        System.out.println("give me the product's voltage");
        int product_voltage = scanner.nextInt();
        p.setVoltage(product_voltage);
        scanner.nextLine();
        System.out.println("enter the the product's price");
        int product_price = scanner.nextInt();
        p.setPrice(product_price);
        scanner.nextLine();
        elctronic_product_list.add(p);
        String filePath = "Electronics.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String new_prod = p.getId() + " " + p.getName() + " " + String.valueOf(p.getStock_availibility()) + " " + p.getBrand_name() + " " + p.getColor() + " " + String.valueOf(p.getWeight()) + " " + String.valueOf(p.getPower()) + " " + String.valueOf(p.getVoltage()) + " " + p.getOwner_id() + " " + String.valueOf(p.getPrice());

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
    public static void delete_product(int id){
        int i = 0;
        for(Home_electronic_product l : elctronic_product_list){
            if(l.getId() == id){
                break;
            }
            i++;
        }
        elctronic_product_list.remove(i);
        String filePath = "Electronics.txt";
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
        lines.remove(i);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setElctronic_product_list(List<Home_electronic_product> elctronic_product_list) {
        Home_electronic_product.elctronic_product_list = elctronic_product_list;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getWeight() {
        return weight;
    }

    public int getPower() {
        return power;
    }

    public int getVoltage() {
        return voltage;
    }

    @Override
    public String toString() {
        return   "Product{" +
                "price=" + this.getPrice() +
                ", id='" + this.getId() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", stock_availibility=" + this.getStock_availibility() +
                ", brand_name='" + this.getBrand_name() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", owner_id='" + this.getOwner_id() + '\'' +
                "weight=" + weight +
                ", power=" + power +
                ", voltage=" + voltage +
                '}';
    }

    public static List<Home_electronic_product> getElctronic_product_list() {
        return elctronic_product_list;
    }
    public static void afficher(){
        for(Home_electronic_product l : elctronic_product_list){
            System.out.println(l.toString());
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
