import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class whatBook extends JFrame implements ActionListener{
    JButton pro = new JButton("Proceed");
    public whatBook(){
        ImageIcon image = new ImageIcon("image.jpg");

        pro.setBounds(160, 27, 85, 25);
        pro.setFocusable(false);
        pro.addActionListener(this);
        pro.setBackground(Color.CYAN);

        JTextField id = new JTextField();
        id.setBounds(85, 30, 60, 20);

        JLabel eID = new JLabel();
        eID.setText("Enter book ID");
        eID.setBounds(5, 30,90, 20);
        eID.setForeground(Color.LIGHT_GRAY);

        this.setVisible(true);
        this.setBounds(600,200, 270, 100);
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
            editBook eBook = new editBook();
        }
    }
}
