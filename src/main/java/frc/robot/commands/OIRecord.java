/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class OIRecord extends Command {
  BTMacroRecord recorder = null;
  public OIRecord() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    try{
      recorder = new BTMacroRecord();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(isOperatorControl()){
      if(OI.leftButton6.whenPressed()){
        try{
          if(recorder != null){
            recorder.record();
          }
        }
        catch(IOException e){
            e.printStackTrace();
        }
      }

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
    try{
      if(recorder != null){
        recorder.end();
      }
    }
      catch(IOException e){
        e.printStackTrace();
      }
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
