import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class addItem extends JFrame implements ActionListener{
    JButton book = new JButton("Order Book");
    JButton newspaper = new JButton("Add Newspaper");
    JButton employee = new JButton("Add employee");


    public addItem (){
        Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);

        book.setBounds(5,50 , 150, 40);
        book.setFocusable(false);
        book.setBackground(Color.CYAN);
        book.addActionListener(this);


        newspaper.setBounds(155,50 , 150, 40);
        newspaper.setFocusable(false);
        newspaper.setBackground(Color.CYAN);
        newspaper.addActionListener(this);

        employee.setBounds(305,50 , 150, 40);
        employee.setFocusable(false);
        employee.setBackground(Color.CYAN);
        employee.addActionListener(this);

        JLabel label = new JLabel();
        label.setText("Choose what you want to add to the system by clicking the button");

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 450, 40);
        panel.setBackground(Color.white);
        panel.setBorder(border);
        panel.add(label);

        
        
        this.setVisible(true);
        this.setBounds(600,200, 475, 130);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0,0,20));
        this.add(panel);
        this.add(book);
        this.add(employee);
        this.add(newspaper);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==book) {
            this.dispose();
            orderBook book = new orderBook();
        }
        if (e.getSource()==newspaper) {
            this.dispose();
            addNewspaper addN = new addNewspaper();
        }
        if (e.getSource()==employee) {
            this.dispose();
            addEmployee addE = new addEmployee();
        }
    }
}
