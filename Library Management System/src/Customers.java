
import com.mysql.cj.x.protobuf.MysqlxCursor;

import java.sql.*;
import java.util.Scanner;

public class Customers {

    private String firstName,lastName,username,password_C, cellphoneNumber;
    private int ID;
    private int rowsAffected;
    //objects
    Book b8k=new Book();
    Newspaper news=new Newspaper();
    Scanner keyboard = new Scanner(System.in);
    Library_System lib=new Library_System();
    //Customers cust=new Customers();

    //connectoin
    Connection con=setCon(lib.getConnect());
    CallableStatement callS;

    //constructors

    Customers(){

    }
    public Customers(int rowsAffected,String firstName, String lastName, String username, String password_C, String cellphoneNumber, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password_C = password_C;
        this.cellphoneNumber = cellphoneNumber;
        this.ID = ID;
        this.rowsAffected=rowsAffected;
    }

    public int getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(int rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword_C() {
        return password_C;
    }

    public void setPassword_C(String password_C) {
        this.password_C = password_C;
    }

    public Connection getCon() {
        return con;
    }

    public Connection setCon(Connection con) {
        this.con = con;
        return con;
    }

    int password = 2001;
    String UserName = "King";

    //Method for customer actions that can perform
    public void CustomerStart() throws SQLException {
        System.out.println("1.login"+'\n'+"2.register");
        int answer=keyboard.nextInt();
        switch (answer){
            case 1:Login();
                break;
            case 2:memberRegister();Login();
                break;

        }
    }
    public void memberRegister() throws SQLException {
        insertC();
        System.out.println(" account successfully created ");
    }
    public void Login() throws SQLException {
        System.out.println("Enter your login details"+'\n'+"username");
        username= keyboard.next();
        System.out.println("password");
        password_C= keyboard.next();

        int count = 0;

        try {
            callS = this.con.prepareCall("Call selectC_usrname_pass(?,?)");
            callS.setString(1,username);
            callS.setString(2,password_C);
            ResultSet rS = callS.executeQuery();

            while (rS.next()) {
                ++count;
                // Get data from the current row and use it
                }if (count > 0)
                {
                    System.out.println("user logged in"
                            +'\n'+"what would you like to do"
                            +'\n'+"1.search for a specific book"
                            +'\n'+"2.browse all available books"
                            +'\n'+"3.borrow a book"
                            +'\n'+"4.search for newspaper");
                    int answr4= keyboard.nextInt();
                    switch (answr4){
                        case 1:b8k.getSpecificBook();
                            break;
                        case 2:b8k.getAllBooks();
                            break;
                        case 3:borrowingBook();
                            break;
                        case 4:customerGettingNewspapers();
                            break;
                    }
                }
        }catch (Exception e){
            System.out.println(e.getMessage());}
    }
    public void customerGettingNewspapers() throws SQLException {
        System.out.println("""
                           looking for a newspaper by
                           1.date
                           2.publisher""");
        int answr5= keyboard.nextInt();
        switch (answr5) {
            case 1 -> news.getNewspaper_date();
            case 2 -> news.getNewspaper_publisher();
        }
    }
    public void borrowingBook() throws SQLException {
        //get from book
        System.out.println("Please choose the book to borrow");
        b8k.getAllBooks();
        b8k.toCustomerBorrowingBook();
            ///book count -- for the book just borrowed
        }
    public  void insertC()throws SQLException{
        System.out.println("enter data in the following way idCustomer,Fname,Lname,cllN,username,password ");
        ID = keyboard.nextInt();
        firstName = keyboard.next();
        lastName = keyboard.next();
        cellphoneNumber = keyboard.next();
        UserName =keyboard.next();
        password_C= keyboard.next();
        try {
            CallableStatement statmnt = con.prepareCall("{call insertC(?,?,?,?,?,?)}");
            statmnt.setInt(1, ID);
            statmnt.setString(2, firstName);
            statmnt.setString(3, lastName);
            statmnt.setString(4, cellphoneNumber);
            statmnt.setString(5, UserName);
            statmnt.setString(6,password_C);
            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into LBMS.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public  void getAllCustomer() throws SQLException {
        callS = this.con.prepareCall("Call selectC()");
        ResultSet rS = callS.executeQuery();
        System.out.println("| ID | Username |  full name  | cell | ");
        while (rS.next()) {
            firstName = rS.getString("firstName");
            ID = rS.getInt("idcustomer");
            lastName = rS.getString("lastName");
            cellphoneNumber = rS.getString("cellphoneNumber");
            username = rS.getString("username");
            System.out.println("  "+ID + "    " +username + "      " + firstName + " " + lastName + "   " + cellphoneNumber);
        }
    }
    public  void deleteC()throws SQLException{
        System.out.println("enter your user id");
        int answer = keyboard.nextInt();
        callS = this.con.prepareCall("call deleteC(?)");
        callS.setInt(1, answer);
        callS.execute();
        System.out.println("delete complete");}
    public  void updateC()throws SQLException{
        System.out.println("what do you want to update"
                +'\n'+"1.username"
                +'\n'+"2.cellphone number"
                +'\n'+"3.password");
        int answr2= keyboard.nextInt();
        switch (answr2){
            case 1: try {
                System.out.println("enter your id followed by your new username");
                ID= keyboard.nextInt();
                username= keyboard.next();
                CallableStatement statmnt = con.prepareCall("{call updateC_userN(?,?)}");
                statmnt.setInt(1, ID);
                statmnt.setString(2, username);

                ResultSet rs = statmnt.executeQuery();
                System.out.println("Your username has been changed.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case 2:try {
                System.out.println("enter your id followed by your new cellphone number");
                ID= keyboard.nextInt();
                cellphoneNumber= keyboard.next();
                CallableStatement statmnt = con.prepareCall("{call updateC_cellN(?,?)}");
                statmnt.setInt(1, ID);
                statmnt.setString(2, cellphoneNumber);

                ResultSet rs = statmnt.executeQuery();
                System.out.println("Your cellphone number has been changed.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case 3:try {
                System.out.println("enter your id followed by your new password");
                ID= keyboard.nextInt();
                password_C= keyboard.next();
                CallableStatement statmnt = con.prepareCall("{call updateC_pass(?,?)}");
                statmnt.setInt(1, ID);
                statmnt.setString(2, password_C);

                ResultSet rs = statmnt.executeQuery();
                System.out.println("Your password has been changed.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        }
    }


}













