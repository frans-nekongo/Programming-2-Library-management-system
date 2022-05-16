import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class message extends JFrame implements ActionListener{
    JButton okay = new JButton("OKAY"); 
    public message(String message){
        JLabel label = new JLabel();
        label.setText(message);
        label.setBounds(100, 25, 300, 30);
        label.setForeground(Color.LIGHT_GRAY);

        okay.addActionListener(this);
        okay.setBounds(180, 50, 70, 30);
        okay.setFocusable(false);

        this.setVisible(true);
        this.setBounds(600,200, 475, 130);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0,0,20));
        this.setLayout(null);
        this.add(label);
        this.add(okay);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==okay) {
            this.dispose();
        }
        
    }
    
}
