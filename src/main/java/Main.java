import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        //Controller declared here
        System.out.println("Roommate Finder initializing...");
        boolean exitFlag = false; //once true, finish the program
        String userInput = "";
        Scanner keyboard = new Scanner(System.in);
        while(!exitFlag)
        {
            //take user input from scanner
            keyboard.nextLine().trim();
            //convert to lowercase
            userInput = userInput.toLowerCase();
            if(userInput.equals("exit"))
            {
                exitFlag = true;
            }
            //potentially flush the scanner?
        }

    }
}
