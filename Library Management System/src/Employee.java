import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee implements Dao {
    private String fname, lname, posE, cellN;
    private int idEmployee;
    private String emplist[] = new String[49];
    //objects
    Scanner keyboard = new Scanner(System.in);
    Library_System lib = new Library_System();
    Order ord = new Order();
    Book b8k=new Book();
    Newspaper news=new Newspaper();

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
    public String[] getEmplist() {
        return emplist;
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
    public void setEmplist(String[] emplist) {
        this.emplist = emplist;
    }

    //methods
    public Connection getConnect() {
        return null;
    }

    public void getAllEmployee() throws SQLException {
        callS = this.con.prepareCall("Call selectE()");
        ResultSet rS = callS.executeQuery();
        int count = 0;
        while (rS.next()) {
            fname = rS.getString("firstName");
            idEmployee = rS.getInt("idEmployee");
            lname = rS.getString("lastName");
            cellN = rS.getString("cellphoneN");
            posE = rS.getString("positionE");
            System.out.println();
            String empL= idEmployee + "       |" + fname + "                                                     |" + lname + "                                |" + cellN + "                                 |" + posE;
            this.emplist[count] = empL;
            count += 1;
        }
    }
    public void deleteEmployee(int id) throws SQLException {
        int answer = id;
        callS = this.con.prepareCall("call deleteE(?)");
        callS.setInt(1, answer);
        callS.execute();
        message mes = new message("Employee "+id+" has been removed");

    }
    public void insertEmployee(int id,String firstN,String sname,String cellP,String pos) throws SQLException {
        idEmployee = id;
         fname = firstN;
         lname = sname;
         cellN = cellP;
         posE = pos;
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
    public void ordering() throws SQLException {
        b8k.updateBook();
    }
    public void login(int num)throws SQLException {
    
        int masterCode = num;

        if (masterCode==1001){
            admin admin = new admin();
        }
        else {
            message message = new message("Entered incorrect code");
        }
    }
    public void borrowFinal() {
    }
}
