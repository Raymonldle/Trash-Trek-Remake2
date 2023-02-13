// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import com.revrobotics.SparkMaxAlternateEncoder.Type;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  PIDController m_PIDController = new PIDController(1,0.1,0.1);
  RelativeEncoder m_encoder = new RelativeEncoder();
  CANSparkMax m_elevatorMotor = new CANSparkMax(1,MotorType.kBrushless);
  SparkMaxLimitSwitch m_limitSwitch = new SparkMaxLimitSwitch(); 

  public Elevator() {
    m_encoder.setPosition(0);
  }

  public double PIDController(double height){
   return m_PIDController.calculate(m_encoder.getPosition(),height);
  }

  public double returnEncoderPos(){
    return m_encoder.getPosition();
  }

  public boolean limitSwitchStatus(){
    return m_lightswitch.isLimitSwitchEnable();
  }

  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Elevator Height", height);
    SmartDashboard.putBoolean("Limit Switch Status", limitSwitchStatus);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
