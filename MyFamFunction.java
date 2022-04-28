import java.util.ArrayList;
public class MyFamFunction{

    public static void main(String[] args){
        System.out.println("Meet my family.");

        ArrayList<String> briansFamily = new ArrayList<String>();

        briansFamily.add("Merrill");
        briansFamily.add("Laura");
        briansFamily.add("Brian");
        briansFamily.add("Greg");
        briansFamily.add("Brenda");
        briansFamily.add("Thomas");


        for (String i : briansFamily){
        System.out.println("\n" + i);

        }
    }
}
