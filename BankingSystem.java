package bankingsystem;

import java.util.Scanner;  // needed for Scanner class

class Account{
    float balance;  // An instance variable to store balance
    Account(float a){  // Parameterized constructor 
        balance=a;  
    } // account constructor 
    
    float Credit(float b){
        balance+=b; // Amount will be added in balance 
        return balance;
    }//credit
    
    void debit(int a){
        int debitAmmount=a;  // Amount which will be withdraw
        
        if(balance>debitAmmount){
             balance-=debitAmmount;  // Withdrawing money from the balance 
        }//if
        else{
            System.out.println(" ERROR : Your balance " + balance + " is less than " + debitAmmount+ " so try again "); //error message 
        }//else
       
    }//debit
}// account class

class SavingAccount extends Account{
    float interest,k;   // Declare an instance variable name as interest
    SavingAccount(float h){  // Constructor
        super(h);  // This will call super class constructor (balance variable).
        interest=5;  // It's in percentage(%).
    }  // SavingAccount constructor
    
    public float calculateInterest(int o){
        //  FORMULA  ******* A = P(1 + rt) ********
        //  A = Total Accrued Amount (principal + interest)
        //  P = Principal Amount
        //  r = Rate of Interest per year in decimal. (r=R/100) .It should not be in percentage(%).
        //  t = Time Period involved in months or years
        //  Note that rate r and time t should be in the same time units such as months or years. 
        
        int time=o; //insertting time value
        interest/=100; //converting percentage into decimal.
        float c=1+interest*time; //putting values in the formula 
        float calculateInterest=balance*c; //putting values in the formula 
        float profit=calculateInterest-balance;
        k=profit;
        return profit;
    }// calculate calculateInterest
    
}//SavingAccount


class CheckingAccount  extends Account{
     int TransactionFee;   // Declare an instance variable name as TransactionFee
    CheckingAccount (float h){    // Constructor
         super(h);      // This will call super class constructor (balance variable).
         TransactionFee=10;  // It's in decimal.
     }  //constructor  CheckingAccount 
    
    void Credit(int b){  // function overridding 
        balance+=b; // Amount will be added in balance 
        balance-=TransactionFee;
    }//credit
    
    
    void debit(int o){ // function overridding 
        int debitAmmount=o;  // Amount which will be withdraw
        
        if(balance>debitAmmount){
             balance-=debitAmmount;  // Withdrawing money from the balance 
             balance-=TransactionFee; // Transaction Fee will be cut
        }//if
        else{
            System.out.println(" ERROR : Your BALANCE " + balance + " is less than " + debitAmmount+ " so try again "); //error message 
        }//else
       
    }//debit
     
}//class CheckingAccount 

