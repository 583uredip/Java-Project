
  package models;
  import java.lang.*;
  
  public class Admin extends User {
      private String adminType;
  
      public Admin() {
          super();
      }
  
      public Admin(String userId, String name, String gender, String email, String phoneNo, int role, String securityAns, String password, String adminType) {
          super(userId, role, securityAns, password);
          this.name = name;
          this.gender = gender;
          this.email = email;
          this.phoneNo = phoneNo;
          this.adminType = adminType;
      }
  
      public void setAdminType(String adminType) {
          this.adminType = adminType;
      }
  
      public String getAdminType() {
          return this.adminType;
      }
  
      public String toStringAdmin() {
          return this.userId + "," + this.name + "," + this.gender + "," + this.email + "," + this.phoneNo + "," + this.role + "," + this.securityAns + "," + this.password + "," + this.adminType + "\n";
      }
  
      public Admin formAdmin(String str)
       {

          if (str == null || str.isEmpty()) {
              System.out.println("Error: Input data is empty or null!");
              return null;
          }
  
          String data[] = str.split(",");
  
          // চেক করি ইনপুট ডাটা ঠিক আছে কিনা
          if (data.length < 9) { // 9 টা ফিল্ড থাকা লাগবে
              System.out.println("Error: Insufficient data to create Admin object! Data length: " + data.length);
              return null;
          }
  
          Admin ad = new Admin();
          try
           {
              ad.setUserId(data[0]);
              ad.setName(data[1]);
              ad.setGender(data[2]);
              ad.setEmail(data[3]);
              ad.setPhoneNo(data[4]);
              ad.setRole(Integer.parseInt(data[5])); 
              ad.setSecurityAns(data[6]);
              ad.setPassword(data[7]);
              ad.setAdminType(data[8]); 
          }
          catch (NumberFormatException e) 
          {
              System.out.println("Error: Invalid number format! " + e.getMessage());
              return null;
          }
  
          return ad;
      }
  }
  





































































  
  