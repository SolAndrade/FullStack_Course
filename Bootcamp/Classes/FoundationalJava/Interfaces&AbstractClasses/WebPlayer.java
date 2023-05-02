package FullStack_IronHack.Bootcamp.Classes.w1.d4;

public class WebPlayer extends Player {
    public WebPlayer(double volume, int currentTrack) {
        super(volume, currentTrack);
    }

    @Override
    public void close() {
        System.out.println("Closing WebPlayer");
    }
}