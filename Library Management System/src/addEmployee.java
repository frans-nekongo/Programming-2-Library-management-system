import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class addEmployee extends JFrame implements ActionListener{
    JTextField id = new JTextField();
    JTextField fname = new JTextField();
    JTextField lname = new JTextField();
    JTextField cellp = new JTextField();
    JTextField pos = new JTextField();
    JButton done = new JButton("Done");
    Employee emp = new Employee();

    public addEmployee(){
        Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);
        JLabel label = new JLabel();
        label.setText("Enter details of Employee you are adding");

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(55, 10, 250, 30);
        panel.setBorder(border);
        panel.add(label);
        
        ImageIcon image = new ImageIcon("image.jpg"); 
        id.setBounds(84, 70,200, 25);    
        
        fname.setBounds(84, 100,200, 25);      

        lname.setBounds(84, 130,200, 25);       

        cellp.setBounds(84, 160,200, 25);

        pos.setBounds(84, 190,200, 25);
        
        done.setBounds(120, 230, 65, 20);
        done.addActionListener(this);
        done.setBackground(Color.CYAN);

        JLabel lid = new JLabel();
        lid.setText("ID");
        lid.setBounds(5, 70, 50, 20);
        lid.setForeground(Color.LIGHT_GRAY);

        JLabel lfname = new JLabel();
        lfname.setText("First Name");
        lfname.setBounds(5, 100, 150, 20);
        lfname.setForeground(Color.LIGHT_GRAY);

        JLabel lsname = new JLabel();
        lsname.setText("Last Name");
        lsname.setBounds(5, 130, 150, 20);
        lsname.setForeground(Color.LIGHT_GRAY);

        JLabel lcellp = new JLabel();
        lcellp.setText("Cellphone no.");
        lcellp.setBounds(5, 190, 150, 20);
        lcellp.setForeground(Color.LIGHT_GRAY);

        JLabel lpos = new JLabel();
        lpos.setText("position");
        lpos.setBounds(5, 160, 50, 20);
        lpos.setForeground(Color.LIGHT_GRAY);

        this.setVisible(true);
        this.setTitle("Employee");
        this.add(id);
        this.add(lid);
        this.add(fname);
        this.add(lcellp);
        this.add(lname);
        this.add(cellp);
        this.add(lpos);
        this.add(pos);
        this.add(done);
        this.add(lfname);
        this.add(lsname);
        this.add(panel);
        this.setBounds(800, 200, 350, 300);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0,0,20));
        this.setIconImage(image.getImage());
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==done) {
            this.dispose();
            String firstN = fname.getText();
            int eid = Integer.parseInt(id.getText());
            String sname = lname.getText();
            String cellP = cellp.getText();
            String posE = pos.getText();
            try {
                emp.insertEmployee(eid, firstN, sname, cellP, posE);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