public class BankingSystem { //main class
    static  int z,y,x,t,i,j=0,p; //declare static variables
    static float  PermenentBalance;
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in); // Making a default class object named as (input)
        // Following displaying account type menu     
        System.out.println(" 1:- SAVING ACCOUNT");
        System.out.println(" 2:- CHECKING ACCOUNT ");
        System.out.println("**********************************************************");
        System.out.print(" ENTER YOU ACCOUNT TYPE : ");
        z=input.nextInt();
        
        System.out.println(" ENTER YOUR 4 DIGIT PIN :                                //1234// "); // Asking for pin(1234)
        y=input.nextInt();// Entering pin
        System.out.println(""); // just for extra space
        
        
        if(y==1234){  //if pin is correct 
            do{
                if(z==1){
                    //display saving account is open 
                    System.out.println("");
                    System.out.println("                  ************************");
                    System.out.println("                  *                      *");
                    System.out.println("                  *     SAVING ACCOUNT   *");
                    System.out.println("                  *                      *");
                    System.out.println("                  ************************");
                    System.out.println("");
        
                }//if
                else if(z==2){
                    //display checking account
                    System.out.println("");
                    System.out.println("                  ************************");
                    System.out.println("                  *                      *");
                    System.out.println("                  *   CHECKING ACCOUNT   *");
                    System.out.println("                  *                      *");
                    System.out.println("                  ************************");
                    System.out.println("");
                }//else if
                
                j-=-1;// increment in j value
                if(j==1){ //it will run only one time process
                    PermenentBalance=1000; //Intialis the balance with 1000
                }//if
                
            switch(z){
                case 1:{
                    SavingAccount save =new SavingAccount(PermenentBalance); // Making object of SavingAccount class
                    
                              //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                    BALANCE = "+ save.balance );// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                                         
                    //Displaying menu 
                     System.out.println("1:- TO INSERT BALANCE ");
                     System.out.println("2:- TO WITHDRAW BALANCE ");
                     System.out.println("3:- TO CHECK INTREST ON BALANCE ");
                     System.out.println("**********************************************************");
                     System.out.print(" ENTER YOUR OPERATION  : ");
                     x=input.nextInt();
                     System.out.println(""); // just for extra space
                      
                     switch(x){
                         case 1:{
                             System.out.print(" ENTER THE MONEY YOU WANT TO INSERT : "); // asking user cridit amount 
                             i=input.nextInt();
                             save.Credit(i);// running the credit methord
                             
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                    BALANCE = "+ save.balance );// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                               
                              PermenentBalance=save.balance;//this logic will save balance to permenent balance
                             break;
                         }//case 1
                         
                         case 2:{
                             System.out.print(" ENTER THE MONEY YOU WANT TO WITHDRAW : "); // asking user WITHDRAW amount 
                             i=input.nextInt();
                             save.debit(i);// running the DEBIT methord
                             
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                   CURRENT BALANCE = "+ save.balance );// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                               
                              PermenentBalance=save.balance; //this logic will save balance to permenent balance
                             break;
                         }//case 2
                         
                         case 3:{
                             System.out.println(" ACCOUDING TO OUT BANK POLICE YEARLY INTEREST RATE IS 5%"); // displaying bank policy
                             System.out.print(" ENTER TIME PERIOD INVOLVED IN YEARS ");
                             t=input.nextInt();
                             System.out.println(" YOUR INTEREST IS : " + save.calculateInterest(t) ); // displaying and calling interet by methord
                             float q=save.k;
                             
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                     NEW BALANCE = "+  save.Credit(q) );// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                               
                             PermenentBalance= save.Credit(q)-q; //this logic will save balance to permenent balance 
                             break;
                         }//case 3
                         
                         default:{ 
                               System.out.println(" YOU SELECT INVALID OPTION ");
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                     NEW BALANCE = "+  save.balance);// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                               
                         }//default
                         
                     }//inner switch
                     break;
                }//case 1
                
                case 2:{
                    CheckingAccount check=new CheckingAccount(PermenentBalance);
                    
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                    CURRENT BALANCE = "+ check.balance);// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                               
                     
                    //Displaying menu 
                     System.out.println("1:- TO INSERT BALANCE ");
                     System.out.println("2:- TO WITHDRAW BALANCE ");
                     System.out.println("**********************************************************");
                     System.out.print(" ENTER YOUR OPERATION  : ");
                     x=input.nextInt();
                     System.out.println(""); // just for extra space
                     switch(x){
                         case 1:{
                             System.out.print(" ENTER THE MONEY YOU WANT TO INSERT : "); // asking user cridit amount 
                             i=input.nextInt();
                             check.Credit(i);
                             System.out.println(" OUR BANK CHARGES 10RS FEE FOR EVERY TRANSACTION"); // BANK POLICY
                             
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                    CURRENT BALANCE = "+ check.balance);// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                             
                             PermenentBalance= check.balance; //this logic will save balance to permenent balance 
                             break;
                         }//case 1
                         
                         case 2:{
                             System.out.print(" ENTER THE MONEY YOU WANT TO WITHDRAW : "); // asking user WITHDRAW amount 
                             i=input.nextInt();
                             check.debit(i);
                             
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                    CURRENT BALANCE = "+ check.balance);// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                             
                             PermenentBalance= check.balance; //this logic will save balance to permenent balance 
                             break;
                         }//case 2
                         
                         default:{
                             System.out.println("  YOU SELECT AN INVALID OPTION  ");
                             
                             //display account balance 
                               System.out.println("");
                               System.out.println("                  ************************");
                               System.out.println("                    CURRENT BALANCE = "+ check.balance);// displaying
                               System.out.println("                  ************************");
                               System.out.println("");
                               
                     
                         }//case 1
                         
                         
                     }//inner switch
                    break;
                }//case 2
                
                default : {
                    System.out.println("  YOU SELECT AN INVALID OPTION  ");
                }//default
            }//switch 
            System.out.println("");//just for extra space
            System.out.print(" IF YOU WANT TO CONTINUE PRESS 1 : "); // IF WONT TO CONTINUE
            p=input.nextInt();
            System.out.println("");//just for extra space
            System.out.println("**********************************************************");//decoration
            System.out.println("**********************************************************");//decoration
            System.out.println("");//just for extra space
            System.out.println("");//just for extra space
            }while(p==1);
        }//if
        else{
            System.out.println("YOU ENTER AN INVALID PIN "); // PIN NOT CORRECT
        }
    }//main methor
    
}//BankingSytem class
