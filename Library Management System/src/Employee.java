import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee implements Dao {
    private String fname, lname, posE, cellN;
    private int idEmployee;
    //objects
    Scanner keyboard = new Scanner(System.in);
    Library_System lib = new Library_System();
    Order ord = new Order();

    private CallableStatement callS;
    Connection con =setCon(lib.getConnect());

    //constructors
    Employee() {
        fname = "";
        lname = "";
        posE = "";

        idEmployee = 0;
        cellN = "";
    }

    Employee(String fname, String lname, String posE, int idEmployee, String cellN) {
        this.fname = fname;
        this.lname = lname;
        this.posE = posE;
        this.idEmployee = idEmployee;
        this.cellN = cellN;
    }
    //getters

    public Connection getCon() {
        return con;
    }

    public Connection setCon(Connection con) {
        this.con = con;
        return con;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPosE() {
        return posE;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getCellN() {
        return cellN;
    }

    //setters


    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPosE(String posE) {
        this.posE = posE;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setCellN(String cellN) {
        this.cellN = cellN;
    }

    //methods
    public Connection getConnect() {
        return null;
    }

    public void getAllEmployee() throws SQLException {
        callS = this.con.prepareCall("Call selectE()");
        ResultSet rS = callS.executeQuery();
        while (rS.next()) {
            fname = rS.getString("firstName");
            idEmployee = rS.getInt("idEmployee");
            lname = rS.getString("lastName");
            cellN = rS.getString("cellphoneN");
            posE = rS.getString("positionE");
            System.out.println(idEmployee + " " + fname + " " + lname + " " + cellN + " " + posE);
        }
    }


    public void deleteEmployee() throws SQLException {
        getAllEmployee();
        System.out.println("which name would you want to delete enter employee id");
        int answer = keyboard.nextInt();
        callS = this.con.prepareCall("call deleteE(?)");
        callS.setInt(1, answer);
        callS.execute();
        System.out.println("delete complete");
        getAllEmployee();
    }


    public void insertEmployee() throws SQLException {
        getAllEmployee();
        idEmployee = keyboard.nextInt();
         fname = keyboard.next();
         lname = keyboard.next();
         cellN = keyboard.next();
         posE = keyboard.next();
        System.out.println("enter data in the following way idEmployee,Fname,Lname,cllN,position ");
        try {
            CallableStatement statmnt = con.prepareCall("{call insertE(?,?,?,?,?)}");
            statmnt.setInt(1, idEmployee);
            statmnt.setString(2, fname);
            statmnt.setString(3, lname);
            statmnt.setString(4, cellN);
            statmnt.setString(5, posE);
            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        getAllEmployee();
    }


    public void updateEmployee() throws SQLException {
        getAllEmployee();
        System.out.println("enter data in the folowing format"
                + '\n' + "employee id"
                + '\n' + "cellphone#"
                + '\n' + "position");
        int idE = keyboard.nextInt();
        String cellN = keyboard.next();
        String posE = keyboard.next();

        try {
            CallableStatement statmnt = con.prepareCall("{call updateE_pos_cellN(?,?,?)}");
            statmnt.setInt(1, idE);
            statmnt.setString(2, posE);
            statmnt.setString(3, cellN);

            ResultSet rs = statmnt.executeQuery();
            System.out.println("Your data has been inserted into table.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        getAllEmployee();
    }

    public void ordering() {
        //name book/np
        //if book count(book) is zero ,then we need to order
        //
    }

    public void login()throws SQLException {
        System.out.println("insert username"
        +'\n'+"insert employee master code");
        int masterCode=1001,
        answr5= keyboard.nextInt();

        if (answr5==masterCode){
            System.out.println("welcome");
        }else {System.out.println("wrong code ACCESS DENIED");
        }

    }

    public void borrowFinal() {
    }
}
