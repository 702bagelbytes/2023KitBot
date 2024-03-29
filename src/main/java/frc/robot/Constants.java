// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   
    public class DriveConstants {
        public static final int TALON_FL_ID = 7; // KitBot 2023
        public static final int TALON_BL_ID = 23; // KitBot 2023

        public static final int TALON_FR_ID = 1; // KitBot 2023
        public static final int TALON_BR_ID = 27; // KitBot 2023

        public static final double DRIVE_SPEED = 1;
    }

    
    public class ControllerConstants {
        public static final int DRIVER_PORT = 0;
        public static final int CODRIVER_PORT = 1;
    }
}
