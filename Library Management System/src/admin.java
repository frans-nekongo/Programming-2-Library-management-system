import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import java.awt.GridLayout;

public class admin implements  ActionListener{
    JPanel panel = new JPanel();
    JButton back = new JButton("Back");
    
    JFrame frame = new JFrame();
    JButton edit = new JButton("Edit");
    JButton add = new JButton("Add");
    JPanel itemB = new JPanel();
    JPanel itemN = new JPanel();
    JPanel itemE = new JPanel();
    JPanel itemU = new JPanel();
    JPanel bar = new JPanel(); 
    Border border1 = BorderFactory.createLineBorder(new Color(0,200,200),2);
    Border wordlineB = BorderFactory.createTitledBorder(border1, "BOOK",0, 0,null, new Color(200,200,200));
    Border wordlineN = BorderFactory.createTitledBorder(border1, "NEWPAPER",0, 0,null, new Color(200,200,200));
    Border wordlineU = BorderFactory.createTitledBorder(border1, "USER",0, 0,null, new Color(200,200,200));
    Border wordlineE = BorderFactory.createTitledBorder(border1, "EMPLOYEE",0, 0,null, new Color(200,200,200));
    JRadioButton bookB = new JRadioButton("Book");
    JRadioButton newsPB = new JRadioButton("Newspaper");
    JRadioButton userB = new JRadioButton("Users");
    JRadioButton empB = new JRadioButton("Employees");

    public admin (){
        
        ImageIcon image = new ImageIcon("image.jpg");
        
        
        
        ButtonGroup group = new ButtonGroup();
        group.add(bookB);
        group.add(newsPB);
        group.add(userB);
        group.add(empB);

        newsPB.setBounds(196, 75, 90, 20);
        newsPB.setBackground(Color.white);
        newsPB.setFocusable(false);
        newsPB.addActionListener(this);
        bookB.setBounds(5, 75, 55, 20);
        bookB.setBackground(Color.white);
        bookB.setFocusable(false);
        bookB.setOpaque(true);
        bookB.addActionListener(this);
        userB.setBounds(57, 75, 60, 20);
        userB.setBackground(null);
        userB.setFocusable(false);
        userB.setOpaque(true);
        userB.addActionListener(this);
        empB.setBounds(113, 75, 87, 20);
        empB.setBackground(null);
        empB.setFocusable(false);
        empB.setOpaque(true);
        empB.addActionListener(this);


        JLabel book = new JLabel();
        book.setText("| ID         | Name                       | Type                    |Number of Books");
        book.setForeground(Color.WHITE);
        JLabel user = new JLabel();
        user.setText("| ID      | First Name                        | Surname                         | Cellphone number                    | Username");
        user.setForeground(Color.WHITE);
        JLabel employee = new JLabel();
        employee.setText("| ID      | First Name                            | Surname                                | Cellphone number                       | Position");
        employee.setForeground(Color.WHITE);
        JLabel newspaper = new JLabel();
        newspaper.setText("| Date                         | Publisher");
        newspaper.setForeground(Color.WHITE);


        edit.setBounds(888, 68, 60, 30);
        edit.setFocusable(false);
        edit.addActionListener(this);
        edit.setBackground(Color.CYAN);

        add.setBounds(888, 38, 60, 30);
        add.setFocusable(false);
        add.addActionListener(this);
        add.setBackground(Color.CYAN);

        itemU.setVisible(true);
        itemU.setLayout(new GridLayout(50,1,4,4));
        itemU.setBackground(null);
        itemU.setBorder(wordlineU);
        itemU.add(user);
        itemU.setBounds(20, 15, 1000, 800);
        itemB.setVisible(true);
        itemB.setLayout(new GridLayout(50,1,4,4));
        itemB.setBackground(null);
        itemB.setBorder(wordlineB);
        itemB.add(book);
        itemB.setBounds(20, 15, 1000, 800);
        itemN.setVisible(false);
        itemN.setLayout(new GridLayout(50,1,4,4));
        itemN.setBackground(null);
        itemN.setBorder(wordlineN);
        itemN.setBounds(20, 15, 1000, 800);
        itemN.add(newspaper);
        itemE.setVisible(false);
        itemE.setLayout(new GridLayout(50,1,4,4));
        itemE.setBackground(null);
        itemE.setBorder(wordlineE);
        itemE.setBounds(20, 15, 1000, 800);
        itemE.add(employee);
        
        //item.setBounds(20, 30, 300, 150);
        

        Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);

       
        Border blackline = BorderFactory.createTitledBorder(border1, "BAR",0, 0,null, new Color(0,200,200));

        
        bar.add(itemB);
        bar.add(itemN);
        bar.add(itemU);
        bar.add(itemE);
        bar.setBounds(40, 150, 1100, 800);
        bar.setBorder(blackline);
        bar.setBackground(new Color(0,0,20));
        bar.setLayout(null);
       

        

        back.setBounds(0, 10, 70, 30);
        back.setFocusable(false);
        back.addActionListener(this);


        panel.setBackground(Color.white);
        panel.setBounds(85, 10, 950, 100);
        panel.setBorder(border);
        // panel.add(label);
        // panel.add(label1);
        // panel.add(label2);
        // panel.add(label3);
        // panel.add(search);
        panel.setLayout(null);
        panel.add(edit);
        panel.add(add);
        panel.add(bookB);
        panel.add(newsPB);
        panel.add(userB);
        panel.add(empB);
        
        
        

        frame.add(panel);
        frame.add(back);
        frame.add(bar);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0,0,20));
        frame.setTitle("Administartion Page");
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
        frame.setBounds(450, 170, 1070, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==edit) {
            editItem eItem = new editItem();
        }
        if (e.getSource()==add) {
            addItem addI = new addItem();
        }
        if (e.getSource()==back) {
            frame.dispose();
            login l = new login();
        }
        if (e.getSource()==bookB) {
            itemU.setVisible(false);
            itemE.setVisible(false);
            itemN.setVisible(false);
            itemB.setVisible(true);
        } else if (e.getSource()==newsPB){
            itemU.setVisible(false);
            itemB.setVisible(false);
            itemE.setVisible(false);
            itemN.setVisible(true);
        }else if (e.getSource()==userB) {
            itemN.setVisible(false);
            itemB.setVisible(false);
            itemN.setVisible(false);
            itemU.setVisible(true);
        } else if (e.getSource()==empB){
            itemU.setVisible(false);
            itemB.setVisible(false);
            itemN.setVisible(false);
            itemE.setVisible(true);
        }
    }
}
