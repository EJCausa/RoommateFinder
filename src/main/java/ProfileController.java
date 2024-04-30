public class ProfileController {
    private static ProfileHandler ProfileHandlerOBJ = new ProfileHandler();

    public static boolean signUp(String user,String email,String phone,String pass){

        ProfileHandlerOBJ.signUp(user, email, phone, pass);
        return true;

    }
    public static Profile login(String user, String email){



    }

}
