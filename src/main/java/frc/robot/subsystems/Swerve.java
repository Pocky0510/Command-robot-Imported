// package frc.robot.subsystems;

// import java.io.File;

// import edu.wpi.first.math.util.Units;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import swervelib.SwerveDrive;
// import swervelib.math.SwerveMath;
// import swervelib.parser.SwerveParser;
// import swervelib.telemetry.SwerveDriveTelemetry;
// import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;

// public class Swerve extends SubsystemBase{
//     private final SwerveDrive swerveDrive;
//     public double maxSpeed = Units.feetToMeters(10);

// public Swerve(File directory){
//     double angleConversionFactory = SwerveMath.calculateDegreesPerSteeringRotation(10);
//     double driveConversionFactory = SwerveMath.calculateMetersPerRotation(Units.inchesToMeters(4), 8.14);
    
//     SwerveDriveTelemetry.verbosity = TelemetryVerbosity.NONE;
// try{
//     swerveDrive = new SwerveParser(directory).createSwerveDrive(maxSpeed, 360, driveConversionFactory);
//     }
// catch(Exception e){
//     throw new RuntimeException();
// }
// swerveDrive.setHeadingCorrection(false);
// // setMoterBrake(true);
//     }
// }
