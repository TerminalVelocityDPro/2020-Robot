package frc.robot.MacroPlayRecord;



import java.io.FileWriter;

import java.io.IOException;



import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hatchpanel;
import frc.robot.subsystems.Lift;


public class BTMacroRecord{



    DriveTrain driveTrain = DriveTrain.getInstance();
    Hatchpanel hatchpanel = Hatchpanel.getInstance();
    Lift lift = Lift.getInstance();




    FileWriter writer;



    long startTime;



    public BTMacroRecord() throws IOException{



        startTime = System.currentTimeMillis();



        //make sure to specify file location

        writer = new FileWriter("recordedAuto.csv");



    }



    public void record() throws IOException{

        if(writer != null){ //Moz
            //5 Weeks
            //5WEEKS 5WEEKS 5WEEKS 5WEEKS 5WEEKS 5WEEKS
            writer.append("" + (System.currentTimeMillis()-startTime));
            writer.append("," + driveTrain.getBackLeft());
            writer.append("," + driveTrain.getFrontRight());
            writer.append("," + driveTrain.getBackLeft());
            writer.append("," + driveTrain.getBackRight());
            writer.append("," + hatchpanel.getRotator());
            writer.append("," + hatchpanel.getSolenoid());
            writer.append("," + lift.getWinch());
            writer.append("," + lift.getFlipMotor1());
            writer.append("," + lift.getFlipMotor2());



        }

    }



    public void end() throws IOException{

        if(writer!=null){

            writer.flush();

            writer.close();

        }

    }









}