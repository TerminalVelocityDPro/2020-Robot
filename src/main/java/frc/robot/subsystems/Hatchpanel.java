package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DefaultHP;

public class Hatchpanel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Spark rotator = new Spark(RobotMap.rotator);
    public static Hatchpanel instance = new Hatchpanel();
    DigitalInput hatchpanelLimit = new DigitalInput(RobotMap.hatchpanelLimit);
    Counter counter = new Counter(hatchpanelLimit);
    double reverseHoldSpeed = -0.25;
    DoubleSolenoid pusher = new DoubleSolenoid(1,0);

    public static Hatchpanel getInstance() {
        return instance;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DefaultHP());
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    public double getRotator(){
        return rotator.get();
    }

    public void setRotator(double num1){
        rotator.set(num1);
    }

    public void setSolenoid(double num1){
        if(num1 == 1){
            pusher.set(DoubleSolenoid.Value.kForward);
        }
        else if(num1 == 0){
            pusher.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public double getSolenoid(){
        double value = 0;
        if(pusher.get() == DoubleSolenoid.Value.kForward){
            value = 1;
        }
        else if(pusher.get() == DoubleSolenoid.Value.kReverse){
            value = 0;
        }
        return value;
    }

    public void hold(){
        rotator.set(0.25);
        if(counter.get() > 0){
            rotator.set(-0.25);
        }
    }

    public void pushOff(){
        pusher.set(DoubleSolenoid.Value.kForward);
    }

    public void reset(){
        pusher.set(DoubleSolenoid.Value.kReverse);
    }

    public void rotate(double num){
        rotator.set(num);
    }
}

