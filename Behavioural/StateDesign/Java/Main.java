package Behavioural.StateDesign.Java;

interface State {
    void play(MediaPlayer player);
    void pause(MediaPlayer player);
}


class PlayingState implements State {

    public void play(MediaPlayer player) {
        System.out.println("Already Playing...");
    }

    public void pause(MediaPlayer player) {
        System.out.println("Pausing...");
        player.setState(new PauseState());
    }
}

class PauseState implements State {

    public void play(MediaPlayer player) {
        System.out.println("Playing...");
        player.setState(new PlayingState());
    }

    public void pause(MediaPlayer player) {
        System.out.println("Already Paused...");
    }
}


class MediaPlayer {

    State currentState = new PauseState();

    void setState(State state) {
        currentState = state;
    }

    void pressPlay() {
        currentState.play(this);
    }

    void pressPause() {
        currentState.pause(this);
    }
}


public class Main {
    public static void main(String args[]) {

        MediaPlayer player = new MediaPlayer();
        player.pressPlay();
        player.pressPause();
        player.pressPause();
        player.pressPlay();
        player.pressPlay();
    }
}
