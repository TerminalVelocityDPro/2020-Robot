package frc.robot.MacroPlayRecord;

import java.io.FileNotFoundException;
import java.io.IOException;


public class BTMain{
    boolean isRecording = false;
    static final int autoNumber = 10;
    static final String autofile = new String("" + autoNumber + ".csv");

    public BTMain(){

    }

    public void robotInit(){

    }

    public void autonomous(){
        BTMacroPlay player = null;

        try{
             player = new BTMacroPlay();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        while(isAutonomous()){
            if(player != null){
                player.play();
            }
        }
        if(player != null){
            player.end();
        }
    }

    public void operatorControl(){
        BTMacroRecord recorder = null;
        try{
            recorder = new BTMacroRecord();
        }catch(IOException e){
            e.printStackTrace();
        }
        while(isOperatorControl()){
            if()
        }
    }
}

