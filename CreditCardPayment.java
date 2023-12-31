import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreditCardPayment {
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
    // this constructor
    public void Credit_card_payment(String cardNumber, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }
    // getters and setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    // this method is used to create a new credit card payment
    public static void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        String num = sc.nextLine();
        System.out.println("Enter your cvv");
        String CVV = sc.nextLine();
        System.out.println("Enter your date of expiry");
        String date = sc.nextLine();
        CreditCardPayment p = new CreditCardPayment();
        p.setCardNumber(num);
        p.setCvv(CVV);
        p.setDateOfExpiry(date);
        System.out.println("Payment done");
    }
}
