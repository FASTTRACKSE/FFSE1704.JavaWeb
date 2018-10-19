package test;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Mess {

 public static void main(String[] args) {
   int lang;
   Scanner s = new Scanner(System.in);
   ResourceBundle bundle;
   do {
    System.out.println("1. English");
    System.out.println("2. Vietnamese");
    System.out.println("3. Exit program");

    System.out.print("Please choose your language: ");
    lang = s.nextInt();
    switch (lang) {
     case 1:
       //internationalization.message is package name
       //MessageBundle is properties file name
       bundle = ResourceBundle.getBundle("test.MessageBundle", Locale.US);
       System.out.println("Message in " + Locale.US
                                + ": " + bundle.getString("key1"));
       break;
     case 2:
       //changing the default locale to Vietnamese 
       Locale.setDefault(new Locale("vi", "VN"));
       bundle = ResourceBundle.getBundle("test.MessageBundle");
       System.out.println("Message in " + Locale.getDefault()
                                + ": " + bundle.getString("key1"));
       break;
    }
   } while (lang != 3);
 }
}
