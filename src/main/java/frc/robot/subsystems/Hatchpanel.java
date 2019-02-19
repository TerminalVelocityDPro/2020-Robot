/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class Hatchpanel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //1 CIM Motor
  //Rotates Back and Forth
  //PID Loops
  //Limit Switches
  //Encoders
  //Hatchpanel - rotation with one motor and pneumatics to push off the hatch panel,
  //Angules of rotation for dropoff and pickup.

  Spark rotator = new Spark(RobotMap.rotator);

  public static Hatchpanel instance = new Hatchpanel();

  DoubleSolenoid pusher = new DoubleSolenoid(0,1);

  public static Hatchpanel getInstance(){
    return instance;
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
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
