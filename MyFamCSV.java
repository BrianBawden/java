
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class MyFamCSV 
{
  public static String path = "C:\\Users\\brian\\OneDrive\\Desktop\\java\\myFamList.csv";
  private static Scanner sc;


  public static void main(String[] args)
  {
    // String newName = "Sam";
    // String editName = "Brian";
    // String newRelation = "Cousion";
    // String newPhone = "55555";
    // String newState = "UT";
    
    // editRecord("Brian", "Me", "770-880-5838", "GA");
    famReader();
    famWriter();
    famReader();

    // searchRecord(path);
  }

////////////////////////Methods///////////////////////////
  
  // This method will print out the data in the file
  static void famReader() 
  {
    try {
        File myObj = new File(path);
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

  // This method will search for the name entered my the user.
  public static void searchRecord(String filePath)
  {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter search: ");
    String userI = userInput.nextLine();
    boolean found = false;
    String name = "";
    String relation = "";
    String phoneNumber = "";
    String state = "";

    try
    {
      sc = new Scanner(new File(filePath));
      sc.useDelimiter("[,\n]");

      while (sc.hasNext() && !found)
      {
        name = sc.next();
        relation = sc.next();
        phoneNumber = sc.next();
        state = sc.next();

        if(name.equals(userI))
        {
          found = true;
          System.out.println(name + relation + phoneNumber + state);
        }

      }
    }
    catch (Exception e)
    {
      System.out.println("An error occurred while searching.");

    }
  }

  // This method of the MyFamCSV class is used to append a new entry to the csv file
  static void famWriter() 
    {
      try 
      {
        FileWriter myWriter = new FileWriter(path, true);

        myWriter.write("\n");
        System.out.println("Enter the new name: ");
        myWriter.write(userInput());
        myWriter.write(", ");
        System.out.println("Enter the new relation: ");
        myWriter.write(userInput());
        myWriter.write(", ");
        System.out.println("Enter the new phone number: ");
        myWriter.write(userInput());
        myWriter.write(", ");
        System.out.println("Enter the new state: ");
        myWriter.write(userInput());
        myWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }


    public static void editRecord(String name, String relation, String phoneNumber, String state)
    {
      famReader();

      String tempFile = "temp.csv";
      File oldFile = new File(path);
      File newFile = new File(tempFile);
      String Name = "";
      String Relation = "";
      String PhoneNumber = "";
      String State = "";

      Scanner nName = new Scanner(System.in);
      System.out.println("\nEnter name to edit: ");
      String newName = "Sam"; 
      String editName = nName.nextLine();
      String newRelation = "Cousion";
      String newPhone = "55555";
      String newState = "UT";


      try
      {
        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        sc = new Scanner(new File(path));
        sc.useDelimiter("[,\n]");

        while(sc.hasNext())
        {
          Name = sc.next();
          Relation = sc.next();
          PhoneNumber = sc.next();
          State = sc.next();
          if(Name.equals(editName))
          {
            pw.println(newName + ", " + newRelation + ", " + newPhone + ", " + newState);
          }
          else
          {
            pw.print(Name + ", " + Relation + ", " + PhoneNumber + ", " + State);
          }
        }
        sc.close();
        pw.flush();
        pw.close();
        oldFile.delete();
        File dump = new File(path);
        newFile.renameTo(dump);

      }
      catch(Exception e)
      {
        System.out.println("Error editing record.");
      }
    }

  // This method is used to return user input.
  static String userInput()
    {
    Scanner userI = new Scanner(System.in);
    return userI.nextLine();
    }

}