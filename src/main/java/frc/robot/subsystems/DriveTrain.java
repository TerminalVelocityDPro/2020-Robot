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
public class DriveTrain extends Subsystem {

  


  Spark frontLeftDrive = new Spark(RobotMap.frontLeftDrive);
  //Spark frontLeftAngle = new Spark(RobotMap.frontLeftAngle);
  Spark backLeftDrive = new Spark(RobotMap.backLeftDrive);
  //Spark backLeftAngle = new Spark(RobotMap.backLeftAngle);
  Spark frontRightDrive = new Spark(RobotMap.frontRightDrive);
  //Spark frontRightAngle = new Spark(RobotMap.frontRightAngle);
  Spark backRightDrive = new Spark(RobotMap.backRightDrive);

  //Encoder frontLeft = new Encoder(0, 1, false, EncodingType.k4X);

  //PIDController frontLeft = new PIDController(1, 0, 0, new AnalogInput(Encoder), frontLeftAngle);

  double lastRight = 0;
  double lastLeft = 0;

  public final double L = 1;
  public final double W = 1;

  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.



  public static DriveTrain instance = new DriveTrain();

  // public void swerveDrive(double x1, double y1, double x2){
  //   double r = Math.sqrt((L*L) + (W*W));
  //   y1 *= -1;

  //   double a = x1 - x2 * (L/r);
  //   double b = x1 + x2 * (L/r);
  //   double c = y1 - x2 * (W/r);
  //   double d = y1 + x2 * (W/r);

  //   double backRightSpeed = Math.sqrt((a*a) + (d*d));
  //   double backLeftSpeed = Math.sqrt((a*a) + (c*c));
  //   double frontRightSpeed = Math.sqrt((b*b) + (d*d));
  //   double frontLeftSpeed = Math.sqrt((b*b) + (c*c));

  //   double backRightAngle = Math.atan2(a,d) / Math.PI;
  //   double backLeftAngle = Math.atan2(a, c) / Math.PI;
  //   double frontRightAngle = Math.atan2(b, d) / Math.PI;
  //   double frontLeftAngle = Math.atan2(b,c) / Math.PI;
    

  // }

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
