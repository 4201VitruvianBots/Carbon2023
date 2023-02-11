// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private TalonSRX[] driveMotors = {
    new TalonSRX(Constants.DriveTrain.leftFrontDriveMotor),
    new TalonSRX(Constants.DriveTrain.leftRearDriveMotor),
    new TalonSRX(Constants.DriveTrain.rightFrontDriveMotor),
    new TalonSRX(Constants.DriveTrain.rightRearDriverMotor),
  };
  
  double m_leftOutput, m_rightOutput;

  public double kP = 1.33;
  public double kI = 0;
  public double kD = 0;

  // SVA values 
  private double kS = 0.19;
  private double kV = 2.23;
  private double kA = 0.0289;

  // Set up constants
  private double wheelDiameterFeet = 0.5; 
  private final double gearRatio = 1.0 / 5.0;
  
  public DriveTrain() {}

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
