import java.util.Scanner;
public class App {

    public static void main(String[] args)
    {
        //Controller declared here
        System.out.println("Roommate Finder initializing...");
        boolean exitFlag = false; //once true, finish the program
        String userInput = "";
        Scanner keyboard = new Scanner(System.in);


        Controller pageController = new Controller();

        //Declare profile?

        while(!exitFlag)
        {
            pageController.printStartupPage();
            //print prompt from controller
            //take user input from scanner
            userInput = keyboard.nextLine().trim();
            //convert to lowercase
            userInput = userInput.toLowerCase();
            if(userInput.equals("/exit"))
            {

                while (!exitFlag) {
                    pageController.printConfirmExitPage();
                    userInput = keyboard.nextLine().trim();
                    if (userInput.equals("no")) {
                        break;
                    } else if (userInput.equals("yes")) {
                        exitFlag = true;
                    }

                }
                
            }
            //potentially flush the scanner?
            //I think we can flush the scanner in the controller methods
            
        }
        System.out.println("Thank you for using the Roommate Finder!");
    }

    
}
