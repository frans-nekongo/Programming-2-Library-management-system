import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book {
    private String bookName, bookType;
    private int idBook,countID, countOfBooks;
//objects
    Scanner keyboard= new Scanner(System.in);
Library_System lib = new Library_System();
//constructors
    public Book(){
    }
    public Book(String bookName, String bookType, int idBook, int countID, int countOfBooks) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.idBook = idBook;
        this.countID = countID;
        this.countOfBooks = countOfBooks;
    }

//getters

    public String getBookName() {
        return bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getCountID() {
        return countID;
    }

    public int getCountOfBooks() {
        return countOfBooks;
    }

// setters

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setCountID(int countID) {
        this.countID = countID;
    }

    public void setCountOfBooks(int countOfBooks) {
        this.countOfBooks = countOfBooks;
    }
    // methods
    /*public void bookCount(){}
    public void getAllBooks() throws SQLException {
        lib.callS = this.lib.con.prepareCall("Call selectB()");
        ResultSet rS = lib.callS.executeQuery();
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
    public void deleteBook() throws SQLException {
        getAllBooks();
        System.out.println("which book would you want to delete enter book id");
        int answer = keyboard.nextInt();
        lib.callS = this.lib.con.prepareCall("call deleteB(?)");
        lib.callS.setInt(1, answer);
        lib.callS.execute();
        System.out.println("delete complete");
        getAllBooks();
    }
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
            CallableStatement statmnt = lib.con.prepareCall("{call insertB(?,?,?,?,?)}");
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
    public void updateBook() throws SQLException {
        getAllBooks();
        System.out.println("enter data in the folowing format"
                +'\n'+"book id"
                +'\n'+"count of books");
        int Bid= keyboard.nextInt();
        int Bcount= keyboard.nextInt();

        try {
            CallableStatement statmnt = lib.con.prepareCall("{call updateB_bc(?,?)}");
            statmnt.setInt(1,Bid);
            statmnt.setInt(2,Bcount);

            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        getAllBooks();
    }
    public void order_newBook() throws SQLException {
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
            CallableStatement statmnt = lib.con.prepareCall("{call insertB(?,?,?,?,?)}");
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
*/
}
