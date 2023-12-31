import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
class PayPalPayment{
    private String email;
    private String password;
    // getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // create a new paypal payment
    public static void create_paypal_cart(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email");
        String email = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        PayPalPayment p = new PayPalPayment();
        p.setEmail(email);
        p.setPassword(password);
        System.out.println("Payment done");
    }
}

