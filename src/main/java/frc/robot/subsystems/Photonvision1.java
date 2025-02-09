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

    public PhotonCamera camera1 = new PhotonCamera("Photonvision1");
    public PhotonCamera camera2 = new PhotonCamera("Photonvision2");

    private PhotonPipelineResult result1 = camera1.getLatestResult();
    private PhotonPipelineResult result2 = camera1.getLatestResult();

    PhotonTrackedTarget target1 = result1.getBestTarget();
    // double yaw1 = target1.getYaw();
    // double pitch1 = target1.getPitch();
    // double area1 = target1.getArea();
    boolean hastarget1 = result1.hasTargets();

    PhotonTrackedTarget target2 = result2.getBestTarget();
    // double yaw2 = target2.getYaw();
    // double pitch2 = target2.getPitch();
    // double area2 = target2.getArea();
    boolean hastarget2 = result2.hasTargets();

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

    public boolean hasTarget1() {
        PhotonPipelineResult Result1 = camera1.getLatestResult();
        return Result1.hasTargets();
        }

    public boolean hasTarget2() {
        PhotonPipelineResult Result2 = camera2.getLatestResult();
        return Result2.hasTargets();
        }
    

    @Override
    public void periodic() {

        hastarget1 = result1.hasTargets();
        // getBestTargetYaw();
        if (result1.hasTargets()) { 
                double poseAmbiguity1 = target1.getPoseAmbiguity();
                Transform3d bestCameraToTarget = target1.getBestCameraToTarget();
                Transform3d alternateCameraToTarget = target1.getAlternateCameraToTarget();

                SmartDashboard.putNumber("Ambiguity", poseAmbiguity1);
    
        hastarget2 = result2.hasTargets();
        // getBestTargetYaw();
        if (result2.hasTargets()) { 
                double poseAmbiguity2 = target2.getPoseAmbiguity();
                Transform3d bestCameraToTarget2 = target2.getBestCameraToTarget();
                Transform3d alternateCameraToTarget2 = target2.getAlternateCameraToTarget();

                SmartDashboard.putNumber("Ambiguity", poseAmbiguity2);
            }
        }
    }
}