package ex4;

import java.util.List;

public abstract class Video {
    private String title;
    private int duration;
    private String language;
    private List<String> subtitles;

    public Video(String title, int duration, String language, List<String> subtitles) {
        this.title = title;
        this.duration = duration;
        this.language = language;
        this.subtitles = subtitles;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getSubtitles() {
        return subtitles;
    }

    public abstract void play();
}
