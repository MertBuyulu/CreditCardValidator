/**
 *This Class is a subclass of Exception class. EmptyLineException is thrown by the LuthMethod class when a empty string is passed to the constructor.
 * Spring COSC-1437.83002
 * Final Project: Credit card numbers and the case of Mobius Duck
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 1.0.1
 */
public class EmptyLineException extends Exception{
  /**
   *This constructor calls its super class's constructor and pass a string message to it.
    @param none
    @return nothing
    @throw nothing implemented 
  */
    public EmptyLineException()
    {
      super("You can't have empty lines between the numbers on your file.\n" + 
            "Please check your file and remove the unnecessary lines between the numbers.");
    }
}// end of class

