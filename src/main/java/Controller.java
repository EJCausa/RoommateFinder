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




                                 type \u001b[1m/quit\u001b[0m to quit at any time
                            type \u001b[1m/back\u001b[0m to return to the previous page
            ____________________________________________________________________________
            Type\u001b[1m /create account\u001b[0m or\u001b[1m /log in\u001b[0m here:\s""";

    public Controller() {
        currentPage = startupPage;
        

    }
}
