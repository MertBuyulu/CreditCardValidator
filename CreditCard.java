/**
 * This Class represents a credit card number.
 * Spring COSC-1437.83002
 * Final Project : Credit card numbers and the case of Mobius Duck 
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 2.1.2
 */
public class CreditCard
{
  private String digits; //field
  
  /**
   *This no arg constructor initializes digits field to empty string.
    @param input
    @return nothing
    @throw nothing implemented 
  */
  public CreditCard(){
      digits = "";
  }
  
  /**
   *This parameterized constructor accepts string as an argument, and calls and passes the String variable to the setDigits methods to update the value of digits     field.
    @param String digits
    @return nothing
    @throw nothing implemented 
  */
  public CreditCard(String digits){
    setDigits(digits);
  }
  
  /**
   *This method returns the value of digits field.
    @param input
    @return digits
    @throw nothing implemented 
  */
  public String getDigits(){
      return digits;
  }
  
  /**
   *This method sets the value of digits field with all leading and trailing whitespaces have been deleted if there is any to the string variable that is passed into     the method as an argument.
    @param String digits
    @return nothing
    @throw nothing implemented 
  */
  public void setDigits(String digits){
        this.digits = digits.trim();
      }
  
  /**
   *This method returns true if the String argument is not equal to empty String; otherwise it returns false.
    @param String str
    @return true/false
    @throw nothing implemented 
  */
  public boolean isValid(String str){
   return(str.equals(""))?false:true;
  }
}
