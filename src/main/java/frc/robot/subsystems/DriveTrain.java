/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;
/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {


  Spark frontLeftDrive = new Spark(RobotMap.frontLeftDrive);
  Spark backLeftDrive = new Spark(RobotMap.backLeftDrive);
  Spark frontRightDrive = new Spark(RobotMap.frontRightDrive);
  Spark backRightDrive = new Spark(RobotMap.backRightDrive);

  double lastRight = 0;
  double lastLeft = 0;

  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.



  public static DriveTrain instance = new DriveTrain();

  public void drive(double leftSpeed, double rightSpeed){
    frontLeftDrive.set(leftSpeed);
    backLeftDrive.set(leftSpeed);
    frontRightDrive.set(rightSpeed);
    backRightDrive.set(rightSpeed);
    lastRight = rightSpeed;
    lastLeft = leftSpeed;
  }

  public void setLeftSpeed(double leftSpeed){
    frontLeftDrive.set(leftSpeed);
    backLeftDrive.set(leftSpeed);
    lastLeft = leftSpeed;
  }

  public void stop(){
    frontLeftDrive.stopMotor();
    backLeftDrive.stopMotor();
    frontRightDrive.stopMotor();
    backRightDrive.stopMotor();
    lastRight = 0;
    lastLeft = 0;
  }

  public double getLastLeft(){
    return lastLeft;
  }

  public double getLastRight(){
    return lastRight;
  }

  public static DriveTrain getInstance(){
    return instance;
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TankDrive());
  }
}
