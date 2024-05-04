public class Match {
    String candidate;
    //double matchValue;
    boolean isFavorite;

    public Match(String candidate, boolean isFavorite) {
        this.candidate = candidate;
       // this.matchValue = matchValue;
        this.isFavorite = isFavorite;
    }

    public int computeMatchValue(boolean[] homeUser, boolean[] guestUser) {
        int baseScore = 0;
        for (int i = 0; i < homeUser.length; i++) {
            if (homeUser[i] == guestUser[i]) {
                baseScore++;
            }
        }
        //consider adding assignment "matchValue = finalScore;
        return baseScore;
    }

    //getters

//    public Profile getCandidate() {
//        return this.candidate;
//    }

//    public double getMatchValue() {
//        return this.matchValue;
//    }

    public boolean getIsFavorite() {
        return this.isFavorite;
    }//idk if we need this - Ariel

    //setters

//    public void setCandidate(Profile candidate) {
//        this.candidate = candidate;
//    }

//    public void setMatchValue(double matchValue) {
//        this.matchValue = matchValue;
//    }

    public void setFavorite(boolean IsFavorite) {
        this.isFavorite = IsFavorite;
    }//idk if we need this - Ariel
}
