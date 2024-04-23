public class ProfileController {
    private static ProfileHandler ProfileHandlerOBJ = new ProfileHandler();
    private ProfileOBJ = new Profile();
    public static boolean signUp(String user,String email,String phone,String pass){

        ProfileHandlerOBJ.signUp(user, email, phone, pass);
        return true;

    }
    public static profile login(String user, String email){

    }

}
