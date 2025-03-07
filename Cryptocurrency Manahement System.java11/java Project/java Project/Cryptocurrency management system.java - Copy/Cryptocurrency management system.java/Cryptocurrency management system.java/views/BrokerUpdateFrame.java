
package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;

public class BrokerUpdateFrame extends JFrame implements ActionListener 
{
    private JLabel userIdLabel,titelLabel ,nameLabel, emailLabel, phoneNoLabel, genderLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF;
    private ImageIcon backImg;
    private  JLabel imgLabel;
    private JPanel panel;
    private Font f1;
    private JButton updateBtn, backBtn;
    
    private User uer;
    private Broker broker;

    public BrokerUpdateFrame(User uer)
     {
        super("Broker Update Profile Frame");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.f1=new Font("Arial Black",Font.PLAIN,17);
        panel = new JPanel();
        panel.setLayout(null);
       this.panel.setBackground(Color.PINK);
        this.add(panel);
        this.titelLabel = new JLabel("Update Your Profile");
        this.titelLabel.setBounds(350, 10, 400, 40);
        this.titelLabel.setFont(new Font("Goudy Stout", Font.BOLD, 15));
        this.titelLabel.setForeground(Color.BLACK);
        this.panel.add(titelLabel);

        BrokerController bro = new BrokerController();
        this.broker = bro.searchBroker(uer.getUserId());
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
        this.backImg=new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\u1.png");
         this.imgLabel=new JLabel(backImg);
         this.imgLabel = new JLabel(backImg);
        this.imgLabel.setBounds(600, 80, 350, 400);
        this.panel.add(imgLabel);

        this.uer = uer;
    }

        public void actionPerformed(ActionEvent ae)
         {
            String command = ae.getActionCommand();
    
            if (command.equals(updateBtn.getText())) {
                if (!emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !genderTF.getText().isEmpty()) 
                {
                    broker.setEmail(emailTF.getText());
                    broker.setPhoneNo(phoneNoTF.getText());
                    broker.setGender(genderTF.getText());

    
                    BrokerController bro = new BrokerController();
                    bro.updateBroker(broker);
            
    
    
                        JOptionPane.showMessageDialog(this, "Update Successfully!");
            
                } 
                else 
                {
                    JOptionPane.showMessageDialog(this, "Please fill up all the fields properly.");
                }
            }
    
            if (command.equals(backBtn.getText())) {
                BrokerHomeFrame bro = new BrokerHomeFrame(uer);
                this.setVisible(false);
                bro.setVisible(true);
            }
        }
    }
















   



