public class Controller {

    String currentPage;

    String[] currentChoices = new String[10];
    String startupPage = """
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

    String confirmExitPage = """
            ____________________________________________________________________________



                            Are you sure you want to close the program?
                                        Enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m
                                     \033[3m(No backslash needed)\033[0m





            ____________________________________________________________________________
            """;

    public Controller() {
        currentPage = startupPage;
        

    }

    private  void clearTerminal() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public void printPage(String page, String prompt) {
        clearTerminal();
        System.out.println(page);
        System.out.println(prompt);
    }
    /*
    public void printStartupPage () { //ERIK: would it be possible to have a single print current page method? Would the values of startup page and exit page need to be modified?
        clearTerminal();
        System.out.println(this.startupPage);
        System.out.print("Type\u001b[1m /create account\u001b[0m or\u001b[1m /log in\u001b[0m here: ");
    }

    public void printConfirmExitPage() {
        clearTerminal();
        System.out.println(this.confirmExitPage);
        System.out.print("Please enter \u001b[1myes\u001b[0m or \u001b[1mno\u001b[0m: ");
    }
    */
}
