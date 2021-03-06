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
    double temp2 = Robot.Width;
    double Rotation = (temp - center)/center*0.6;
    double Speed = (160 - temp2)/160*0.6;

    if(Speed < 0){
        SmartDashboard.putString("Direction", "Back");
        //Speed -= .2;
    }
    else{
        SmartDashboard.putString(("Direction"), "Forward");
       // Speed += .2;
    }
    if(Rotation < 0){
    SmartDashboard.putString(("Direction2"), "Left");
    //Rotation -=.2;
    }
    else{
      SmartDashboard.putString("Direction2", "Right");
      //Rotation += .2;
    }

    SmartDashboard.putNumber("Rotation Calculated", Rotation);
    SmartDashboard.putNumber("Speed Calculated", Speed);


    if(Robot.PixySigCount == 1) {
    Robot.m_driveTrain.DriveWithXbox(Rotation, (Speed));
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