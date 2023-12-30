import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Clothes extends Product {
    private static List<Clothes> clothes;
    private String size;
    private String gender;
    public static Clothes find_product_by_id(int ID){
        for(Clothes l : clothes){
            if(l.getId() == ID){
                return(l);
            }
        }
        return(null);
    }
    // afficher clothes
    public static void initialise_clothes() {
        String filePath = "Clothes.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        clothes = new ArrayList<>();
        for (String s : lines) {
            String[] informations = s.split(" ");
            Clothes p = new Clothes();
            p.setId(Integer.parseInt(informations[0]));
            p.setName(informations[1]);
            p.setStock_availibility(Integer.parseInt(informations[2]));
            p.setBrand_name(informations[3]);
            p.setColor(informations[4]);
            p.setGender(informations[5]);
            p.setSize(informations[6]);
            p.setPrice(Integer.parseInt(informations[7]));
            p.setOwner_id(informations[8]);
            p.setRating(Integer.parseInt(informations[9]));
            clothes.add(p);
        }
    }

    public static List<Clothes> getClothes() {
        return clothes;
    }

    public static void setClothes(List<Clothes> clothes) {
        Clothes.clothes = clothes;
    }

    public static int get_element_by_id(int productId) {
        int i = 0;
        for (Clothes p : clothes) {
            if (p.getId() == productId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void update_product() {
        int i = 0;
        for (Clothes h : clothes){
            if(Objects.equals(this.getId(), h.getId())){
                break;
            }
            i++;
        }
        String filePath = "Clothes.txt";
        String newContent = this.getId() + " " + this.getName() + " " + this.getStock_availibility() + " " + this.getBrand_name() + " " + this.getColor() + " " + gender + " " + size + " " + this.getPrice() + " " + this.getOwner_id() + " " + this.getRating();
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
        Clothes p = new Clothes();
        if(clothes.size() > 0){
            p.setId(clothes.get(clothes.size() - 1).getId() + 1);
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
        System.out.println("give me the product's size");
        String product_size = scanner.nextLine();
        p.setSize(product_size);
        System.out.println("give me the product's gender");
        String  product_gender = scanner.nextLine();
        p.setGender(product_gender);
        System.out.println("enter the the product's price");
        int product_price = scanner.nextInt();
        p.setPrice(product_price);
        p.setRating(0);
        clothes.add(p);
        String filePath = "Clothes.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String new_prod = p.getId() + " " + p.getName() + " " + p.getStock_availibility() + " " + p.getBrand_name() + " " + p.getColor() + " " + p.getGender() + " " + p.getSize() + " " + p.getPrice() + " " + p.getOwner_id() + " " + p.getRating();

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
        for(Clothes l : clothes){
            if(l.getId() == id){
                break;
            }
            i++;
        }
        clothes.remove(i);
        String filePath = "Clothes.txt";
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
                " size=" + size +
                ", gender=" + gender +
                ", rating=" + this.getRating() +
                '}';
    }
    public static void afficher(){
        for(Clothes l : clothes){
            System.out.println(l.toString());
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    public static void search(String s){
        for(Clothes l : clothes){
            String substring1 = l.getName().substring(0, s.length());
            if(substring1.equals(s)){
                System.out.println(l.toString());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}