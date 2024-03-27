public class Match {
    Profile candidate;
    double matchValue;
    boolean isFavorite;

    public Match(Profile candidate, double matchValue, boolean isFavorite) {
        this.candidate = candidate;
        this.matchValue = matchValue;
        this.isFavorite = isFavorite;
    }

    public double computeMatchValue() {
        return 0.0;
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
