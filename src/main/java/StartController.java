import java.util.Scanner;

public class StartController implements PageController {


    private String currentPage;
    private boolean userExit = false;


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
                            |  /create account  |    |  /log in  |
                            '-------------------'    '-----------'




                                 type \u001b[1m/exit\u001b[0m to quit at any time
                            type \u001b[1m/back\u001b[0m to return to the previous page
            ____________________________________________________________________________""";


    @Override
    public void loadPage() {

        PageController accountCreationPage = new CreateAccountController(); //prepare pages for available options
        PageController loginPage = new LoginController();
        PageController exitPage = new ExitPageController();

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
                    exitPage.loadPage();
                case "/create account":
                    accountCreationPage.loadPage(); //this doesnt do anything right now
                    break;
                case "/log in":
                    loginPage.loadPage(); //this doesnt do anything either, mainly bc we dont have a layout for these pages yes
                    break;
                default:
                    System.out.println("Invalid Command! Please enter one of the given options! Press Enter to continue");
                    input = userIn.nextLine();
            }
        }
    }


}
