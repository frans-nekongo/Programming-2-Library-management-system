import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book {
    private String bookName, bookType;
    private int idBook,countID, countOfBooks;
//objects
    Scanner keyboard= new Scanner(System.in);
    Library_System lib = new Library_System();
    label lab;
    label listLabel;
    borrowedBook borrow;
    String booklist[] = new String[49];

    private CallableStatement callS;
    Connection con =setCon(lib.getConnect());
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

    public Connection getCon() {
        return con;
    }

    public Connection setCon(Connection con) {
        this.con = con;
        return con;
    }

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
    public label getLab() {
        return lab;
    }
    public label getListLabel() {
        return listLabel;
    }
    public String[] getBooklist() {
        return booklist;
    }
    public borrowedBook getBorrow() {
        return borrow;
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
    public void setLab(label lab) {
        this.lab = lab;
    }
    public void setListLabel(label listLabel) {
        this.listLabel = listLabel;
    }
    public void setBooklist(String[] booklist) {
        this.booklist = booklist;
    }
    public void setBorrow(borrowedBook borrow) {
        this.borrow = borrow;
    }

    // methods
    public void bookCount(){}
    public void getAllBooks() throws SQLException {
        callS = this.con.prepareCall("Call selectB()");
        ResultSet rS = callS.executeQuery();
        int count = 0;
        while (rS.next()) {
            idBook = rS.getInt("idBook");
            bookName=rS.getString("BookName");
            bookType=rS.getString("BookType");
            countID=rS.getInt("countID");
            countOfBooks=rS.getInt("CountOfBooks");
            String bookL=  " "+idBook+"          |"+bookName+"                                                |"+bookType+"                                                                    |"+countID+"                                              |"+countOfBooks+" ";
            this.booklist[count] = bookL;
            count += 1;
        }
    }
    public void getSpecificBook(String name)throws SQLException{
        bookName=name;
        callS = this.con.prepareCall("Call selectB_name(?)");
        callS.setString(1,bookName);
        ResultSet rS = callS.executeQuery();
        while (rS.next()) {
            idBook = rS.getInt("idBook");
            bookName=rS.getString("BookName");
            bookType=rS.getString("BookType");
            countID=rS.getInt("countID");
            countOfBooks=rS.getInt("CountOfBooks");
            String book = Integer.toString(idBook)+"           |"+bookName+"                                     |"+bookType+"                                              |"+countOfBooks;
            lab = new label(book);
            lab.setVisible(true);
            
        }
    }
    public void toCustomerBorrowingBook(String name,String user)throws SQLException{
        bookName=name;
        callS = this.con.prepareCall("Call selectB_name(?)");
        callS.setString(1,bookName);
        ResultSet rS = callS.executeQuery();
        while (rS.next()) {
            idBook = rS.getInt("idBook");
            bookName=rS.getString("BookName");
            bookType=rS.getString("BookType");
            countID=rS.getInt("countID");
            countOfBooks=rS.getInt("CountOfBooks");
            borrow = new borrowedBook(user,bookName, idBook, bookType);
        }
        callS = this.con.prepareCall("Call updateB_borw(?)");
        callS.setInt(1,idBook);
        rS = callS.executeQuery();

        if (countOfBooks==0){
            message mes =new message("this book is out of stock ..come back later");
        }else if (countOfBooks>0){
            message mess =new message("book has been borrowed please pick up at counter");
        }
    }

    public void deleteBook(int id) throws SQLException {
        int answer = id;
        callS = this.con.prepareCall("call deleteB(?)");
        callS.setInt(1, answer);
        callS.execute();
        message mes = new message("Book "+id+" has been deleted");
    }
    public void insertBook_bookCount() throws SQLException {
        getAllBooks();
        System.out.println("""
                enter data in the following format
                book id
                book name
                book type
                count id
                count of books""");
        idBook = keyboard.nextInt();
        bookName =keyboard.next();
        bookType = keyboard.next();
        countID = keyboard.nextInt();
        countOfBooks = keyboard.nextInt();
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
    public void updateBook() throws SQLException {
        System.out.println("""
                enter data in the folowing format
                book id
                count of books""");
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
    public void order_newBook(int id,String name,String type,int coID,int count) throws SQLException {
         idBook = id;
         bookName =name;
         bookType = type;
         countID = coID;
         countOfBooks = count;
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
    }
}
