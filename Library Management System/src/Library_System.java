import java.sql.*;
import java.util.Scanner;

public class Library_System implements EmployeeDao {
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

        lib.getConnect();


        //begin
        System.out.println("welcome ");
       // switch (lib.swi){
         //   case 1:

        try {
            //lib.getAllEmployee();
            //lib.deleteEmployee();
            //lib.insertEmployee();
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
    //employee
    @Override
    public void getAllEmployee() throws SQLException {
        callS = this.con.prepareCall("Call selectE()");
        ResultSet rS = callS.executeQuery();
        while (rS.next()) {
            fname = rS.getString("firstName");
            idEmployee = rS.getInt("idEmployee");
            lname = rS.getString("lastName");
            cellN=rS.getString("cellphoneN");
            posE=rS.getString("positionE");
            System.out.println(idEmployee + " " + fname + " " + lname+ " " + cellN + " " + posE);
        }
    }

    @Override
    public void deleteEmployee() throws SQLException {
        getAllEmployee();
        System.out.println("which name would you want to delete enter employee id");
        int answer = keyboard.nextInt();
        callS = this.con.prepareCall("call deleteE(?)");
        callS.setInt(1, answer);
        callS.execute();
        System.out.println("delete complete");
        getAllEmployee();
    }

    @Override
    public void insertEmployee() throws SQLException {
        getAllEmployee();
        String idEmployee = keyboard.next();
        String fname = keyboard.next();
        String lname = keyboard.next();
        String cellN=keyboard.next();
        String posE=keyboard.next();
        try {
            CallableStatement statmnt = con.prepareCall("{call insertE(?,?,?,?,?)}");
            statmnt.setString(1, idEmployee);
            statmnt.setString(2, fname);
            statmnt.setString(3, lname);
            statmnt.setString(4,cellN);
            statmnt.setString(5,posE);
            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        getAllEmployee();
    }

    @Override
    public void updateEmployee() throws SQLException {
        getAllEmployee();
        System.out.println("enter data in the folowing format"
                +'\n'+"employee id"
                +'\n'+"cellphone#"
                +'\n'+"position");
        int idE= keyboard.nextInt();
        String cellN = keyboard.next();
        String posE = keyboard.next();

        try {
            CallableStatement statmnt = con.prepareCall("{call updateE_pos_cellN(?,?,?)}");
            statmnt.setInt(1,idE);
            statmnt.setString(2,posE);
            statmnt.setString(3,cellN);

            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        getAllEmployee();
    }
    //book

    @Override
    public void getAllBooks() throws SQLException {
        callS = this.con.prepareCall("Call selectB()");
        ResultSet rS = callS.executeQuery();
        System.out.println("| Book ID | Book Name | BookType | countID | countOfBooks |");
        while (rS.next()) {
            idBook = rS.getInt("idBook");
            bookName=rS.getString("BookName");
            bookType=rS.getString("BookType");
            countID=rS.getInt("countID");
            countOfBooks=rS.getInt("CountOfBooks");
            System.out.println("| "+idBook+" | "+bookName+" | "+bookType+" | "+countID+" | "+countOfBooks+" |");
        }
    }

    @Override
    public void deleteBook() throws SQLException {
        getAllBooks();
        System.out.println("which book would you want to delete enter book id");
        int answer = keyboard.nextInt();
        callS = this.con.prepareCall("call deleteB(?)");
        callS.setInt(1, answer);
        callS.execute();
        System.out.println("delete complete");
        getAllBooks();
    }

    @Override
    public void insertBook_bookCount() throws SQLException {
        getAllBooks();
        System.out.println("enter data in the folowing format"
                        +'\n'+"book id"
                        +'\n'+"book name"+'\n'
                        +"book type"+'\n'
                        +"count id"+'\n'
                        +"count of books");
        int idBook = keyboard.nextInt();
        String bookName =keyboard.next();
        String bookType = keyboard.next();
        int countID = keyboard.nextInt();
        int countOfBooks = keyboard.nextInt();
        try {
            CallableStatement statmnt = con.prepareCall("{call insertB(?,?,?,?,?)}");
            statmnt.setInt(1,idBook);
            statmnt.setString(2, bookName);
            statmnt.setString(3, bookType);
            statmnt.setInt(4, countID);
            statmnt.setInt(5,countOfBooks);
            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        getAllBooks();
    }

    @Override
    public void updateBook() throws SQLException {
        getAllBooks();
        System.out.println("enter data in the folowing format"
                +'\n'+"book id"
                +'\n'+"count of books");
        int Bid= keyboard.nextInt();
        int Bcount= keyboard.nextInt();

        try {
            CallableStatement statmnt = con.prepareCall("{call updateB_bc(?,?)}");
            statmnt.setInt(1,Bid);
            statmnt.setInt(2,Bcount);

            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        getAllBooks();
    }

}
