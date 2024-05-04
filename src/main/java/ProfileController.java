public class ProfileController {
    private static ProfileHandler ProfileHandlerOBJ = new ProfileHandler();

    public static boolean signUp(String user,String email,String phone,String pass,boolean[] quizAns){

        ProfileHandlerOBJ.signUp(user, email, phone, pass,quizAns);
        return true;

    }
    public static Profile login(String user, String pass){
    Profile pfpOBJ=ProfileHandler.login(user,pass);
    return pfpOBJ;

    }
    public static Profile[] getMatchList(Profile currProfile){
        ProfileHandlerOBJ.getMatchList();
    }

    public static void takeQuiz(Profile profile, boolean[] quiz){
        ProfileHandlerOBJ.takeQuiz(profile,quiz);
    }

}
