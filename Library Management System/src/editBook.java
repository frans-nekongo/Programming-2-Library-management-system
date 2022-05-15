import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editBook extends JFrame implements ActionListener{
    JTextField name = new JTextField();
    JTextField type = new JTextField();
    JTextField countID = new JTextField();
    JTextField count = new JTextField();
    JButton done = new JButton("Done");

    public editBook(){
        ImageIcon image = new ImageIcon("image.jpg"); 
        
        name.setBounds(70, 100,200, 25);
        name.setText("name");

        type.setBounds(70, 130,200, 25);
        type.setText("type");

        countID.setBounds(70, 160,200, 25);
        countID.setText("countID");

        count.setBounds(70, 190,200, 25);
        count.setText("count");
        
        done.setBounds(120, 230, 65, 20);
        done.addActionListener(this);
        done.setBackground(Color.CYAN);

        JLabel lname = new JLabel();
        lname.setText("Name");
        lname.setBounds(20, 100, 50, 20);
        lname.setForeground(Color.LIGHT_GRAY);

        JLabel ltype = new JLabel();
        ltype.setText("type");
        ltype.setBounds(20, 130, 50, 20);
        ltype.setForeground(Color.LIGHT_GRAY);

        JLabel lcount = new JLabel();
        lcount.setText("count");
        lcount.setBounds(20, 190, 50, 20);
        lcount.setForeground(Color.LIGHT_GRAY);

        JLabel lcountID = new JLabel();
        lcountID.setText("countID");
        lcountID.setBounds(20, 160, 50, 20);
        lcountID.setForeground(Color.LIGHT_GRAY);

        this.setVisible(true);
        this.setTitle("Book");
        this.add(name);
        this.add(lcount);
        this.add(type);
        this.add(lcountID);
        this.add(countID);
        this.add(count);
        this.add(done);
        this.add(lname);
        this.add(ltype);
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
        }
    }
}
