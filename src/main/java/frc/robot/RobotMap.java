/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int frontLeftDrive = 1;
  //public static int frontLeftAngle;
  public static int backLeftDrive = 2;
  //public static int backLeftAngle;
  public static int frontRightDrive = 3;
  //public static int frontRightAngle;
  public static int backRightDrive = 4;
  //public static int backRightAngle;

  public static int winch = 6;
  public static int flipMotor1 = 7;
  public static int flipMotor2 = 8;

  public static int hatchpanelLimit = 2;

  public static int rotator = 0;
  //public static int cargoMotor; //lol

  public static double defaultLeftP=0.02;
  public static double defaultLeftI=0;
  public static double defaultLeftD=0;
}
