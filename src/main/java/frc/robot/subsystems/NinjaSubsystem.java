package frc.robot.subsystems;

import frc.robot.constants.RobotStates;


abstract class NinjaSubsystem implements RobotStatesCommands {
    protected boolean execute_command;
    public void updateState(RobotStates _currenState){
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
    public abstract void initSubsystem();
    
    public void execute_command(boolean exe){
        this.execute_command = exe;
    }

    

}
