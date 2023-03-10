// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class SetArcadeDrive extends CommandBase {
  private final DriveTrain m_driveTrain;
  private final DoubleSupplier m_throttle, m_turn;
  private double joystickX, joystickY, throttle, turn;
  /** Creates a new ArcadeDrive. */
  public SetArcadeDrive(DriveTrain driveTrain, DoubleSupplier throttle, DoubleSupplier turn) {
    m_driveTrain = driveTrain;
    m_throttle = throttle;
    m_turn = turn;

    addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    joystickY = MathUtil.applyDeadband(m_throttle.getAsDouble(), 0.05);
    joystickX = MathUtil.applyDeadband(m_turn.getAsDouble(), 0.05);
    
    throttle = joystickY;
    turn = -0.60 * joystickX;

    m_driveTrain.setMotorAcradeDrive(throttle, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
