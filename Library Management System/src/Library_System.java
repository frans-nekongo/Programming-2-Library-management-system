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

        lib.getConnect();


        //begin
        System.out.println("welcome ");
       // switch (lib.swi){
         //   case 1:

        try {
            //emp.getAllEmployee();
            //emp.deleteEmployee();
            //emp.insertEmployee();
            //lib.getAllBooks();
            //lib.deleteBook();
            //lib.insertBook();
            //lib.updateBook();
            //lib.updateEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    Library_System(String fname, String lname, int idEmployee, String bookName, String bookType,String posE,String cellN, int idBook, int countID, int countOfBooks) {
        this.fname = fname;
        this.lname = lname;
        this.idEmployee = idEmployee;
        this.bookName = bookName;
        this.bookType = bookType;
        this.idBook = idBook;
        this.countID = countID;
        this.countOfBooks = countOfBooks;
        this.cellN=cellN;
        this.posE=posE;
    }

    public Library_System() {

    }

    public String getfName() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPosE() {
        return posE;
    }

    public void setPosE(String posE) {
        this.posE = posE;
    }

    public String getCellN() {
        return cellN;
    }

    public void setCellN(String cellN) {
        this.cellN = cellN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getCountID() {
        return countID;
    }

    public void setCountID(int countID) {
        this.countID = countID;
    }

    public int getCountOfBooks() {
        return countOfBooks;
    }

    public void setCountOfBooks(int countOfBooks) {
        this.countOfBooks = countOfBooks;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int rollNo) {
        this.idEmployee = idEmployee;
    }

    @Override
    public Connection getConnect() {

        String url = "jdbc:mysql://localhost:3306/librarymdb";
        String user = "root";
        String password = "90952";

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connection achieved");
        } catch (Exception e) {
            System.out.println("connection not achieved");
        }
        return con;
    }
}
