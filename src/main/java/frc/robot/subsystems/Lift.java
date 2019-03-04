package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.DefaultHP;
import frc.robot.commands.DefaultWinch;
import frc.robot.commands.DefaultWinchBefore;

public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.


    Spark winch = new Spark(RobotMap.winch);
    Spark flipMotor1 = new Spark(RobotMap.flipMotor1);
    Spark flipMotor2 = new Spark(RobotMap.flipMotor2);
    public static Lift instance = new Lift();
    public static Lift getInstance(){
        return instance;
    }
    boolean liftFlag = false;

    public void lift(double num){
        winch.set(num);
        liftFlag = true;
    }

    public void holdV1(){
        winch.set(0);

    }

    public void holdV2(){
        winch.set(0.25);
    }


    public void flip(double num1){
        flipMotor1.set(num1);
        flipMotor2.set(num1);
    }





    public void initDefaultCommand() {
        boolean beforeLift = false;

        if(OI.xbox.dPad.left.get()){
            beforeLift = false;
        }

        if(OI.xbox.dPad.right.get()){
            beforeLift = true;
        }

        if(beforeLift == true){
            setDefaultCommand(new DefaultWinch());
        }
        else if(beforeLift == false){
            setDefaultCommand(new DefaultWinchBefore());
        }
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

