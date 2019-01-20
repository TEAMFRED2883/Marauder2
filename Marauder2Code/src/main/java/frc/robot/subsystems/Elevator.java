/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ElevatorTriggerControl;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Motors
  final WPI_TalonSRX Elevator1 = new WPI_TalonSRX(RobotMap.Elevator1);
  final WPI_TalonSRX Elevator2 = new WPI_TalonSRX(RobotMap.Elevator2);

  //Inputs
  DigitalInput topSwitch = new DigitalInput(RobotMap.TopSwitch);
  DigitalInput botSwitch = new DigitalInput(RobotMap.BotSwitch);
  //Pnuematics
  final Solenoid Break = new Solenoid(RobotMap.Break);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ElevatorTriggerControl());
    // setDefaultCommand(new MySpecialCommand());
  }
  /**Moves elevator Upwards */
    public void TriggerControl(XboxController box)
    {
      if(botSwitch.get() && box.getRawAxis(2) != 0){
        Break.set(false);
        Elevator1.set(-box.getRawAxis(2));
        Elevator2.set(-box.getRawAxis(2));


      }
      else if(topSwitch.get() && box.getRawAxis(3) !=0)
      { Break.set(false);
        Elevator1.set(box.getRawAxis(3));
        Elevator2.set(box.getRawAxis(3));
      }
      else{
        Elevator1.set(0);
        Elevator2.set(0);
        Break.set(true);
        
      }


 
  }

  public void SetElevatorSpeed (double speed)
{
  {
    if(botSwitch.get() && speed < 0){
      Break.set(false);
      Elevator1.set(speed);
      Elevator2.set(speed);


    }
    else if(topSwitch.get() && speed > 0)
    { 
      Break.set(false);
      Elevator1.set(speed);
      Elevator2.set(speed);
    }
    else
      Break();
      
  }
}
public void Break()
{
  Break.set(true);
  Elevator1.set(0);
  Elevator2.set(0);}
}
