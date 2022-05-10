
import java.util.Scanner;

public class Customers {

    String FirstName;
    String username;
    String lastName;
    int ID;
    int CellphoneNumber;

    Customers(){

    }
    //objects
    Scanner keyboard = new Scanner(System.in);

    public Customers(String firstName, String username, String lastName, int ID, int cellphoneNumber, int password, String userName) {
        FirstName = firstName;
        this.username = username;
        this.lastName = lastName;
        this.ID = ID;
        CellphoneNumber = cellphoneNumber;
        this.password = password;
        UserName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCellphoneNumber() {
        return CellphoneNumber;
    }

    public void setCellphoneNumber(int cellphoneNumber) {
        CellphoneNumber = cellphoneNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    int password = 2001;
    String UserName = "King";

    //Method allows new customers to register

    public static void memberRegister() {
        System.out.println("Please Register");
        System.out.println("Please enter a Username");
        //String Username = .nextLine();
        System.out.println("Enter a password");
       // int password = scan.nextInt();


        System.out.println(" Welcome your are now a member ");
    }
    //Login method

    public static void Login() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your login details");
        String Username = scan.nextLine();
        int password = scan.nextInt();

        if (Username == "King" && password == 2001) {

            System.out.println("You are now a member");
        } else if (Username != "King" && password != 2001) {

            System.out.println("Enter a valid name");

        }
    }

    //Interface implements the borrow book function

    public static void borrowingBook() {

        System.out.println("Please choose the book to borrow");

        String[] x = new String[3];
        System.out.println(x);




    }


}













