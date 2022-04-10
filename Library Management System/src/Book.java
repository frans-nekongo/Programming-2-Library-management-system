public class Book {
    private String name;
    private String type;
    private int countID = 0;
    private int countOfBooks = 0;
    private String names[];
    private String types[];

    public void givingBookID(String name,String type){
        this.name = name;
        this.type = type;
        String names[] = new String[this.countOfBooks+1];
        String types[] = new String[this.countOfBooks+1];
        for (int i = 0; i < names.length; i++) {
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
        System.out.println("Book ID looked for:"+this.countID+" ,the name of the book: "+this.names[this.countID]+" and it's type: "+this.types[this.countID]);
    }
}
