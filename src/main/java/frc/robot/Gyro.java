/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * Add your docs here.
 */
public class Gyro {
    static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public static void calibrate () {

		gyro.calibrate();

	}

	

	/**

	 * @return angle turned from heading 

	 */

	public static double getAngle () {

		return gyro.getAngle();

	}

	

	/**

	 * @return rate of rotation

	 */

	public static double getRate () {

		return gyro.getRate();

	}

	

	/**

	 * Resets gyro back to heading 0

	 */

	public static void reset () {

		gyro.reset();

	}
}
