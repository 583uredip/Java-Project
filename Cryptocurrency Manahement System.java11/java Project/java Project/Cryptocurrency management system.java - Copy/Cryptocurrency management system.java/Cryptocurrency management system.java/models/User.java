
package models;
import java.lang.*;

public class User {
    protected String userId;
    protected String name;
    protected String gender;
    protected String email;
    protected String phoneNo;
    protected int role;
    protected String securityAns;
    protected String password;


    public User() {
    }


    public User(String userId, int role, String securityAns, String password) {
        this.userId = userId;
        this.role = role;
        this.securityAns = securityAns;
        this.password = password;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return this.role;
    }

    public void setSecurityAns(String securityAns) {
        this.securityAns = securityAns;
    }

    public String getSecurityAns() {
        return this.securityAns;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String toStringUser() {
        return this.userId + "," + this.role + "," + this.securityAns + "," + this.password + "\n";
    }

    public static User fromUser(String str) {
        String[] data = str.split(",");
        if (data.length < 4) {
            System.out.println("Error: Input data is not in the correct format!");
            return null;
        }

        try {
            User u = new User();
            u.setUserId(data[0]);

        
            u.setRole(Integer.parseInt(data[1]));

            u.setSecurityAns(data[2]);
            u.setPassword(data[3]);

            return u;
        } catch (NumberFormatException e) {
            System.out.println("Error: Role must be a valid integer! " + e.getMessage());
            return null; 
        }
    }
}































































































































































































   /* public User fromUser(String str)
     {
        String[] data = str.split(",");
        User u = new User();
        try
         {
            u.setUserId(data[0]);
            u.setRole(Integer.parseInt(data[1]));
            u.setSecurityAns(data[2]);
            u.setPassword(data[3]);
        } 
        catch (NumberFormatException e)
         {
            System.out.println("Invalid number format in role: " + data[1]);
        }
        return u;
    }
    



}
*/