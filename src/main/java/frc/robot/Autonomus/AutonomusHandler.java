package frc.robot.Autonomus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.io.*;

import com.pathplanner.lib.PathPlannerTrajectory.PathPlannerState;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.Timer;

public class AutonomusHandler {
    List<RobotAutonomusState> robotAutobomusStates;
    Iterator<RobotAutonomusState> it;
    RobotAutonomusState _currState;
    Trajectory examplePath;
    Queue<PathPlannerState> path;
    Timer time;
    public void startAutonomus(){
        
        executeCommand();
        if(time.get()*1000 >= 30 && it.hasNext()){
            
            time.reset();
            time.start();
            _currState = it.next();
            
        }


    }
    public void init() throws FileNotFoundException {

        try {
            File file = new File(
                    "C:/Users/Greenix/Desktop/robot/Robot2022/src/main/deploy/pathplanner/generatedJSON/3ballAuto.json");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            robotAutobomusStates = new ArrayList<RobotAutonomusState>();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(line, ',');
                robotAutobomusStates
                        .add(new RobotAutonomusState(Double.parseDouble(tempArr[0]), Double.parseDouble(tempArr[2]),
                                Double.parseDouble(tempArr[4]), Double.parseDouble(tempArr[5])));

            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Iterator<RobotAutonomusState> it =  robotAutobomusStates.iterator();
        time = new Timer();
        
        _currState = robotAutobomusStates.get(0);

        time.start();
    }
    void executeCommand(){
        System.out.println(_currState.velocityMetersPerSecond);
    }
}
