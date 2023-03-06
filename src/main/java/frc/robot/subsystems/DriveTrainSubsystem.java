// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class DriveTrainSubsystem extends SubsystemBase {
  WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(DriveTrainConstants.FrontLeftMotorPort);
  WPI_TalonSRX backLeftMotor =  new WPI_TalonSRX(DriveTrainConstants.RearLeftMotorPort);
  WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(DriveTrainConstants.FrontRightMotorPort);
  WPI_TalonSRX backRightMotor = new WPI_TalonSRX(DriveTrainConstants.RearRightMotorPort);
  
  MotorControllerGroup leftMotors = new  MotorControllerGroup(frontLeftMotor,backLeftMotor);
  MotorControllerGroup rightMotors = new MotorControllerGroup(frontRightMotor, backRightMotor);
  
  DifferentialDrive robotDrive = new DifferentialDrive(leftMotors, rightMotors);

  public DriveTrainSubsystem() {
    rightMotors.setInverted(true);
  }

  public void driveArcade(double _straight, double _turn) {
    double left  = MathUtil.clamp(_straight + _turn, -1.0, 1.0);
    double right = MathUtil.clamp(_straight - _turn, -1.0, 1.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
