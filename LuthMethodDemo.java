import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 *This Class demostrates Luth Method Class. It also reads data from a file, catch possible exceptions, and write to proper text files for valid and
  invalid credit card numbers.
 * Spring COSC-1437.83002
 * Final Project: Credit card numbers and the case of Mobius Duck
 * 05/06/2020
 * @author Ahmet Mert Buyulu
 * @version 7.4.5
 */
public class LuthMethodDemo{  
   /**
   *This method first reads data from a file and passes its contents to creditCardNumbers arraylist. After that, it passes the arraylist to the Luth Method
    class's constructor as an argument. Then it calls the Luth Class's cardEvaluater method to validate the card numbers, which were passed from a text file.
    At the end, it writes to two different text files called valid_cards and invalid_cards based on the evaluation being made in Luth Method Class. It also
    catches possible checked exceptions. And if there's an user interaction being made to the program ,then it catches the unchecked exceptions as well.
    @param args; command line argument
    @return nothing
    @throw nothing implemented 
  */
   public static void main(String args[]){    
     ArrayList<String> creditCardNumbers = new ArrayList<>();    
     Scanner keyboard = new Scanner(System.in);
     File file;
     Scanner inputFile = null;
     try{
        try{
        file = new File(args[0]);
        inputFile = new Scanner(file);
        }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Error occured:" + " No file name is given.");
         System.exit(1);
        } 
     }catch(FileNotFoundException e){
       while(inputFile == null){
         try{
            System.out.print("File named " + args[0] + " does not exist.\n");  
            System.out.println("Enter another file name below (.txt extention is required):");  
            args[0] = keyboard.nextLine();
            file = new File(args[0]);
            inputFile = new Scanner(file);
         }catch(FileNotFoundException a){
            inputFile = null;
         }
       }
     }
     
     try{
         
       try{
          while (inputFile.hasNext()){
            String s = inputFile.nextLine();
            // store the element in an arraylist
            creditCardNumbers.add(s);
          }  
       }catch(NoSuchElementException | IllegalStateException e){
       System.out.println("Error occured: " + "Either no line is found or the Scanner is closed.");     
       }finally{ // for preventing resource leaks
         inputFile.close(); // closes the file regardless of whether an InputMismatch occurs.
       }
    
     }catch(NullPointerException e){
       System.out.println("Error occured: No content found in the file.");
       System.exit(2);
     }
     //--------------------------------------------------//
     try{
       LuthMethod method = new LuthMethod(creditCardNumbers);
       method.cardEvaluater();
      
       try{
         validNumberOfFiles(args.length); // calls the method to see if there's valid numbers of files entered by the user (must be 3).
      
         try{
            
           while(!args[1].equals("valid_cards.txt")){
            System.out.println("Please enter valid_cards.txt below for the process to be continued:");
            args[1] = keyboard.nextLine();
           }
           PrintWriter outputfile = new PrintWriter(args[1]);
           for(int i = 0; i < method.validSize(); i++){
            outputfile.println(method.getValidNumbers(i) + " ------> " + method.getIssuerValid(i));
           }
           outputfile.close();
           //------------------------------------//
           while(!args[2].equals("invalid_cards.txt")){
            System.out.println("Please enter invalid_cards.txt below for the process to be completed:");
            args[2] = keyboard.nextLine();
           }
           PrintWriter outputfile2 = new PrintWriter(args[2]);
           for(int i = 0; i < method.invalidSize(); i++){
            outputfile2.println(method.getInvalidNumbers(i) + " ------> " + method.getIssuerInvalid(i));
           }
           outputfile2.close();
        
         }catch(FileNotFoundException | SecurityException e){
           System.out.println("Some problems occured while writing to the files.");
         }
        
         System.out.println("Process completed.");
        
       }catch(FileNumException e){
        System.out.println(e.getMessage());
       }
       
     }catch(EmptyLineException | InvalidDigitException e){
        System.out.println(e.getMessage());
     }
  } // end of method
  
  /**
   *This method throws FileNumException if the number of files entered by the user not equal to three.
    @param int num
    @return nothing
    @throw FileNumException
  */
  public static void validNumberOfFiles(int num) throws FileNumException{
      if(num != 3){
          throw new FileNumException();
      }
  }// end of method
}// end of class