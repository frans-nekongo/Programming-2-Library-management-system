import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/*important passwords
master-code 1001=normal employee,90952=admin

database
user = "root";
password = "90952";
*/
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
        login log = new login();
        Scanner keyboard = new Scanner(System.in);
        Library_System lib = new Library_System();
        Order ord = new Order();
        Employee emp=new Employee();
        Book b8k=new Book();
        Customers cust=new Customers();
        Newspaper news=new Newspaper();

        lib.getConnect();

    }
    @Override
    public Connection getConnect() {

        String url = "jdbc:mysql://localhost:3306/lib_new";
        String user = "root";
        String password = "90952";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("connection not achieved");
        }
        return con;
    }
}
