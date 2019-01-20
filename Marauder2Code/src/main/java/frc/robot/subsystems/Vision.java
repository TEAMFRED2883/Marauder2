package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.awt.List;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Vision extends Subsystem {


	// These values are the default if you instantiate a PixySPI without arguments.
	// To create multiple PixySPI objects and thus use multiple Pixy cameras via SPI
	// Copy the items below, change variable names as needed and especially change
	// the SPI port used eg; Port.kOnboardCS[0-3] or Port.kMXP
	public PixyCamSPI pixy1;
	Port port = Port.kOnboardCS0;
	String print;
	public HashMap<Integer, ArrayList<PixyPacket>> packets = new HashMap<Integer, ArrayList<PixyPacket>>();
	public boolean DynamicInput = true;
	HashMap<Integer, PixyPacket> visonValues = new HashMap<Integer, PixyPacket>();
	public Vision(){
		// Open a pipeline to a Pixy camera.
		pixy1 = new PixyCamSPI(new SPI(port), packets, new PixyException(print));
		
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public HashMap<Integer, PixyPacket> GetVisionInfo()
	{
		return visonValues;
	}

	public void PostCustomSmartDashInfo(){
		for(Integer i : visonValues.keySet()){
				SmartDashboard.putNumber("OurValues|" + i + "|X:", visonValues.get(i).X);
				SmartDashboard.putNumber("OurValues|" + i + "|X:", visonValues.get(i).Y);
				SmartDashboard.putNumber("OurValues|" + i + "|X:", visonValues.get(i).Width);
				SmartDashboard.putNumber("OurValues|" + i + "|X:", visonValues.get(i).Height);
		}
	}

	public void testPixy1(){
		int ret = -1;
		// Get the packets from the pixy.
		try {
			ret = pixy1.readPackets();
		} catch (PixyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SmartDashboard.putNumber("Pixy Vision: packets size: ", packets.size());


		if(DynamicInput == true){
			for(int i = 1; i <= PixyCamSPI.PIXY_SIG_COUNT ; i++) {
				SmartDashboard.putString("Pixy Vision: Signature: ", Integer.toString(i));

				SmartDashboard.putNumber("Pixy Vision: packet: " + Integer.toString(i) + ": size: ", packets.get(i).size());
				
			
			// Loop through the packets for this signature.
			for(int j=0; j < packets.get(i).size(); j++) {
				PixyPacket ourPacket = new PixyPacket();
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": X: ", packets.get(i).get(j).X);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Y: ", packets.get(i).get(j).Y);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Width: ", packets.get(i).get(j).Width);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Height: ", packets.get(i).get(j).Height);
				ourPacket.X = packets.get(i).get(j).X;
				ourPacket.Y = packets.get(i).get(j).Y;
				ourPacket.Width = packets.get(i).get(j).Width;
				ourPacket.Height = packets.get(i).get(j).Height;
			}
			}	
		}
		else{
			//signature 1
			SmartDashboard.putString("Pixy Vision: Signature: ", Integer.toString(1));
			SmartDashboard.putNumber("Pixy Vision: packet: " + Integer.toString(1) + ": size: ", packets.get(1).size());
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(1) + ": X: ", packets.get(1).get(1).X);
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(1) + ": Y: ", packets.get(1).get(1).Y);
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(1) + ": Width: ", packets.get(1).get(1).Width);
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(1) + ": Height: ", packets.get(1).get(1).Height);
			//signature 2
			SmartDashboard.putString("Pixy Vision: Signature: ", Integer.toString(2));
			SmartDashboard.putNumber("Pixy Vision: packet: " + Integer.toString(2) + ": size: ", packets.get(2).size());
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(2) + ": X: ", packets.get(2).get(2).X);
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(2) + ": Y: ", packets.get(2).get(2).Y);
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(2) + ": Width: ", packets.get(2).get(2).Width);
			SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(2) + ": Height: ", packets.get(2).get(2).Height);
		}
		}
	}
