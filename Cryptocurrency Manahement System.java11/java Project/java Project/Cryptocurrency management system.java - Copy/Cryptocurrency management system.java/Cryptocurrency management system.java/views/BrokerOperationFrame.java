package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;
public class BrokerOperationFrame extends JFrame implements ActionListener
 {
    private JLabel userIdLabel,titelLabel , nameLabel, emailLabel, phoneNoLabel, genderLabel, securityAnsLabel, passLabel, adminTypeLabel,commissionRateLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, securityAnsTF,commissionRteTf;
    private JPasswordField passPF;
	private ImageIcon brokarimg;
  private JLabel imgLabel;
  private Font f1,f4;
    private JRadioButton maleRB, femaleRB;
    private ButtonGroup bg;
    
    private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
    private JTable brokerTable;
    private JScrollPane brokerTableSP;
    private JPanel panel;
    private User uer;

    public BrokerOperationFrame( User uer)
	 {
        super("Broker Operation Frame");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.f1=new Font("Arial Black",Font.PLAIN,13);
        this.panel = new JPanel();
        this.panel.setLayout(null);
		this.panel.setBackground(Color.RED);
		this.titelLabel = new JLabel("Broker Operation Page");
        this.titelLabel.setBounds(300, 10, 400, 40);
        this.titelLabel.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 30));
        this.titelLabel.setForeground(Color.LIGHT_GRAY);
        this.panel.add(titelLabel);

        this.brokarimg = new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\br.png");
        this.imgLabel = new JLabel(brokarimg);
        this.imgLabel.setBounds(600, 80, 350, 400);
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

		this.commissionRateLabel  =new JLabel("CommissionRate");
		this.commissionRateLabel.setBounds(50,430,150,30);
		this.commissionRateLabel.setFont(f1);
		this.panel.add(commissionRateLabel);
		this.commissionRteTf=new JTextField();
		this.commissionRteTf.setBounds(210,430,150,30);
		this.commissionRteTf.setFont(f1);
		this.panel.add(commissionRteTf);
		this.add(panel);
       
        addBtn = new JButton("Add Admin");
        addBtn.setBounds(300, 80, 120, 30);
		this.addBtn.setBackground(Color.ORANGE);
        addBtn.addActionListener(this);
        panel.add(addBtn);

        updateBtn = new JButton("Update Admin");
        updateBtn.setBounds(300, 130, 120, 30);
		this.updateBtn.setBackground(Color.ORANGE);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        removeBtn = new JButton("Remove Admin");
        removeBtn.setBounds(300, 180, 120, 30);
		this.removeBtn.setBackground(Color.ORANGE);
        removeBtn.addActionListener(this);
        panel.add(removeBtn);

        searchBtn = new JButton("Search Admin");
        searchBtn.setBounds(300, 230, 120, 30);
		this.searchBtn.setBackground(Color.ORANGE);
        searchBtn.addActionListener(this);
        panel.add(searchBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(300, 280, 120, 30);
		this.resetBtn.setBackground(Color.ORANGE);
        resetBtn.addActionListener(this);
        panel.add(resetBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(340, 330, 130, 30);
		this.backBtn.setBackground(Color.ORANGE);
        backBtn.addActionListener(this);
        panel.add(backBtn);
	
        BrokerController bro=new BrokerController();
		Broker[] brokerList=bro.getAllBroker();
		String brokerData1[][]=new String[brokerList.length][6];
		for(int i=0;i<brokerList.length;i++)
		{
			if(brokerList[i]!=null)
			{
				System.out.println(brokerList[i].toStringBroker());
				brokerData1[i][0] = brokerList[i].getUserId();
                 brokerData1[i][1] = brokerList[i].getName();
                brokerData1[i][2] = brokerList[i].getGender();
                brokerData1[i][3] = brokerList[i].getEmail();
                brokerData1[i][4] = brokerList[i].getPhoneNo();
                brokerData1[i][5] =String.valueOf( brokerList[i].getCommissionRate());
			}
		}

		String hade1[]={"Id","Name","Gender","Email","Phone No","CommissionRate"};
        this.brokerTable=new JTable(brokerData1,hade1);
		this.brokerTableSP=new JScrollPane(brokerTable);
		this.brokerTableSP.setBounds(60,500,900,200);
		this.brokerTable.setBackground(Color.ORANGE);
		this.brokerTable.getTableHeader().setBackground(Color.black);
		this.brokerTable.getTableHeader().setForeground(Color.BLUE);
        this.brokerTable.setFont(new Font("Arial", Font.PLAIN, 14));
        this.brokerTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		this.brokerTable.setEnabled(false);
		this.panel.add(brokerTableSP);
        
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
              if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && ((maleRB.isSelected()) ||(femaleRB.isSelected())) && !emailTF.getText().isEmpty()&& !phoneNoTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty()&&!passPF.getText().isEmpty() && !commissionRteTf.getText().isEmpty())
			  {
                UserController ul=new UserController();
				
                BrokerController bro=new BrokerController();
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
					double price=0.0;
					try 
					{
						price = Double.parseDouble(commissionRteTf.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	 

					
					Broker br=new Broker(userId,name,gender,email,phoneNo,role,securityAns,password,price);
					ul.insertUser(br);
					bro.insertBroker(br);
					JOptionPane.showMessageDialog(this,"Successfully Done");
					this.setVisible(false);
					BrokerOperationFrame bof=new BrokerOperationFrame(uer);
					bof.setVisible(true);
				 }
			  }
			  else
			  {
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			  }

			}

			if(command.equals(updateBtn.getText()))
			{
	 		  if(!userTF.getText().isEmpty() && nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty()&& !commissionRteTf.getText().isEmpty())
			  {
            
				  BrokerController bro=new BrokerController();
				  Broker br=bro.searchBroker(userTF.getText());
				  if(br!=null)
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
					double price=0.0;
					try 
					{
						price = Double.parseDouble(commissionRteTf.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	 
				    
					br.setName(name);
					br.setGender(gender);
					br.setEmail(email);
					br.setPhoneNo(phoneNo);
					br.setCommissionRate(price);
					bro.updateBroker(br);
					JOptionPane.showMessageDialog(this, "Successfully Done");
					this.setVisible(false);
					BrokerOperationFrame bof=new BrokerOperationFrame(uer);
					bof.setVisible(true);
					
				  }

				  else
				{
					JOptionPane.showMessageDialog(this,"Broker not found");
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
					
					BrokerController bro=new BrokerController();
					bro.deleteBroker(userId);
					JOptionPane.showMessageDialog(this, "Successfully Removed");
					BrokerOperationFrame bof=new BrokerOperationFrame(uer);
					this.setVisible(false);
					bof.setVisible(true);
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
				
				BrokerController br=new BrokerController();
				String userId=userTF.getText();
				Broker bro =br.searchBroker(userId);

				if(bro!=null)
				{
					userTF.setEnabled(false);
					nameTF.setText(bro.getName());
					if(bro.getGender().equals("Male"))
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
						price = Double.parseDouble(commissionRteTf.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	 

					emailTF.setText(bro.getEmail());
					phoneNoTF.setText(bro.getPhoneNo());
					
					commissionRteTf.setText(userId);
					
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
			
				AdminHomeFrame ad =new AdminHomeFrame(uer);
				this.setVisible(false);
				ad.setVisible(true);
			}								
	}
}
















	
