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
    int UserRole;
    String Password;
    
    UserDataModel(int uid, String fname, String lname, String email, int urole, String pword){
        this.UserId = uid;
        this.FirstName = fname;
        this.LastName = lname;
        this.Email = email;
        this.UserRole = urole;
        this.Password = pword;
    }
    
    public int getId(){
        return UserId;
    }
    
    public void setId(int id){
        this.UserId = id;
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
    
    public int getRole(){
        return UserRole;
    }
    
    public void setRole(int UserRole){
        this.UserRole = UserRole;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String Password){
        this.Password = Password;
    }

}
