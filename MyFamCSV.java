
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;

public class MyFamCSV {

    static void famReader() {
        try {
            File myObj = new File("C:\\Users\\brian\\OneDrive\\Desktop\\java\\myFamList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    static void famWriter() {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\brian\\OneDrive\\Desktop\\java\\myFamList.txt", true);
            myWriter.write(famInput("Name"));
            myWriter.close();
            }catch(IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

      static String famInput(String data) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter " + data + ": ");
        return myInput.nextLine();
      }
    
  public static void main(String[] args) {
    famReader();
    famWriter();
    famReader();
  }
}