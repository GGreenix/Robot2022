package subsystems;

import frc.robot.constants.RobotStates;


abstract class NinjaSubsystem implements RobotStatesCommands {
    
    protected void updateState(RobotStates _currenState){
        switch (_currenState) {
                    case COLLECTING:
                        collect();
                        
                    case EJECT:
                        eject();

                    case NEUTRAL:
                        neutral();
                    case CLIMB:
                        
                    default:
                        neutral();  
                }
    }

    protected abstract void initSubsystem();

    

}
