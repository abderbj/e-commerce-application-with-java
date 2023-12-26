import java.util.*;
public class Login {
    public static boolean check_email(String x){
        for(User l : Users.getUsers()){
            if(Objects.equals(l.getEmail(), x)){
                return true;
            }
            if(Objects.equals(l.getUsername(), x)){
                return true;
            }
        }
        return false;
    }
    public static User check_password(String email, String password){
        for(User l : Users.getUsers()){
            if(Objects.equals(l.getEmail(), email) && Objects.equals(l.getPassword(), password)){
                return l;
            }
            if(Objects.equals(l.getUsername(), email) && Objects.equals(l.getPassword(), password)){
                return l;
            }
        }
        return null;
    }


    public static User sign_up(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name: ");
        String name = scanner.nextLine();
        System.out.println("enter your age: ");
        int age = scanner.nextInt();
        System.out.println("enter your email adress");
        scanner.nextLine();
        String e = scanner.nextLine();
        while(check_email(e)){
            System.out.println("this email has been used before please enter a new email adress: ");
            e = scanner.nextLine();
        }
        System.out.println("enter your username ");
        String user_name = scanner.nextLine();
        while(check_email(user_name)){
            System.out.println("this username has been used before please enter a new username: ");
            user_name = scanner.nextLine();
        }
        System.out.println("create a password");
        String pass_word = scanner.nextLine();
        while(pass_word.length() < 8){
            System.out.println("your password should consist of at least 8 characters");
            System.out.println("create a valid password");
            pass_word = scanner.nextLine();
        }
        System.out.println("confirm your password");
        String confirmed_password = scanner.nextLine();
        while(!Objects.equals(confirmed_password, pass_word)){
            System.out.println("your confirmed password is wrong");
            System.out.println("confirm your password");
            confirmed_password = scanner.nextLine();
        }
        System.out.println("what type you want your account to be admin(1) or costumer(2) write 1 if you want to be an admin ,2 if you want to be a costumer" );
        int n = scanner.nextInt();
        String type ;
        while(n != 1 && n != 2){
            System.out.println("please write 1 or 2");
            n = scanner.nextInt();
        }
        if(n == 1){
            type = "admin";
        }else{
            type = "costumer";
        }
        String i = UUID.randomUUID().toString();
        User new_user = new User();
        new_user.setName(name);
        new_user.setAge(age);
        new_user.setUsername(user_name);
        new_user.setEmail(e);
        new_user.setPassword(pass_word);
        new_user.setAccount_type(type);
        new_user.setId(i);
        Users.addUser(new_user);
        return new_user;
    }


    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter ur email adress or your username: ");
        String inputString = scanner.nextLine();
        while(!Login.check_email(inputString)){
            System.out.println("invalid email or username");
            System.out.println("enter your email adress or your username: ");
            inputString = scanner.nextLine();
        }
        System.out.println("enter your password: ");
        String password = scanner.nextLine();
        while(Login.check_password(inputString, password) == null){
            System.out.println("invalid email or password");
            System.out.println("do you want to change the email(1) or the password(2) write 1 for the email and 2 for the password ");
            int x = scanner.nextInt();
            scanner.nextLine();
            while(x != 1 && x != 2){
                System.out.println("please write 1 or 2");
                x = scanner.nextInt();
                scanner.nextLine();
            }
            if(x == 1){
                System.out.println("enter the new email adress or your username: ");
                inputString = scanner.nextLine();
            }
            if(x == 2){
                System.out.println("enter the correct password: ");
                password = scanner.nextLine();
            }
        }
        System.out.println("You are now connected successfully!");
        return (Login.check_password(inputString, password));
    }
    public static String get_account_type(){
        return Users.getUsers().get(Users.getUsers().size() - 1).getAccount_type();
    }
}
