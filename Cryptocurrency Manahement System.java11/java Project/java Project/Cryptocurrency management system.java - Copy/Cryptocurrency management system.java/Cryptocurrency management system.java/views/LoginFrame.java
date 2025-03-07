package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;

public class LoginFrame extends JFrame implements ActionListener
 {
    private JLabel usarIdLabel,passLabel,titelLabel,titel1Label1;
    private JLabel imgLabel,img1Label;
     JTextField userTf;
     JPasswordField passPf;
     JButton adButton,brButton,clButton,backButton,loginButton,forgetpassButton;
     private ImageIcon img,img1;
     private Color c1,c2;
     private Font f1,f2,f3,f4;
     private JPanel panel;

     public  LoginFrame()
     {
        super("Login Frame");
        this.c1=new Color(100, 255, 0);
        this.c2=new Color(0, 220, 255 );
        this.f1=new Font("Wide Latin",Font.ITALIC,19);
        this.f2=new Font("Arial Nova",Font.PLAIN,18);
        this.f3=new Font("Arial Black",Font.PLAIN,17);
        this.f4=new Font("Cooper Black", Font.BOLD, 14);

        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel=new JPanel();
        this.panel.setBackground(c1);
        this.panel.setLayout(null);

        this.titelLabel=new JLabel("Cryptocurrency Buy-Sell and Trading Shop");
        this.titelLabel.setBounds(100,10,700,40);
        this.titelLabel.setFont(f1);
        this.titelLabel.setForeground(Color.BLACK);
        this.panel.add(titelLabel);

        this.titel1Label1=new JLabel("Let's Try Your Luck By Trading");
        this.titel1Label1.setBounds(220,90,300,30);
        this.panel.add(titel1Label1);
        this.titel1Label1.setFont(f2);

        this.usarIdLabel=new JLabel("User Id");
        this.usarIdLabel.setBounds(200,230,100,30);
        this.usarIdLabel.setFont(f3);
        this.panel.add(usarIdLabel);

        this.userTf=new JTextField();
        this.userTf.setBounds(300,230,100,30);
        this.userTf.setFont(f3);
        this.panel.add(userTf);

        this.passLabel=new JLabel("Password");
        this.passLabel.setBounds(200,280,100,30);
        this.passLabel.setFont(f3);
        this.panel.add(passLabel);

        this.passPf=new JPasswordField();
        this.passPf.setBounds(300,280,200,30);
        this.passPf.setFont(f3);
        this.panel.add(passPf);

        this.img=new ImageIcon("views\\luck.jpg.png");
        this.imgLabel=new JLabel(img);
        this.imgLabel.setBounds(50,70,150,150);
        this.panel.add(imgLabel);

        this.img1=new ImageIcon("views\\Wow.jpg.png.png");
        this.img1Label=new JLabel(img1);
        this.img1Label.setBounds(328,75,350,70);
        this.panel.add(img1Label);

        this.loginButton=new JButton("Login");
        this.loginButton.setBounds(50,350,120,30);
        this.loginButton.setFont(f4);
        this.loginButton.setBackground(c2);
        this.loginButton.addActionListener(this);
        this.panel.add(loginButton);

        this.adButton=new JButton("Admin sign up");
        this.adButton.setBounds(200,350,150,30);
        this.adButton.setFont(f4);
        this.adButton.setBackground(c2);
        this.adButton.addActionListener(this);
        this.panel.add(adButton);

        this.brButton=new JButton("Broker sign up");
        this.brButton.setBounds(400,350,150,30);
        this.brButton.setFont(f4);
        this.brButton.setBackground(c2);
        this.brButton.addActionListener(this);
        this.panel.add(brButton);

        this.clButton=new JButton("Client sign up");
        this.clButton.setBounds(600,350,150,30);
        this.clButton.setFont(f4);
        this.clButton.setBackground(c2);
        this.clButton.addActionListener(this);
        this.panel.add(clButton);

        this.forgetpassButton=new JButton("Forget password");
        this.forgetpassButton.setBounds(200,450,180,30);
        this.forgetpassButton.setFont(f4);
        this.forgetpassButton.setBackground(c2);
        this.forgetpassButton.addActionListener(this);
        this.panel.add(forgetpassButton);

        this.backButton=new JButton("Back");
        this.backButton.setBounds(400,450,100,30);
        this.backButton.setFont(f4);
        this.backButton.setBackground(c2);
        this.backButton.addActionListener(this);
        this.panel.add(backButton);

        this.add(panel);
     }
       
     
     public void actionPerformed(ActionEvent ae) 
     {
      String command = ae.getActionCommand();
      if (command.equals(loginButton.getText())) 
      {
          if (!userTf.getText().isEmpty() && passPf.getPassword().length != 0) 
          {
              String userTfValue = userTf.getText();
              String passTfValue = new String(passPf.getPassword());

              UserController us = new UserController();
              User u = us.searchUser(userTfValue);

              if (u != null) {
                  if (u.getPassword().equals(passTfValue)) {
                      if (u.getRole() == 1) 
                      {
                          AdminHomeFrame ahf = new AdminHomeFrame(u);
                          this.setVisible(false);
                          ahf.setVisible(true);
                      } 
                      else if (u.getRole() == 2) 
                      {
                          BrokerHomeFrame bro = new BrokerHomeFrame(u);
                          this.setVisible(false);
                          bro.setVisible(true);
                      } 
                      else if (u.getRole() == 3)
                       {
                          ClientHomeFrame chf = new ClientHomeFrame(u);
                          this.setVisible(false);
                          chf.setVisible(true);
                          
                          
                      }
                  } else {
                      JOptionPane.showMessageDialog(this, "Wrong password");
                  }
              } else {
                  JOptionPane.showMessageDialog(this, "Wrong User Id");
              }
          } else {
              JOptionPane.showMessageDialog(this, "Please Fill up All the Field");
          }
      } else if (command.equals(adButton.getText())) {
          AdminRegistrationFrame ar = new AdminRegistrationFrame();
          this.setVisible(false);
          ar.setVisible(true);
      } else if (command.equals(brButton.getText())) {
          BrokerRegistrationFrame bo = new BrokerRegistrationFrame();
          this.setVisible(false);
          bo.setVisible(true);
      } else if (command.equals(clButton.getText())) {
          ClientRegistrationFrame clf = new ClientRegistrationFrame();
          this.setVisible(false);
          clf.setVisible(true);
      } else if (command.equals(backButton.getText())) {
          WelcomeFrame we = new WelcomeFrame();
          this.setVisible(false);
          we.setVisible(true);
      } else if (command.equals(forgetpassButton.getText())) {
          ForgetPassFrame fro = new ForgetPassFrame();
          this.setVisible(false);
          fro.setVisible(true);
      }
  }
}







