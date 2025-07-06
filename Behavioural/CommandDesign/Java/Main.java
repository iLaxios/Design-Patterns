package Behavioural.CommandDesign.Java;

interface Command {
    public void execute();
}

// receiver
class Light {
    public void lightsTurnOn() {
        System.out.println("Light turned on!");
    }
}

class Stereo {
    public void turnVolumeUp() {
        System.out.println("Volume turned Up!");
    }
}

// commands that act on a reciver
class LightsTurnOn implements Command {

    private Light light;

    public LightsTurnOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightsTurnOn();
    }
}


class TurnVolumeUp implements Command {

    private Stereo stereo;

    public TurnVolumeUp(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.turnVolumeUp();
    }
}


// remote/invoker that takes a command and 
// asks the command to execute (triggers!)
class Remote {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}


public class Main {
    
    public static void main(String args[]) {

        Light light = new Light();
        Stereo stereo = new Stereo();
        LightsTurnOn lightsTurnOn = new LightsTurnOn(light);
        TurnVolumeUp turnVolumeUp = new TurnVolumeUp(stereo);
        
        Remote remote = new Remote();
        remote.setCommand(lightsTurnOn);
        remote.pressButton();

        remote.setCommand(turnVolumeUp);
        remote.pressButton();
    }
}
