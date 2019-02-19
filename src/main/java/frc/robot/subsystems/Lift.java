/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //2 CIM Motors
  //PID Loops
  //Encoders
  //Limit Switches
  //Lift - One motor rotation for a winch to lift up robot from foot at endgame, goes in both directions so we can pick
  //foot back up.
  //Rotation - two motor gearbox that powers the flip at endgame, one time use, one direction



  Spark winch = new Spark(RobotMap.winch);


  Spark flipMotor1 = new Spark(RobotMap.flipMotor1);
  Spark flipMotor2 = new Spark(RobotMap.flipMotor2);

  public static Lift instance = new Lift();

  public static Lift getInstance(){
    return instance;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void lift(double num){
    winch.set(num);
  }

  public void flip(double num1, double num2){
    flipMotor1.set(num1);
    flipMotor2.set(num2);
  }

  


}
