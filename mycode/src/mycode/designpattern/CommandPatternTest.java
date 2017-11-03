package mycode.designpattern;

public class CommandPatternTest {
	//client
    public static void main(String[] args)
    {
        Light livingRoomLight = new Light();    //receiver 1
 
        Fan livingRoomFan = new Fan();  //receiver 2
 
        Light bedRoomLight = new Light();   //receiver 3
 
        Fan bedRoomFan = new Fan();     //receiver 4
 
        HomeAutomationRemote remote = new HomeAutomationRemote();   //Invoker
 
        remote.setCommand(new TurnOnLightCommand( livingRoomLight ));
        remote.buttonPressed();
 
        remote.setCommand(new TurnOnLightCommand( bedRoomLight ));
        remote.buttonPressed();
 
        remote.setCommand(new StartFanCommand( livingRoomFan ));
        remote.buttonPressed();
 
        remote.setCommand(new StopFanCommand( livingRoomFan ));
        remote.buttonPressed();
 
        remote.setCommand(new StartFanCommand( bedRoomFan ));
        remote.buttonPressed();
 
        remote.setCommand(new StopFanCommand( bedRoomFan ));
        remote.buttonPressed();
    }
}

/**
 * Command Interface which will be implemented by the exact commands.
 *
 */
@FunctionalInterface
interface ICommand {
    public void execute();
}

/**
 * Light is a Receiver component in command pattern terminology.
 *
 */
class Light {
    public  void turnOn() {
        System.out.println("Light is on");
    }
 
    public void turnOff() {
        System.out.println("Light is off");
    }
}

/**
 * Fan class is a Receiver component in command pattern terminology.
 *
 */
class Fan {
    void start() {
        System.out.println("Fan Started..");
 
    }
 
     void stop() {
        System.out.println("Fan stopped..");
 
    }
}

/**
 * Light Start Command where we are encapsulating both Object[light] and the
 * operation[turnOn] together as command. This is the essence of the command.
 *
 */
class TurnOffLightCommand implements ICommand {
 
    Light light;
 
    public TurnOffLightCommand(Light light) {
        super();
        this.light = light;
    }
 
    public void execute() {
        System.out.println("Turning off light.");
        light.turnOff();
    }
}

/**
 * Light stop Command where we are encapsulating both Object[light] and the
 * operation[turnOff] together as command. This is the essence of the command.
 *
 */
class TurnOnLightCommand implements ICommand {
 
    Light light;
 
    public TurnOnLightCommand(Light light) {
        super();
        this.light = light;
    }
 
    public void execute() {
        System.out.println("Turning on light.");
        light.turnOn();
    }
}

/**
 * Fan Start Command where we are encapsulating both Object[fan] and the
 * operation[start] together as command. This is the essence of the command.
 *
 */
class StartFanCommand implements ICommand {
 
    Fan fan;
 
    public StartFanCommand(Fan fan) {
        super();
        this.fan = fan;
    }
 
    public void execute() {
        System.out.println("starting Fan.");
        fan.start();
    }
}

class StopFanCommand implements ICommand {
	 
    Fan fan;
 
    public StopFanCommand(Fan fan) {
        super();
        this.fan = fan;
    }
 
    public void execute() {
        System.out.println("stopping Fan.");
        fan.stop();
    }
}

/**
 * Remote Control for Home automation where it will accept the command and
 * execute. This is the invoker in terms of command pattern terminology
 */
class HomeAutomationRemote {
     
    //Command Holder
    ICommand command;
 
    //Set the command in runtime to trigger.
    public void setCommand(ICommand command) {
        this.command = command;
    }
 
    //Will call the command interface method so that particular command can be invoked.
    public void buttonPressed() {
        command.execute();
    }
}