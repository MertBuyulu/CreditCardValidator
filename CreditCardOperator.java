/**
 * This Class makes some operations on a credit card number, and it's a subclass of CreditCard Class.
 * Spring COSC-1437.83002
 * Final Project: Credit card numbers and the case of Mobius Duck
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 6.5.8
 */
public class CreditCardOperator extends CreditCard
{
  private int rightMostDigit; // holds the last digit of credit cart number before all the operations being done to that number.
  
  /**
   *This parameterized constructor passes the String value that is passed as an argument into the method to its super class's constructor, and it initializes
    the rightMostDigit field to 0.
    @param String input
    @return nothing
    @throw nothing implemented 
  */
   public  CreditCardOperator(String input){
    super(input);
    rightMostDigit = 0;
  }// end of method
  
  /**
   *This method returns the value of rightMostDigits field.
    @param none
    @return rightMostDigits
    @throw nothing implemented 
  */
   public int getRightMostDigit(){
       return rightMostDigit;
  }// end of method
  
  /**
   *This method demostrates deleting the last digit of the given credit card number, and store the last digits of the number into rightMostDigit field.
    At the end, it updates the value of the number by sending the updated version of it to its super class's setDigits method.
    @param none
    @return nothing
    @throw nothing implemented 
  */
  public void removeDigit(){ //Step #1
    String object = super.getDigits();
    StringBuilder str = new StringBuilder(object);
    rightMostDigit = Integer.parseInt(str.substring(str.length()-1));
    str.deleteCharAt(str.length() - 1);
    super.setDigits(str.toString());
  }//end of method
  
  /**
   *This method demostrates reversing the digits of a credit card number, then it updates the value of the number by sending the updated version of it to 
    its super class's setDigits method.
    @param none
    @return nothing
    @throw nothing implemented 
  */
  public void reverse(){// Step #2
    StringBuilder str = new StringBuilder();
    char[] array; 
    array = super.getDigits().toCharArray();
    int middle = array.length/2, i = 0, j = array.length - 1;
    while(i < middle){
      char start = array[i]; // char variable that holds the value of the array at index i before i get updated.
      array[i] = array[j];
      array[j] = start;
      i++;
      j--;
    }
    super.setDigits(str.append(array).toString());
  }// end of method     
  
  /**
   *This method demostrates multiplying the odd index digits of the updated credit card number by 2 and if the value of the digits at the odd index after 
    multiplying is bigger than 9 then the method substracts 9 from the value of the digits an store it in StringBuilder object. At the end, it updates 
    the value of the number by sending the updated version of it to its super class's setDigits method.
    @param none
    @return nothing
    @throw nothing implemented 
  */
  public void multiplyOddDigits(){ //steps #3&4
    char[] array;
    array = super.getDigits().toCharArray();
    StringBuilder str = new StringBuilder();
    int num,num2;
    if(array.length%2 == 0){ // if the length is even.
      for(int i = 0 ; i < array.length; i += 2){
         int oddDigit = Integer.parseInt(String.valueOf(array[i]));
         num = oddDigit * 2;
         if(num > 9){
            num -= 9; 
         }
         str.append(num);
         int evenDigit = Integer.parseInt(String.valueOf(array[i+1]));
         str.append(evenDigit);
      }
      
    }else{ // if the length is odd.
      for(int i = 0 ; i < array.length; i += 2){
        int oddDigit = Integer.parseInt(String.valueOf(array[i]));
        num2 = oddDigit * 2;
        if(num2 > 9){
           num2 -= 9; 
        }
        str.append(num2);
        if(i != array.length-1){
         int evenDigit = Integer.parseInt(String.valueOf(array[i+1]));
         str.append(evenDigit);
        }else{
         break;
        }      
      }     
    }
    super.setDigits(str.toString());// updates the value of digits field. 
  }// end of method
 
  /**
   *This method adds all the digits of the updated credit card number and stores them in an accumulator called total. At the end, it updates the value of 
   the number by sending the sum of its digits to its super class's setDigits method.
    @param none
    @return nothing
    @throw nothing implemented 
  */
  public void addDigits(){ // step#5
     int total = 0; //accumulator
     StringBuilder str = new StringBuilder();
     char[] array = super.getDigits().toCharArray();
     // enhanced for loop for the requirement of at least one used.
     for(char c : array){
         total += Integer.parseInt(String.valueOf(c));
     }
     str.append(total);
     super.setDigits(str.toString()); // updates the value of digits field
  }// end of method

  /**
   *This method overrides its super class's isValid method. It determines if the credit card number is valid or not after all the modifications being done
    to it. The way it works is that if the sum of all the digits of final credit card number plus the digit that was removed during the first step is divisible
    by 10, then it is a valid card and found becomes true. Otherwise, found stays false. At the end, the method returns the variable found.
    @param String str
    @return boolean found
    @throw nothing implemented 
  */
  @Override
  public boolean isValid(String str){ //step #6
     boolean found = false; // flag variable
     int num = Integer.parseInt(str); // num contains the String number that's in the str as an integer data type. 
     if(Math.floorMod((Math.abs(num+rightMostDigit)),10) == 0){
          found = true;
     }
     return found;
  }// end of method
}// end of class
