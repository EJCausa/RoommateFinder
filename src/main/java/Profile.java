import java.util.ArrayList;

public class Profile {
    String username;
    String email;
    String phoneNumber;
    String password;
    ArrayList<Match> matches;
    boolean quizAnswers[];
    static final int questionAmt = 10;
    ArrayList<Profile> favorites;
    ArrayList<Profile> blockedUsers;
    ArrayList<HousePost> housePosts;


    public Profile (String uname, String email, String pnum, String pswd) {
        this.username = uname;
        this.email = email;
        this.phoneNumber = pnum;
        this.password = pswd;
        this.matches = new ArrayList<Match>();
        this.quizAnswers =new boolean[questionAmt];
        this.favorites = new ArrayList<Profile>();
        this.blockedUsers = new ArrayList<Profile>();
        this.housePosts = new ArrayList<HousePost>();
    }


    public void takeQuiz(boolean[] activeAnswers) {
        for(int i = 0; i < activeAnswers.length; i++)
        {
            this.quizAnswers[i] = activeAnswers[i];
        }
        ///quiz code & print statements
    }

    public void favoriteUser(Profile user) {
        this.favorites.add(user);
    }

    public void blockUser(Profile user) {
        this.blockedUsers.add(user);
    }

    public void unfavoriteUser(Profile user) {
        this.favorites.remove(user);
    }

    public void unblockUser(Profile user) {
        this.blockedUsers.remove(user);
    }

    public void makeHousePost() {
        HousePost.makeHousePost();
    }



    //getters

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<Match> getMatches() {
        return this.matches;
    }

    public boolean[] getQuizAnswers() {
        return quizAnswers;
    }

    public ArrayList<Profile> getFavorites() {
        return favorites;
    }

    public ArrayList<Profile> getBlockedUsers() {
        return blockedUsers;
    }

    public ArrayList<HousePost> getHousePosts() {
        return housePosts;
    }


    //setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setQuizAnswers(boolean[] quizAnswers) {
        this.quizAnswers = quizAnswers;
    }

}
