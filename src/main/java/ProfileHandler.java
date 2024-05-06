import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
                        for (int i = 0; i < 10; i++) {
                            prof.quizAnswers[i] = Boolean.valueOf(line[i + 4]);
                        }
                        File postFile = new File("postFile.csv");
                        if(postFile.canRead()) {
                            FileReader postFileReader = new FileReader(postFile);
                            CSVReader postReader = new CSVReader(postFileReader);
                            while (postReader.peek() != null) {
                                String[] postLine = postReader.readNext();
                                if (postLine[0].equals(user)) {
                                    prof.makeHousePost(postLine[1]);
                                }
                            }
                        }
                        prof.lineNum = (int) reader.getLinesRead();
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
        try {
            FileReader fr = new FileReader("accounts.csv");
            CSVReader csvReader = new CSVReader(fr);
            while(csvReader.peek() != null){
                String[] line = csvReader.readNext();
                if (line[0].equals(user)) {
                    System.out.print("That username is taken!");
                    return false;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

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

    public static String[] getMatchList(Profile currProfile) {

        ArrayList<String> ALmatches = new ArrayList<String>();

        File file = new File("accounts.csv");
        try {
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);
            for (int i = 0; i < 5; i++) {
                if (reader.peek() != null) {
                    String[] arr = reader.readNext();
                    if (i != currProfile.lineNum - 1) {


                        boolean whar = false;
                        Match matchClass = new Match(arr[1], whar);
                        boolean[] quizArr = new boolean[10];

                        for (int j = 4; j < 14; j++) {
                            boolean b1 = Boolean.parseBoolean(arr[j]);
                            quizArr[j - 4] = b1;
                        }
                        int value = matchClass.computeMatchValue(currProfile.quizAnswers, quizArr);
                        ALmatches.add(arr[1]);
                        ALmatches.add(Integer.toString(value));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        String[] matches = ALmatches.toArray(new String[ALmatches.size()]);
        return matches;
    }

    public static void retakeQuiz(Profile profile, boolean[] quiz) {
        profile.takeQuiz(quiz);
        //change csv answers
        File file = new File("accounts.csv");
        try {
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);

            List<String[]> csvContent = reader.readAll();

            int lineIndex = -1;
            for(int i = 0; i < csvContent.size(); i++)
            {
                if(csvContent.get(i)[0].equals(profile.getUsername()))
                {
                    lineIndex = i;
                }
            }

            for(int i = 0; i < 10; i++)
            {
                csvContent.get(lineIndex)[i+4] = String.valueOf(quiz[i]);
            }

            reader.close();
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            writer.writeAll(csvContent);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUsername(Profile profile, String username)
    {
        File file = new File("accounts.csv");
        try {
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);

            List<String[]> csvContent = reader.readAll();

            int lineIndex = -1;
            for(int i = 0; i < csvContent.size(); i++)
            {
                if(csvContent.get(i)[0].equals(profile.getUsername()))
                {
                    lineIndex = i;
                }
            }

            csvContent.get(lineIndex)[0] = username;

            reader.close();
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            writer.writeAll(csvContent);
            writer.flush();
            writer.close();
            profile.setUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateEmail(Profile profile, String email)
    {
        File file = new File("accounts.csv");
        try {
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);

            List<String[]> csvContent = reader.readAll();

            int lineIndex = -1;
            for(int i = 0; i < csvContent.size(); i++)
            {
                if(csvContent.get(i)[0].equals(profile.getUsername()))
                {
                    lineIndex = i;
                }
            }

            csvContent.get(lineIndex)[1] = email;

            reader.close();
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            writer.writeAll(csvContent);
            writer.flush();
            writer.close();
            profile.setEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePhone(Profile profile, String phone)
    {
        File file = new File("accounts.csv");
        try {
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);

            List<String[]> csvContent = reader.readAll();

            int lineIndex = -1;
            for(int i = 0; i < csvContent.size(); i++)
            {
                if(csvContent.get(i)[0].equals(profile.getUsername()))
                {
                    lineIndex = i;
                }
            }

            csvContent.get(lineIndex)[2] = phone;

            reader.close();
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            writer.writeAll(csvContent);
            writer.flush();
            writer.close();
            profile.setPhoneNumber(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAcct(Profile profile)
    {
        File file = new File("accounts.csv");
        try {
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);

            List<String[]> csvContent = reader.readAll();

            int lineIndex = -1;
            for(int i = 0; i < csvContent.size(); i++)
            {
                if(csvContent.get(i)[0].equals(profile.getUsername()))
                {
                    lineIndex = i;
                }
            }

            csvContent.remove(lineIndex);

            reader.close();
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            writer.writeAll(csvContent);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUsername(Profile profile)
    {
        return profile.getUsername();
    }

    public static String getEmail(Profile profile)
    {
        return profile.getEmail();
    }

    public static String getPhone(Profile profile)
    {
        return profile.getPhoneNumber();
    }

    public static void makeHousePost(Profile profile, String input)
    {
        String[] newLine = {profile.getUsername(), input};
        try {
            File file = new File("postFile.csv");
            FileWriter outFile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outFile);
            writer.writeNext(newLine);
            writer.close();
            profile.makeHousePost(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] viewHousePosts(Profile profile)
    {
        ArrayList<HousePost> userPosts = profile.getHousePosts();
        int sizeOfList = userPosts.size();
        String[] returnString = new String[sizeOfList];
        for(int i = 0; i < sizeOfList; i++)
        {
            returnString[i] = userPosts.get(i).display();
        }
        return returnString;
    }

    public static void deleteHousePost(Profile profile, int index)
    {
        int removalIndex = index;
        try {
            File file = new File("postFile.csv");
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);
            List<String[]> CSVContent = reader.readAll();
            for(int i = 0; i < CSVContent.size(); i++)
            {
                if(CSVContent.get(i)[0].equals(profile.getUsername()) && index > 0)
                {
                    index--;
                }
                else if(CSVContent.get(i)[0].equals(profile.getUsername()) && index == 0)
                {
                    CSVContent.remove(i);
                }
            }
            reader.close();
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            writer.writeAll(CSVContent);
            writer.flush();
            writer.close();
            profile.removeHousePost(removalIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editHousePost(Profile profile, int index, String description)
    {
        int editIndex = index;
        try {
            File file = new File("postFile.csv");
            FileReader fr = new FileReader(file);
            CSVReader reader = new CSVReader(fr);
            List<String[]> CSVContent = reader.readAll();
            for(int i = 0; i < CSVContent.size(); i++)
            {
                if(CSVContent.get(i)[0].equals(profile.getUsername()) && index > 0)
                {
                    index--;
                }
                else if(CSVContent.get(i)[0].equals(profile.getUsername()) && index == 0)
                {
                    CSVContent.get(i)[1] = description;
                }
            }
            reader.close();
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            writer.writeAll(CSVContent);
            writer.flush();
            writer.close();
            profile.editHousePost(editIndex, description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
