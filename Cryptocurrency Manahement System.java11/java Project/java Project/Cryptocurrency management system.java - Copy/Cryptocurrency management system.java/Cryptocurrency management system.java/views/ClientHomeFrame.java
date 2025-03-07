
package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;
public class ClientHomeFrame extends JFrame implements ActionListener
{
	private JButton  transactionBtn, cryptoBtn, profileBtn,logoutBtn;
	private JPanel panel;
	private JLabel titelLabel;
	private Font f1;
    private ImageIcon brokarimg;
  private JLabel imgLabel;
  private Font f4;
	private User ub;
	
	public ClientHomeFrame(User ub)
	{
		super("Client  Home Frame" );
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.f4=new Font("Cooper Black", Font.BOLD, 17); 
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.GRAY);
		
		this.titelLabel = new JLabel("Client Home Page");
        this.titelLabel.setBounds(350, 10, 400, 40);
        this.titelLabel.setFont(new Font("Britannic Bold", Font.BOLD, 30));
        this.titelLabel.setForeground(Color.BLACK);
        this.panel.add(titelLabel);
		
		
		this.transactionBtn = new JButton("Transactions operation");
        this.transactionBtn.setBounds(50, 80, 250, 40);
        this.transactionBtn.setFont(f4);
        this.transactionBtn.setBackground(Color.WHITE);
         this.transactionBtn.addActionListener(this);
         this.panel.add(transactionBtn);
		this.cryptoBtn=new JButton ("Crypto operation");
		this.cryptoBtn.setBounds(50,140,200,40);
		this.cryptoBtn.setBackground(Color.WHITE);
		this.cryptoBtn.setFont(f4);
        this.cryptoBtn.addActionListener(this);
		this.panel.add(cryptoBtn);
		
		this.profileBtn=new JButton (" Update profile");
		this.profileBtn.setBounds(50,200,200,40);
		this.profileBtn.setFont(f4);
		this.profileBtn.setBackground(Color.WHITE);
		this.profileBtn.addActionListener(this);
		this.panel.add(profileBtn);
		
		this.logoutBtn=new JButton("Log out");
		this.logoutBtn.setBounds (50,260,200,40);
		this.logoutBtn.setFont(f4);
		this.logoutBtn.setBackground(Color.WHITE);
        this.logoutBtn.addActionListener(this);
		this.panel.add(logoutBtn);
		this.brokarimg = new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\cli1.png");
        this.imgLabel = new JLabel(brokarimg);
        this.imgLabel.setBounds(330, 80, 600, 500);
        this.panel.add(imgLabel);
		
		this.add(panel);
		this.ub=ub;
        		
		
	}
	
	public void actionPerformed(ActionEvent ae)
    { 
        String command=ae.getActionCommand();

        
		if(profileBtn.getText().equals(command))
		{
    
		   ClientUpadateFrame c=new ClientUpadateFrame(ub);
		   this.setVisible(false);
		   c.setVisible(true);

		}

		 if(cryptoBtn.getText().equals(command))
		{
			CryptocurrencyFrame cry=new CryptocurrencyFrame();
			this.setVisible(false);
			cry.setVisible(true);
			

		}

		   if(logoutBtn.getText().equals(command))
		{
			LoginFrame lo=new LoginFrame();
			this.setVisible(false);
			lo.setVisible(true);
		}

		if(transactionBtn.getText().equals(command))
		{
			

			TransactionOperationFrame trf=new TransactionOperationFrame();
			this.setVisible(false);
			trf.setVisible(true);
			
		}


    }

	
	
}