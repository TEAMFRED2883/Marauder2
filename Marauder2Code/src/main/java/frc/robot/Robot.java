/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PixyCamSPI;
import frc.robot.commands.SimpleAuto;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.Vision;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  public static Elevator m_Elevator = new Elevator();
  public static DriveTrain m_driveTrain = new DriveTrain();
  public static OI m_oi;
  public static Compressor m_compressor = new Compressor();
  public static Intake m_Intake = new Intake();
  CameraServer server;

  Command m_autonomousCommand = null;
  SendableChooser<Command> m_chooser = new SendableChooser<>(); 

  public Vision Eyes;

  public static int X = 0;
  public static int Y = 0;
  public static int Width = 0;
  public static int PixySigCount = 0;
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    m_chooser.addOption("Timed Auto", new SimpleAuto());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    m_compressor.setClosedLoopControl(true);
    server = CameraServer.getInstance();
    //server.setQuality(50);
    server.startAutomaticCapture("cam0",0);

   Eyes = new Vision();
  
   
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  //@Override
  //public void robotPeriodic() {
  //}

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  //@Override
  //public void disabledInit() {
  //}

  //@Override
  //public void disabledPeriodic() {
    //Scheduler.getInstance().run();
  //}

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }


  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    Eyes.testPixy1();
    Eyes.PostCustomSmartDashInfo();
    if(Eyes.GetVisionInfo().get(1) != null){
    X = Eyes.GetVisionInfo().get(1).X;
    Y = Eyes.GetVisionInfo().get(1).Y;
    Width = Eyes.GetVisionInfo().get(1).Width;
    }

    SmartDashboard.putNumber("Our X From Vision:", X);
    SmartDashboard.putNumber("Our Y From Vision:", Y);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
