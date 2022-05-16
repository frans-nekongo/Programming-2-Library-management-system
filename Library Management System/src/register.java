import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class register implements ActionListener{
    JFrame frame;
    JPanel panel = new JPanel();
    JButton signup;
    JButton back;
    Customers cust = new Customers();
    JTextField tid = new JTextField();
    JTextField tcp = new JTextField();
    JTextField tsname = new JTextField();
    JTextField tname = new JTextField();
    JTextField uName = new JTextField();
    JTextField  tpass= new JTextField();
    public register(){
        frame = new JFrame();
        signup = new JButton("Finished");
        signup.setBounds(250, 320, 100, 30);
        signup.setFocusable(false);
        signup.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(0, 0, 70, 30);
        back.addActionListener(this);
        back.setFocusable(false);

        ImageIcon image = new ImageIcon("image.jpg"); 
        Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);

        
        tname.setBounds(100,80 , 200, 25);
        
        
        tsname.setBounds(100, 120, 200, 25);
        tid.setBounds(100,160 , 200, 25);
        
        tcp.setBounds(100,200 , 200, 25);
        
        uName.setBounds(100,240 , 200, 25);
       
        tpass.setBounds(100,280 , 200, 25);

        JLabel blank = new JLabel();
        blank.setText("First Name:");
        blank.setBounds(20, 45, 100, 100);
        blank.setForeground(Color.WHITE);
        blank.setFont(new Font("Consolas",Font.PLAIN,13));

        JLabel sname = new JLabel();
        sname.setText("Surname:");
        sname.setBounds(40, 85, 100, 100);
        sname.setForeground(Color.WHITE);
        sname.setFont(new Font("Consolas",Font.PLAIN,13));

        JLabel id = new JLabel();
        id.setText("ID number:");
        id.setBounds(25, 125, 100, 100);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Consolas",Font.PLAIN,13));

        JLabel cp = new JLabel();
        cp.setText("Cellphone no.:");
        cp.setBounds(5, 165, 100, 100);
        cp.setForeground(Color.WHITE);
        cp.setFont(new Font("Consolas",Font.PLAIN,13));

        JLabel userN = new JLabel();
        userN.setText("Username:");
        userN.setBounds(25, 205, 100, 100);
        userN.setForeground(Color.WHITE);
        userN.setFont(new Font("Consolas",Font.PLAIN,13));

        JLabel pass = new JLabel();
        pass.setText("Password:");
        pass.setBounds(25, 245, 100, 100);
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Consolas",Font.PLAIN,13));
        
        JLabel detail = new JLabel();
        detail.setText("stuff");

        JLabel fname = new JLabel();
        fname.setVisible(true);
        fname.setText("First Name:");
        fname.setBounds(100, 100, 50, 50);
        fname.setForeground(Color.WHITE);
        fname.setFont(new Font("Consolas",Font.PLAIN,13));
     
        panel.setBounds(80, 15, 250, 50);
        panel.setBorder(border);
        panel.setBackground(Color.white);
        panel.setVisible(true);
        panel.add(detail);

                
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setTitle("Member Registration");
        frame.setLocation(750, 300);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0,0,20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(signup);
        frame.add(userN);
        frame.add(pass);
        frame.add(back);
        frame.add(uName);
        frame.add(tpass);
        frame.add(panel);
        frame.add(tsname);frame.add(tid);
        frame.add(tname);
        frame.add(tcp);
        frame.add(id);
        frame.add(cp);
        frame.add(sname);frame.setIconImage(image.getImage());
        frame.add(blank);
        frame.add(fname);
           
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signup){
            frame.dispose();
            int id =  Integer.parseInt(tid.getText());
            String fname = tname.getText();
            String lname = tsname.getText();
            String cellP = tcp.getText();
            String user= uName.getText();
            String pass = tpass.getText();
            try {
                cust.insertC(id, fname, lname, cellP, user, pass);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            message mes = new message("You have successfully created an account");
        }
        if(e.getSource()==back){
            frame.dispose();
            login lPage = new login();
        }
    }
    
}
