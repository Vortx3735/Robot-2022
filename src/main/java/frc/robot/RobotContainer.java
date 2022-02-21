// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;
import frc.robot.util.VorTXController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive drive = new Drive();

  private final DriveCommand m_autoCommand = new DriveCommand(drive,0,0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    drive.setDefaultCommand(new DriveCommand(drive, 0, 0));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {


    //binding triggers to arcade drive behavior
    main.r2.whileHeld(new DriveCommand(drive, .5 + yAxisReturn(), xAxisReturn()));
    main.l2.whileHeld(new DriveCommand(drive, -.5 + yAxisReturn(), xAxisReturn()));

    //augmenting arcade drive based on the position of the joystick
    main.pov0.whileHeld(new DriveCommand(drive, 1, 0));
    main.pov180.whileHeld(new DriveCommand(drive, .5, 0));
    main.pov90.whileHeld(new DriveCommand(drive, .75, .25));
    main.pov0.whileHeld(new DriveCommand(drive, .75, -.25));
    main.pov45.whileHeld(new DriveCommand(drive, .75, .125));
    main.pov135.whileHeld(new DriveCommand(drive, .5, .125));
    main.pov225.whileHeld(new DriveCommand(drive, .5, -.125));
    main.pov315.whileHeld(new DriveCommand(drive, .75, -.125));
  }

  public double xAxisReturn()
  {
    return main.getLeftX()/2;
  }
  public double yAxisReturn()
  {
    return main.getLeftY()/2;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  VorTXController main = new VorTXController(0);
  VorTXController co = new VorTXController(1);
  


}
