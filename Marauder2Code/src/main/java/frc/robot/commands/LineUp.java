/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.Vision;

/**
 * An example command.  You can replace me with your own command.
 */
public class LineUp extends Command {
  double driveSpeed = 0;
  double driveRotation = 0;
  double center = 0;
  double Speed = 0;
  public LineUp(double speed, double center) {
    // Use requires() here to declare subsystem dependencies
    this.center = center;
    this.Speed = speed;
    requires(Robot.m_driveTrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double temp = Robot.X;
    double temp2 = Robot.Y;
    double Rotation = (temp - center)/center;
    double Speed = (temp2 - 60)/60;

    if(Speed < 0){
        driveSpeed = -Speed;
        SmartDashboard.putString("Direction", "Back");
    }
    else{
      driveSpeed = Speed;
        SmartDashboard.putString(("Direction"), "Forward");
    }
    if(Rotation < 0){
      driveRotation = Speed;
    SmartDashboard.putString(("Direction2"), "Left");
    }
    else{
      SmartDashboard.putString("Direction2", "Right");
      driveRotation = -Speed;
    }

    SmartDashboard.putNumber("Rotation Calculated", Rotation);

    if((Robot.X > center + 20 || Robot.X < center - 20) && (Robot.Y > 65 || Robot.X < 55))
    Robot.m_driveTrain.DriveWithXbox(driveSpeed, driveRotation);
    else{
    Robot.m_driveTrain.DriveWithXbox(0, 0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.m_dDrive.arcadeDrive(0, 0);
  }
}