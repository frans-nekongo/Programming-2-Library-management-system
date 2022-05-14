import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Newspaper {
    private String date,npPublisher;
    private int npCount;
    //objects
    Library_System lib=new Library_System();
    Scanner keyboard=new Scanner(System.in);
    //connection
    private CallableStatement callS;
    Connection con =setCon(lib.getConnect());
    //constructors
    Newspaper(){
        date ="";
        npPublisher="";
        npCount=0;
    }
    Newspaper(String Date, String npPublisher, int npCount){
        this.date = Date;
        this.npPublisher=npPublisher;
        this.npCount=npCount;
    }
    //getters

    public Connection getCon() {
        return con;
    }

    public Connection setCon(Connection con) {
        this.con = con;
        return con;
    }

    public String getDate() {
        return date;
    }

    public String getNpPublisher() {
        return npPublisher;
    }

    public int getNpCount() {
        return npCount;
    }
    //setters

    public void setDate(String date) {
        this.date = date;
    }

    public void setNpPublisher(String npPublisher) {
        this.npPublisher = npPublisher;
    }

    public void setNpCount(int npCount) {
        this.npCount = npCount;
    }

    //methods
    public void insertNewspaper(){
        System.out.println("""
                enter data in the following format
                date yyyy-mm-dd
                publisher publisher name(no spaces)
                """);
        date =keyboard.next();
        npPublisher = keyboard.next();
        try {
            CallableStatement statmnt = con.prepareCall("{call insertN(?,?)}");
            statmnt.setString(1,date);
            statmnt.setString(2, npPublisher);
            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void getNewspaper_date() throws SQLException {
        System.out.println("enter year...YYYY-MM-DD"+'\n'+"enter numerically e.g 2008-11-25");
        date= keyboard.next();

        callS = this.con.prepareCall("Call selectN_date(?)");
        callS.setString(1,date);
        ResultSet rS = callS.executeQuery();
        System.out.println("| Date |  publisher |");
            while (rS.next()) {
                date = rS.getString("Date");
                npPublisher=rS.getString("publisher");
                System.out.println("| "+date+" |     "+npPublisher+" | ");
        }
    }
    public void getNewspaper_publisher() throws SQLException {
        System.out.println("enter publisher name");
        npPublisher = keyboard.next();

        callS = this.con.prepareCall("Call selectN_publisher(?)");
        callS.setString(1, npPublisher);
        ResultSet rS = callS.executeQuery();
        System.out.println("| Date |  publisher |");
        while (rS.next()) {
            date = rS.getString("Date");
            npPublisher = rS.getString("publisher");
            System.out.println("| " + date + " |     " + npPublisher + " | ");
        }
    }
}

