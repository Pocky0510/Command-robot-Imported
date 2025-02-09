// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.text.html.HTML.Tag;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.chassisID;
import frc.robot.LimelightHelpers;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class chassis extends SubsystemBase {
  // private NetworkTable limelightTable;
  // private double tx;
  // private double ta;
  // private double tv;

  private final Photonvision1 photonvision1 = new Photonvision1();

  public void robotInit() {
      // limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
  }
  // public void periodic(){
      // double tx = limelightTable.getEntry("tx").getDouble(0);
      // // double ty = limelightTable.getEntry("ty").getDouble(0);
      // double ta = limelightTable.getEntry("ta").getDouble(0);
      // double tv = limelightTable.getEntry("tv").getDouble(0);

      // SmartDashboard.putNumber("tx", tx);
      // // SmartDashboard.putNumber("ty", tx);
      // SmartDashboard.putNumber("ta", ta);
      // SmartDashboard.putNumber("tv", tv);
  // }

  public final WPI_VictorSPX Frontleft = new WPI_VictorSPX(chassisID.FL);
  public final WPI_VictorSPX Frontright = new WPI_VictorSPX(chassisID.FR);
  public final WPI_VictorSPX RearLeft = new WPI_VictorSPX(chassisID.RL);
  public final WPI_VictorSPX Rearright = new WPI_VictorSPX(chassisID.RR);


  public DifferentialDrive tank = new DifferentialDrive(Frontleft, Frontright);
  
/** Creates a new ExampleSubsystem. */
  
  public chassis() {
    Frontleft.configFactoryDefault();
    Frontright.configFactoryDefault();
    RearLeft.configFactoryDefault();
    Rearright.configFactoryDefault();

    Frontleft.setInverted(false);
    Frontright.setInverted(false); 
    RearLeft.setInverted(false);
    Rearright.setInverted(false);

    RearLeft.follow(Frontleft);
    Rearright.follow(Frontright);
    }
  
  public void drive(double X, double Y){
    tank.arcadeDrive(-X, Y);
  }
  
  public void forward(){
    Frontleft.set(chassisID.Speed);
    Frontright.set(chassisID.Speed);
  }

  public void backward(){
    Frontleft.set(-chassisID.Speed);
    Frontright.set(-chassisID.Speed);
  }
  public void right(){
    Frontleft.set(-chassisID.Speed);
    Frontright.set(chassisID.Speed);
  }
  public void left(){
    Frontleft.set(chassisID.Speed);
    Frontright.set(-chassisID.Speed);
  }

  public void stop(){
    Frontleft.set(0);
    Frontright.set(0);
  }

  public void autotarget() {


    




//   double tx = Limelight.getTX();
//   double ta = Limelight.getTa();
//   double tv = Limelight.getTv();
// if(tv >= 1){
//   if (tx < 6 && tx > -6) {
//     stop();
//   }else if (ta < 6 && ta > 4 ) {
//     stop();
//   }else if (ta > 6) {
//     backward();
//   }else if (ta < 4) {
//     forward();
//   }else if (tx > 6) {
//     right();
//   } else {
//     left();
//     }  
// }else{
//   stop();
//       }
//     }
//   }




//   public class AutoTargetCommand extends Command {
//     private final chassis mChassis;

//     public AutoTargetCommand(chassis subsystem) {
//         mChassis = subsystem;
//         addRequirements(subsystem);
//     }

//     @Override
//     public void execute() {
//         mChassis.autotarget();
//     }

//     @Override
//     public void end(boolean interrupted) {
//         mChassis.stop();
//     }
// }

//   public Command exampleMethodCommand() {
//     // Inline construction of command goes here.
//     // Subsystem::RunOnce implicitly requires this subsystem.
//     return runOnce(
//         () -> {
//           /* one-time action goes here */
//         });
//     }
  
//   /**
//    * An example method querying a boolean state of the subsystem (for example, a digital sensor).
//    *
//    * @return value of some boolean subsystem state, such as a digital sensor.
//    */
  
//   public boolean exampleCondition() {
//     // Query some boolean state, such as a digital sensor.
//     return false;
//   }

//   @Override
//   public void periodic() {
// }
    

//   @Override
//   public void simulationPeriodic() {
//     // This method will be called once per scheduler run during simulation
//   }

if (photonvision1.hastarget1 == true && photonvision1.hastarget2 == false) {
  forward();
}else if(photonvision1.hastarget1 == false && photonvision1.hastarget2 == true){
  backward();
}else{
  stop();
}
  }
}
