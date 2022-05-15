import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class editItem extends JFrame implements ActionListener{
    JButton book = new JButton("edit Book");
    JButton newspaper = new JButton("edit Newspaper");
    JButton employee = new JButton("edit employee");

    public editItem (){
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
        label.setText("Choose what you want to edit in the system by clicking the button");

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
        if(e.getSource()==book){
            this.dispose();
            whatBook wBook= new whatBook();
        }
        if(e.getSource()==newspaper){
            this.dispose();
            whatNewspaper wBook= new whatNewspaper();
        }
        if(e.getSource()==employee){
            this.dispose();
            whatEmployee wBook= new whatEmployee();
        }
    }
}
