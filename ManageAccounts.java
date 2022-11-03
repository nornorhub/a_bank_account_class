// ****************************************************************

//   ManageAccounts.java

//

//   Use Account class to create and manage Sally and Joe's

//   bank accounts      

// ****************************************************************



package account;

import java.util.*;

public class ManageAccounts {

    public static void main(String[] args) {
        
      Scanner scan = new Scanner(System.in);
      System.out.println("First Account name: ");
      String accName1 = scan.nextLine();
      System.out.println("First Accout Balance: " );
      double balance1 = scan.nextDouble();
      
      System.out.println("Second Account name: ");
      String accName2 = scan.nextLine();
      System.out.println("Second Accout Balance: " );
      double balance2 = scan.nextDouble();

      Account acct1, acct2;

      //create account1 for Sally with $1000

      acct1 = new Account(balance1, accName1, 1);
 
      //create account2 for Joe with $500

      acct2 = new Account(balance2, accName2, 2);
      
      System.out.println("Which account are you using? " + accName1 +"(1) or " + accName2 + "(2)");
      Account acct;
      if (scan.nextInt() == 1) {
          acct = acct1;
      } else {
          acct = acct2;
      }
      
      int x = 0;
      while (x != 5) {
          System.out.print("Options: \n1. Make a deposit\n" +
            "\n" +
            "      2. Make a withdrawal  (every withdrawal should add the fee)\n" +
            "\n" +
            "         3. Print out account details\n" +
            "\n" +
            "         4. Change the name on the account\n" +
            "\n" +
            "         5. Quit");
          x = scan.nextInt();
          
          if (x == 1) {
              System.out.println("How much: ");
              double deposit = scan.nextDouble();
              acct.deposit(deposit);
          } else if (x == 2) {
              System.out.println("How much: ");
              double withdrawal = scan.nextDouble();
              acct.withdraw(withdrawal);
              acct.chargeFee();
          } else if (x == 3) {
              System.out.println(acct);
          } else if (x == 4) {
              System.out.println("New name: ");
              String newName = scan.nextLine();
              acct.changeName(newName);
          }
      }
      
      //deposit $100 to Joe's account

      acct2.deposit(100);

      //print Joe's new balance (use getBalance())

      System.out.println(acct2.getBalance());

      //withdraw $50 from Sally's account

      acct1.withdraw(50);

      //print Sally's new balance (use getBalance())

      System.out.println(acct1.getBalance());

      //charge fees to both accounts

      System.out.println("Sally's balance after fee: " + acct1.chargeFee());
      System.out.println("Joe's balance after fee: " + acct2.chargeFee());

      //change the name on Joe's account to Joseph

      acct2.changeName("Joseph");

      //print summary for both accounts
      
      System.out.println(acct1.toString());
      System.out.println(acct2.toString());

    }

}
