import java.sql.*;
import java.util.Scanner;

public class Library_System implements Dao {
    //employee v
    private String fname, lname,posE,cellN;
    private CallableStatement callS;
    private int idEmployee,swi;
    //book v
    private String bookName, bookType;
    private int idBook, countID, countOfBooks;

    Connection con;
    Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        Library_System lib = new Library_System();
        Order ord = new Order();
        Employee emp=new Employee();
        Book b8k=new Book();
        Customers cust=new Customers();

        lib.getConnect();


        //begin
        System.out.println("welcome customer/employee"
                            +'\n'+"1.customer"
                            +'\n'+"2.employee");
        int answr3=keyboard.nextInt();
        switch (answr3){
            case 1: cust.CustomerStart();
                break;
            case 2:emp.login();
                break;
        }
    }
    @Override
    public Connection getConnect() {

        String url = "jdbc:mysql://localhost:3306/librarymdb";
        String user = "root";
        String password = "90952";

        try {
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("connection achieved");
        } catch (Exception e) {
            System.out.println("connection not achieved");
        }
        return con;
    }
}
