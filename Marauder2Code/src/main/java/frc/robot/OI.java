/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import java.lang.module.ModuleDescriptor.Requires;
import java.util.HashMap;
//import com.sun.tools.jdi.Packet;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.OpenIntake;
import frc.robot.commands.SpitOut;
import frc.robot.commands.ToggleIntake;
import frc.robot.subsystems.PixyPacket;
import frc.robot.commands.CloseIntake;
import frc.robot.commands.LineUp;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.PixyCamSPI;
import frc.robot.subsystems.Vision;
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
  final XboxController stick = new XboxController(RobotMap.XboxPort);
  public Button A_button = new JoystickButton(stick, RobotMap.A_Button);
  public Button B_button = new JoystickButton(stick, RobotMap.B_Button);
  public Button X_button = new JoystickButton(stick, RobotMap.X_Button);
  public Button Y_button = new JoystickButton(stick, RobotMap.Y_Button);
  public Button RightBumper =new JoystickButton(stick, RobotMap.RightBumper);
  

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
public OI()
{
  
double center = 157.5;
double Rotation = 0.5;
double Speed = 0;

//double Rotation = (center-X)/center;




  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());
  A_button.whileHeld(new OpenIntake());
  B_button.whileHeld(new SpitOut());
  RightBumper.whenPressed(new ToggleIntake());
  A_button.whenReleased(new CloseIntake());
  B_button.whenReleased(new CloseIntake());
  X_button.whileHeld(new LineUp(Speed,Rotation));
  //Configure Elevator
 /* X_button.whileHeld(new ElevatorUp());
  X_button.whenReleased(new ElevatorStop());
  Y_button.whileHeld(new ElevatorDown());
  Y_button.whenReleased(new ElevatorStop());*/
}

  public XboxController GetConch(){
    return stick;
  }


  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
