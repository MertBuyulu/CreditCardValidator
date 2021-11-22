import java.util.ArrayList;
/**
 * This Class uses the Luth algorithm to evaluate a credit card number. It also gets the issuer banks for every possible credit card number.
 * Spring COSC-1437.83002
 * Final Project: Credit card numbers and the case of Mobius Duck
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 4.3.9
 */
public class LuthMethod
{
  private ArrayList<String> validNumbers = new ArrayList<>();
  private ArrayList<String> invalidNumbers = new ArrayList<>();
  private ArrayList<String> dataGiven = new ArrayList<>();
  private ArrayList<String> issuerValid = new ArrayList<>();
  private ArrayList<String> issuerInvalid = new ArrayList<>(); 
  
  /**
   *This parameterized constructor accepts String arraylist as an argument. It first, checks for input validation and if there's an invalid element in the
    arraylist that's passed to the method as an argument the method  throws an exception based on the problem with the entry. If the elements of 
    dataGiven array is all valid. It then, copies the contents of the arraylist into the dataGiven arraylist field one by one.
    @param ArrayList<String> dataGiven
    @return nothing
    @throw EmptyLineException
    @throw InvalidDigitException
  */
  public LuthMethod(ArrayList<String> dataGiven) throws EmptyLineException,InvalidDigitException{ 
    for(int i = 0; i < dataGiven.size(); i++){
     if(dataGiven.get(i).equals("")){
     throw new EmptyLineException();
     }
     
     if(validDigits(dataGiven.get(i).trim())){
      String str = dataGiven.get(i);
      this.dataGiven.add(str);
     } 
    }
  }
  
  /**
   *This method accepts an CreditCard class's object as an argument, and returns the value of CreditCard class's digits field. It's useful for the
    cardEvaluater method of this class.
    @param CreditCard card
    @return card.getDigits()
    @throw nothing implemented 
  */
  public String showDigits(CreditCard card){ //shows polymorphism concept
      return card.getDigits();
  }// end of method
  
  /**
   *This method first determines, if a credit card number is made up or not. If yes, then it stores the number in madeupNumbers arraylist field at index i. Otherwise, it uses Luth method to determine if the number is valid or not. If the card number is valid, then it stores the card number in validNumbers
    arraylist field and its brand in issuerValid array list field at index i. If not, it stores the card number in invalidNumber arraylist field and
    its brand in issuerInvalid arraylist field at index i. This process lasts until there's no more credit card numbers to evaluate. 
    @param none
    @return none
    @throw nothing implemented 
  */
  public void cardEvaluater(){       
     for(int i = 0; i < dataGiven.size(); i++){
        CreditCardIssuer issuer = new CreditCardIssuer(dataGiven.get(i));
        if(issuer.isValid(showDigits(issuer))){
          CreditCardOperator operator = new CreditCardOperator(dataGiven.get(i));
          operator.removeDigit();
          operator.reverse();
          operator.multiplyOddDigits();
          operator.addDigits();
          if(operator.isValid(showDigits(operator))){
          validNumbers.add(showDigits(issuer));
          issuerValid.add(issuer.getIssuerBank());
          }else{
          invalidNumbers.add(showDigits(issuer));
          issuerInvalid.add(issuer.getIssuerBank());
          }  
        }
     }
  }// end of method
  // getters..
  /**
   *This method accepts an integer as an argument, and returns the value of validNumbers arraylist for the given index.
    @param int i
    @return validNumbers.get(i)
    @throw nothing implemented 
  */
  public String getValidNumbers(int i){
      return validNumbers.get(i);    
  }// end of method
  
  /**
   *This method accepts an integer as an argument, and returns the value of invalidNumbers arraylist for the given index.
    @param int i
    @return invalidNumbers.get(i)
    @throw nothing implemented 
  */
  public String getInvalidNumbers(int i){
      return invalidNumbers.get(i);    
  }// end of method
  
  /**
   *This method accepts an integer as an argument, and returns the value of issuerValid arraylist for the given index.
    @param int i
    @return issuerValid.get(i)
    @throw nothing implemented 
  */
  public String getIssuerValid(int i){
     return issuerValid.get(i);   
  }// end of method
  
  /**
   *This method accepts an integer as an argument, and returns the value of issuerInvalid arraylist for the given index.
    @param int i
    @return issuerInvalid.get(i)
    @throw nothing implemented 
  */
  public String getIssuerInvalid(int i){
    return issuerInvalid.get(i);   
  }// end of method
  
  /**
   *This method returns the size of validNumbers arraylist field.
    @param none
    @return validNumbers.size()
    @throw nothing implemented 
  */
  public int validSize(){
      return validNumbers.size();
  }// end of method
  
  /**
   *This method accepts an integer as an argument, and returns the value of validNumbers arraylist for the given index.
    @param none
    @return invalidNumbers.size()
    @throw nothing implemented 
  */
  public int invalidSize(){
      return invalidNumbers.size();
  }// end of method
  
  /**
   *This method determines if the given credit card number has all digits or not. If yes, the method returns found as true. Otherwise, it return found as
   false.
    @param String str
    @return found
    @throw InvalidDigitException
  */
  public boolean validDigits(String str) throws InvalidDigitException{
   boolean found = true;
   char[] array = str.toCharArray();
   for(int i = 0; i < array.length; i++){
      if(!Character.isDigit(array[i])){
          found = false;
          throw new InvalidDigitException();
      }   
   }
    return found;    
  }// end of method
}// end of class