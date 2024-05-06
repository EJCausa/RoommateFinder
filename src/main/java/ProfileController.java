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

    public static void retakeQuiz(Profile profile, boolean[] quiz){
        ProfileHandlerOBJ.retakeQuiz(profile,quiz);
    }

    public static void updateUsername(Profile profile, String newUsername)
    {
        ProfileHandlerOBJ.updateUsername(profile, newUsername);
    }

    public static void updateEmail(Profile profile, String newEmail)
    {
        ProfileHandlerOBJ.updateEmail(profile, newEmail);
    }

    public static void updatePhone(Profile profile, String newPhone)
    {
        ProfileHandlerOBJ.updatePhone(profile, newPhone);
    }

    public static void deleteAcct(Profile profile)
    {
        ProfileHandlerOBJ.deleteAcct(profile);
    }

    public static String getUsername(Profile profile)
    {
        return ProfileHandlerOBJ.getUsername(profile);
    }

    public static String getEmail(Profile profile)
    {
        return ProfileHandlerOBJ.getEmail(profile);
    }

    public static String getPhone(Profile profile)
    {
        return ProfileHandlerOBJ.getPhone(profile);
    }

    public static void makeHousePost(Profile profile, String input)
    {
        ProfileHandlerOBJ.makeHousePost(profile, input);
    }

    public static String[] viewHousePosts(Profile profile)
    {
        return ProfileHandlerOBJ.viewHousePosts(profile);
    }

    public static void deleteHousePost(Profile profile, int index)
    {
        ProfileHandlerOBJ.deleteHousePost(profile, index);
    }

    public static void editHousePost(Profile profile, int index, String description)
    {
        ProfileHandlerOBJ.editHousePost(profile, index, description);
    }
}
