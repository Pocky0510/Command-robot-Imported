package frc.robot.subsystems;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.List;

import org.photonvision.*;

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Photonvision1 extends SubsystemBase {

    public PhotonCamera camera = new PhotonCamera("photonvision1");
    // public PhotonCamera camera2 = new PhotonCamera("Photonvision2");
    
    private PhotonPipelineResult result1 = camera.getLatestResult();
    // private PhotonPipelineResult result2 = camera1.getLatestResult();
    PhotonTrackedTarget target = result1.getBestTarget();
    public Photonvision1() {
        updateTarget();
    }

    double Area = 0;
    double Skew = 0;

    private void updateTarget() {
        result1 = camera.getLatestResult();
        if (result1.hasTargets()) {
            target = result1.getBestTarget();
            if (target != null) {
                Area = target.getArea();
                Skew = target.getSkew();
            }
        } else {
            target = null;
            Area = 0;
            Skew = 0;
        }
    }
    public boolean hasTarget1() {

        PhotonPipelineResult Result1 = camera.getLatestResult();
        return Result1.hasTargets();
        }


    // public boolean hasTarget2() {
    //     PhotonPipelineResult Result2 = camera2.getLatestResult();
    //     return Result2.hasTargets();
    //     } 
    boolean hastarget1 = result1.hasTargets();
    // boolean hastarget2 = result2.hasTargets();


    @Override
    public void periodic() {
        updateTarget();
        // hasTarget2();
        

       
    // double yaw1 = target1.getYaw();
    // double pitch1 = target1.getPitch();
    // double area1 = target1.getArea();
        


    // double yaw2 = target2.getYaw();
    // double pitch2 = target2.getPitch();
    // double area2 = target2.getArea();


    // List<PhotonTrackedTarget> targets1 = result1.getTargets();
    // public double getBestTargetYaw1() {

    //     result1 = camera1.getLatestResult();

    //     var bestTarget = result1.getBestTarget();
    //     return bestTarget.getYaw();
    // }

    // List<PhotonTrackedTarget> targets2 = result2.getTargets();
    // public double getBestTargetYaw() {

    //     result2 = camera2.getLatestResult();

    //     var bestTarget = result2.getBestTarget();
    //     return bestTarget.getYaw();
    // }

        
}


}