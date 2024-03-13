// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    
    

  }
  public static class DriveTrainConstants
  {
    //update CAN IDS
    public static final int rightBackID = 2;
    public static final int leftBackID = 1;
    public static final int rightFrontID = 4;
    public static final int leftFrontID = 3; 

   
 





  }
  public static class LimeLightConsants{

    public static final double kLimelightAngleDeadband = 1; //in degrees

    public static final double Kp = -0.01f;

    public static final double minCommand = 0.05f;

    public static final double MaxShoot = 90;

    public static final double MinShoot = 50;


    
    //d = (h2-h1) / tan(a1+a2)


    // how many degrees back is your limelight rotated from perfectly vertical?
    public static final double limelightMountAngleDegrees = 25.0; //a1

    // distance from the center of the Limelight lens to the floor
    public static double limelightLensHeightInches = 20.0;  //h1

    // distance from the target to the floor
    public static double goalHeightInches = 60.0; // h2 




  }
}
