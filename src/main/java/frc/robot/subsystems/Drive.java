// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  TalonFX right_front_motor = new TalonFX(1);
  //TalonFX right_back_motor = new TalonFX(1); 
  //TalonFX left_front_motor = new TalonFX(2);    
  //TalonFX left_back_motor = new TalonFX(3); 

  public Drive() {
    config();
  }

  public void config()
  {
    right_front_motor.setInverted(true);   
   // right_back_motor.follow(right_front_motor);

   // left_back_motor.setInverted(true);   
    //left_back_motor.follow(left_front_motor);
  }

  public void arcadeDrive(double move, double rotation)
  {
    // This is defining the speed of both sides of the drive train based off of direction and rotation values (right is positive, left is negative)
    right_front_motor.set(ControlMode.PercentOutput, move - rotation);
    //left_front_motor.set(ControlMode.PercentOutput, move + rotation);
    System.out.println("Move : " + move);
    System.out.println("Right : " + (move - rotation));
    System.out.println("Left : " + (move + rotation));
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
