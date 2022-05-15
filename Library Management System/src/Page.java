import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Page implements ActionListener,KeyListener{
    JFrame frame = new JFrame();
    String books[] = {"Name","Genre","Author","ID"};
    String newsP[] = {"Publisher","Date"};
    JComboBox b ;
    JComboBox n ;
    JButton search;
    Character name;
    JButton back = new JButton("back");
    JTextField bar = new JTextField();
    JRadioButton bookB = new JRadioButton("Book");
    JRadioButton newsPB = new JRadioButton("Newspaper");
    JPanel panel = new JPanel();
    JPanel itemP;
    JPanel item ;
    JPanel itemNP ;

public Page(){
       
       Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);

        JLabel label = new JLabel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        itemP = new JPanel();
        panel = new JPanel();

        ButtonGroup group = new ButtonGroup();
        group.add(bookB);
        group.add(newsPB);
        

        bookB.setBounds(83, 45, 55, 20);
        bookB.setBackground(Color.white);
        bookB.setFocusable(false);
        bookB.setOpaque(true);
        bookB.addActionListener(this);
        newsPB.setBounds(140, 45, 90, 20);
        newsPB.setBackground(Color.white);
        newsPB.setFocusable(false);
        newsPB.addActionListener(this);

        bar.setBounds(170,80,500,20 );
        bar.setFont(new Font("Consolas",Font.PLAIN,15));
        bar.setPreferredSize(new Dimension(50,50));

        label.setText("Welcome Username to Library System");
        label.setBounds(5, 10, 300, 20);
        label1.setText("You can search for a book or a newpaper to be able to interact with them");
        label1.setBounds(5, 23, 600, 20);
        label2.setText("Search for:");
        label2.setBounds(5, 45, 300, 20);
        label3.setText("Search bar:");
        label3.setBounds(5, 70, 100, 20);
        
        label.setFont(new Font("Consolas",Font.PLAIN,12));
        label1.setFont(new Font("Consolas",Font.PLAIN,12));
        label2.setFont(new Font("Consolas",Font.PLAIN,12));
        label3.setFont(new Font("Consolas",Font.PLAIN,12));

        //label.setBounds(200, 65, 300,50 ); 
        search = new JButton("Search");
        search.setBounds(585, 70, 78, 19);
        search.setFocusable(false);
        search.addActionListener(this);
        search.setBackground(Color.CYAN);
        

        
        
        panel.setBackground(Color.white);
        panel.setBounds(85, 10, 950, 100);
        panel.setBorder(border);
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(search);
        panel.setLayout(null);

        
        Border border1 = BorderFactory.createLineBorder(new Color(0,200,200),2);
        Border blackline = BorderFactory.createTitledBorder(border1, "ITEM SEARCHED",0, 0,null, new Color(0,200,200));
        

        ImageIcon image = new ImageIcon("image.jpg");

        itemP.setBounds(40, 150, 1100, 800);
        itemP.setBorder(blackline);
        itemP.setBackground(new Color(0,0,20));
        itemP.setLayout(null);
        

        back.setBounds(2, 1, 70, 30);
        back.setFocusable(false);
        back.addActionListener(this);

        b = new JComboBox(books);
        n = new JComboBox(newsP);
        b.setBorder(null);
        n.setBorder(null);
        b.setBackground(null);
        n.setBackground(null);
        b.setBounds(250, 45, 80, 20);
        n.setBounds(250, 45, 80, 20);

        item = new JPanel();
        itemNP = new JPanel();
        JLabel name = new JLabel();
        JLabel nameP = new JLabel();

        name.setText("| ID         | Name                                   | Type                                            | Number of Books");
        name.setForeground(Color.WHITE);

        nameP.setText("| Publisher                                           | Date                                             ");
        nameP.setForeground(Color.WHITE);
        

        Border borderI = BorderFactory.createLineBorder(new Color(200,200,200),2);
        Border wordline = BorderFactory.createTitledBorder(borderI, "BOOK",0, 0,null, new Color(200,200,200));
        Border wordlineP = BorderFactory.createTitledBorder(borderI, "NEWSPAPER",0, 0,null, new Color(200,200,200));

        item.setBackground(null);
        item.setBorder(wordline);
        item.add(name);
        item.setLayout(new GridLayout(50,1,4,4));
        item.setVisible(false);
        item.setBounds(10, 10, 1000, 1000);

        itemNP.setBackground(null);
        itemNP.setBorder(wordlineP);
        itemNP.add(nameP);
        itemNP.setLayout(new GridLayout(50,1,4,4));
        itemNP.setVisible(false);
        itemNP.setBounds(10, 10, 1000, 1000);
        

        panel.add(bookB);
        panel.add(newsPB);

        
        bar.addKeyListener(this);
        frame.setLocation(400, 100);
        frame.add(panel);
        frame.add(itemP);
        frame.getContentPane().setBackground(new Color(0,0,20));
        frame.add(back);
        frame.setIconImage(image.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(1070, 720);
        frame.setTitle("User page");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bar);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            frame.dispose();
            login lg = new login();
            
        }
        if(e.getSource()==search){
            itemP.add(item);
            item.setVisible(true);
        }
        if (e.getSource()==bookB) {
            n.setVisible(false);
            b.setVisible(true);
            itemNP.setVisible(false);
            panel.add(b);
            itemP.add(item);
            item.setVisible(true);
        } else if (e.getSource()==newsPB){
            b.setVisible(false);
            n.setVisible(true);
            panel.add(n);
            item.setVisible(false);
            itemP.add(itemNP);
            itemNP.setVisible(true);
        }
    }

    public void setName(Character name) {
        this.name = name;
    }
    public Character getName() {
        return name;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*if (e.getKeyChar()== 'j') {
            bookPanel bookp = new bookPanel();
            itemP.add(bookp);
        }*/
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ENTER) {
            itemP.add(item);
        }
    }
}
