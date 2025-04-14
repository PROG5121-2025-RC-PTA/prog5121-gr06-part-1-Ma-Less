/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class AppMain {
    public static void main(String[] args) {
        Login login = new Login();
        
        //Registration
        System.out.println( "=== User Registration ===");
        login.registerUser();
        
        //Login
        System.out.println("\n=== User Login ===");
        boolean loginSuccess = login.loginUser();
        
        //Welcome Message Displayed
        if (loginSuccess) {
            System.out.println(
                login.returnLoginStatus(
                login.getRegisteredUsername(),
                    login.getRegisteredPassword()
                )
            );
        }
    }
}
