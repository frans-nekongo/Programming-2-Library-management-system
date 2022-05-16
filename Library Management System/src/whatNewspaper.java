// import java.awt.Color;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.Date;

// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JTextField;

// public class whatNewspaper extends JFrame implements ActionListener{
//     JButton pro = new JButton("Proceed");
//     public whatNewspaper(){
//         ImageIcon image = new ImageIcon("image.jpg");

//         pro.setBounds(240, 27, 85, 25);
//         pro.setFocusable(false);
//         pro.addActionListener(this);
//         pro.setBackground(Color.CYAN);

//         JTextField date = new JTextField();
//         date.setBounds(135, 30, 100, 20);

//         JLabel eDate = new JLabel();
//         eDate.setText("Enter newspaper date:");
//         eDate.setBounds(5, 30,130, 20);
//         eDate.setForeground(Color.LIGHT_GRAY);

//         this.setVisible(true);
//         this.setBounds(600,200, 350, 100);
//         this.getContentPane().setBackground(new Color(0,0,20));
//         this.setLayout(null);
//         this.setResizable(false);
//         this.setIconImage(image.getImage());
//         this.add(date);
//         this.add(eDate);
//         this.add(pro);
//     }
//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource()==pro) {
//             this.dispose();
//             //editNewspaper eBook = new editNewspaper();
//         }
//     }
// }

