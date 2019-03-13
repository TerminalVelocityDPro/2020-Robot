package frc.robot.MacroPlayRecord;



import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;



import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hatchpanel;
import frc.robot.subsystems.Lift;


public class BTMacroPlay{



    DriveTrain driveTrain = DriveTrain.getInstance();
    Hatchpanel hatchpanel = Hatchpanel.getInstance();
    Lift lift = Lift.getInstance();

    Scanner scanner;

    long startTime;



    boolean onTime = true;

    double nextDouble;



    public BTMacroPlay() throws FileNotFoundException{

        scanner = new Scanner(new File("recordedAuto.csv"));



        scanner.useDelimiter(",|\\n");



        startTime = System.currentTimeMillis();

    }



    public void play(){

        if((scanner != null) && (scanner.hasNextDouble())){

            double t_delta;



            if(onTime){

                nextDouble = scanner.nextDouble();

            }



            t_delta = nextDouble - (System.currentTimeMillis()-startTime);



            if(t_delta <= 0){

                driveTrain.setFrontLeft(scanner.nextDouble());

                driveTrain.setFrontRight(scanner.nextDouble());

                driveTrain.setBackLeft(scanner.nextDouble());

                driveTrain.setBackRight(scanner.nextDouble());

                hatchpanel.setRotator(scanner.nextDouble());
                hatchpanel.setSolenoid(scanner.nextDouble());
                lift.setWinch(scanner.nextDouble());
                lift.setFlipMotor1(scanner.nextDouble());
                lift.setFlipMotor2(scanner.nextDouble());



                onTime  = true;





            }

        }

    }

    public void end(){
        driveTrain.stop();
        if(scanner != null){
            scanner.close();
        }
    }

}