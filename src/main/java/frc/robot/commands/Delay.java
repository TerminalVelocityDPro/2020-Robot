/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.subsystems.Lift;

/**
 * Add your docs here.
 */
public class Delay extends TimedCommand {
    /**
     * Add your docs here.
     */
    Lift lift = Lift.getInstance();
    double speed1;




    public Delay(double timeout, double spd1) {
        super(timeout);
        requires(lift);
        speed1 = spd1;
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
        lift.reverseWinch(speed1);

    }

    // Called once after timeout
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
