
public class User {
    private String name;
    private int age;
    private String username;
    private String email;
    private String password;
    private String account_type;
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getPassword(){
        return password;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getAccount_type(){
        return account_type;
    }
    public void setName(String n){
        name = n;
    }
    public void setAge(int a){

        age = a;
    }
    public void setUsername(String u){
        username = u;
    }
    public void setEmail(String e){
        email = e;
    }
    public void setPassword(String p){
        password = p;
    }
    public void setAccount_type(String acc){
        account_type = acc;

    }
}
