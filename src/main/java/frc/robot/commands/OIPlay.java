/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class OIPlay extends Command {
  BTMacroPlay player = null;
  public OIPlay() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    try {
      player = new BTMacroPlay();
      
    } catch (FileNotException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    while(isAutonomous()){
      if(player != null){
        player.play();
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
    if(player != null){
      player.end();
    }
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
