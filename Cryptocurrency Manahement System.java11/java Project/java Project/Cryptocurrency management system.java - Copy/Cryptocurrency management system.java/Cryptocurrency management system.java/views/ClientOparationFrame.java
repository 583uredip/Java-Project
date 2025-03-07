package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;
public class ClientOparationFrame extends JFrame implements ActionListener
 {
    private JLabel userIdLabel,titelLabel, nameLabel, emailLabel, phoneNoLabel, genderLabel, securityAnsLabel, passLabel,walletBalanceLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, securityAnsTF,walletBalanceTf;
    private JPasswordField passPF;
	private ImageIcon brokarimg;
	private Font f1;
  private JLabel imgLabel;
    private JRadioButton maleRB, femaleRB;
    private ButtonGroup bg;
    
    private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
    private JTable clientTable;
    private JScrollPane clientTableSP;
    private JPanel panel;
    private User uer;

    public ClientOparationFrame( User uer)
	 {
        super("Client Oparation Frame");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		this.f1=new Font("Arial Black",Font.PLAIN,13);
        this.panel = new JPanel();
        this.panel.setLayout(null);
		this.panel.setBackground(Color.cyan);
		this.titelLabel = new JLabel("Client Operation Page");
        this.titelLabel.setBounds(300, 10, 400, 40);
        this.titelLabel.setFont(new Font("Old English Text MT", Font.BOLD, 32));
        this.titelLabel.setForeground(Color.RED);
        this.panel.add(titelLabel);

        this.brokarimg = new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\ad1.png");
        this.imgLabel = new JLabel(brokarimg);
        this.imgLabel.setBounds(600, 90, 350, 400);
        this.panel.add(imgLabel);

        this.userIdLabel = new JLabel("User Id:");
        this.userIdLabel.setBounds(50, 80, 60, 30);
        this.userIdLabel.setFont(f1);
        this.panel.add(userIdLabel);

        this.userTF = new JTextField();
        this.userTF.setBounds(120, 80, 150, 30);
        this.userTF.setFont(f1);
        this.panel.add(userTF);

        this.nameLabel = new JLabel("Name:");
        this.nameLabel.setBounds(50, 130, 60, 30);
        this.nameLabel.setFont(f1);
        this.panel.add(nameLabel);

        this.nameTF = new JTextField();
        this.nameTF.setBounds(120, 130, 150, 30);
        this.nameTF.setFont(f1);
        this.panel.add(nameTF);

        this.emailLabel = new JLabel("Email:");
        this.emailLabel.setBounds(50, 180, 60, 30);
        this.emailLabel.setFont(f1);
        this.panel.add(emailLabel);

        this.emailTF = new JTextField();
        this.emailTF.setBounds(120, 180, 150, 30);
        this.emailTF.setFont(f1);
        this.panel.add(emailTF);

        this.phoneNoLabel = new JLabel("Phone No:");
        this.phoneNoLabel.setBounds(50, 230, 80, 30);
        this.phoneNoLabel.setFont(f1);
        this.panel.add(phoneNoLabel);

        this.phoneNoTF = new JTextField();
        this.phoneNoTF.setBounds(125, 230, 150, 30);
        this.phoneNoTF.setFont(f1);
        this.panel.add(phoneNoTF);

        this.genderLabel = new JLabel("Gender:");
        this.genderLabel.setBounds(50, 280, 60, 30);
        this.genderLabel.setFont(f1);
        this.panel.add(genderLabel);

        this.maleRB = new JRadioButton("Male");
        this.maleRB.setBounds(120, 280, 60, 30);
        this.panel.add(maleRB);

        this.femaleRB = new JRadioButton("Female");
        this.femaleRB.setBounds(190, 280, 80, 30);
        this.panel.add(femaleRB);

        this.bg = new ButtonGroup();
        this.bg.add(maleRB);
        this.bg.add(femaleRB);

        this.securityAnsLabel = new JLabel("Security Ans:");
        this.securityAnsLabel.setBounds(50, 330, 100, 30);
        this.securityAnsLabel.setFont(f1);
        this.panel.add(securityAnsLabel);

        this.securityAnsTF = new JTextField();
        this.securityAnsTF.setBounds(160, 330, 150, 30);
        this.securityAnsTF.setFont(f1);
        this.panel.add(securityAnsTF);

        this.passLabel = new JLabel("Password:");
        this.passLabel.setBounds(50, 380, 100, 30);
        this.passLabel.setFont(f1);
        this.panel.add(passLabel);

        this.passPF = new JPasswordField();
        this.passPF.setBounds(160, 380, 150, 30);
        this.passPF.setFont(f1);
        this.panel.add(passPF);
		this.walletBalanceLabel  =new JLabel("Wallet Balance");
		this.walletBalanceLabel.setBounds(50,430,150,30);
		this.walletBalanceLabel.setFont(f1);
		this.panel.add(walletBalanceLabel);
		this.walletBalanceTf=new JTextField();
		this.walletBalanceTf.setBounds(210,430,150,30);
		this.walletBalanceTf.setFont(f1);
		this.panel.add(walletBalanceTf);
		this.add(panel);
       
        addBtn = new JButton("Add Client");
        addBtn.setBounds(300, 80, 120, 30);
		this.addBtn.setBackground(Color.WHITE);
        addBtn.addActionListener(this);
        panel.add(addBtn);

        updateBtn = new JButton("Update Client");
        updateBtn.setBounds(300, 130, 120, 30);
		this.updateBtn.setBackground(Color.WHITE);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        removeBtn = new JButton("Remove  Client");
        removeBtn.setBounds(300, 180, 130, 30);
		this.removeBtn.setBackground(Color.WHITE);
        removeBtn.addActionListener(this);
        panel.add(removeBtn);

        searchBtn = new JButton("Search  Client");
        searchBtn.setBounds(300, 230, 130, 30);
		this.searchBtn.setBackground(Color.WHITE);
        searchBtn.addActionListener(this);
        panel.add(searchBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(300, 280, 120, 30);
		this.resetBtn.setBackground(Color.WHITE);
        resetBtn.addActionListener(this);
        panel.add(resetBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(340, 330, 130, 30);
		this.backBtn.setBackground(Color.WHITE);
        backBtn.addActionListener(this);
        panel.add(backBtn);
	
        
		ClientController cro=new ClientController();
		Client[] clientList=cro.getAllClient();
		String ClientData1[][]=new String[clientList.length][6];
		for(int i=0;i<clientList.length;i++)
		{
			if(clientList[i]!=null)
			{
				System.out.println(clientList[i].toStringClient());
				ClientData1[i][0] = clientList[i].getUserId();
                 ClientData1[i][1] = clientList[i].getName();
                ClientData1[i][2] = clientList[i].getGender();
                ClientData1[i][3] = clientList[i].getEmail();
                ClientData1[i][4] = clientList[i].getPhoneNo();
                ClientData1[i][5] =String.valueOf( clientList[i].getWalletBalance());
			}
		}

		String hade1[]={"Id","Name","Gender","Email","Phone No","Wallet Balance"};
        this.clientTable=new JTable(ClientData1,hade1);
		this.clientTableSP=new JScrollPane(clientTable);
		this.clientTableSP.setBounds(60,500,900,200);
		this.clientTable.setBackground(Color.lightGray);
		this.clientTable.getTableHeader().setBackground(Color.pink);
		this.clientTable.getTableHeader().setForeground(Color.darkGray);
		this.clientTable.setFont(new Font("Arial", Font.PLAIN, 14));
        this.clientTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));

		this.clientTable.setEnabled(false);
		this.panel.add(clientTableSP);
        
		this.panel.revalidate();
		this.panel.repaint();
		this.add(panel);
	      this.uer=uer;
	 }
    
	  public void actionPerformed(ActionEvent ae)
	{

		String command=ae.getActionCommand();
		
			if(command.equals(addBtn.getText()))
			{
              if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && ((maleRB.isSelected()) ||(femaleRB.isSelected())) && !emailTF.getText().isEmpty()&& !phoneNoTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty()&&!passPF.getText().isEmpty() && !walletBalanceTf.getText().isEmpty())
			  {
                UserController ul=new UserController();
				
            
				ClientController cli=new ClientController();
				User uer=ul.searchUser(userTF.getText());
                 if(uer!=null)
				 {
					JOptionPane.showMessageDialog(this, "Id is already used");
				 }

				 else
				 {
					String userId=userTF.getText();
					String name=nameTF.getText();
					String gender="";
					if(maleRB.isSelected())
					{
						gender=maleRB.getText();
					}
                    else
					{
						gender=femaleRB.getText();
					}

					String email=emailTF.getText();
					String phoneNo=phoneNoTF.getText();
					int role=2;
					String securityAns=securityAnsTF.getText();
					String password=passPF.getText();
					double balance=0.0;
					try 
					{
						balance = Double.parseDouble(walletBalanceTf.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	 

					
					Client ci=new Client(userId,name,gender,email,phoneNo,role,securityAns,password,balance);
					ul.insertUser(ci);
					cli.insertClient(ci);
					JOptionPane.showMessageDialog(this,"Successfully Done");
					this.setVisible(false);
			
					ClientOparationFrame cl=new ClientOparationFrame(uer);
					cl.setVisible(true);
				 }
			  }
			  else
			  {
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			  }

			}

			if(command.equals(updateBtn.getText()))
			{
	 		  if(!userTF.getText().isEmpty() && nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty()&& !walletBalanceTf.getText().isEmpty())
			  {
            
		
				  ClientController cli= new ClientController();
				  Client cl=cli.searchClient(userTF.getText());
				  if(cl!=null)
				  {
					String userId=userTF.getText();
					String name=nameTF.getText();
					String gender="";
					if(maleRB.isSelected())
					{
						gender=maleRB.getText();
					}
					
					else
					{
						gender=femaleRB.getText();
					}
					String email=emailTF.getText();
					String phoneNo=phoneNoTF.getText();
					double balance=0.0;
					try 
					{
						balance = Double.parseDouble(walletBalanceTf.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	 
				    
					cl.setName(name);
					cl.setGender(gender);
					cl.setEmail(email);
					cl.setPhoneNo(phoneNo);
					cl.setWalletBalance(balance);
					cli.updateClient(cl);
					JOptionPane.showMessageDialog(this, "Successfully Done");
					this.setVisible(false);
					
					AdminOperationFrame aof=new AdminOperationFrame(uer);
					aof.setVisible(true);
					
				  }

				  else
				{
					JOptionPane.showMessageDialog(this,"Client not found");
				}
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(this,"Please fill up field properly");
			  }

		    }

			if(command.equals(removeBtn.getText()))
			{
				if(!userTF.getText().isEmpty())
				{
                  String userId=userTF.getText();
				  UserController ul=new UserController();
				  User user=ul.searchUser(userId);

				  if(user!=null)
				  {
					ul.deleteUser(userId);
					
			
					ClientController cli=new ClientController();
					cli.deleteClient(userId);
					JOptionPane.showMessageDialog(this, "Successfully Removed");
		
					ClientOparationFrame cof=new ClientOparationFrame(uer);
					this.setVisible(false);
					cof.setVisible(true);
				  }
				

				else
				{
					JOptionPane.showMessageDialog(this, "Didnot Found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Enter UserId");
			}

	    }

		if(command.equals(searchBtn.getText()))
		{
			if(!userTF.getText().isEmpty())
			{
				
	
				ClientController cli=new ClientController();
				String userId=userTF.getText();
				Client cl =cli.searchClient(userId);

				if(cl!=null)
				{
					userTF.setEnabled(false);
					nameTF.setText(cl.getName());
					if(cl.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}

                    double price=0;
					try 
					{
						price = Double.parseDouble(walletBalanceTf.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	 

					emailTF.setText(cl.getEmail());
					phoneNoTF.setText(cl.getPhoneNo());
					
					walletBalanceTf.setText(userId);
					
				}
				else
			{
				JOptionPane.showMessageDialog(this, "Broker Did Not Found");
			}

			}

			else
			{
				JOptionPane.showMessageDialog(this, "Please Enter UserId");
			}
		}

		if(command.equals(resetBtn.getText()))
			{
				userTF.setEditable(true);
				userTF.setText("");
				nameTF.setText("");
				emailTF.setText("");
				phoneNoTF.setText("");
				passPF.setText("");
				securityAnsTF.setText("");
				
			}

			if(command.equals(backBtn.getText()))
			{
			
				
				AdminHomeFrame ad=new AdminHomeFrame(uer);
				this.setVisible(false);
				ad.setVisible(true);
			}								
	}
}
















	
