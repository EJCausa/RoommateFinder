import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ProfileHandler {

    String[] header = {"Name", "Email", "Phone", "Pass", "quizAns"};

    //Profile profile1; //will be intialized when you Login
    public ProfileHandler() {

    }

    public static Profile login(String user, String pass) {
        File file = new File("accounts.csv");
        try {
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);
            while (reader.peek() != null) {
                String[] line = reader.readNext();
                if (line[0].equals(user)) {
                    if (line[3].equals(pass)) {
                        Profile prof = new Profile(user, line[1], line[2], line[3]);
                        return prof;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean signUp(String user, String email, String phone, String pass, boolean[] quizAns) {
        Profile newAcc = new Profile(user, email, phone, pass);
        newAcc.takeQuiz(quizAns);
        File accountFile = new File("accounts.csv");
        ArrayList<String> line = new ArrayList<String>();
        line.add(user);
        line.add(email);
        line.add(phone);
        line.add(pass);
        for (int i = 0; i < 10; i++) {
            line.add(String.valueOf(quizAns[i]));
        }
        String[] fullLine = line.toArray(new String[line.size()]);
        try {
            FileWriter outFile = new FileWriter(accountFile, true);
            CSVWriter writer = new CSVWriter(outFile);
            writer.writeNext(fullLine);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }

    public static Profile getMatchList(Profile currProfile) {
        Profile profile1;
        return null;
    }

    public static void takeQuiz(Profile profile, boolean[] quiz) {

    }
}
