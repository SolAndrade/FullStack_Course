package ex4;

import java.util.List;

public class TvSeries extends Video{
    private int seasons;
    private List<String> characters;

    public TvSeries(String title, int duration, String language, List<String> subtitles, int seasons, List<String> characters) {
        super(title, duration, language, subtitles);
        this.seasons = seasons;
        this.characters = characters;
    }

    public int getSeasons() {
        return seasons;
    }

    public List<String> getCharacters() {
        return characters;
    }

    @Override
    public void play() {
        // play a series
    }
}
