
/**
 * Created by Bilal on 4/25/2017.
 */

class Movie {

    private boolean isWatched;
    private String title;
    private int year;

    Movie(String title, int year) {
        this.title = title;
        this.year = year;
        this.isWatched = false;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getWatchedState() {
        return isWatched ? "watched" : "unwatched";
    }

    public String getTitleAndStatus() {
        return getTitle() + " ("
                + getWatchedState() + ")";
    }
}
