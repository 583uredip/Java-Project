package models;
import java.lang.*;

public class Client extends User
 {
    private double walletBalance;

    public Client()
    {
        super();
    }

    public Client(String userId,String name,String gender,String email,String phoneNo,int role,String securityAns,String password,double walletBalance)
    {
        super(userId,role,securityAns,password);
        
            this.name=name;
            this.gender=gender;
            this.email=email;
            this.phoneNo=phoneNo;
            this.walletBalance=walletBalance;
    }

    public void setWalletBalance(double walletBalance)
    {
        this.walletBalance=walletBalance;
    }
    public double getWalletBalance()
    {
        return this.walletBalance;
    }

    public String toStringClient()
    {
        String str=this.userId+","+this.name+","+this.gender+","+this.email+","+this.phoneNo+","+this.role+","+this.securityAns+","+this.password+","+this.walletBalance+"\n";
        return str;
    }

   

    public Client fromClient(String str) {
        String[] data = str.split(",");
        if (data.length < 9) {
            System.out.println("Insufficient data to create Client object");
            return null;
        }
    
        Client cl = new Client();
        try {
            cl.setUserId(data[0]);
            cl.setName(data[1]);
            cl.setGender(data[2]);
            cl.setEmail(data[3]);
            cl.setPhoneNo(data[4]);
            cl.setRole(Integer.parseInt(data[5]));
            cl.setSecurityAns(data[6]);
            cl.setPassword(data[7]); 
            cl.setWalletBalance(Double.parseDouble(data[8]));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
            return null;
        }
    
        return cl;
    }

}



















































































































































































































  