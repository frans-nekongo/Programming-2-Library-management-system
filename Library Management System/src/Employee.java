public class Employee {
    private String firstName,surname,position;
    private int iD,cellphoneN;

    //constructors
    Employee(){
        firstName="";
        surname="";
        position="";

        iD=0;
        cellphoneN=0;
    }
    Employee(String firstName,String surname,String position,int iD,int cellphoneN){
        this.firstName=firstName;
        this.surname=surname;
        this.position=position;
        this.iD=iD;
        this.cellphoneN=cellphoneN;
    }
    //methods
    public void ordering(){
        //name book/np
        //if book count(book) is zero ,then we need to order
        //
    }
    public void login(){
        //userName and password//
        //
    }
    public void borrowFinal(){}

    //getters

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public int getiD() {
        return iD;
    }

    public int getCellphoneN() {
        return cellphoneN;
    }

    //setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public void setCellphoneN(int cellphoneN) {
        this.cellphoneN = cellphoneN;
    }
}
