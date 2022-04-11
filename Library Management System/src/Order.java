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
        System.out.println("enter 1 if you odering an already existing book"+'\n'+"2.for a new entry");
        int sw1=keyboard.nextInt();
        switch (sw1){
            case 1://already existing
                System.out.println("enter bookName");
                ///adding process here
                System.out.println("how many books");
                numBooksToBeOrderred=keyboard.nextInt();
                break;
            case 2://new books
                System.out.println();
                break;
            default:
                System.out.println("wrong entry");
        }
    };
    public void orderingNewspaper(){};

}
