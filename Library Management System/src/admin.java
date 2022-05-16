import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
    Book Book = new Book();
    Customers cust = new Customers();
    Employee emp = new Employee();
    Newspaper news = new Newspaper();
    JFrame frame = new JFrame();
    JButton edit = new JButton("Delete");
    JButton add = new JButton("Add");
    JPanel itemB = new JPanel();
    JPanel itemN = new JPanel();
    JPanel itemE = new JPanel();
    JPanel itemU = new JPanel();
    JPanel itemBo = new JPanel();
    JPanel bar = new JPanel(); 
    Border border1 = BorderFactory.createLineBorder(new Color(0,200,200),2);
    Border wordlineB = BorderFactory.createTitledBorder(border1, "BOOK",0, 0,null, new Color(200,200,200));
    Border wordlineN = BorderFactory.createTitledBorder(border1, "NEWPAPER",0, 0,null, new Color(200,200,200));
    Border wordlineU = BorderFactory.createTitledBorder(border1, "USER",0, 0,null, new Color(200,200,200));
    Border wordlineE = BorderFactory.createTitledBorder(border1, "EMPLOYEE",0, 0,null, new Color(200,200,200));
    Border wordlineBo = BorderFactory.createTitledBorder(border1, "BORROWED",0, 0,null, new Color(200,200,200));
    JRadioButton bookB = new JRadioButton("Book");
    JRadioButton newsPB = new JRadioButton("Newspaper");
    JRadioButton userB = new JRadioButton("Users");
    JRadioButton empB = new JRadioButton("Employees");
    JRadioButton borB = new JRadioButton("Borrowed");
    borrowedBook borBook = new borrowedBook();
    public admin (){
        
        ImageIcon image = new ImageIcon("image.jpg");
        
        
        
        ButtonGroup group = new ButtonGroup();
        group.add(bookB);
        group.add(newsPB);
        group.add(userB);
        group.add(empB);
        group.add(borB);

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
        borB.setBounds(295, 75, 87, 20);
        borB.setBackground(null);
        borB.setFocusable(false);
        borB.setOpaque(true);
        borB.addActionListener(this);

        

        JLabel book = new JLabel();
        book.setText("| ID         | Name                                             | Type                                                              |Count ID                               |Number of Books");
        book.setForeground(Color.WHITE);
        JLabel user = new JLabel();
        user.setText("| ID      | Username                    | First Name                        | Surname                         | Cellphone number ");
        user.setForeground(Color.WHITE);
        JLabel employee = new JLabel();
        employee.setText("| ID      | First Name                            | Surname                                | Cellphone number                       | Position");
        employee.setForeground(Color.WHITE);
        JLabel newspaper = new JLabel();
        newspaper.setText("| Date                         | Publisher");
        newspaper.setForeground(Color.WHITE);
        JLabel borrow = new JLabel();
        borrow.setText("|User                         |ID of book                         |Book Name                         |Book Type");
        borrow.setForeground(Color.WHITE);

        JLabel line1 = new JLabel();
        line1.setText("Welcome to the admin page where you can see the details of the Book, Newspapers, User and Employees");
        line1.setBounds(3, 2, 700, 25);
        JLabel line2 = new JLabel();
        line2.setText("Click on the 'add' button to add an item of your choice or click on the delete button to delete an item of your choice when asked for it's ID");
        line2.setBounds(3, 16, 800, 25);


        edit.setBounds(878, 68, 70, 30);
        edit.setFocusable(false);
        edit.addActionListener(this);
        edit.setBackground(Color.CYAN);

        add.setBounds(878, 38, 70, 30);
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
        itemBo.setVisible(false);
        itemBo.setLayout(new GridLayout(50,1,4,4));
        itemBo.setBackground(null);
        itemBo.setBorder(wordlineBo);
        itemBo.setBounds(20, 15, 1000, 800);
        itemBo.add(borrow);
        //cause issues
        //item.setBounds(20, 30, 300, 150);
        // borrowedBook BoBook = Book.getBorrow();
        // String[] uName = BoBook.getUser();
        // int[] BooKid =  BoBook.getIds();
        // String[] Btypes = BoBook.getTypes();
        // String[] Bname = BoBook.getNames() ;
        // for (int i = 0; i < uName.length; i++) {
        //     String borDetails = uName[i]+BooKid[i]+Btypes[i]+Bname[i];
        //     label BoDetails = new label(borDetails);
        //     itemBo.add(BoDetails);
        // }
        //to display all the books in the database
        try {
            Book.getAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String listbook[] = Book.getBooklist();
        for (int i = 0; i < listbook.length; i++) {
            String text = listbook[i];
            label lab = new label(text);
            itemB.add(lab);
        }
        //display all the users in the database
        try {
            cust.getAllCustomer();;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String listuser[] = cust.getUserlist();
        for (int i = 0; i < listuser.length; i++) {
            String details = listuser[i];
            label label = new label(details);
            itemU.add(label);
        }
        //display all the employees in the system
        try {
            emp.getAllEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String listemp[] = emp.getEmplist();
        for (int i = 0; i < listemp.length; i++) {
            String list = listemp[i];
            label l = new label(list);
            itemE.add(l);
        }
        //displays details of all the newspapers
        try {
            news.getAllNewspapers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String listnews[] = news.getNewsList();
        for (int i = 0; i < listnews.length; i++) {
            String listN = listnews[i];
            label labelN = new label(listN);
            itemN.add(labelN);
        }
        // border colour and thickness for panels
        Border border = BorderFactory.createLineBorder(new Color(0,200,200),2);

       
        Border blackline = BorderFactory.createTitledBorder(border1, "BAR",0, 0,null, new Color(0,200,200));

        //the panel that displays the
        bar.add(itemB);
        bar.add(itemN);
        bar.add(itemU);
        bar.add(itemE);
        bar.add(itemBo);
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
        panel.add(line1);
        panel.add(line2);
        panel.add(edit);
        panel.add(add);
        panel.add(borB);
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
            itemBo.setVisible(false);
            itemB.setVisible(true);
        } else if (e.getSource()==newsPB){
            itemU.setVisible(false);
            itemB.setVisible(false);
            itemE.setVisible(false);
            itemBo.setVisible(false);
            itemN.setVisible(true);
        }else if (e.getSource()==userB) {
            itemN.setVisible(false);
            itemB.setVisible(false);
            itemBo.setVisible(false);
            itemN.setVisible(false);
            itemU.setVisible(true);
        } else if (e.getSource()==empB){
            itemU.setVisible(false);
            itemB.setVisible(false);
            itemBo.setVisible(false);
            itemN.setVisible(false);
            itemE.setVisible(true);
        } else if (e.getSource()==borB){
            itemU.setVisible(false);
            itemB.setVisible(false);
            itemN.setVisible(false);
            itemE.setVisible(false);
            itemBo.setVisible(true);
        }
    }
}
