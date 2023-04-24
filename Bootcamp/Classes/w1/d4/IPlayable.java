package FullStack_IronHack.Bootcamp.Classes.w1.d4;

public interface IPlayable {
    public abstract void play();
    void pause();
    void mute();
    void increaseVolume();

    final double MAX_VOLUME = 1;
}