package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;
public class ForgetPassFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, titelLabel,securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField userTF, securityAnsTF;
	private JPasswordField passPF;
	private JButton submitBtn, exitBtn, backBtn;
  private Font f1,f4;
  private ImageIcon brokarimg;
  private JLabel imgLabel;
	private JPanel panel;
	
	
	public ForgetPassFrame()
	{
		super("Forget Password Frame");
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null); 
    this.f1=new Font("Arial Black",Font.PLAIN,13);
    this.f4=new Font("Cooper Black", Font.BOLD, 17); 
		this.panel=new JPanel();
		this.panel.setLayout(null);
        this.panel.setBackground(Color.GRAY);
        this.titelLabel = new JLabel("Forget Password Page");
        this.titelLabel.setBounds(150, 10, 400, 40);
        this.titelLabel.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 20));
        this.titelLabel.setForeground(Color.RED);
        this.titelLabel.setForeground(Color.black);
        this.panel.add(titelLabel);
        this.brokarimg = new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\for.png");
        this.imgLabel = new JLabel(brokarimg);
        this.imgLabel.setBounds(600, 90, 350, 400);
        this.panel.add(imgLabel);
      
        this.userIdLabel = new JLabel("User ID:");
        this.userIdLabel.setBounds(50, 60, 150, 25);
        this.userIdLabel.setFont(f1);
        this.panel.add(userIdLabel);
        
        this.userTF = new JTextField();
        this.userTF.setBounds(200, 60, 300, 25);
        this.userTF.setFont(f1);
        this.panel.add(userTF);
      
      
        this.securityQuesLabel = new JLabel("Security Ques: What is your pet's name?");
        this.securityQuesLabel.setBounds(50, 100, 400, 25);
        this.securityQuesLabel.setFont(f1);
        this.panel.add(securityQuesLabel);
        
      
        this.securityAnsLabel = new JLabel("Security Ans:");
        this.securityAnsLabel.setBounds(50, 140, 150, 25);
        this.securityAnsLabel.setFont(f1);
        this.panel.add(securityAnsLabel);
        
        this.securityAnsTF = new JTextField();
        this.securityAnsTF.setBounds(200, 140, 300, 25);
        this.securityAnsTF.setFont(f1);
        this.panel.add(securityAnsTF);
        
      
        this.passLabel = new JLabel("New Password:");
        this.passLabel.setBounds(50, 180, 150, 25);
        this.passLabel.setFont(f1);
        this.panel.add(passLabel);
        
        this.passPF = new JPasswordField();
        this.passPF.setBounds(200, 180, 300, 25);
        this.passPF.setFont(f1);
        this.panel.add(passPF);
        
    
        this.submitBtn = new JButton("Submit");
        this.submitBtn.setBounds(50, 230, 100, 30);
        this.submitBtn.setFont(f4);
        this.submitBtn.setBackground(Color.MAGENTA);
        this.submitBtn.addActionListener(this);
        this.panel.add(submitBtn);
        
        this.exitBtn = new JButton("Exit");
        this.exitBtn.setBounds(160, 230, 100, 30);
        this.exitBtn.setFont(f4);
        this.exitBtn.setBackground(Color.MAGENTA);
        this.exitBtn.addActionListener(this);
        this.panel.add(exitBtn);
        
        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(270, 230, 100, 30);
        this.backBtn.setBackground(Color.MAGENTA);
        this.backBtn.setFont(f4);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
        this.add(panel);
	}


    public void actionPerformed(ActionEvent ae)
    {
           String command=ae.getActionCommand();
           if(command.equals(submitBtn.getText()))
           {
             if(!userTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty() )
             {
                  
                   String userTFValue=userTF.getText();
                   String passTFValue=passPF.getText();
                   String securityAnsTFValue=securityAnsTF.getText();
                   UserController ue=new UserController();
                   User ur=ue.searchUser(userTFValue);
                   if(ur!=null)
                   {
                     if(ur.getSecurityAns().equals(securityAnsTFValue))
                     {
                          ur.setPassword(passTFValue);
                          ue.updateUser(ur);
                          JOptionPane.showMessageDialog(this,"Password Update Successfully");
                          LoginFrame li=new LoginFrame();
                          this.setVisible(false);
                          li.setVisible(true);

                     }
                     else
                     {
                        JOptionPane.showMessageDialog(this,"Wrong Security Ans");

                     }

                   }

                   else
                   {
                          JOptionPane.showMessageDialog(this,"Wrond UserId");

                   }
             }
             else
             {
              JOptionPane.showMessageDialog(this,"please fill up all the field properly");

             }
           }
             if(command.equals(backBtn.getText()))
             {
                LoginFrame li=new LoginFrame();
                          this.setVisible(false);
                          li.setVisible(true);
             }
            if(command.equals(exitBtn.getText()))   
            {
                 System.exit(0);

            }
    }
}