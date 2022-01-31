package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

import frc.robot.constants.RobotStates;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.NinjaDrive;

public class NinjaRobot {

    private RobotStates _currenState;
    private XboxController _states_joystick;
    private Intake _intake;
    private NinjaDrive _drive;
    private Climb _climb;
    

    private void _statesController() {
        
        if (_states_joystick.getAButtonPressed()) {
            this._currenState = RobotStates.COLLECTING;
        } else if (_states_joystick.getYButtonPressed()) {
            this._currenState = RobotStates.EJECT;
        } else if (_states_joystick.getXButtonPressed()) {
            this._currenState = RobotStates.NEUTRAL;
        } else if (_states_joystick.getRightTriggerAxis() > 0) {
            this._currenState = RobotStates.CLIMB;
        }

    }

    public void initSubsystems() {

        _currenState = RobotStates.NEUTRAL;
        _intake = new Intake();
        _drive = new NinjaDrive();
        _climb = new Climb();
        _states_joystick = new XboxController(0);

        _intake.initSubsystem();
        _drive.initSubsystem();
        _climb.initSubsystem();

    }

    public void maintainState() {
        _statesController();
        _intake.updateState(this._currenState);
        _drive.updateState(this._currenState);
        _climb.updateState(this._currenState);
    }

    public void updateStates(RobotStates newState) {
        this._currenState = newState;
    }
}
