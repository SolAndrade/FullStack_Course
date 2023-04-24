package ex4;

import java.util.List;

public class Movie extends Video{
    private String director;
    private List<String> actors;

    public Movie(String title, int duration, String language, List<String> subtitles, String director, List<String> actors) {
        super(title, duration, language, subtitles);
        this.director = director;
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return actors;
    }

    @Override
    public void play() {
        // play a movie
    }
}
