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
                            |  /create account  |    |  /login   |
                            '-------------------'    '-----------'




                                 type \u001b[1m/exit\u001b[0m to quit at any time
                            type \u001b[1m/back\u001b[0m to return to the previous page
            ____________________________________________________________________________""";

            private final String homePage = """
            ____________________________________________________________________________


                        .-------------------.           .-------------------.
                        |  /delete account  |           |  /update profile  |
                        '-------------------'           '-------------------'
                            
                        .--------------------.            .-----------------.
                        | /retrieve matches  |            |  /view profile  |
                        '--------------------'            '-----------------'

                        .----------------.                        .---------.
                        |  /retake quiz  |                        |  /exit  |
                        '----------------'                        '---------'

                        .----------.  .------------------.  .---------------.
                        |  /inbox  |  |  /favorite user  |  |  /block user  |
                        '----------'  '------------------'  '---------------'

                            Welcome to the homepage! Type one of the commands!

            ____________________________________________________________________________""";





    private void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
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
            if(input.equals("/exit")) {
                loadExitPg();
            }
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

    public void getHomePage() {
        clearTerminal();
            System.out.println(this.homePage);
            System.out.println("Success");

            while (!userExit) {
                Scanner userIn = new Scanner(System.in);
                //System.out.println("Options are: /exit, /retake quiz, /retrieve matches, /update profile, /delete account, /view profile");
                String input;
                input = userIn.nextLine();

                switch (input) {
                    case "/exit":
                        userExit = true;
                        userIn.nextLine();
                        break;
                    case "/retake quiz": //retake quiz
                        loadRetake(currentProfile);
                        break;
                    case "/retrieve matches": //retrieve matches
                        loadRetrieval();
                        break;
                    case "/update profile"://update profile
                        loadUpdateProfile(currentProfile);
                        break;
                    case "/delete account":
                        deleteAcct(currentProfile);
                        userExit = true;
                        break;
                    case "/view profile":
                        viewProfile(currentProfile);
                        break;
                    default:
                        System.out.println("Invalid Command! Please use of the given options!");

                }


            }

    }

    public void loadLogin() {
        String user;
        String pass;
        
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
            getHomePage();
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

    public void loadMatches(int matchCeiling, int compatFloor) {
        String[] matchArray = ProfileHandler.getMatchList(currentProfile);

        for (int i = 0; i < matchArray.length && i < matchCeiling; i++) {
            String matchedUser = matchArray[i];
            i++;
            if (Integer.parseInt(matchArray[i]) > compatFloor) {
                System.out.print(matchedUser);
                System.out.println(" compatabilty: " + matchArray[i]);
            }

        }
    }

    public void loadRetrieval() {
        Scanner userIn = new Scanner(System.in);
        System.out.println("Do you want to filter your matches? Yes or no?");

        String input;
        input = userIn.nextLine();

        boolean filterLoopFlag = true;
        boolean filtersActiveLoop = false;
        while (filterLoopFlag) {
            switch (input) {
                case "yes":
                    filterLoopFlag = false;
                    filtersActiveLoop = true;
                    break;
                case "no":
                    filterLoopFlag = false;
                    break;
                default:
                    System.out.println("Please either input yes or no");
                    input = userIn.nextLine();
            }
        }

        int displayMatchAmount = 20;
        int displayMatchCompat = 0;
        while (filtersActiveLoop) {
            System.out.println("Filter options: minimum compatibility, maximum amount of matches. Input finish to finish");
            input = userIn.nextLine();
            switch (input) {
                case "compatibility":
                    System.out.println("Please input the minimum compatibility score you want");
                    displayMatchCompat = userIn.nextInt();
                    userIn.nextLine();
                    break;
                case "amount":
                    System.out.println("Please input the maximum amount of matches to display");
                    displayMatchAmount = userIn.nextInt();
                    userIn.nextLine();
                    break;
                case "finish":
                    filtersActiveLoop = false;
                    break;
                default:
                    System.out.println("Invalid Input! Please input valid input!");
            }
        }

        loadMatches(displayMatchAmount, displayMatchCompat);

    }

    public void loadRetake(Profile profile) {
        boolean[] newAnswers = loadQuiz();
        ProfileController.retakeQuiz(profile, newAnswers);
        clearTerminal();
        System.out.println(this.homePage);
        System.out.println("[QUIZ ANSWERS UPDATED]");

    }

    public void loadUpdateProfile(Profile profile) {
        Scanner userIn = new Scanner(System.in);
        String input;
        boolean updateLoopFlag = true;

        String newUsername;
        String newEmail;
        String newPhone;

        while (updateLoopFlag) {
            System.out.println("Please enter a field to update: username, email, phone number. Type exit to exit");
            input = userIn.nextLine();
            switch (input) {
                case "username":
                    System.out.println("Enter a username: ");
                    newUsername = userIn.nextLine();
                    ProfileController.updateUsername(profile, newUsername);
                    break;
                case "email":
                    System.out.println("Enter an email address: ");
                    newEmail = userIn.nextLine();
                    ProfileController.updateEmail(profile, newEmail);
                    break;
                case "phone number":
                    System.out.println("Enter a phone number: ");
                    newPhone = userIn.nextLine();
                    ProfileController.updatePhone(profile, newPhone);
                    break;
                case "exit":
                    updateLoopFlag = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
        getHomePage();
    }

    public void deleteAcct(Profile profile)
    {
        ProfileController.deleteAcct(profile);
    }

    public void viewProfile(Profile profile)
    {
        String username = "Username: " + ProfileController.getUsername(profile);
        String email = "Email: " + ProfileController.getEmail(profile);
        String phone = "Phone: " + ProfileController.getPhone(profile);
        System.out.println(username);
        System.out.println(email);
        System.out.println(phone);
    }
}



