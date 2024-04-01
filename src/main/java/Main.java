import java.util.Scanner;
public class App {

    public static void main(String[] args)
    {//TO-DO: Relocate page variables, print methods, and all IO from controller here
        
        //I think it is good to handle user input (keyboard Scanner) and UI display (Strings the ones found at the top of Controller) separately.
        //Currently, the main is not a UI class. It only handles user input. To display the UI, it is calling methods from the Controller class.
        //The only things in the Controller class right now are UI strings and methods to print them. Maybe we should rename Controller.java to UI.java?
        //I think Main's only purpose should be to handle user input and call other classes.

        //It makes more sense to handle user input and UI display in separate classes, rather than combining both into Main.java.
        
        System.out.println("Roommate Finder initializing...");
        boolean exitFlag = false; //once true, finish the program
        String userInput = "";
        Scanner keyboard = new Scanner(System.in);

        //Controller declared here
        Controller pageController = new Controller();

        while(!exitFlag)
        {
            pageController.printPage(
                pageController.getStartupPage(),
                "Type\u001b[1m /create account\u001b[0m or\u001b[1m /log in\u001b[0m here: "
            );
            //print prompt from controller
            //take user input from scanner
            userInput = keyboard.nextLine().trim();
            //convert to lowercase
            userInput = userInput.toLowerCase();
            if(userInput.equals("/exit"))
            {

                while (!exitFlag) {
                    pageController.printPage(
                        pageController.getConfirmExitPage(),
                        "Please enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m: "
                    );
                    userInput = keyboard.nextLine().trim();
                    if (userInput.equals("no")) {
                        break;
                    } else if (userInput.equals("yes")) {
                        exitFlag = true;
                    }

                }
                
            }
            //else
            //{
            //Need a function in controller to pass the user input to
            //}
            //potentially flush the scanner?
            //I think we can flush the scanner in the controller methods
            
        }
        System.out.println("Thank you for using the Roommate Finder!");
    }

    
}
