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
 * Toggles the intake.
 */
public class ToggleIntake extends Command {
  boolean IsUp = false;
  boolean done = false;
  public ToggleIntake() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_Elevator);
  }
  @Override
  protected void initialize(){
    done = false;
  }
  // Called repeatedly when this Command is scheduled to run

  @Override
  protected void execute() {
    if(IsUp){
      Robot.m_Intake.Tip(false);
    }
    else{
      Robot.m_Intake.Tip(true);
    }
    IsUp = !IsUp;
    done = true;
    isFinished();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }
}
