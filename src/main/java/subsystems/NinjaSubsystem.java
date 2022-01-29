package subsystems;

import frc.robot.constants.SystemConstantsAndVariables;

abstract class NinjaSubsystem implements RobotStates {
    
    protected void updateState(){
        switch (SystemConstantsAndVariables._currentState) {
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
