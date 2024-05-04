import java.util.ArrayList;

public class ProfileController {
    private static ProfileHandler ProfileHandlerOBJ = new ProfileHandler();

    public static boolean signUp(String user,String email,String phone,String pass,boolean[] quizAns){

        ProfileHandlerOBJ.signUp(user, email, phone, pass,quizAns);
        return true;

    }

    public static Profile login(String user, String pass) {
        Profile pfpOBJ = ProfileHandler.login(user, pass);
        return pfpOBJ;

    }
    public static String[] getMatchList(Profile currProfile){
        String [] matches = ProfileHandler.getMatchList(currProfile);

       return matches;
    }

    public static void takeQuiz(Profile profile, boolean[] quiz){
        ProfileHandlerOBJ.takeQuiz(profile,quiz);
    }

}
