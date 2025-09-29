/**
 * MagpieRunner3.java
 * A program to carry on conversations with a human user.
 * Create a Magpie3, give it user input, and print its replies.
 */

import java.util.Scanner;       
public class MagpieRunner3            
{   
   public static void main(String[] args)
   {
      Magpie3 maggie = new Magpie3();  		
      String greeting = maggie.getGreeting();                                                 
      System.out.println(greeting);
      Scanner in = new Scanner (System.in); 
      String statement = in.nextLine();       
		
      while (!statement.equals("Bye"))       
      {
         String response = maggie.getResponse(statement);                    
         System.out.println(response);         
         statement = in.nextLine();        
      }
      System.out.println("Thank you for the conversation. Have a nice day.");
      in.close();
   }
}
