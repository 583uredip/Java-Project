

package models;

public class Broker extends User {
    private double commissionRate;

    public Broker() {
        super();
    }
    public Broker(String userId, String name, String gender, String email, String phoneNo, int role, String securityAns, String password, double commissionRate) {
        super(userId, role, securityAns, password);
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phoneNo = phoneNo;
        this.commissionRate = commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public String toStringBroker() {
        return this.userId + "," + this.name + "," + this.gender + "," + this.email + "," + this.phoneNo + "," +
                this.role + "," + this.securityAns + "," + this.password + "," + this.commissionRate + "\n";
    }

    public static Broker fromBroker(String str) {
        String data[] = str.split(",");

        if (data.length < 9) {
            System.out.println("Error: Insufficient data to create Broker object.");
            return null;
        }

        try {
            Broker bro = new Broker();
            bro.setUserId(data[0]);
            bro.setName(data[1]);
            bro.setGender(data[2]);
            bro.setEmail(data[3]);
            bro.setPhoneNo(data[4]);
            bro.setRole(Integer.parseInt(data[5]));
            bro.setSecurityAns(data[6]);
            bro.setPassword(data[7]);

            
            if (!data[8].isEmpty()) {
                bro.setCommissionRate(Double.parseDouble(data[8])); 
            } else {
                System.out.println("Warning: Commission rate is empty. Setting to 0.0");
                bro.setCommissionRate(0.0);
            }

            return bro;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in data - " + e.getMessage());
            return null;
        }
    }
}








































































































































































