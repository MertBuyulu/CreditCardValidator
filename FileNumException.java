/**
 *This Class is a subclass of Exception class. FileNumException is thrown by the LuthMethodDemo class when invalid number of files passes to the LuthMethodDemo
  class's main method.
 * Spring COSC-1437.83002
 * Final Project: Credit card numbers and the case of Mobius Duck
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 1.0.1
 */
public class FileNumException extends Exception{
  /**
   *This constructor calls its super class's constructor and pass a string message to it.
    @param none
    @return nothing
    @throw nothing implemented 
  */
    public FileNumException()
    {
      super("Process couldn't be completed at the moment. Please try again and enter the required file names in following order:\n1)The text file you want to process.\n" +
                                                            "2)valid_cards.txt\n" +  "3)invalid_cards.txt\n");
    }
}
