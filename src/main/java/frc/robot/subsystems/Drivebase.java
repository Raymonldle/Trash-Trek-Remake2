// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAlternateEncoder.Type;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Drivebase() {}

  CANSparkMax m_rightMaster = new CANSparkMax(1,MotorType.kBrushless);
  CANSparkMax m_rightSlave = new CANSparkMax(2,MotorType.kBrushless);
  CANSparkMax m_leftMaster = new CANSparkMax(3,MotorType.kBrushless);
  CANSparkMax m_leftSlave = new CANSparkMax(4,MotorType.kBrushless);

  MotorController m_rightGroup = new MotorController(m_rightMaster,m_rightSlave);
  MotorController m_leftGroup = new MotorController(m_leftMaster,m_leftSlave);

  DifferentialDrive m_differentialDrive = new DifferentialDrive();

  public void arcadeDrive(double speed, double rotation){
    m_differentialDrive.arcadeDrive(speed,rotation);
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
