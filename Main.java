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
        Home_electronic_product.initialise_products();
        Clothes.initialise_clothes();
        Shopping_cart.initialise_shopping_cart();
        Order.initialise();
        System.out.println("Hello! what do u want to do");
        System.out.println("1 - Log in");
        System.out.println("2 - Sign up");
        System.out.println("Hello! what do u want to do");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        User u = new User();
        while(n != 1 && n != 2){
            System.out.println("please write 1 or 2");
            n = scanner.nextInt();
            scanner.nextLine();
        }
        switch (n){
            case 1:
                u = Login.login();
                System.out.println("What do you want to do next!");
                break;
            case 2:
                u = Login.sign_up();
                System.out.println("Welcome to your account!");
                System.out.println("What do you want to do next!");
                break;
        }
        int l = 0;
        if(Objects.equals(u.getAccount_type(), "admin")){
            System.out.println("hello world");
            while(l != 4){
                System.out.println("1 - add a new product");
                System.out.println("2 - update a product");
                System.out.println("3 - delete a product");
                System.out.println("4 - log out");
                l = scanner.nextInt();
                scanner.nextLine();
                switch (l){
                    case 1:
                        System.out.println("what is the product category");
                        System.out.println("1 - house electronics");
                        System.out.println("2 - clothes");
                        int t = scanner.nextInt();
                        scanner.nextLine();
                        while(n != 1 && n != 2 && n != 3){
                            t = scanner.nextInt();
                            scanner.nextLine();
                        }
                        if(t == 1){
                            Home_electronic_product.add_product(u.getId());
                        }
                        else if(t == 2){
                            Clothes.add_product(u.getId());
                        }
                        break;
                    case 2:
                        System.out.println("what is the product category");
                        System.out.println("1 - house electronics");
                        System.out.println("2 - clothes");
                        t = scanner.nextInt();
                        scanner.nextLine();
                        while(n != 1 && n != 2 && n != 3){
                            t = scanner.nextInt();
                            scanner.nextLine();
                        }
                        if(t == 1){
                            Home_electronic_product.afficher();
                            System.out.println("pick the id of the product you want to update");
                            int new_id =scanner.nextInt();
                            Home_electronic_product h = Home_electronic_product.find_product_by_id(new_id);
                            while(!Objects.equals(h.getOwner_id(), u.getId())){
                                System.out.println("you can't update a product that it is not yours");
                                System.out.println("pick a new id of the product you want to update");
                                new_id =scanner.nextInt();
                                h = Home_electronic_product.find_product_by_id(new_id);
                            }
                            while(h == null){
                                System.out.println("pick a valid id");
                                new_id =scanner.nextInt();
                                h = Home_electronic_product.find_product_by_id(new_id);
                            }
                            System.out.println("what do you want to update");
                            System.out.println("if you want to update the name write y else write n");
                            String answer = scanner.nextLine();
                            Home_electronic_product updated_one = h;

                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_name = scanner.nextLine();
                                updated_one.setName(new_name);
                            }
                            System.out.println("if you want to update the price write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                int new_price = scanner.nextInt();
                                scanner.nextLine();
                                updated_one.setPrice(new_price);
                            }
                            System.out.println("if you want to update the stock write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                int new_stock = scanner.nextInt();
                                scanner.nextLine();
                                updated_one.setStock_availibility(new_stock);
                            }
                            System.out.println("if you want to update the color write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_color = scanner.nextLine();
                                updated_one.setColor(new_color);
                            }
                            System.out.println("if you want to update the brand write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_brand = scanner.nextLine();
                                updated_one.setBrand_name(new_brand);
                            }
                            System.out.println("if you want to update the weight write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                int new_weight = scanner.nextInt();
                                scanner.nextLine();
                                updated_one.setWeight(new_weight);
                            }
                            System.out.println("if you want to update the voltage write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                int new_voltage = scanner.nextInt();
                                scanner.nextLine();
                                updated_one.setVoltage(new_voltage);
                            }
                            System.out.println("if you want to update the power write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                int new_power = scanner.nextInt();
                                scanner.nextLine();
                                updated_one.setPower(new_power);
                            }
                            updated_one.update_product();
                        }
                        if(t == 2){
                            Clothes.afficher();
                            System.out.println("pick the id of the product you want to update");
                            int new_id =scanner.nextInt();
                            Clothes h = Clothes.find_product_by_id(new_id);
                            while(!Objects.equals(h.getOwner_id(), u.getId())){
                                System.out.println("you can't update a product that it is not yours");
                                System.out.println("pick a new id of the product you want to update");
                                new_id =scanner.nextInt();
                                h = Clothes.find_product_by_id(new_id);
                            }
                            while(h == null){
                                System.out.println("pick a valid id");
                                new_id =scanner.nextInt();
                                h = Clothes.find_product_by_id(new_id);
                            }
                            System.out.println("what do you want to update");
                            System.out.println("if you want to update the name write y else write n");
                            String answer = scanner.nextLine();
                            Clothes updated_one = h;

                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_name = scanner.nextLine();
                                updated_one.setName(new_name);
                            }
                            System.out.println("if you want to update the price write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                int new_price = scanner.nextInt();
                                scanner.nextLine();
                                updated_one.setPrice(new_price);
                            }
                            System.out.println("if you want to update the stock write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && !Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                int new_stock = scanner.nextInt();
                                scanner.nextLine();
                                updated_one.setStock_availibility(new_stock);
                            }
                            System.out.println("if you want to update the color write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && ! Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_color = scanner.nextLine();
                                updated_one.setColor(new_color);
                            }
                            System.out.println("if you want to update the brand write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && ! Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_brand = scanner.nextLine();
                                updated_one.setBrand_name(new_brand);
                            }
                            System.out.println("if you want to update the size write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && ! Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_size = scanner.nextLine();
                                updated_one.setSize(new_size);
                            }
                            System.out.println("if you want to update the gender write y else write n");
                            answer = scanner.nextLine();
                            while(!Objects.equals(answer, "y") && ! Objects.equals(answer, "n")){
                                System.out.println("please write y or n");
                                answer = scanner.nextLine();
                            }
                            if(answer.equals("y")){
                                System.out.println("write the new value");
                                String new_gender = scanner.nextLine();
                                updated_one.setGender(new_gender);
                            }
                            updated_one.update_product();
                        }
                    case 3:
                        System.out.println("what is the product category");
                        System.out.println("1 - house electronics");
                        System.out.println("2 - clothes");
                        System.out.println("3 - pcs and smartphones");
                        t = scanner.nextInt();
                        scanner.nextLine();
                        while(n != 1 && n != 2 && n != 3){
                            t = scanner.nextInt();
                            scanner.nextLine();
                        }
                        if(t == 1){
                            Home_electronic_product.afficher();
                            System.out.println("pick the id of the product you want to delete");
                            int new_id =scanner.nextInt();
                            Home_electronic_product h = Home_electronic_product.find_product_by_id(new_id);
                            while(!Objects.equals(h.getOwner_id(), u.getId())){
                                System.out.println("you can't update a product that it is not yours");
                                System.out.println("pick a new id of the product you want to update");
                                new_id =scanner.nextInt();
                                h = Home_electronic_product.find_product_by_id(new_id);
                            }
                            while(h == null){
                                System.out.println("pick a valid id");
                                new_id =scanner.nextInt();
                                h = Home_electronic_product.find_product_by_id(new_id);
                            }
                            Home_electronic_product.delete_product(new_id);
                        }
                        if(t == 2){
                            Clothes.afficher();
                            System.out.println("pick the id of the product you want to delete");
                            int new_id =scanner.nextInt();
                            scanner.nextLine();
                            Clothes h = Clothes.find_product_by_id(new_id);
                            while(!Objects.equals(h.getOwner_id(), u.getId())){
                                System.out.println("you can't update a product that it is not yours");
                                System.out.println("pick a new id of the product you want to update");
                                new_id =scanner.nextInt();
                                scanner.nextLine();
                                h = Clothes.find_product_by_id(new_id);
                            }
                            while(h == null){
                                System.out.println("pick a valid id");
                                new_id =scanner.nextInt();
                                h = Clothes.find_product_by_id(new_id);
                            }
                            System.out.println(new_id);
                            Clothes.delete_product(new_id);
                        }
                }
            }
        }
        if(Objects.equals(u.getAccount_type(), "costumer")) {
            do{
            System.out.println("what do you want to do next");
            System.out.println("1 - create a new shopping card");
            System.out.println("2- search for a product");
            System.out.println("3- view recommendations ");
            System.out.println("4- view your shopping cards");
            System.out.println("5- add a new order");
            System.out.println("6- view your orders");
            System.out.println("7- confirm an order");
            System.out.println("8- create an order");
            System.out.println("9 add a product rating");
            System.out.println("10- log out");
            l = scanner.nextInt();
            scanner.nextLine();
            switch (l) {
                case 1:
                    int shopping_cart_id = Shopping_cart.create_shopping_cart(u.getId());
                    System.out.println("1 - add a product to the cart");
                    System.out.println("2 - delete a product from the cart");
                    System.out.println("3 - back");
                    int y = scanner.nextInt();
                    scanner.nextLine();
                    while (y != 3) {
                        switch (y) {
                            case 1:
                                Shopping_cart.add_product(shopping_cart_id);
                                break;
                            case 2:
                                Shopping_cart.delete_product(shopping_cart_id);
                                break;
                        }
                        System.out.println("what do you want to do next");
                        System.out.println("1 - add a product to the cart");
                        System.out.println("2 - delete a product from the cart");
                        System.out.println("3 - back");
                        y = scanner.nextInt();
                        scanner.nextLine();
                        while (y != 1 && y != 2 && y != 3) {
                            System.out.println("please write 1, 2 or 3");
                            y = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
                    break;
                case 2:
                    System.out.println("write what you want to search for");
                    String search = scanner.nextLine();
                    Home_electronic_product.search(search);
                    Clothes.search(search);
                    break;
                case 3:
                    int result = Shopping_cart.getRecommendations(u.getId());
                    if (result == 1) {
                        Home_electronic_product.afficher();
                    } else {
                        Clothes.afficher();
                    }
                    break;
                case 4:
                    Shopping_cart.afficher(u.getId());
                    break;
                case 5:
                    Order.add_order(u.getId());
                    break;
                case 6:
                    Order.afficher(u.getId());
                    break;
                case 7:
                    Order.afficher(u.getId());
                    System.out.println("pick the id of the order you want to confirm");
                    int new_id = scanner.nextInt();
                    scanner.nextLine();
                    while (Order.find_order_by_id(new_id) == null) {
                        System.out.println("pick a valid id");
                        new_id = scanner.nextInt();
                        scanner.nextLine();
                    }
                    Order.confirm_order(new_id);
                    break;
                case 8:
                    Order.add_order(u.getId());
                case 9:
                    System.out.println("what is the product category");
                    System.out.println("1 - house electronics");
                    System.out.println("2 - clothes");
                    int t = scanner.nextInt();
                    scanner.nextLine();
                    while(n != 1 && n != 2 && n != 3){
                        t = scanner.nextInt();
                        scanner.nextLine();
                    }
                    if(t == 1){
                        Home_electronic_product.afficher();
                        System.out.println("pick the id of the product you want to rate");
                        new_id =scanner.nextInt();
                        Home_electronic_product h = Home_electronic_product.find_product_by_id(new_id);
                        while(h == null){
                            System.out.println("pick a valid id");
                            new_id =scanner.nextInt();
                            h = Home_electronic_product.find_product_by_id(new_id);
                        }
                        System.out.println("write your rating");
                        int rating = scanner.nextInt();
                        scanner.nextLine();
                        if(h.getRating() == 0){
                            h.setRating(rating);
                        }
                        else{
                            h.setRating((h.getRating()+rating) / 2);

                        }
                        h.update_product();
                    }
                    if(t == 2){
                        Clothes.afficher();
                        System.out.println("pick the id of the product you want to rate");
                        new_id =scanner.nextInt();
                        Clothes h = Clothes.find_product_by_id(new_id);
                        while(h == null){
                            System.out.println("pick a valid id");
                            new_id =scanner.nextInt();
                            h = Clothes.find_product_by_id(new_id);
                        }
                        System.out.println("write your rating");
                        int rating = scanner.nextInt();
                        scanner.nextLine();
                        if(h.getRating() == 0){
                            h.setRating(rating);
                        }
                        else{
                            h.setRating((h.getRating()+rating) / 2);

                        }
                        h.update_product();
                    }
            }
        }while(l != 10);
}}}

