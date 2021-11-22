import java.util.regex.*;
/**
 * This Class determines the brand of a credit card, and it's a subclass of CreditCard Class.
 * Spring COSC-1437.83002
 * Final Project: Credit card numbers and the case of Mobius Duck
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 5.6.4
 */
public class CreditCardIssuer extends CreditCard
{
  private String issuerBank;// holds the name of the issuer bank 
  
  /**
   *This parameterized constructor passes the String value that is passed as an argument into the method to its super class's constructor.
    @param String input
    @return nothing
    @throw nothing implemented 
  */
  public CreditCardIssuer(String input){    
   super(input); // calls the superclass constructor
  }
  
  /**
   *This method returns the value of issuerBank field.
    @param none
    @return issuerBank
    @throw nothing implemented 
  */
  public String getIssuerBank(){
      return issuerBank;
  }//end of method
  
  /**
   *This method overrides its super class's isValid method. It determines the brand of a credit card number. It first, groups the brands based on their 
    starting digit to cut some time while processing  the given card number. Then it goes through the regular expressions and attempts to match the given 
    input against them. If any match occurs during the process, it stores the issuer bank's name into issuerBank field. Otherwise, found becomes false.
    At the end, the method returns the variable found.
    @param String s
    @return found
    @throw nothing implemented 
  */
  @Override
  public boolean isValid(String s){
     boolean found = true;
     String str = s.substring(0,1);
     switch(str){
       case "3": 
       if(Pattern.matches("35(2[89]|[3-8][0-9])[0-9]{12}",super.getDigits())){
             issuerBank = "JCB Card";  
             break; 
       }else if(Pattern.matches("3[47][0-9]{13}",super.getDigits())){
             issuerBank = "American Express Card"; 
             break; 
       }else if(Pattern.matches("30[1-5][0-9]{11}",super.getDigits())){
             issuerBank = "Diners Club - Carte Blanche Card";
             break; 
       }else if(Pattern.matches("36\\d{12}",super.getDigits())){
             issuerBank = "Diners Club - International Card"; 
             break; 
       }     
       case "4":
       if(Pattern.matches("4((0[2][6]|5[0][8]|8[4][4]|91[3|7])[0-9]{12})|(417500[0-9]{10})",super.getDigits())){
             issuerBank = "Visa Electron Card"; 
             break; 
       }else if(Pattern.matches("[4]\\d{12,15}",super.getDigits())){
             issuerBank = "Visa Card"; 
             break;                               
       }
       case "5":
       if(Pattern.matches("5[4][0-9]{14}",super.getDigits())){
            issuerBank = "Either Diners Club - USA&Canada " + 
                                    "or MasterCard "; 
            break;
       }else if(Pattern.matches("5[1-5][0-9]{14,17}",super.getDigits())){
            issuerBank = "MasterCard"; 
            break;
       }else if(Pattern.matches("5(0([13][8]|[2][0])|8[9][3])[0-9]{12,15}",super.getDigits())){
            issuerBank = "Maestro Card"; 
            break;
       }
       case "6":
       if(Pattern.matches("63[789][0-9]{13}",super.getDigits())){
           issuerBank = "InstaPayment Card"; 
           break;
       }else if(Pattern.matches("6(7([0][69]|[7][1]))[0-9]{12,15}",super.getDigits())){
           issuerBank = "Laser Card"; 
           break;
       }else if(Pattern.matches("6304[0-9]{12,15}",super.getDigits())){
           issuerBank = "Either Maestro or Laser Card";
           break;
       }else if(Pattern.matches("67(5[9]|6[1-3])[0-9]{12,15}",super.getDigits())){
           issuerBank = "Maestro Card";
           break;
       }else if(Pattern.matches("6(22(1[2][6-9]|[2-8][0-9][0-9]|9(1[0-9]|2[1-5]))[0-9]{10}|(011[0-9]{12})|(4[4-9][0-9]{13})|(5[0-9]{14}))",super.getDigits())){
           issuerBank = "Discover Card";
           break;
       } 
       default:
           found = false;
     }
    
     return found; 
  }// end of method
}// end of class

