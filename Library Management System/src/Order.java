import java.util.Scanner;

public class Order{
    Scanner keyboard=new Scanner(System.in);
    Book b8k = new Book();
    Employee emP=new Employee();
    Newspaper nP = new Newspaper();

    String npName,bName,bType,npPublisher;
    int npCount,bCountiD,countOfBooks,numBooksToBeOrderred;

    //constructors
    Order(){
        //from book//
        b8k.setName(bName);
        b8k.setType(bType);
        b8k.setCountID(bCountiD);
        b8k.setCountOfBooks(countOfBooks);
        //from newspaper//
        nP.setNpName(npName);
        nP.setNpPublisher(npPublisher);
        nP.setNpCount(npCount);
    };
    //methods
    public void orderingBook(){
        System.out.println("how many books do you want to enter");
        numBooksToBeOrderred=keyboard.nextInt();


    };
    public void orderingNewspaper(){};

}
