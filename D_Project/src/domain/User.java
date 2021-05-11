
package domain;
import java.sql.Date;

public class User {
   int usernum; // primary key
   String usertype;
   String userid;
   String username;
   String password;
   String email;
   String tel;
   String address;
   public int getUsernum() {
      return usernum;
   }
   public void setUsernum(int usernum) {
      this.usernum = usernum;
   }
   public String getUsertype() {
      return usertype;
   }
   public void setUsertype(String usertype) {
      this.usertype = usertype;
   }
   public String getUserid() {
      return userid;
   }
   public void setUserid(String userid) {
      this.userid = userid;
   }
   public String getUsername() {
      return username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   
   public User(int usernum, String usertype, String userid, String username, String password,
         String email, String tel, String address) {
      //super();
      this.usernum = usernum;
      this.usertype = usertype;
      this.userid = userid;
      this.username = username;
      this.password = password;
      this.email = email;
      this.tel = tel;
      this.address = address;
   }

   
}