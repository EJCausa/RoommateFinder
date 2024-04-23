import java.util.Scanner;

public class ExitPageController implements PageController {
    private final String confirmExitPage = """
            ____________________________________________________________________________



                            Are you sure you want to close the program?
                                        Enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m
                                     \033[3m(No backslash needed)\033[0m





            ____________________________________________________________________________
            """;

    private boolean userExit = false;

    public void loadPage() {
        Scanner userIn = new Scanner(System.in);
        String input;

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
}
