/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends Command {

  DriveTrain driveTrain;
  public TankDrive() {

    driveTrain = DriveTrain.getInstance();

    requires(driveTrain);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //saadi - setting to get negative value for right joystick protects leftspeed value?? 
    //double leftSpeed = Math.pow(OI.leftJoystick.getY(), 3);
    //double rightSpeed = Math.pow(-OI.rightJoystick.getY(), 3);
    double leftSpeed = OI.leftJoystick.getY();
    double rightSpeed = -OI.rightJoystick.getY();

    driveTrain.drive(leftSpeed, rightSpeed);

    if(OI.leftTrigger.get()){
      driveTrain.closeDrive(leftSpeed, rightSpeed);
    }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
