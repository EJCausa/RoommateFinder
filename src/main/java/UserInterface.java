import java.util.Scanner;

public class UserInterface {


    private boolean userExit = false;
    private Profile currentProfile;

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

        boolean[] quizAnswer = loadQuiz();
        ProfileController.signUp(username, email, phone, pass, quizAnswer);
    }

    public void loadLogin() {
        String user;
        String pass;
        String input;
        userExit = false;
        Scanner userIn = new Scanner(System.in);
        System.out.println("Enter username: ");
        user = userIn.nextLine();
        System.out.println("Please enter password: ");
        pass = userIn.nextLine();
        currentProfile = ProfileController.login(user, pass);
        if (currentProfile == null) {
            System.out.println("login failed!");
        } else {
            //load main menu
            System.out.println("Success");

            while (!userExit) {

                System.out.println("Enter 1 for retake quiz");
                System.out.println("Enter 2 for retrieve matches");
                System.out.println("Enter 3 for update profile");

                input = userIn.nextLine();

                switch (input) {
                    case "1": //retake quiz

                    case "2": //retrieve matches
                        loadMatches();
                    case "3"://update profile

                }


            }
        }
    }

    public boolean[] loadQuiz() {
        String[] quizQuestions = {
                "I am generally a clean person.",
                "I like to go out often",
                "I enjoy having friends over",
                "I go to bed before 11pm most nights",
                "I drink often",
                "I consume weed often",
                "I will study in communal spaces often",
                "I smoke cigarettes often",
                "I will bring pets to the living space",
                "I will have a job while in school"
        };
        boolean[] quizAnswers = new boolean[10];
        Scanner userIn = new Scanner(System.in);


        for (int i = 0; i < quizQuestions.length; i++) {
            System.out.println("\nTrue or False:");
            System.out.println(quizQuestions[i]);
            String input = userIn.nextLine();
            while (!(input.toUpperCase().equals("TRUE") || input.toUpperCase().equals("FALSE"))) {
                System.out.println("Input \"TRUE\" or \"FALSE:\"");
                //System.out.println(quizQuestions[i]);
                input = userIn.nextLine();
            }
            quizAnswers[i] = Boolean.valueOf(input);
        }

        return quizAnswers;
    }

    public void loadMatches() {
        String[] matchArray = ProfileHandler.getMatchList(currentProfile);

        for (int i = 0; i < matchArray.length; i++) {
            System.out.print(matchArray[i]);
            i++;
            System.out.println(" compatabilty: " + matchArray[i]);
        }
    }
}



