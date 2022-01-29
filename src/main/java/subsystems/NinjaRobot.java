package subsystems;

public class NinjaRobot   {
    Intake _intake;
    NinjaDrive _drive;

    public void initSubsystems() {
        _intake.initSubsystem();
        _drive.initSubsystem();
        
    }
    
    public void updateStates() {
        _intake.updateState();
        _drive.updateState();
        
    }
}
