package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
    private final WPI_TalonSRX talonFL = new WPI_TalonSRX(DriveConstants.TALON_FL_ID);
    private final WPI_TalonSRX talonBL = new WPI_TalonSRX(DriveConstants.TALON_BL_ID);
    private final MotorControllerGroup leftGroup = new MotorControllerGroup(talonFL, talonBL);
    private final WPI_TalonSRX talonFR = new WPI_TalonSRX(DriveConstants.TALON_FR_ID);
    private final WPI_TalonSRX talonBR = new WPI_TalonSRX(DriveConstants.TALON_BR_ID);
    private final MotorControllerGroup rightGroup = new MotorControllerGroup(talonFR, talonBR);
    private final DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

    public DriveSubsystem() {

        rightGroup.setInverted(true);

        talonFL.setNeutralMode(NeutralMode.Brake);
        talonBL.setNeutralMode(NeutralMode.Brake);
        talonFR.setNeutralMode(NeutralMode.Brake);
        talonBR.setNeutralMode(NeutralMode.Brake);

    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void arcadeDrive(double speed, double rotation, boolean squareInputs) {
        drive.arcadeDrive(speed, rotation);
    }

    public Command arcadeDriveCmd(Supplier<Double> speedSupplier, Supplier<Double> rotationSupplier) {
        return this.runEnd(
                () -> drive.arcadeDrive(speedSupplier.get(), rotationSupplier.get() * 1),
                () -> drive.arcadeDrive(0, 0)

        );
    }

    public Command tankDriveCmd(Supplier<Double> leftSpeedSupplier, Supplier<Double> rightSpeedSupplier) {

        return this.runEnd(
                () -> drive.tankDrive(leftSpeedSupplier.get() * DriveConstants.DRIVE_SPEED,
                        rightSpeedSupplier.get() * DriveConstants.DRIVE_SPEED),
                () -> drive.tankDrive(0, 0));
    }

    @Override
    public void periodic() {

    }

    public void resetEncoders() {

    }
}
