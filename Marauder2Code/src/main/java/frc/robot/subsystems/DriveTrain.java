/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.commands.ExampleCommand;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.LineUp;
import frc.robot.RobotMap;
//import frc.robot.commands.Drive;

/**
 * Do NOT add any static variables to this class, or any initialization at all.
 * Unless you know what you are doing, do not modify this file except to change
 * the parameter class to the startRobot call.
 */
public class DriveTrain extends Subsystem {
  
  //motors
  private final WPI_TalonSRX LeftBack = new WPI_TalonSRX(RobotMap.LeftBack);
  private final WPI_TalonSRX LeftFront = new WPI_TalonSRX(RobotMap.LeftFront);
  private final WPI_TalonSRX RightBack = new WPI_TalonSRX(RobotMap.RightBack);
  private final WPI_TalonSRX RightFront = new WPI_TalonSRX(RobotMap.RightFront);

  //Grooping
  public SpeedControllerGroup m_Left = new SpeedControllerGroup(LeftFront, LeftBack);
  public SpeedControllerGroup m_Right = new SpeedControllerGroup(RightFront, RightBack);
  //drivetrain
  final public DifferentialDrive m_dDrive = new DifferentialDrive(m_Left, m_Right);
 
  public DriveTrain()
  {
    super();

    //m_dDrive = new DifferentialDrive(m_Left, m_Right);
    m_Left.setInverted(true);
    m_dDrive.setSafetyEnabled(true);
    m_dDrive.setExpiration(0.3);
    m_dDrive.setMaxOutput(1);

  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ExampleCommand());
  }
  public void DriveWithXbox(XboxController box){
    m_dDrive.arcadeDrive(box.getRawAxis(0), -box.getRawAxis(1));
  }
  public void DriveWithXbox(double speed, double rotation)
  {
    m_dDrive.arcadeDrive(speed, rotation);
  }
}
