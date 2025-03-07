
package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;

public class AdminHomeFrame extends JFrame implements ActionListener
 {
    private JLabel titelLabel;
    private JButton adminBtn, clientBtn, brokerBtn, cryptoBtn, profileBtn, backBtn;
    private JPanel panel;
    private Font f1;
    private ImageIcon brokarimg;
  private JLabel imgLabel;
  private Font f4;
    private User uer;

    public AdminHomeFrame(User uer) 
    {
        super("Admin Home Frame");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.f4=new Font("Cooper Black", Font.BOLD, 17); 
       
      

        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(Color.BLACK);
        this.titelLabel = new JLabel("Admin Home Page");
        this.titelLabel.setBounds(350, 10, 400, 40);
        this.titelLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 27));
        this.titelLabel.setForeground(Color.WHITE);
        this.panel.add(titelLabel);

        this.adminBtn = new JButton("Admin Operation");
        this.adminBtn.setBounds(50, 80, 200, 40);
        this.adminBtn.setFont(f4);
        this.adminBtn.setForeground(Color.ORANGE);
        this.adminBtn.setBackground(Color.BLACK);
        this.adminBtn.addActionListener(this);
        this.panel.add(adminBtn);

        this.clientBtn = new JButton("Client Operation");
        this.clientBtn.setBounds(50, 140, 200, 40);
        this.clientBtn.setFont(f4);
        this.clientBtn.setForeground(Color.ORANGE);
        this.clientBtn.setBackground(Color.BLACK);
        this.clientBtn.addActionListener(this);
        this.panel.add(clientBtn);

        this.cryptoBtn = new JButton("Crypto Operation");
        this.cryptoBtn.setBounds(50, 200, 200, 40);
        this.cryptoBtn.setFont(f4);
        this.cryptoBtn.setForeground(Color.ORANGE);
        this.cryptoBtn.setBackground(Color.BLACK);
        this.cryptoBtn.addActionListener(this);
        this.panel.add(cryptoBtn);

        this.profileBtn = new JButton("Update Profile");
        this.profileBtn.setBounds(50, 260, 200, 40);
        this.profileBtn.setFont(f4);
        this.profileBtn.setForeground(Color.ORANGE);
        this.profileBtn.setBackground(Color.BLACK);
        this.profileBtn.addActionListener(this);
        this.panel.add(profileBtn);

        this.brokerBtn = new JButton("Broker Operation");
        this.brokerBtn.setBounds(50, 320, 200, 40);
        this.brokerBtn.setFont(f4);
        this.brokerBtn.setForeground(Color.ORANGE);
        this.brokerBtn.setBackground(Color.BLACK);
        this.brokerBtn.addActionListener(this);
        this.panel.add(brokerBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(50, 380, 200, 40);
        this.backBtn.setFont(f4);
        this.backBtn.setForeground(Color.ORANGE);
        this.backBtn.setBackground(Color.BLACK);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        
        this.brokarimg = new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\Adhome.png");
        this.imgLabel = new JLabel(brokarimg);
        this.imgLabel.setBounds(300, 80, 600, 500); 
        this.panel.add(imgLabel);

        this.add(panel);
        this.uer = uer;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals(adminBtn.getText())) 
		{
            AdminOperationFrame arf = new AdminOperationFrame(uer);
            this.setVisible(false);
            arf.setVisible(true);
        }

        if (command.equals(profileBtn.getText())) 
		{
            this.setVisible(false);
            UpdateAdminFrame uaf = new UpdateAdminFrame(uer);
            uaf.setVisible(true);
        }

        if (command.equals(cryptoBtn.getText()))
		 {
            this.setVisible(false);
            CryptocurrencyFrame crf = new CryptocurrencyFrame();
            crf.setVisible(true);
			BrokerHomeFrame bro= new BrokerHomeFrame(uer);
			bro.setVisible(false);
			ClientHomeFrame cli= new ClientHomeFrame(uer);
			cli.setVisible(false);
        }

        if (command.equals(brokerBtn.getText())) 
		{
            this.setVisible(false);
            BrokerOperationFrame bro = new BrokerOperationFrame(uer);
            bro.setVisible(true);
        }

        if (command.equals(clientBtn.getText())) 
		{
            this.setVisible(false);
            ClientOparationFrame cof = new ClientOparationFrame(uer);
            cof.setVisible(true);
        }

        if (command.equals(backBtn.getText()))
		 {
            LoginFrame lf = new LoginFrame();
            this.setVisible(false);
            lf.setVisible(true);
        }
    }
}
