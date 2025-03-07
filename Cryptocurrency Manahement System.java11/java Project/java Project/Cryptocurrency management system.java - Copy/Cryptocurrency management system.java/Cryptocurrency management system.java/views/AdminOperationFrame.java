package views;
import java.lang.*;
import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;
public class AdminOperationFrame extends JFrame implements ActionListener
 {
    private JLabel userIdLabel, nameLabel,titelLabel, emailLabel, phoneNoLabel, genderLabel, securityAnsLabel, passLabel, adminTypeLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, securityAnsTF;
    private JPasswordField passPF;
    private JRadioButton maleRB, femaleRB;
    private ButtonGroup bg;
	private ImageIcon brokarimg;
  private JLabel imgLabel;
    private JComboBox  adminTypeCMB;
    private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
    private JTable adminTable;
	private Font f1,f4;
    private JScrollPane adminTableSP;
    private JPanel panel;
    private User uer;

    public AdminOperationFrame( User uer)
	 {
        super("Admin Operation Frame");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.f1=new Font("Arial Black",Font.PLAIN,13);
		

        this.panel = new JPanel();
        this.panel.setLayout(null);
		this.panel.setBackground(Color.RED);
		this.panel.setBackground(Color.ORANGE);
		this.titelLabel = new JLabel("Admin Operation Page");
        this.titelLabel.setBounds(300, 10, 400, 40);
        this.titelLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
        this.titelLabel.setForeground(Color.BLACK);
        this.panel.add(titelLabel);

        this.brokarimg = new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\broker.png");
        this.imgLabel = new JLabel(brokarimg);
        this.imgLabel.setBounds(600, 80, 350, 400);
        this.panel.add(imgLabel);

        // Initialize labels and text fields
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

        this.adminTypeLabel = new JLabel("Admin Type:");
        this.adminTypeLabel.setBounds(50, 430, 100, 30);
        this.adminTypeLabel.setFont(f1);
        this.panel.add(adminTypeLabel);

        String[] item = {"Hr Admin", "Academic Admin"};
        adminTypeCMB = new JComboBox<>(item);
        adminTypeCMB.setBounds(160, 430, 150, 30);
        panel.add(adminTypeCMB);

        
        addBtn = new JButton("Add Admin");
        addBtn.setBounds(300, 80, 120, 30);
		this.addBtn.setBackground(Color.MAGENTA);
        addBtn.addActionListener(this);
        panel.add(addBtn);

        updateBtn = new JButton("Update Admin");
        updateBtn.setBounds(300, 130, 120, 30);
		this.updateBtn.setBackground(Color.MAGENTA);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        removeBtn = new JButton("Remove Admin");
        removeBtn.setBounds(300, 180, 120, 30);
		this.removeBtn.setBackground(Color.MAGENTA);
        removeBtn.addActionListener(this);
        panel.add(removeBtn);

        searchBtn = new JButton("Search Admin");
        searchBtn.setBounds(300, 230, 120, 30);
		this.searchBtn.setBackground(Color.MAGENTA);
        searchBtn.addActionListener(this);
        panel.add(searchBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(300, 280, 120, 30);
		this.resetBtn.setBackground(Color.MAGENTA);
        resetBtn.addActionListener(this);
        panel.add(resetBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(340, 330, 130, 30);
		this.backBtn.setBackground(Color.MAGENTA);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        AdminController ar = new AdminController();
        Admin[] adminList = ar.getAllAdmin();
        String adminData1[][] = new String[adminList.length][6];
        for (int i = 0; i < adminList.length; i++) {
            if (adminList[i] != null) {
                System.out.println(adminList[i].toStringAdmin());
                adminData1[i][0] = adminList[i].getUserId();
                adminData1[i][1] = adminList[i].getName();
                adminData1[i][2] = adminList[i].getGender();
                adminData1[i][3] = adminList[i].getEmail();
                adminData1[i][4] = adminList[i].getPhoneNo();
                adminData1[i][5] = adminList[i].getAdminType();
            }
        }

        String hade1[] = {"Id", "Name", "Gender", "Email", "Phone No", "AdminType"};
        this.adminTable = new JTable(adminData1, hade1);
        this.adminTableSP = new JScrollPane(adminTable);
        this.adminTableSP.setBounds(50, 500, 900, 200); // Adjusted bounds for the table
        this.adminTable.setEnabled(false);
        this.adminTable.setBackground(Color.LIGHT_GRAY);
        this.adminTable.getTableHeader().setBackground(Color.YELLOW);
        this.adminTable.getTableHeader().setForeground(Color.RED);
        this.adminTable.setFont(new Font("Arial", Font.PLAIN, 14));
        this.adminTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        this.panel.add(adminTableSP);

        this.panel.revalidate();
        this.panel.repaint();
        this.add(panel);
        this.uer = uer;
		
        
	 }
		
    
	  public void actionPerformed(ActionEvent ae)
	{

		String command=ae.getActionCommand();
		
			if(command.equals(addBtn.getText()))
			{
              if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && ((maleRB.isSelected()) ||(femaleRB.isSelected())) && !emailTF.getText().isEmpty()&& !phoneNoTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty()&&!passPF.getText().isEmpty())
			  {
                UserController ul=new UserController();
				AdminController ar=new AdminController();
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
					int role=1;
					String securityAns=securityAnsTF.getText();
					String password=passPF.getText();
					String adminType=adminTypeCMB.getSelectedItem().toString();
					Admin ai=new Admin(userId,name,gender,email,phoneNo,role,securityAns,password,adminType);
					ul.insertUser(ai);
					ar.insertAdmin(ai);
					JOptionPane.showMessageDialog(this,"Successfully Done");
					this.setVisible(false);
					AdminOperationFrame aof=new AdminOperationFrame(uer);
					aof.setVisible(true);
				 }
			  }
			  else
			  {
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			  }

			}

			if(command.equals(updateBtn.getText()))
			{
	 		  if(!userTF.getText().isEmpty() && nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty())
			  {
                  AdminController  ac=new AdminController();
				  Admin ai=ac.searchAdmin(userTF.getText());
				  if(ai!=null)
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
					String adminType=adminTypeCMB.getSelectedItem().toString();
					ai.setName(name);
					ai.setGender(gender);
					ai.setEmail(email);
					ai.setPhoneNo(phoneNo);
					ai.setAdminType(adminType);
					ac.updateAdmin(ai);
					JOptionPane.showMessageDialog(this, "Successfully Done");
					this.setVisible(false);
					AdminOperationFrame aof=new AdminOperationFrame(uer);
					aof.setVisible(true);
					
				  }

				  else
				{
					JOptionPane.showMessageDialog(this,"Admin not found");
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
					AdminController ac=new AdminController();
					ac.deleteAdmin(userId);
					JOptionPane.showMessageDialog(this, "Successfully Removed");
					AdminOperationFrame aof=new AdminOperationFrame(user);
					this.setVisible(false);
					aof.setVisible(true);
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
				AdminController ac=new AdminController();
				String userId=userTF.getText();
				Admin ad=ac.searchAdmin(userId);

				if(ad!=null)
				{
					userTF.setEnabled(false);
					nameTF.setText(ad.getName());
					if(ad.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}

					emailTF.setText(ad.getEmail());
					phoneNoTF.setText(ad.getPhoneNo());
					adminTypeCMB.setSelectedItem(ad.getAdminType());
				}
				else
			{
				JOptionPane.showMessageDialog(this, "Admin Did Not Found");
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
			
				AdminHomeFrame aof=new AdminHomeFrame(uer);
				this.setVisible(false);
				aof.setVisible(true);
			}								
	}
}
















	