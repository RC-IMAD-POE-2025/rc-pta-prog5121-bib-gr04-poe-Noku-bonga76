/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    User registeredUser;
    
    public boolean checkUserName(String username){
        return username.contains("_")&& username.length()<=5;
    }
    
    public boolean checkPasswordComplexity(String password){
        return password.length()>=8 &&
               password.matches(".*[A-Z].*")&&
               password.matches(".*[0-9].*")&&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }   
    
    public boolean checkCellPhoneNumber(String phoneNumber){
        return phoneNumber.matches("^\\+\\d{1,3}\\d{10}$");
    }
    
    public String registerUser(String username,String password,String phoneNumber){
        
        if (!checkUserName(username)){
            return"Username is not correctly formatted, please ensure username contains an underscore amd is no more than five characters long.";
        }
        
        if(!checkPasswordComplexity(password)){
            return"Password is not correctly formatted,please ensure that the password contains at least eight characters,a capital letter,a number, and a special character.";
        }
        
        if(!checkCellPhoneNumber(phoneNumber)){
            return"Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        
        registeredUser = new User(username,password,phoneNumber);
        return"User successfully registered.";      
}
    public boolean loginUser(String username, String password){
        return registeredUser !=null &&
               registeredUser.getUsername().equals(username)&&
               registeredUser.getPassword().equals(password);
    }
    
    public String returnLoginStatus(boolean success, String firstName, String lastName){
        if(success){
            return"welcome" +firstName + " " + lastName + ",it is great to see you.";
        } else {
            return"Username or passowrd incorrect, please try again.";
        }
        }
    }
