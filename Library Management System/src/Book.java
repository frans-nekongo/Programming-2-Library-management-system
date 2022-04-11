import javax.naming.NamingEnumeration;

public class Book {
    private String name;
    private String type;
    private int countID = 0;
    private int countOfBooks = 0;
    private String names[] = new String[this.countOfBooks+1];
    private String types[] = new String[this.countOfBooks+1];

    public Book(String name,String type){
        this.name = name;
        this.type = type;
    }

    public Book() {
        
    }

    public String getType() {
        return type;
    }
    public int getCountID() {
        return countID;
    }
    public int getCountOfBooks() {
        return countOfBooks;
    }
    public String getName() {
        return name;
    }
    public String[] getNames() {
        return names;
    }
    public String[] getTypes() {
        return types;
    }
    
    public void setCountID(int countID) {
        this.countID = countID;
    }
    public void setCountOfBooks(int countOfBooks) {
        this.countOfBooks = countOfBooks;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNames(String[] names) {
        this.names = names;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setTypes(String[] types) {
        this.types = types;
    }
    
    public void givingBookID(Book book){
        book = new Book(this.name,this.type);
        for (int i = 0; i < this.names.length; i++) {
            if (names[i].compareTo("")== 0) {
                this.names[i] = this.name;
                this.types[i] = this.type;
                this.countID = i;
                break;
            }
        }
    }

    public int bookCount(){
        this.countOfBooks = this.countOfBooks++;
        return this.countOfBooks;
    }

    public void searchBook(String name,String type,int id){
        for (int i = 0; i < this.names.length; i++) {
            if (name.compareTo(this.names[i])==0) {
                System.out.println("You found "+this.names[i]+ "which is a "+this.types[i]+" with the identification number:"+i);
            }
        }
        //or
        System.out.println("Book ID looked for:"+this.countID+" ,the name of the book: "+this.names[this.countID]+" and it's type: "+this.types[this.countID]);
    }
}
