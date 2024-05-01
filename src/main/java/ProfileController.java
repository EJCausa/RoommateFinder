public class ProfileController {
    private static ProfileHandler ProfileHandlerOBJ = new ProfileHandler();

    public static boolean signUp(String user,String email,String phone,String pass,boolean[] quizAns){

        ProfileHandlerOBJ.signUp(user, email, phone, pass,quizAns);
        return true;

    }
//    public static Profile login(String user, String email){
//
//
//
//    }

    public static void takeQuiz(Profile profile, boolean[] quiz){
        ProfileHandlerOBJ.takeQuiz(profile,quiz);
    }

}
