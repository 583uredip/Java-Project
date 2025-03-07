package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;
public class BrokerRegistrationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLebel, nameLabel,titelLabel, emailLabel, securityqusLabel,phoneNumberLabel,passwordLabel,genderLabel,commissionRateLabel;
	private JRadioButton maleRb, femaleRb;
	private JTextField useridTF,  nameTF, emailTF,phoneNumberTF, securityansTF,commissionRateTF;
	private JPasswordField passPF;
  private Font f1,f4;
	private JButton submitButton, backButton;
  private ImageIcon brokarimg;
  private JLabel imgLabel;
  private ButtonGroup brg;
	private JPanel panel;
	 public BrokerRegistrationFrame ()
	 {
		 super("Broker Registration Frame");
		 this.setSize(1000,1000);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.f1=new Font("Arial Black",Font.PLAIN,17);
     this.f4=new Font("Cooper Black", Font.BOLD, 17); 
		 this.panel=new JPanel();
     this.panel.setBackground(Color.LIGHT_GRAY);
		 this.panel.setLayout(null);
     this.titelLabel=new JLabel("Broker Registration Frome");
    this.titelLabel.setBounds(350, 10, 400, 40);
    this.titelLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
    this.titelLabel.setForeground(Color.BLUE);
    this.panel.add(titelLabel);  
		 this.userIdLebel=new JLabel("User Id");
		 this.userIdLebel.setBounds(50, 80, 150, 25);
     this.userIdLebel.setFont(f1);
		 this.panel.add(userIdLebel);
		 this.useridTF=new JTextField();
     this.useridTF.setBounds(200, 80, 300, 25);
     this.useridTF.setFont(f1);
		 this.panel.add(useridTF);
		 this.nameLabel = new JLabel("Name"); 
     this.nameLabel.setBounds(50, 120, 150, 25);
     this.nameLabel.setFont(f1);
      this.panel.add(nameLabel);
      this.nameTF = new JTextField();
      this.nameTF.setBounds(200, 120, 300, 25);
      this.nameTF.setFont(f1);
      this.panel.add(nameTF);

        this.brokarimg=new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\bri.png");
        this.imgLabel=new JLabel(brokarimg);
        this.imgLabel.setBounds(600, 80, 350, 400); 
        this.panel.add(imgLabel);



		 this.emailLabel=new JLabel("Email");
     this.emailLabel.setBounds(50, 160, 150, 25);
     this.emailLabel.setFont(f1);
		 this.panel.add(emailLabel);
		 this.emailTF=new JTextField();
		 this.panel.add(emailTF);
     this.emailTF.setBounds(200, 160, 300, 25);
     this.emailTF.setFont(f1);
		 this.phoneNumberLabel=new JLabel("Phone Number");
		 this.phoneNumberLabel.setBounds(50, 200, 150, 25);
     this.phoneNumberLabel.setFont(f1);
		 this.panel.add(phoneNumberLabel);
		this.phoneNumberTF=new JTextField();
		this.panel.add(phoneNumberTF);
		this.phoneNumberTF.setBounds(200, 200, 300, 25);
    this.phoneNumberTF.setFont(f1);
		this.genderLabel=new JLabel("Gender");
		this.genderLabel.setBounds(50, 240, 150, 25);
    this.genderLabel.setFont(f1);
                this.panel.add(genderLabel);
                this.maleRb=new JRadioButton("male");
                this.maleRb.setBounds(200, 240, 70, 25);
                this.panel.add(maleRb);
                this.femaleRb=new JRadioButton("female");
                this.femaleRb.setBounds(280, 240, 70, 25);
                this.panel.add(femaleRb);
                this.brg=new ButtonGroup();
                brg.add(maleRb);
                brg.add(femaleRb);
                this.submitButton=new JButton("Submit");
                this.submitButton.setBounds(100, 480, 120, 35);
                this.submitButton.setBackground(Color.GREEN);
                this.submitButton.setFont(f4);
                this.submitButton.addActionListener(this);
                this.panel.add(submitButton);
                this.backButton=new JButton("Back");
                this.backButton.setBounds(250, 480, 120, 35);
                this.backButton.setFont(f4);
                this.backButton.setBackground(Color.GREEN);
                this.backButton.addActionListener(this);
                this.panel.add(backButton);
                this.passwordLabel = new JLabel("Password");
                this.passwordLabel.setBounds(50, 430, 150, 25);
                this.passwordLabel.setFont(f1);
                this.panel.add(passwordLabel);
                this.passPF = new JPasswordField();
                this.passPF.setBounds(200, 430, 300, 25);
                this.passPF.setFont(f1);
                this.panel.add(passPF);
                this.securityqusLabel=new JLabel("Security Question: What is your pet name?");
                this.securityqusLabel.setBounds(50, 360, 400, 25); 
                this.securityqusLabel.setFont(f1);
                this.panel.add(securityqusLabel);
                this.securityansTF=new  JTextField();
                this.securityansTF.setBounds(50, 390, 450, 25);
                this.securityansTF.setFont(f1);
                this.panel.add(securityansTF);
                 this.commissionRateLabel=new JLabel("Commission Rate");
                 this.commissionRateLabel.setBounds(50, 280, 200, 25);
                 this.commissionRateLabel.setFont(f1);
                 this.panel.add(commissionRateLabel);
                 this.commissionRateTF=new JTextField();
                 this.commissionRateTF.setBounds(260, 280, 300, 25);
                 this.commissionRateTF.setFont(f1);
                 this.panel.add(commissionRateTF);
                 this.add(panel);
                 
                
             }

           public void actionPerformed(ActionEvent ae)
           {
                String command=ae.getActionCommand();

                if(command.equals(submitButton.getText()))
                {
                  if(!useridTF.getText().isEmpty() && !nameTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNumberTF.getText().isEmpty() && !securityansTF.getText().isEmpty() && !passPF.getText().isEmpty() && !commissionRateTF.getText().isEmpty() && ((maleRb.isSelected() || femaleRb.isSelected())))
                      {
                          String useridTFValue=useridTF.getText();
                          String nameTFValue=nameTF.getText();
                          String genderValue="";
                          if(maleRb.isSelected())
                          {
                            genderValue="male";
                          }
                          else
                          {
                            genderValue="female";
                          }
                             double commissionRateValue=0;
                          try
                           {
                                String iputCommissionRate=commissionRateTF.getText();
                                commissionRateValue=Double.parseDouble(iputCommissionRate);
                            
                          } 
                          catch (Exception e) 
                          {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(this,"CommissionRate Value Should Be Double");
                          }
                        
                          String emailTFValue=emailTF.getText();
                          String phoneNoValue=phoneNumberTF.getText();
                          String passwordValue=passPF.getText();
                          String securityAnsValue=securityansTF.getText();
                      
                          int role=2;

                          Broker br = new Broker(useridTFValue,nameTFValue,genderValue,emailTFValue,phoneNoValue,role,securityAnsValue,passwordValue,commissionRateValue);
                          
                          UserController uc= new UserController();
                           uc.insertUser(br);

                           BrokerController bro=new BrokerController();
                            bro.insertBroker(br);
                           ImageIcon suIcon=new ImageIcon("C:\\Users\\HP\\Downloads\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\happy.jpg.png");
                           JOptionPane.showMessageDialog(this,"Submit SussesFull!","Submit Done",JOptionPane.PLAIN_MESSAGE,suIcon);

                           LoginFrame lo=new LoginFrame();
                           this.setVisible(false);
                           lo.setVisible(true);
                      }

                      else
                      {
                          ImageIcon imageIcon=new ImageIcon("C:\\Users\\HP\\Downloads\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\Bro.jpg.png");
                          JOptionPane.showMessageDialog(this,"Submit UnsussesFull!","Submit Not Done",JOptionPane.PLAIN_MESSAGE,imageIcon);
                      }

                }

                if(command.equals(backButton.getText()))
                {
 
                    LoginFrame lo=new LoginFrame();
                    this.setVisible(false);
                    lo.setVisible(true);
                }

            }
	
}
