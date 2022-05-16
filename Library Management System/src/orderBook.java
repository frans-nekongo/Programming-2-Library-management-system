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

public class orderBook extends JFrame implements ActionListener{
    JTextField id = new JTextField();
    JTextField name = new JTextField();
    JTextField type = new JTextField();
    JTextField countID = new JTextField();
    JTextField count = new JTextField();
    JButton done = new JButton("Done");
    Book book = new Book();

    public orderBook(){
        Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);
        JLabel label = new JLabel();
        label.setText("Enter details of Book you are ordering");

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(65, 10, 220, 30);
        panel.setBorder(border);
        panel.add(label);
        
        ImageIcon image = new ImageIcon("image.jpg"); 
        id.setBounds(70, 70,200, 25);    
        
        name.setBounds(70, 100,200, 25);      

        type.setBounds(70, 130,200, 25);       

        countID.setBounds(70, 160,200, 25);

        count.setBounds(70, 190,200, 25);
        
        done.setBounds(120, 230, 65, 20);
        done.addActionListener(this);
        done.setBackground(Color.CYAN);

        JLabel lid = new JLabel();
        lid.setText("ID");
        lid.setBounds(20, 70, 50, 20);
        lid.setForeground(Color.LIGHT_GRAY);

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
        this.add(id);
        this.add(lid);
        this.add(name);
        this.add(lcount);
        this.add(type);
        this.add(lcountID);
        this.add(countID);
        this.add(count);
        this.add(done);
        this.add(lname);
        this.add(ltype);
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
            int bid = Integer.parseInt(id.getText());
            String bname = name.getText();
            String btype = type.getText();
            int coID = Integer.parseInt(countID.getText());
            int c = Integer.parseInt(count.getText());
            try {
                book.order_newBook(bid, bname, btype, coID, c);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}


