/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.OI;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public static Joystick leftJoystick = new Joystick(0);
  public static Joystick rightJoystick = new Joystick(1);

  public static JoystickButton leftTrigger = new JoystickButton(leftJoystick, 1);
  public static JoystickButton leftButton3 = new JoystickButton(leftJoystick, 3);
  public static JoystickButton leftButton4 = new JoystickButton(leftJoystick, 4);
  public static JoystickButton leftButton5 = new JoystickButton(leftJoystick, 5);
  public static JoystickButton leftButton6 = new JoystickButton(leftJoystick, 6);

	

  public static JoystickButton rightTrigger = new JoystickButton(rightJoystick, 1);
  public static JoystickButton rightButton3 = new JoystickButton(rightJoystick, 3);
  public static JoystickButton rightButton4 = new JoystickButton(rightJoystick, 4);
  
  public static XboxController xbox = new XboxController(2);

  static{
      //rotate arm up
      OI.xbox.rt.whileHeld(new RotateHP(-0.5));
      //rotate arm down
      OI.xbox.lt.whileHeld(new RotateHP(0.68));
      OI.xbox.y.whileHeld(new Winch(1));
      OI.xbox.dPad.right.whileHeld(new Winch(0.5));
      OI.xbox.x.whileHeld(new Winch(-1));
      OI.leftTrigger.whileHeld(new TestReverseWinch(0));
      //Use reverse winch for game only
      //Unwind rever//se winch for flip
      //Use only winch for flip
      OI.rightTrigger.whileHeld(new TestReverseWinch(-.5));
      OI.xbox.dPad.up.whenPressed(new Flip(-0.75));
      OI.xbox.dPad.down.whenPressed(new Flip(0.05));
      //OI.xbox.dPad.up.whileHeld(new FinalFlip());
      OI.xbox.a.whenPressed(new PushHP());
      OI.xbox.b.whenPressed(new ResetHP());
  }

  

  
}
