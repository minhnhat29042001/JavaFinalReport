/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author Admin
 */
public class Splash_Backend {
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
     SplashScreen splash = new SplashScreen();
     splash.setVisible(true);
     Login_Screen login = new Login_Screen();
     try{
         for (int i = 0; i <= 100; i++) {
             Thread.sleep(10);
             splash.loadingnum.setText(Integer.toString(i)+"%");
             splash.loadingbar.setValue(i);
             if(i==100){
                 splash.dispose();
                 login.setVisible(true);
             }
         }
     } catch (Exception e){
         
     }
    }
    
    
}
