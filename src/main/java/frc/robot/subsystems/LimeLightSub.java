
package frc.robot.subsystems;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.LimeLightConsants;

public class LimeLightSub extends SubsystemBase {
  //limelight values
   //= LimelightHelpers.getTX("limeLight");

   public PIDController controller = new PIDController(0.01, 0.01, 0.0);

   
   
 
   public double steerMotorToTarget(double tx){
 
   SmartDashboard.putNumber("Heading Error",tx);

     
   //double steeringAdjust = headingError * LimeLightConsants.Kp;
     
   controller.setTolerance(LimeLightConsants.kLimelightAngleDeadband);
    controller.setSetpoint(tx);
    return controller.calculate(0.0);
 
  //  if(Math.abs(headingError) > LimeLightConsants.kLimelightAngleDeadband){
  //     return steeringAdjust;
  //  }
  //    else {
  //     return 0.0;
  //    }

   }
   public double calculateDistanceFromTarget(){


     // what is the offset angle of the Limelight to the target
     double targetOffsetAngle_Vertical = LimelightHelpers.getTY("limelight");


      // get in degrees and converts into radians
     double angleToGoalDegrees = LimeLightConsants.limelightMountAngleDegrees + targetOffsetAngle_Vertical;
     double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0); // a2
    //d = (h2-h1) / tan(a1+a2)
    // conduct distance formulas using the values from constants and the recent ty value

     double distanceFromLimelightToGoalInches = (LimeLightConsants.goalHeightInches - LimeLightConsants.limelightLensHeightInches) / Math.tan(angleToGoalRadians);

     SmartDashboard.putNumber("Distance", distanceFromLimelightToGoalInches);

     

    
     return distanceFromLimelightToGoalInches;

   }


   @Override
   public void periodic() {
     calculateDistanceFromTarget();

     if(calculateDistanceFromTarget() > LimeLightConsants.MaxShoot || calculateDistanceFromTarget() < LimeLightConsants.MinShoot){
      SmartDashboard.putBoolean("shoot", false);
     }else{
      SmartDashboard.putBoolean("shoot",true);
     }
     
   }
    
   
    
}
