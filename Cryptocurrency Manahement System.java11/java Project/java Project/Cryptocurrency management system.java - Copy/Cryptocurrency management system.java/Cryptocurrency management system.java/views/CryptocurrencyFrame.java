package views;
import java.lang.*;
import java.util.ArrayList;

import javax.swing.*;
import models.*;
import java.awt.event.*;
import java.awt.*;
import controllers.*;
public class CryptocurrencyFrame extends JFrame implements ActionListener
{
    private JLabel cryptoidLabel,titelLabel ,nameLabel, symbolLabel, categorryLabel, currentPriceLabel, detailsLabel;
    private JTextField cryTf, nameTF, syTf, catTf, deTf, priceTF;
    private JButton addButton, updateButton, removeButton, resetButton, backButton;
    private JTable cryptoTable;
	private Font f1;
	private ImageIcon brokarimg;
  private JLabel imgLabel;
    private JScrollPane cryptoTableSP;
    private JPanel panel;

	private User uer;

    public CryptocurrencyFrame()
	 {
        super("Cryptocurrency Frame");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.f1=new Font("Arial Black",Font.PLAIN,13);
        this.panel = new JPanel();
		this.panel.setBackground(Color.yellow);
        this.panel.setLayout(null);
        
		this.titelLabel = new JLabel("Crypto Operation Page");
        this.titelLabel.setBounds(300, 10, 400, 40);
        this.titelLabel.setFont(new Font("Ravie", Font.BOLD, 25));
        this.titelLabel.setForeground(Color.black);
        this.panel.add(titelLabel);
		this.brokarimg = new ImageIcon("C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\cry.png");
        this.imgLabel = new JLabel(brokarimg);
        this.imgLabel.setBounds(600, 90, 350, 400);
        this.panel.add(imgLabel);

        this.cryptoidLabel = new JLabel("Crypto Id:");
      this.cryptoidLabel.setBounds(50, 80, 100, 30);
      this.cryptoidLabel.setFont(f1);
      this.panel.add(cryptoidLabel);

       this.cryTf = new JTextField();
       this.cryTf.setBounds(160, 80, 150, 30); 
       this.cryTf.setFont(f1);
       this.panel.add(cryTf);

    this.nameLabel = new JLabel("Coin Name:");
    this.nameLabel.setBounds(50, 130, 100, 30);
    this.nameLabel.setFont(f1);
    this.panel.add(nameLabel);

    this.nameTF = new JTextField();
   this.nameTF.setBounds(160, 130, 150, 30);
    this.nameTF.setFont(f1);
    this.panel.add(nameTF);

    this.symbolLabel = new JLabel("Symbol:");
    this.symbolLabel.setBounds(50, 180, 100, 30);
    this.symbolLabel.setFont(f1);
   this.panel.add(symbolLabel);

    this.syTf = new JTextField();
    this.syTf.setBounds(160, 180, 150, 30); 
   this.syTf.setFont(f1);
   this.panel.add(syTf);


   this.categorryLabel = new JLabel("Category:");
   this.categorryLabel.setBounds(50, 230, 100, 30);
  this.categorryLabel.setFont(f1);
  this.panel.add(categorryLabel);

   this.catTf = new JTextField();
  this.catTf.setBounds(160, 230, 150, 30);
   this.catTf.setFont(f1);
  this.panel.add(catTf);


  this.currentPriceLabel = new JLabel("Price:");
  this.currentPriceLabel.setBounds(50, 280, 100, 30);
  this.currentPriceLabel.setFont(f1);
  this.panel.add(currentPriceLabel);

   this.priceTF = new JTextField();
  this.priceTF.setBounds(160, 280, 150, 30);
this.priceTF.setFont(f1);
this.panel.add(priceTF);

this.detailsLabel = new JLabel("Details:");
this.detailsLabel.setBounds(50, 330, 100, 30);
this.detailsLabel.setFont(f1);
this.panel.add(detailsLabel);
this.deTf = new JTextField();
this.deTf.setBounds(160, 330, 150, 30);
this.deTf.setFont(f1);
this.panel.add(deTf);
this.addButton = new JButton("Add Cryptocurrency");
this.addButton.setBounds(350, 80, 180, 30);
this.addButton.setBackground(Color.MAGENTA);
this.addButton.addActionListener(this);
this.panel.add(addButton);

this.updateButton = new JButton("Update Cryptocurrency");
this.updateButton.setBounds(350, 130, 180, 30);
this.updateButton.setBackground(Color.MAGENTA);
this.updateButton.addActionListener(this);
this.panel.add(updateButton);


this.removeButton = new JButton("Remove Cryptocurrency");
this.removeButton.setBounds(350, 180, 180, 30);
this.removeButton.setBackground(Color.MAGENTA);
this.removeButton.addActionListener(this);
this.panel.add(removeButton);

this.resetButton = new JButton("Reset");
this.resetButton.setBounds(350, 230, 180, 30);
this.resetButton.setBackground(Color.MAGENTA);
this.resetButton.addActionListener(this);
this.panel.add(resetButton);

this.backButton = new JButton("Back");
this.backButton.setBounds(350, 280, 100, 30);
this.backButton.setBackground(Color.MAGENTA);
this.backButton.addActionListener(this);
this.panel.add(backButton);
          CryptocurrencyController cc = new CryptocurrencyController();
        Cryptocurrency[] cryptocurrenciesList = cc.getAllCryptocurrency();
        String cryptocurrenciesdata1[][] = new String[cryptocurrenciesList.length][6];
        for (int i = 0; i < cryptocurrenciesList.length; i++) {
            if (cryptocurrenciesList[i] != null) 
			{
                cryptocurrenciesdata1[i][0] = cryptocurrenciesList[i].getCryptoId();
                cryptocurrenciesdata1[i][1] = cryptocurrenciesList[i].getName();
                cryptocurrenciesdata1[i][2] = cryptocurrenciesList[i].getSymbol();
                cryptocurrenciesdata1[i][3] = cryptocurrenciesList[i].getCategory();
                cryptocurrenciesdata1[i][4] = String.valueOf(cryptocurrenciesList[i].getCurrentPrice());
                cryptocurrenciesdata1[i][5] = cryptocurrenciesList[i].getDetails();
            }
        }
		


        String header[] = {"Crypto ID", "Name", "Symbol", "Category", "Price", "Details"};
        this.cryptoTable = new JTable(cryptocurrenciesdata1, header);
        this.cryptoTableSP = new JScrollPane(cryptoTable);
        this.cryptoTableSP.setBounds(60,500,900,200);
		this.cryptoTable.setBackground(Color.GREEN);
		this.cryptoTable.getTableHeader().setBackground(Color.black);
		this.cryptoTable.getTableHeader().setForeground(Color.RED);
        this.cryptoTable.setFont(new Font("Arial", Font.PLAIN, 14));
        this.cryptoTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        this.cryptoTable.setEnabled(false);
        this.panel.add(cryptoTableSP);
        this.panel.revalidate();
        this.panel.repaint();
        this.add(panel);
		
		
    }


