/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An example command.  You can replace me with your own command.
 */
public class SimpleAuto extends CommandGroup {
  public SimpleAuto(){
      addSequential(new Drive(.65,0.2), 2);
      addSequential(new Drive(.1,.6), .5);
      addSequential(new Drive(0,-.2), .1);
      addSequential(new Drive(.65,.2), 1.4);
      addSequential(new Drive(-.15,0), .5);
      addSequential(new Drive(-.65, -.2), 1.3);
      addSequential(new Drive(0, .2), .1);
      addSequential(new Drive(-.1,-.55), .5);
      addSequential(new Drive(-.65,-.2), 1.5);

  }

}