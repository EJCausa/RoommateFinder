import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProfileHandler {

    String[] header = {"Name", "Email", "Phone", "Pass", "quizAns"};

    public ProfileHandler() {

    }

    public static boolean signUp(String user, String email, String phone, String pass, boolean[] quizAns) {
        Profile newAcc = new Profile(user, email, phone, pass);
        newAcc.takeQuiz(quizAns);
        File accountFile = new File("accounts.csv");
        String[] line = {user, email, phone, pass};
        try {
            FileWriter outFile = new FileWriter(accountFile, true);
            CSVWriter writer = new CSVWriter(outFile);
            writer.writeNext(line);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }

    public static void takeQuiz(Profile profile, boolean[] quiz) {

    }
}
