import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class whatEmployee extends JFrame implements ActionListener{
//page for deleteing employee
    JButton pro = new JButton("Proceed");
    Employee emp = new Employee();
    JTextField id = new JTextField();
    String task = "";

    public whatEmployee(String task){
    ImageIcon image = new ImageIcon("image.jpg");
    this.task = task;

        pro.setBounds(220, 27, 85, 25);
        pro.setFocusable(false);
        pro.addActionListener(this);
        pro.setBackground(Color.CYAN);

        
        id.setBounds(150, 30, 60, 23);

        JLabel eID = new JLabel();
        if(this.task.compareTo("detele")==0){
            eID.setText("Enter employee ID");
        }else if(this.task.compareTo("enter")==0){
            eID.setText("Enter employee passcode");
        }
        
        eID.setBounds(2, 30,160, 20);
        eID.setForeground(Color.LIGHT_GRAY);

        this.setVisible(true);
        this.setBounds(600,200, 320, 100);
        this.getContentPane().setBackground(new Color(0,0,20));
        this.setLayout(null);
        this.setResizable(false);
        this.setIconImage(image.getImage());
        this.add(id);
        this.add(eID);
        this.add(pro);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==pro) {
            this.dispose();
            if(this.task.compareTo("detele")==0){
                int Eid = Integer.parseInt(id.getText());
                try {
                    emp.deleteEmployee(Eid);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }else if(this.task.compareTo("enter")==0){
                int Eid = Integer.parseInt(id.getText());
                try {
                    emp.login(Eid);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }}
            
    }

