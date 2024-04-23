public class ProfileHandler {

    public ProfileHandler(){

    }
    public static boolean signUp(String user,String email,String phone,String pass){

        Profile newAcc  = new Profile(user,email,phone,pass);
        return true;

    }
}
