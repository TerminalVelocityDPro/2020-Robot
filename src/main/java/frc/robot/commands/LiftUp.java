package frc.robot.commands;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
* Error 404,
* @author Saadi Ahmad
* FRC 2019
*/

public class LiftUp extends Subsystem {

    DigitalInput limitSwitch = new DigitalInput(1);
    SpeedController armMotor = new Victor(1);
    Counter counter = new Counter(limitSwitch);

    //use counter increment to activate (fault tolerant)
    public boolean isSwitchSet() {
        return counter.get() > 0;
    }

    public void initializeCounter() {
        counter.reset();
    }

    public void liftUp() {
        //add spark 6
    }

    public void liftDown() {
        //add
    }

    public void liftStop() {
        //add 
    }
    protected void initDefaultCommand() {
    }
}