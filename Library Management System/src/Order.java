import java.sql.SQLException;
import java.util.Scanner;

public class Order{
    Scanner keyboard=new Scanner(System.in);
    Library_System lib=new Library_System();
    Book b8k = new Book();
    Newspaper nP = new Newspaper();

    private String bookName,bookType;
    private int idBook,countID,countOfBooks;

    //getters and setters

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

    //methods
    public void orderingBook() throws SQLException {
        System.out.println("enter 1 if you ordering an already existing book"
                     +'\n'+"2.for a new entry");
        int sw1=keyboard.nextInt();
        switch (sw1){
            case 1://already existing
                break;
            case 2://new books
                //order_newBook();
                break;
            default:
                System.out.println("wrong entry");
        }
    };
    public void orderingNewspaper(){};

}
