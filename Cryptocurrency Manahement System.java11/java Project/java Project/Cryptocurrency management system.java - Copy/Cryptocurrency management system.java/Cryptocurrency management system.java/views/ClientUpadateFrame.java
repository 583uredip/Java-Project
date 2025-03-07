package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;

public class ClientUpadateFrame extends JFrame implements ActionListener
 {
    private JLabel userIdLabel, titelLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF;
    private JButton updateBtn, backBtn;
    private ImageIcon backImg;
    private  JLabel imgLabel;
    private Font f1;
    private JPanel panel;
    private User uer;
    private Client client;
    public ClientUpadateFrame(User uer)
     {
        super("Client Update Profile Frame");
        this.setSize(1000, 1000);
        this.f1=new Font("Arial Black",Font.PLAIN,17);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        this.titelLabel = new JLabel("Update Your Profile");
        this.titelLabel.setBounds(350, 10, 400, 40);
        this.titelLabel.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 30));
        this.titelLabel.setForeground(Color.BLACK);
        this.panel.add(titelLabel);
         
         ClientController cli=new ClientController();
         this.client=cli.searchClient(uer.getUserId());
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
        this.backImg=new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\pre.png");
         this.imgLabel=new JLabel(backImg);
         this.imgLabel = new JLabel(backImg);
        this.imgLabel.setBounds(600, 80, 350, 400);
        this.panel.add(imgLabel);

        this.uer = uer;
        
        
    }

   public void actionPerformed (ActionEvent ae)  
   {

    String command=ae.getActionCommand();
    if(command.equals(updateBtn.getText()))
    {
         if((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&(!genderTF.getText().isEmpty()))
         {
            client.setEmail(emailTF.getText());
            client.setPhoneNo(phoneNoTF.getText());
            client.setGender(genderTF.getText());
 
           
           ClientController co=new ClientController();
            co.updateClient(client);
            JOptionPane.showMessageDialog(this,"Update Successfully");
         }
         else
         {
            JOptionPane.showMessageDialog(this,"please fill up all the field properly");

         }
    }
    if(command.equals(backBtn.getText()))
    {
        
        ClientHomeFrame cli=new ClientHomeFrame(uer);
        
        this.setVisible(false);
        cli.setVisible(true);
        
    }
   }

    
}



























/*package views;

import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;


public class UpdateAdminFrame extends JFrame implements ActionListener {
    private JLabel userIdLabel, nameLabel, emailLabel, phoneNoLabel, genderLabel, adminTypeLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF, adminTypeTF;
    private JButton updateBtn, backBtn;
    private JPanel panel;
    private Admin admin;

    public UpdateAdminFrame(User uer) {
        super("Admin Update Profile Frame");
        this.admin = admin; // Admin অবজেক্ট ইনিশিয়ালাইজ
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(50, 30, 100, 30);
        panel.add(userIdLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 30);
        panel.add(nameLabel);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 110, 100, 30);
        panel.add(emailLabel);

        phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(50, 150, 100, 30);
        panel.add(phoneNoLabel);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 190, 100, 30);
        panel.add(genderLabel);

        adminTypeLabel = new JLabel("Admin Type:");
        adminTypeLabel.setBounds(50, 270, 100, 30);
        panel.add(adminTypeLabel);

        userTF = new JTextField();
        userTF.setBounds(160, 30, 200, 30);
        panel.add(userTF);

        nameTF = new JTextField();
        nameTF.setBounds(160, 70, 200, 30);
        panel.add(nameTF);

        emailTF = new JTextField();
        emailTF.setBounds(160, 110, 200, 30);
        panel.add(emailTF);

        phoneNoTF = new JTextField();
        phoneNoTF.setBounds(160, 150, 200, 30);
        panel.add(phoneNoTF);

        genderTF = new JTextField();
        genderTF.setBounds(160, 190, 200, 30);
        panel.add(genderTF);

        adminTypeTF = new JTextField();
        adminTypeTF.setBounds(160, 270, 200, 30);
        panel.add(adminTypeTF);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(50, 320, 150, 40);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(220, 320, 150, 40);
        backBtn.addActionListener(this);
        panel.add(backBtn);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals(updateBtn.getText())) {
            if ((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && (!genderTF.getText().isEmpty())) {
                admin.setEmail(emailTF.getText());
                admin.setPhoneNo(phoneNoTF.getText()); // getText() ব্যবহার করুন
                admin.setGender(genderTF.getText());
                AdminController acd = new AdminController();
                acd.updateAdmin(admin);
                JOptionPane.showMessageDialog(this, "Update Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill up all the field properly");
            }
        }
        if (command.equals(backBtn.getText())) {
            AdminHomeFrame adf = new AdminHomeFrame(admin);
            this.setVisible(false);
            adf.setVisible(true);
        }
    }
}*/

