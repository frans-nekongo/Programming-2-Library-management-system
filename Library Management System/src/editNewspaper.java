// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JTextField;
// import java.awt.Color;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class editNewspaper extends JFrame implements ActionListener{
//     JTextField date = new JTextField();
//     JTextField pub = new JTextField();
//     JButton done = new JButton("Done");

//     public editNewspaper(){
//         ImageIcon image = new ImageIcon("image.jpg"); 
        
//         date.setBounds(70, 100,200, 25);
//         date.setText("date");

//         pub.setBounds(70, 130,200, 25);
//         pub.setText("publisher");
        
//         done.setBounds(120, 160, 65, 20);
//         done.addActionListener(this);
//         done.setBackground(Color.CYAN);

//         JLabel ldate = new JLabel();
//         ldate.setText("Date:");
//         ldate.setBounds(20, 100, 50, 20);
//         ldate.setForeground(Color.LIGHT_GRAY);

//         JLabel lpub = new JLabel();
//         lpub.setText("publisher:");
//         lpub.setBounds(10, 130, 70, 20);
//         lpub.setForeground(Color.LIGHT_GRAY);


//         this.setVisible(true);
//         this.setTitle("Book");
//         this.add(date);
//         this.add(pub);
//         this.add(done);
//         this.add(ldate);
//         this.add(lpub);
//         this.setBounds(800, 200, 300, 250);
//         this.setLayout(null);
//         this.setResizable(false);
//         this.getContentPane().setBackground(new Color(0,0,20));
//         this.setIconImage(image.getImage());
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource()==done) {
//             this.dispose();
//         }
//     }
// }
