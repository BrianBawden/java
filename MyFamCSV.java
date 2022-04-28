

import java.io.File;

public class MyFamCSV {

    public MyFamCSV() {
        
    }

    public static void main(String[] args) {
        File myFamfile = new File ("C:\\Users\\brian\\OneDrive\\Desktop\\java\\myFamList.csv");

        System.out.println(myFamfile.canRead());
    }
        
}
