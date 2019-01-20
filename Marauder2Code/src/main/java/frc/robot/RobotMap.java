/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.XboxController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Joysitcks
  public static int XboxPort = 0;
  public static int A_Button = 1;
  public static int B_Button = 2;
  public static int X_Button = 3;
  public static int Y_Button = 4;
  public static int RightBumper = 6;
  //drivetrain
  public static int LeftFront = 13;
  public static int RightFront = 17;
  public static int LeftBack = 12;
  public static int RightBack = 15;
  //elevator
  public static int Elevator1 = 10;
  public static int Elevator2 = 11;
  //Elevator DIO's
  public static int BotSwitch = 7;
  public static int TopSwitch = 8;
  //Intake Motors
  public static int IntakeRight = 14;
  public static int IntakeLeft = 16;
  //Selenoids
  public static int In = 0;
  public static int Out = 1;
  public static int Up = 2;
  public static int Down = 3;
  
  public static int Break = 4;
}