
import java.io.*;
import java.util.Scanner;


public class myFamCSV2 
{//open myFamCSV2 class
    public static void main(String[] args) throws Exception  
    {//open main
        reader("C:\\Users\\brian\\OneDrive\\Desktop\\java\\myFamList.csv");
    }// close main

    
    static void reader(String file) throws FileNotFoundException
    {//ope reader module 
        Scanner sc = new Scanner(new File(file)); //sets file used in program.
        sc.useDelimiter(",");
        while(sc.hasNext())
        {//open while loop
            System.out.print(sc.next());
        }// close while loop
        sc.close();
    }//close module reader
} //Close myFamCSV2
