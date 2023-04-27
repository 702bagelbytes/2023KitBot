package frc.robot.subsystems;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase{
    PhotonCamera camera = new PhotonCamera("Microsoft_LifeCam_HD-3000");
    
    public CameraSubsystem() {



    }

    public double getYaw() {
        var result = camera.getLatestResult();
        if(result.hasTargets()) {
           return result.getBestTarget().getYaw();
        }
        else {
            return 180;
        }
       
    }

    public double getDistance() {
        var result = camera.getLatestResult();
        if(result.hasTargets()) {
            var tomato = result.getBestTarget().getBestCameraToTarget();
            return tomato.getX();
        }
        else {
            return 180;
        }
       
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Yaw of AprilTag", this.getYaw());
        SmartDashboard.putNumber("X", this.getDistance());


    }



}
