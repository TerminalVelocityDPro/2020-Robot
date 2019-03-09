/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.Lift;

public class FinalFlip extends CommandGroup {

  public FinalFlip() {
    //addSequential(new ReverseWinch(3,1)); //Reverse
    //addSequential(new Delay(3, 0)); //Delay
    addParallel(new FlipTimed(20,.75));
    addSequential(new Delay(20, 0));
    //addSequential(new LiftTimed(10, -0.5));

  }
}
