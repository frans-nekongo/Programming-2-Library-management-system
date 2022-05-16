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

public class addNewspaper extends JFrame implements ActionListener{
    JTextField date = new JTextField();
    JTextField pub = new JTextField();
    JButton done = new JButton("Done");
    Newspaper news = new Newspaper();

    public addNewspaper(){
        ImageIcon image = new ImageIcon("image.jpg"); 

        Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);
        JLabel label = new JLabel();
        label.setText("enter data in the following format date {yyyy-mm-dd}");
        JLabel label1 = new JLabel();
        label1.setText("and publisher name(no spaces)");

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(5, 10, 370, 50);
        panel.setBorder(border);
        panel.add(label);
        panel.add(label1);

        
        date.setBounds(70, 70,200, 25);  

        pub.setBounds(70, 100,200, 25);
        
        done.setBounds(120, 140, 65, 20);
        done.addActionListener(this);
        done.setBackground(Color.CYAN);

        JLabel ldate = new JLabel();
        ldate.setText("Date:");
        ldate.setBounds(20, 70, 50, 20);
        ldate.setForeground(Color.LIGHT_GRAY);

        JLabel lpub = new JLabel();
        lpub.setText("publisher:");
        lpub.setBounds(10, 100, 70, 20);
        lpub.setForeground(Color.LIGHT_GRAY);


        this.setVisible(true);
        this.setTitle("Newspaper");
        this.add(date);
        this.add(pub);
        this.add(done);
        this.add(ldate);
        this.add(lpub);
        this.add(panel);
        this.setBounds(800, 200, 400, 250);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0,0,20));
        this.setIconImage(image.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==done) {
            this.dispose();
            String Date = date.getText();
            String Pub = pub.getText();
            news.insertNewspaper(Date, Pub);
        }
    }
}