	  public void actionPerformed(ActionEvent ae)
	{

		String command=ae.getActionCommand();
		
			if(command.equals(addButton.getText()))
			{
              if(!cryTf.getText().isEmpty() && !nameTF.getText().isEmpty() &&!syTf.getText().isEmpty() && !catTf.getText().isEmpty() && !deTf.getText().isEmpty())
			  {
                
                CryptocurrencyController cry=new CryptocurrencyController();
			
                Cryptocurrency cryp=cry.searchCryptocurrency(cryTf.getText());
                 if(cryp!=null)
				 {
					JOptionPane.showMessageDialog(this, "Id is already used");
				 }

				 if (uer != null && uer.getRole() == 2) {
					JOptionPane.showMessageDialog(this,"Sorry You Cannot Add Coin");
				}
				

				 else
				 {
					String cryptoid=cryTf.getText();
					String name=nameTF.getText();
				

					String symbol = syTf.getText();
                   String category = catTf.getText();
                     double price = 0.0;
					try {
						price = Double.parseDouble(priceTF.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	 


                String details = deTf.getText();
					Cryptocurrency cr=new Cryptocurrency(cryptoid,name,symbol,price,details);
			
					cry.insertCryptocurrency(cr);
					JOptionPane.showMessageDialog(this,"Successfully Done");
					this.setVisible(false);
					CryptocurrencyFrame cf=new CryptocurrencyFrame();
					cf.setVisible(true);
				 }
			  } 
			  else
			  {
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			  }

			}

			if(command.equals(updateButton.getText()))
			{
				if(!cryTf.getText().isEmpty() && !nameTF.getText().isEmpty() &&!syTf.getText().isEmpty() && !catTf.getText().isEmpty() && !deTf.getText().isEmpty())
				{
				CryptocurrencyController cc = new CryptocurrencyController();
				Cryptocurrency cr=cc.searchCryptocurrency(cryTf.getText());

				  
				  if(cr!=null)
				  {
					String cryptoid=cryTf.getText();
					String name=nameTF.getText();
				

					String symbol = syTf.getText();
                   String category = catTf.getText();
                     double price = 0;
					try {
						price = Double.parseDouble(priceTF.getText());
					} 
					catch (NumberFormatException e)
					 {
						JOptionPane.showMessageDialog(this,"Price must be a valid double value");

					 }	

                String details = deTf.getText();
					cr.setCryptoId(cryptoid);
					cr.setName(name);
					cr.setCategory(category);
					cr.setCurrentPrice(price);
					cr.setDetails(details);

					JOptionPane.showMessageDialog(this, "Successfully Done");
					this.setVisible(false);
					CryptocurrencyFrame cry=new CryptocurrencyFrame();
					cry.setVisible(true);
					
				  }

				  else
				{
					JOptionPane.showMessageDialog(this,"Croypto not found");
				}
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(this,"Please fill up field properly");
			  }

		    }

			if(command.equals(removeButton.getText()))
			{
				if(!cryTf.getText().isEmpty())
				{
                  String cryptoId=cryTf.getText();
				  CryptocurrencyController cr=new CryptocurrencyController();
				  Cryptocurrency cryptocurrencies=cr.searchCryptocurrency(cryptoId);

				  if(cryptocurrencies!=null)
				  {
					cr.deleteCryptocurrency(cryptoId);
					JOptionPane.showMessageDialog(this, "Successfully Removed");
				     CryptocurrencyFrame cry=new CryptocurrencyFrame();
					this.setVisible(false);
					cry.setVisible(true);
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

		if(command.equals(resetButton.getText()))
			{
				 cryTf.setEditable(true);
				cryTf.setText("");
				nameTF.setText("");
				syTf.setText("");
				catTf.setText("");
				priceTF.setText("");
				deTf.setText("");
				
			}

			if(command.equals(backButton.getText()))
			{
			
				
				LoginFrame lo=new LoginFrame();
				this.setVisible(false);
				lo.setVisible(true);
			
            }
			
			
		}
		
	}














	