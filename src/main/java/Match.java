public class Match {
    Profile candidate;
    double matchValue;
    boolean isFavorite;

    public Match(Profile candidate, double matchValue, boolean isFavorite) {
        this.candidate = candidate;
        this.matchValue = matchValue;
        this.isFavorite = isFavorite;
    }

    public double computeMatchValue(boolean[] homeUser, boolean[] guestUser)
    {
        int baseScore = 0;
        for(int i = 0; i < homeUser.length; i++)
        {
            if(homeUser[i] == guestUser[i])
            {
                baseScore++;
            }
        }
        double finalScore = (double) baseScore / homeUser.length;
        return finalScore;
    }

    //getters

    public Profile getCandidate() {
        return this.candidate;
    }

    public double getMatchValue() {
        return this.matchValue;
    }

    public boolean getisFavorite() {
        return this.isFavorite;
    }

    //setters

    public void setCandidate(Profile candidate) {
        this.candidate = candidate;
    }

    public void setMatchValue(double matchValue) {
        this.matchValue = matchValue;
    }
    
    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
