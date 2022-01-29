package subsystems;

import frc.robot.constants.RobotStates;

public class NinjaRobot  {

    private RobotStates _currenState;
    
    Intake _intake;
    NinjaDrive _drive;
    Climb _climb;

    public void initSubsystems() {

        _currenState = RobotStates.NEUTRAL;
        Intake _intake = new Intake();
        NinjaDrive _drive = new NinjaDrive();
        _climb = new Climb();

        _intake.initSubsystem();
        _drive.initSubsystem();
        _climb.initSubsystem();
        
    }
    
    public void updateStates(RobotStates newState) {
        
        if(_currenState != newState){
            _currenState = newState;
        }
        _intake.updateState(_currenState);
        _drive.updateState(_currenState);
        _climb.updateState(_currenState);
        
    }
}


