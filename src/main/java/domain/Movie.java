package domain;

public class Movie {

    private String title;
    private String director;
    private int pop;
    private double score;

    public Movie(String title, String director, int pop, double score) {
        this.title = title;
        this.director = director;
        this.pop = pop;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", pop=" + pop +
                ", score=" + score +
                '}';
    }
}
