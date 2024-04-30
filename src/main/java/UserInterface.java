import java.util.Scanner;

public class UserInterface {


    private boolean userExit = false;

    private final String confirmExitPage = """
            ____________________________________________________________________________



                            Are you sure you want to close the program?
                                        Enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m
                                     \033[3m(No backslash needed)\033[0m





            ____________________________________________________________________________
            """;
    private final String startupPage = """
            ____________________________________________________________________________
               _____                             _         __  __       _       _    \s
              |  __ \\                           | |       |  \\/  |     | |     | |   \s
              | |__) |___   ___  _ __ ___   __ _| |_ ___  | \\  / | __ _| |_ ___| |__ \s
              |  _  // _ \\ / _ \\| '_ ` _ \\ / _` | __/ _ \\ | |\\/| |/ _` | __/ __| '_ \\ \s
              | | \\ \\ (_) | (_) | | | | | | (_| | ||  __/ | |  | | (_| | || (__| | | |\s
              |_|  \\_\\___/ \\___/|_| |_| |_|\\__,_|\\__\\___| |_|  |_|\\__,_|\\__\\___|_| |_|\s
                                                                                      \s




                            .-------------------.    .-----------.
                            |  /create account  |    |  /login  |
                            '-------------------'    '-----------'




                                 type \u001b[1m/exit\u001b[0m to quit at any time
                            type \u001b[1m/back\u001b[0m to return to the previous page
            ____________________________________________________________________________""";


    public void loadPage() {


        Scanner userIn = new Scanner(System.in);
        String input;
        while (!userExit) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(startupPage); //display page content, this is the part the user sees

            input = userIn.nextLine();
            switch (input) {
                case "/back":
                    userExit = true;
                    break;
                case "/exit":
                    loadExitPg();
                case "/create account":
                    loadAcctCreation();
                    break;
                case "/login":
                    loadLogin();
                    break;
                default:
                    System.out.println("Invalid Command! Please enter one of the given options! Press Enter to continue");
                    input = userIn.nextLine();
            }
        }
    }

    public void loadExitPg() {
        Scanner userIn = new Scanner(System.in);
        String input;

        System.out.println(confirmExitPage);

        while (!userExit) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(confirmExitPage);
            input = userIn.nextLine();
            switch (input) {
                case "yes":
                    System.out.println("Thank you for using the program!");
                    System.exit(0);
                case "no":
                    userExit = true;
                    break;
                default:
                    System.out.println("Invalid Command! Please use of the given options!");
            }
        }
        userExit = false;

    }

    public void loadAcctCreation() {
        Scanner userIn = new Scanner(System.in);
        String username;
        String pass = "";
        String email;
        String phone;
        String input = "default";

        System.out.println("Please Enter information");
        System.out.print("Username:");
        username = userIn.nextLine();
        //make sure username is not taken

        while (!input.equals(pass)) {
            System.out.print("password: ");
            pass = userIn.nextLine();
            System.out.print("Please confirm password: ");
            input = userIn.nextLine();
            if (!input.equals(pass)) {
                System.out.println("Password does not match!");
            }
        }

        System.out.print("Email: ");
        email = userIn.nextLine();
        //validate email
        System.out.print("Phone: ");
        phone = userIn.nextLine();
        //validate phone

    }

    public void loadLogin() {
        Scanner userIn = new Scanner(System.in);
        String username;
        String pass;
        boolean loginSuccess = false;

        while (!userExit) {
            System.out.println("Please enter login info:");
            System.out.print("Username: ");
            username = userIn.nextLine();
            System.out.print("Password: ");
            pass = userIn.nextLine();

            //database login validation here, set loginSuccess accordingly


            if (loginSuccess) {
                //load main menu

            } else {
                //login failed
                userExit = true;
            }


        }
        userExit = false;

    }
}
