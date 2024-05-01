public class ProfileHandler {

    public ProfileHandler(){

    }
    public static boolean signUp(String user,String email,String phone,String pass,boolean[] quizAns){
        Profile newAcc  = new Profile(user,email,phone,pass);
        newAcc.takeQuiz(quizAns);
        return true;

    }

    public static void takeQuiz( Profile profile,boolean[] quiz){

    }
}
