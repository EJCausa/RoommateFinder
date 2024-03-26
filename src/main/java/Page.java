import java.util.Scanner;

/**
 * This Page class displays and handles user input in the Roomate Match system.
 * Here, the system is organized in pages. When the user enters a valid command, a new page is loaded.
 * 
 * Each page method displays a page with print statements and handles user input with a while loop and an if statement.
 * 
 * Adding a "validateCommand" method may make this code more readable by reducing the need to validate input in every
 * individual page method. However, the validation process differs from page to page, as every page will not always be
 * directly accessible from the current page.
 */
public class Page {
    String backPage;
    String currentPage;
    Scanner keyboard;
    String command;

    /**
     * Page class constructor.
     */
    public Page () {
        backPage = "";
        currentPage = "";
        keyboard = new Scanner(System.in);
        command = "";
    }

    /**
     * Method to display UI and handle user input on the "sign-in" page.
     */
    public void signInPage() {
        currentPage = "signIn";
        backPage = "\033[3mYou're at the sign-in page! You can't go back any further!\033[0m";
        clearTerminal();
        System.out.println("____________________________________________________________________________");
        System.out.println("   _____                             _         __  __       _       _     ");
        System.out.println("  |  __ \\                           | |       |  \\/  |     | |     | |    ");
        System.out.println("  | |__) |___   ___  _ __ ___   __ _| |_ ___  | \\  / | __ _| |_ ___| |__  ");
        System.out.println("  |  _  // _ \\ / _ \\| '_ ` _ \\ / _` | __/ _ \\ | |\\/| |/ _` | __/ __| '_ \\ ");
        System.out.println("  | | \\ \\ (_) | (_) | | | | | | (_| | ||  __/ | |  | | (_| | || (__| | | |");
        System.out.println("  |_|  \\_\\___/ \\___/|_| |_| |_|\\__,_|\\__\\___| |_|  |_|\\__,_|\\__\\___|_| |_|");
        System.out.println("                                                                          ");

        System.out.println("\n\n\n");
        System.out.println("                .-------------------.    .-----------.");
        System.out.println("                |  /create account  |    |  /log in  |");
        System.out.println("                '-------------------'    '-----------'");
        System.out.println("\n\n\n");
        System.out.println("                     type \u001b[1m/quit\u001b[0m to quit at any time");
        System.out.println("                type \u001b[1m/back\u001b[0m to return to the previous page");
        System.out.println("____________________________________________________________________________\n");
        
        System.out.print("Type\u001b[1m /create account\u001b[0m or\u001b[1m /log in\u001b[0m here: ");
        command = keyboard.nextLine().trim();

        while (!(command.equals("/create account") || command.equals("/log in") || command.equals("/quit"))) {
            if (command.equals("/back")) {
                System.out.println(backPage);
            }
            System.out.print("Please enter \u001b[1m/create account\u001b[0m or \u001b[1m/log in\u001b[0m: ");
            command = keyboard.nextLine().trim();
        }
        
        if (command.equals("/create account")) {
            this.createAccountPage();
        } else if (command.equals("/log in")) {
            this.logInPage();
        } else if (command.equals("/quit")) {
            quitSequence();
        } else {
            System.out.println("ERROR: Command invalid. Terminating program.");
        }
    }

    /**
     * Method to display UI and handle user input on the "create account" page.
     */
    public void createAccountPage() {
        currentPage = "createAccount";
        backPage = "signIn";
        clearTerminal();
        System.out.println("____________________________________________________________________________\n\n");
        System.out.println("                        Username: __________\n");
        System.out.println("                        Password: __________\n");
        System.out.println("                Confirm Password: __________\n");
        System.out.println("                          E-mail: __________\n");
        System.out.println("         Phone number (Optional): __________\n");
        System.out.println("\n\n____________________________________________________________________________");

        System.out.print("~END OF PROTOTYPE~ you can still enter \u001b[1m/back\u001b[0m though: ");
        command = keyboard.nextLine().trim();
        while (!(command.equals("/back") || command.equals("/quit"))) {
            
            System.out.print("You can only enter \u001b[1m/back\u001b[0m on this page for now: ");
            command = keyboard.nextLine().trim();
        }

        if (command.equals("/back")) {
            this.backPage(this.backPage);
        } else if (command.equals("/quit")) {
            this.quitSequence();
        } else {
            System.out.println("ERROR: Command invalid. Terminating program.");
        }
        
    }
    
    /**
     * Method to display UI and handle user input on the "log-in" page.
     */
    public void logInPage() {
        currentPage = "logIn";
        backPage = "signIn";
        clearTerminal();
        System.out.println("____________________________________________________________________________\n\n\n\n");
        System.out.println("                        Username: __________\n");
        System.out.println("                        Password: __________\n");
        System.out.println("\n\n\n\n\n\n____________________________________________________________________________");

        System.out.print("~END OF PROTOTYPE~ you can still enter \u001b[1m/back\u001b[0m though: ");
        command = keyboard.nextLine().trim();
        while (!(command.equals("/back") || command.equals("/quit"))) {
            
            System.out.print("You can only enter \u001b[1m/back\u001b[0m on this page for now: ");
            command = keyboard.nextLine().trim();
        }

        if (command.equals("/back")) {
            this.backPage(this.backPage);
        } else if (command.equals("/quit")) {
            this.quitSequence();
        } else {
            System.out.println("ERROR: Command invalid. Terminating program.");
        }
    }



    /**
     * Private method used at the beginning of the above methods.
     * Clears the terminal so a new page can be displayed.
     */
    private void clearTerminal() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * Private method that handles the /back command. Also called when the user enters "no" on the quit page.
     * @param page The name of the page to return to
     */
    private void backPage(String page) {
        switch (page) {
            case "signIn":
                this.signInPage();
                break;
            case "logIn":
                this.logInPage();
                break;
            case "createAccount":
                this.createAccountPage();
                break;
            default:
                System.out.println("BACKPAGE ERROR: Backpage not found. Terminating program.");
                break;
        }
    }

    /**
     * Private method that handles the /quit command.
     */
    private void quitSequence() {
        clearTerminal();
        System.out.println("____________________________________________________________________________\n\n\n\n");
        System.out.println("                 Are you sure you want to close the program?\n");
        System.out.println("                               Enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m\n");
        System.out.println("                            \033[3m(No backslash needed)\033[0m\n");

        System.out.println("\n\n\n\n\n\n____________________________________________________________________________");
        
        System.out.print("Please enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m: ");
        command = keyboard.nextLine().trim();
        while (!(command.equals("yes") || command.equals("no"))) {
            
            System.out.print("Please enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m: ");
            command = keyboard.nextLine().trim();
        }

        if (command.equals("yes")) {
            clearTerminal();
            System.out.println("____________________________________________________________________________\n\n");
            System.out.println("Program closed.\n\nThank you for using Roomate Match!");
            System.out.println("\n\n\n\n____________________________________________________________________________");
        } else if (command.equals("no")) {
            backPage(currentPage);
        }
    }
}
