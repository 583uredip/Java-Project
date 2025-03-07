
package views;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeFrame extends JFrame implements ActionListener
{
    private JLabel titelLabel;
    private JLabel imgLabel;
    private JButton contriButton, enterButton, exiButton;
    private JPanel panel;
    private Color c1,c2;
    private Font f1;
    private ImageIcon img;

    public WelcomeFrame()
    {
        super("Welcome Page");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        c1 = new Color(226, 192, 1);
        c2=new Color(66, 183, 225);
        f1 = new Font("Cooper Black", Font.BOLD, 18);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);

        titelLabel = new JLabel("Welcome To Cryptocurrency");
        titelLabel.setBounds(250, 20, 350, 40);
        titelLabel.setFont(f1);
        titelLabel.setForeground(Color.RED);
        this.titelLabel.setBackground(c1);
        panel.add(titelLabel);

        
        img = new ImageIcon("C:\\Users\\HP\\Downloads\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\views\\Welcome.jpg.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(250, 80, 300, 200);
        panel.add(imgLabel);

        contriButton = new JButton("Contribution");
        contriButton.setBounds(50, 350, 200, 40);
        contriButton.setBackground(c2);
        contriButton.setForeground(Color.WHITE);
        contriButton.setFont(f1);
        contriButton.addActionListener(this);
        panel.add(contriButton);

        enterButton = new JButton("Enter");
        enterButton.setBounds(300, 350, 150, 40);
        enterButton.setBackground(c2);
        enterButton.setForeground(Color.WHITE);
        enterButton.setFont(f1);
        enterButton.addActionListener(this);
        panel.add(enterButton);

        exiButton = new JButton("Exit");
        exiButton.setBounds(550, 350, 150, 40);
        exiButton.setFont(f1);
        exiButton.setBackground(c2);
        exiButton.setForeground(Color.WHITE);
        exiButton.addActionListener(this);
        panel.add(exiButton);

        this.add(panel);

        new Thread(() -> {
            while (true) {
                try {
                    titelLabel.setVisible(false);
                    Thread.sleep(500);
                    titelLabel.setVisible(true);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == enterButton)
         {
            LoginFrame lo = new LoginFrame();
            lo.setVisible(true);
            this.setVisible(false);
        } 
        else if (e.getSource() == exiButton) 
        {
            System.exit(0);
        } 
        else if (e.getSource() == contriButton) 
        {
            JOptionPane.showMessageDialog(this, "Contribution Section Coming Soon!");
        }
    }

   
}