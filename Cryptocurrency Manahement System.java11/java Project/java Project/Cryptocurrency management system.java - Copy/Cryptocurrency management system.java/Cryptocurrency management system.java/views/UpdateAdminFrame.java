package views;

import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;

public class UpdateAdminFrame extends JFrame implements ActionListener
 {
    private JLabel userIdLabel,titelLabel ,nameLabel, emailLabel, phoneNoLabel, genderLabel, adminTypeLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF,  adminTypeTF;
    private JButton updateBtn, backBtn;
    private ImageIcon backImg;
    private  JLabel imgLabel;
    private JPanel panel;
    private Font f1,f4;
    private User uer;
    private Admin admin;
    public UpdateAdminFrame(User uer)
     {
        super("Admin Update Profile Frame");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.f1=new Font("Arial Black",Font.PLAIN,17);
        this.panel = new JPanel();
       this. panel.setLayout(null);
       this.panel.setBackground(Color.WHITE);
        this.add(panel);
        this.titelLabel = new JLabel("Update Your Profile");
        this.titelLabel.setBounds(350, 10, 400, 40);
        this.titelLabel.setFont(new Font("Forte", Font.BOLD, 25));
        this.titelLabel.setForeground(Color.BLUE);
        this.panel.add(titelLabel);
         AdminController acd=new AdminController();
         this.admin=acd.searchAdmin(uer.getUserId());
         this.backImg=new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\up.png");
         this.imgLabel=new JLabel(backImg);
         this.imgLabel = new JLabel(backImg);
        this.imgLabel.setBounds(600, 80, 350, 400);
        this.panel.add(imgLabel);
        this.userIdLabel = new JLabel("User Id");
        this.userIdLabel.setBounds(50, 80, 150, 25);
        this.userIdLabel.setFont(f1);
        this.panel.add(userIdLabel);
        this.userTF = new JTextField();
        this.userTF.setBounds(200, 80, 300, 25);
        this.userTF.setFont(f1);
        this.panel.add(userTF);

        this.nameLabel = new JLabel("Name");
        this.nameLabel.setBounds(50, 120, 150, 25);
        this.nameLabel.setFont(f1);
        this.panel.add(nameLabel);
        this.nameTF = new JTextField();
        this.nameTF.setBounds(200, 120, 300, 25);
        this.nameTF.setFont(f1);
        this.panel.add(nameTF);

        this.emailLabel = new JLabel("Email");
        this.emailLabel.setBounds(50, 160, 150, 25);
        this.emailLabel.setFont(f1);
        this.panel.add(emailLabel);
        this.emailTF = new JTextField();
        this.emailTF.setBounds(200, 160, 300, 25);
        this.emailTF.setFont(f1);
        this.panel.add(emailTF);

        this.phoneNoLabel = new JLabel("Phone No:");
        this.phoneNoLabel.setBounds(50, 200, 150, 25);
        this.phoneNoLabel.setFont(f1);
        this.panel.add(phoneNoLabel);
        this.phoneNoTF = new JTextField();
        this.phoneNoTF.setBounds(200, 200, 300, 25);
        this.phoneNoTF.setFont(f1);
        this.panel.add(phoneNoTF);

        this.genderLabel = new JLabel("Gender:");
        this.genderLabel.setBounds(50, 240, 150, 25);
        this.genderLabel.setFont(f1);
        this.panel.add(genderLabel);
        this.genderTF = new JTextField();
        this.genderTF.setBounds(200, 240, 300, 25);
        this.genderTF.setFont(f1);
        this.panel.add(genderTF);

        this.adminTypeLabel = new JLabel("Admin Type:");
        this.adminTypeLabel.setBounds(50, 280, 150, 25);
        this.adminTypeLabel.setFont(f1);
        this.panel.add(adminTypeLabel);
        this.adminTypeTF = new JTextField();
        this.adminTypeTF.setBounds(200, 280, 300, 25);
        this.adminTypeTF.setFont(f1);
        this.panel.add(adminTypeTF);

        this.updateBtn = new JButton("Update");
        this.updateBtn.setBounds(200, 330, 150, 40);
        this.updateBtn.setFont(f1);
        this.updateBtn.setBackground(Color.LIGHT_GRAY);
        this.updateBtn.addActionListener(this);
        this.panel.add(updateBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(400, 330, 150, 40);
        this.backBtn.setBackground(Color.LIGHT_GRAY);
        this.backBtn.setFont(f1);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

       
        this.uer=uer;
    }

   public void actionPerformed (ActionEvent ae)  
   {

    String command=ae.getActionCommand();
    if(command.equals(updateBtn.getText()))
    {
         if((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&(!genderTF.getText().isEmpty()))
         {
            admin.setEmail(emailTF.getText());
            admin.setPhoneNo(phoneNoTF.getText());
            admin.setGender(genderTF.getText());
            AdminController acd=new AdminController();
            acd.updateAdmin(admin);
            JOptionPane.showMessageDialog(this,"Update Successfully");
         }
         else
         {
            JOptionPane.showMessageDialog(this,"please fill up all the field properly");

         }
    }
    if(command.equals(backBtn.getText()))
    {
        AdminHomeFrame adf=new AdminHomeFrame(uer);
        this.setVisible(false);
        adf.setVisible(true);
        
    }
   }

    
}


