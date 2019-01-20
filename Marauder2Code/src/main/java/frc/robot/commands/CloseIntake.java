/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class CloseIntake extends Command {
  public CloseIntake() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_Intake);
  }

  //Called just before this COmmand runs the first time
  @Override
  protected void initialize(){
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_Intake.InOut(false);
    Robot.m_Intake.SetMotor(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.m_dDrive.tankDrive(0, 0);
  }
}
