package frc.robot.MacroPlayRecord;

import java.io.FileWriter;
import java.io.IOException;

import frc.robot.subsystems.DriveTrain;

public class BTMacroRecord{

    DriveTrain driveTrain = DriveTrain.getInstance();

    FileWriter writer;

    long startTime;

    public BTMacroRecord() throws IOException{

        startTime = System.currentTimeMillis();

        //make sure to specify file location
        writer = new FileWriter("");

    }

    public void record() throws IOException{
        if(writer != null){
            writer.append("" + (System.currentTimeMillis()-startTime));
            writer.append("," + driveTrain.getBackLeft());
            writer.append("," + driveTrain.getFrontRight());
            writer.append("," + driveTrain.getBackLeft());
            writer.append("," + driveTrain.getBackRight());
        }
    }

    public void end() throws IOException{
        if(writer!=null){
            writer.flush();
            writer.close();
        }
    }




}