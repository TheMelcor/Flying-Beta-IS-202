/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author Melcor
 */
public class UserDataModel implements java.io.Serializable{
    int UserId;
    String FirstName;
    String LastName;
    String Email;
    UsrRoleDataModel UserRole;
    String Password;
    
    public UserDataModel(){
        
    }
    
    public UserDataModel(String fname, String lname, String email, UsrRoleDataModel urole, String pword){
        this.FirstName = fname;
        this.LastName = lname;
        this.Email = email;
        this.UserRole = urole;
        this.Password = pword;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getFirstName(){
        return FirstName;
    }
    
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    
    public String getLastName(){
        return LastName;
    }
    
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    
    public String getFullName(){
        return FirstName + " " + LastName;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }

    public UsrRoleDataModel getUserRole() {
        return UserRole;
    }

    public void setUserRole(UsrRoleDataModel UserRole) {
        this.UserRole = UserRole;
    }
    
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String Password){
        this.Password = Password;
    }

}
