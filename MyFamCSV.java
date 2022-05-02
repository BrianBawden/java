
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;

public class MyFamCSV 
{
  public static String path = "C:\\Users\\brian\\OneDrive\\Desktop\\java\\myFamList.csv";
  private static Scanner x;


  public static void main(String[] args)
  {
    // famReader();
    // famWriter();
    searchRecord("Brian", path);
  }


  
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

  public static void searchRecord(String searchTerm, String filePath)
  {
    boolean found = false;
    String name = "";
    String relation = "";
    String phoneNumber = "";
    String state = "";

    try
    {
      x = new Scanner(new File(filePath));
      x.useDelimiter("[,\n]");

      while (x.hasNext() && !found)
      {
        name = x.next();
        relation = x.next();
        phoneNumber = x.next();
        state = x.next();

        if(name.equals(searchTerm))
        {
          found = true;
          System.out.println(name + relation + phoneNumber + state);
        }

      }
    }
    catch (Exception e)
    {


    }
  }


  static void famWriter() 
    {
      try 
      {
        FileWriter myWriter = new FileWriter(path, true);

        myWriter.write("\n");
        myWriter.write(famInput("Name"));
        myWriter.write(", ");
        myWriter.write(famInput("Relation"));
        myWriter.write(", ");
        myWriter.write(famInput("Phone Number"));
        myWriter.write(", ");
        myWriter.write(famInput("State"));
        myWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


  static String famInput(String data)
    {
    Scanner myInput = new Scanner(System.in);
    System.out.println("Enter " + data + ": ");
    return myInput.nextLine();
    }

}




// import javax.swing.JOptionPane;


// public static void readRecord(String searchTerm, String filePath)
//   {
//     boolean found = false;
//     String name = "";
//     String relation = "";
//     String phone = "";
//     String state = "";

//     try
//     {
//       x = new Scanner(new File(path));
//       x.useDelimiter(",\n");

//       while (x.hasNext() && !found)
//         {
//           name = x.next();
//           relation = x.next();
//           phone = x.next();
//           state = x.next();

//           if(name.equals(searchTerm))
//             {
//               found = true;
//             }
//           if (found)
//             {
//               JOptionPane.showMessageDialog(null, name + relation + phone + state);
//             }
//           else
//             {
//               JOptionPane.showMessageDialog(null, "Name Not found");

//             }
//         } 
//     }
//     catch(Exception e)
//       {
//         JOptionPane.showMessageDialog(null, "Error: File not found.");
//       }
//   }

