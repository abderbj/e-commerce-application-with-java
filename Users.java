import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
public class Users {
    private static List<User> users = new ArrayList<>();
    public static List<User> getUsers(){
        return users;
    }
    public static void initialise_users(){
        System.out.println("hello");
        String filePath = "Users.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        users = new ArrayList<>();
        for (String s : lines) {
            String[] informations = s.split(" ");
            User user = new User();
            user.setName(informations[0]);
            user.setAge(Integer.valueOf(informations[1]));
            user.setEmail(informations[2]);
            user.setUsername(informations[3]);
            user.setPassword(informations[4]);
            user.setAccount_type(informations[5]);
            user.setId(informations[6]);
            users.add(user);
        }
    }

    public Users() {
        this.users = new ArrayList<>();
    }
    public static void afficher(){
        for(User u : users){
            System.out.println(u.getName());
        }
    }

    public static void addUser(User user) {

        users.add(user);
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

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

}
