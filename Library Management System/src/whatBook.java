import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class whatBook extends JFrame implements ActionListener{
    JButton pro = new JButton("Proceed");
    Book book = new Book();
    String task = "" ;
    JTextField id = new JTextField();
    String user = "";
    public whatBook(String task,String username){
        this.task = task;
        this.user = username;
        ImageIcon image = new ImageIcon("image.jpg");

        pro.setBounds(180, 27, 85, 25);
        pro.setFocusable(false);
        pro.addActionListener(this);
        pro.setBackground(Color.CYAN);

        id.setBounds(105, 30, 70, 20);

        JLabel eID = new JLabel();
        if (task.compareTo("borrow")==0){
            eID.setText("Enter book name");
        }else if (task.compareTo("delete")==0){
            eID.setText("Enter book ID");
        }
        eID.setBounds(5, 30,120, 20);
        eID.setForeground(Color.LIGHT_GRAY);

        this.setVisible(true);
        this.setBounds(600,200, 300, 100);
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
            
            if (task.compareTo("borrow")==0) {
                String name = id.getText();
                try {
                    book.toCustomerBorrowingBook(name,this.user);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }else if(task.compareTo("delete")==0){
                try {
                    int Bid = Integer.parseInt(id.getText());
                   book.deleteBook(Bid);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
        }
        }
    }
}
