// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Users.initialise_users();
        Users.afficher();
        System.out.println("Hello! what do u want to do");
        System.out.println("1 - Log in");
        System.out.println("2 - Sign up");
        System.out.println("Hello! what do u want to do");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:
                Login.login();
                System.out.println("What do you want to do next!");
                break;
            case 2:
                Login.sign_up();
                System.out.println("Welcome to your account!");
                System.out.println("What do you want to do next!");
                break;
        }
        while(n != 6){
            System.out.println("1 - Create a new shopping cart");
            System.out.println("2 - Search for a specefic product");
            System.out.println("Hello! what do u want to do");
        }
    }
}

