/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.PID;

/**
 * Add your docs here.
 */
public class HatchpanelPID {
    public static HatchpanelPID instance = new HatchpanelPID();
    Hatchpanel hatchpanel = Hatchpanel.getInstance();
    PIDController pidController;
    double speed;

    public HatchpanelPID(){

    }

    public void init(double targetDistance, double maxSpeed){
        PIDSource pidSource = new PIDSource(){
            @Override
            public void setPIDSourceType(PIDSourceType pidSource){}

            @Override
            public PIDSourceType getPIDSourceType(){
                return PIDSourceType.kDisplacement();
            }

            @Override
            public double pidGet(){
                return 0;
            }
        };

        PIDOutput pidOutput = new PIDOutput(){
            @Override
            public void pidWrite(double output){
                speed = -output;
            }
        };

        final double kP = SmartDashboard.getNumber("Left P", RobotMap.defaultLeftP);
        final double kI = SmartDashboard.getNumber("Left I", RobotMap.defaultLeftI);
        final double kD = SmartDashboard.getNumber("Left D", RobotMap.defaultLeftD);

        pidController = new PIDController(kP, kI, kD, pidSource, pidOutput);
        pidController.setAbsoluteTolerance(2);
        pidController.setSetpoint(targetDistance);
        pidController.enable();
        System.out.println("Button is pressed");
    }

    public double getSpeed(){
        return speed;
    }

    public boolean onTarget(){
        return pidController.onTarget();
    }

    public void end(){
        pidController.disable();
        pidController.free();
    }

    public static HatchpanelPID getInstance(){
        return instance;
    }

}
