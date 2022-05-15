import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editEmployee extends JFrame implements ActionListener{
    JTextField id = new JTextField();
    JTextField fname = new JTextField();
    JTextField sname = new JTextField();
    JTextField cellP = new JTextField();
    JTextField pos = new JTextField();
    JButton done = new JButton("Done");

    public editEmployee(){
        ImageIcon image = new ImageIcon("image.jpg"); 
        
        id.setBounds(90, 100,200, 25);
        id.setText("name");

        fname.setBounds(90, 130,200, 25);
        fname.setText("type");

        sname.setBounds(90, 160,200, 25);
        sname.setText("sname");

        cellP.setBounds(90, 190,200, 25);
        cellP.setText("cellP");

        pos.setBounds(90, 220,200, 25);
        pos.setText("pos");
        
        done.setBounds(130, 260, 65, 20);
        done.addActionListener(this);
        done.setBackground(Color.CYAN);

        JLabel lID = new JLabel();
        lID.setText("ID");
        lID.setBounds(10, 100, 70, 20);
        lID.setForeground(Color.LIGHT_GRAY);

        JLabel lfname = new JLabel();
        lfname.setText("First Name");
        lfname.setBounds(10, 130, 80, 20);
        lfname.setForeground(Color.LIGHT_GRAY);

        JLabel lsname = new JLabel();
        lsname.setText("Last Name");
        lsname.setBounds(10, 190, 80, 20);
        lsname.setForeground(Color.LIGHT_GRAY);

        JLabel lcell = new JLabel();
        lcell.setText("Cellphone no.");
        lcell.setBounds(10, 160, 80, 20);
        lcell.setForeground(Color.LIGHT_GRAY);

        JLabel lpos = new JLabel();
        lpos.setText("Position");
        lpos.setBounds(10, 220, 80, 20);
        lpos.setForeground(Color.LIGHT_GRAY);

        this.setVisible(true);
        this.setTitle("Employee");
        this.add(id);
        this.add(lsname);
        this.add(fname);
        this.add(lcell);
        this.add(sname);
        this.add(cellP);
        this.add(pos);
        this.add(lpos);
        this.add(done);
        this.add(lID);
        this.add(lfname);
        this.setBounds(800, 200, 350, 350);
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

