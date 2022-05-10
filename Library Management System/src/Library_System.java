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

    public static void main(String[] args) {
        Library_System lib = new Library_System();
        Order ord = new Order();
        Employee emp=new Employee();
        Book b8k=new Book();
        Customers cust=new Customers();

        lib.getConnect();


        //begin
        System.out.println("welcome ");
       // switch (lib.swi){
         //   case 1:

        try {
            cust.CustomerStart();
            //cust.CustomerStart();
            //cust.insertC();
            //cust.getAllCustomer();
            //cust.deleteC();
            //cust.updateC();
            //emp.getAllEmployee();
            //emp.deleteEmployee();
            //emp.insertEmployee();
            //b8k.getAllBooks();
            //lib.deleteBook();
            //lib.insertBook();
            //lib.updateBook();
            //lib.updateEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
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
