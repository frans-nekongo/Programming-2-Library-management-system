
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customers {

    private String firstName,lastName,username,password_C, cellphoneNumber;
    private int ID;
    private int rowsAffected;
    private String userlist[] = new String[49];
    //objects
    Book b8k=new Book();
    Newspaper news=new Newspaper();
    Scanner keyboard = new Scanner(System.in);
    Library_System lib=new Library_System();
    Boolean allow = false;
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
    public String[] getUserlist() {
        return userlist;
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
    public Boolean getAllow() {
        return allow;
    }
    public void setAllow(Boolean allow) {
        this.allow = allow;
    }
    public void setUserlist(String[] userlist) {
        this.userlist = userlist;
    }

    int password = 2001;
    String UserName = "King";

    //Method for customer actions that can perform
    public void CustomerStart() throws SQLException {
        System.out.println("1.login"+'\n'+"2.register");
        int answer=keyboard.nextInt();
        switch (answer){
            case 1:Login("S","S");
                break;
            case 2:Login("S","S");
                break;

        }
    }
    public void Login(String name,String pass) throws SQLException {
        username= name;
        password_C= pass;

        int count = 0;

        try {
            callS = this.con.prepareCall("Call selectC_usrname_pass(?,?)");
            callS.setString(1,username);
            callS.setString(2,password_C);
            ResultSet rS = callS.executeQuery();

            while (rS.next()) {
                ++count;
                }if (count > 0)
                {
                    this.allow = true;
                }
        }catch (Exception e){
            message message = new message("You have entered non-matching information");
        }
    }
    public void customerGettingNewspapers() throws SQLException {
        System.out.println("""
                           looking for a newspaper by
                           1.date
                           2.publisher""");
        int answr5= keyboard.nextInt();
        switch (answr5) {
            case 1 -> news.getNewspaper_date();
            //case 2 -> news.getNewspaper_publisher();
        }
    }
    public  void insertC(int id,String fname,String lname,String cellP,String user,String pass)throws SQLException{
        ID = id;
        firstName = fname;
        lastName = lname;
        cellphoneNumber = cellP;
        UserName =user;
        password_C= pass;
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
        int count = 0;
        while (rS.next()) {
            firstName = rS.getString("firstName");
            ID = rS.getInt("idcustomer");
            lastName = rS.getString("lastName");
            cellphoneNumber = rS.getString("cellphoneNumber");
            username = rS.getString("username");
            String userL="  "+ID + "          " +username + "                             " + firstName + "                                         " + lastName + "                                           " + cellphoneNumber;
            this.userlist[count] = userL;
            count += 1;
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













