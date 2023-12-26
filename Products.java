import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Products {
    private static List<User> products = new ArrayList<>();
    public static List<User> getProducts(){
        return products;
    }
    public static void initialise_products(){
        String filePath = "Products.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        products = new ArrayList<>();
        for (String s : lines) {
            String[] informations = s.split(" ");
            User user = new User();

        }
    }

    public Products() {
        this.products = new ArrayList<>();
    }
    public static void afficher(){
        for(User u : products){
            System.out.println(u.getName());
        }
    }

    public static void addUser(User user) {

        String filePath = "Users.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String age = "" + user.getAge();
            String name = user.getName();
            String email = user.getEmail();
            String username = user.getUsername();
            String password = user.getPassword();
            String account_type = user.getAccount_type();
            String id = user.getId();
            String s = name + " " + age + " " + email + " " + username + " "  + password + " "  + account_type + " " + id;

            if (Files.size(Paths.get(filePath)) == 0) {
                writer.write(s);
            } else {
                writer.newLine();
                writer.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public List<User> getAllProducts() {
        return new ArrayList<>(products);
    }
}