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
        String account_type = "";
        while(n != 1 && n != 2){
            n = scanner.nextInt();
            switch (n){
                case 1:
                    account_type = Login.login();
                    System.out.println("What do you want to do next!");
                    break;
                case 2:
                    account_type = Login.sign_up();
                    System.out.println("Welcome to your account!");
                    System.out.println("What do you want to do next!");
                    break;
            }
        }

        int l = 0;
        if(account_type == "admin"){
            while(l != 6){
                System.out.println("1 - add a new product");
                System.out.println("2 - update a product");
                System.out.println("3 - delete a product");
                System.out.println("4 - see a specefic product sales");
                System.out.println("5 - see all products sales");
                System.out.println("6 - log out");
                l = scanner.nextInt();
                switch (l){
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
            }
        }
    }
}

