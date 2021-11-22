/**
 *This Class is a subclass of Exception class. InvalidDigitException is thrown by the LuthMethod class when a number that contains invalid digits 
  is passed to the constructor.
 * Spring COSC-1437.83002
 * Final Project: Credit card numbers and the case of Mobius Duck
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 1.0.1
 */
public class InvalidDigitException extends Exception{
  /**
   *This constructor calls its super class's constructor and pass a string message to it.
    @param none
    @return nothing
    @throw nothing implemented 
  */
    public InvalidDigitException()
    {
        super("Credit card number can't contain letters or keyboard sysmbols and have space between its digits.\n" +
              "Please check your file and make sure that you don't have these stuff with any numbers in your file.");       
    }
}
