import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener{
    JLabel label;
    JTextField textfield1;
    JButton button;
    JButton button2;
    JPasswordField textfield2;
    JLabel label2;
    JButton button3;
    String name = "";
    Customers cust = new Customers();
    

    public login(){
        label = new JLabel();
        label2 = new JLabel();
        textfield1= new JTextField();
        textfield2= new JPasswordField();

        button = new JButton("Login");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBounds(500,200 ,120 ,30 );
        
        button2 = new JButton("Register");
        button2.addActionListener(this);
        button2.setBounds(520, 10, 90, 35);
        button2.setForeground(Color.BLACK);
        button2.setFont(new Font("Consolas",Font.BOLD,13));
        button2.setFocusable(false);

        button3 = new JButton("Login as Guest");
        button3.setBounds(500, 240, 120,30);
        button3.setFocusable(false);
        button3.addActionListener(this);

        
        ImageIcon image = new ImageIcon("image.jpg");
        Border border = BorderFactory.createLineBorder(Color.black,6);
        
        label.setText("Enter username");
        label.setFont(new Font("Consolas",Font.PLAIN,13));
        label.setBounds(200, 65, 300,50 );
        label.setForeground(Color.LIGHT_GRAY);

        label2.setText("Enter password");
        label2.setFont(new Font("Consolas",Font.PLAIN,13));
        label2.setForeground(Color.LIGHT_GRAY);
        label2.setBounds(200, 125, 300, 50);

        textfield1.setPreferredSize(new Dimension(100,100));
        textfield1.setBounds(200,100,250,30 );
        textfield1.setFont(new Font("Consolas",Font.PLAIN,20));
        textfield2.setPreferredSize(new Dimension(100,100));
        textfield2.setBounds(200,160,250,30 );
        textfield2.setFont(new Font("Consolas",Font.PLAIN,20));

        this.add(button3);
        this.add(textfield1);
        this.add(button);
        this.add(button2);
        this.add(textfield2);
        this.add(label);
        this.add(label2);
        this.setLocation(600,300);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(680, 325);
        this.setTitle("System");
        this.setIconImage(image.getImage());
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0,0,20));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public String getName() {
        
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            
            try {
            
            this.name = textfield1.getText();
            String pass = "";
            char[] passC = textfield2.getPassword();
            for (int index = 0; index < passC.length; index++) {
                pass = pass + Character.toString(passC[index]);
            } 
            cust.Login(name, pass);
            if (cust.getAllow()) {
                this.dispose();
                Page cPage = new Page(this.name);
            }else if(pass.compareTo("p@$$w0rol")==0){
                whatEmployee wBook = new whatEmployee("enter");
            }else{
                message mess = new message("Entered incorrect information");
            }
            
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            
        }else if (e.getSource()==button2) {
            this.dispose();
            register reg = new register();
        }else if (e.getSource()==button3) {
            this.name = textfield1.getText();
            this.dispose();
            Page cPage = new Page(this.name);
        }
        
    }
}