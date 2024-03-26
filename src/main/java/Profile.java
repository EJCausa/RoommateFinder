import java.util.ArrayList;

public class Profile {
    String username;
    String email;
    String phoneNumber;
    String password;
    ArrayList<Match> matches;
    String quizAnswers;
    ArrayList<Profile> favorites;
    ArrayList<Profile> blockedUsers;
    ArrayList<House> housePosts;


    public Profile (String uname, String email, String pnum, String pswd) {
        this.username = uname;
        this.email = email;
        this.phoneNumber = pnum;
        this.password = pswd;
        this.matches = new ArrayList<Match>();
        this.quizAnswers = "";
        this.favorites = new ArrayList<Profile>();
        this.blockedUsers = new ArrayList<Profile>();
        this.housePosts = new ArrayList<House>();
    }


    public void takeQuiz() {

        ///quiz code & print statements

        
    }


    public void login() {

    }

    public void signUp() {

    }

    public void openConversation() {

    }

    public void sendNewMessage(String message) {

    }

    public void changeInfo() {

    }

    public void checkInbox() {

    }

    public void favoriteUser(Profile user) {
        this.favorites.add(user);
    }

    public void blockUser(Profile user) {
        this.blockedUsers.add(user);
    }

    public void unfavoriteUser(Profile user) {
        
    }

    public void unblockUser(Profile user) {

    }

    public void makeHousePost() {

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

    public String getQuizAnswers() {
        return quizAnswers;
    }

    public ArrayList<Profile> getFavorites() {
        return favorites;
    }

    public ArrayList<Profile> getBlockedUsers() {
        return blockedUsers;
    }

    public ArrayList<House> getHousePosts() {
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

    public void setQuizAnswers(String quizAnswers) {
        this.quizAnswers = quizAnswers;
    }

}
