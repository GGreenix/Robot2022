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
    
    private boolean _execute_intake_command;
    private boolean _execute_drive_command;
    

    private void _statesController() {
        
        if (_states_joystick.getAButtonPressed()) {
            this._currenState = RobotStates.COLLECTING;
            _execute_drive_command = _states_joystick.getAButtonPressed();
            _execute_intake_command = _states_joystick.getAButtonPressed();
        } else if (_states_joystick.getYButtonPressed()) {
            this._currenState = RobotStates.EJECT;
            _execute_drive_command = _states_joystick.getYButtonPressed();
            _execute_intake_command = _states_joystick.getYButtonPressed();
        } else if (_states_joystick.getXButtonPressed()) {
            this._currenState = RobotStates.NEUTRAL;
            _execute_drive_command = _states_joystick.getXButtonPressed();
            _execute_intake_command = _states_joystick.getXButtonPressed();
        } else if (_states_joystick.getBButtonPressed()) {
            this._currenState = RobotStates.CLIMB;
            _execute_drive_command = _states_joystick.getBButtonPressed();
            _execute_intake_command = _states_joystick.getBButtonPressed();
        }

    }

    public void initSubsystems() {

        _currenState = RobotStates.NEUTRAL;
        _intake = new Intake();
        _drive = new NinjaDrive();
        // _climb = new Climb();
        _states_joystick = new XboxController(0);
        
        _intake.initSubsystem();
        _drive.initSubsystem();
        _climb.initSubsystem();

    }

    public void maintainState() {
        _statesController();
        _intake.updateState(this._currenState);
        _drive.updateState(this._currenState);
        _intake.execute_command(_execute_intake_command);
        _drive.execute_command(_execute_drive_command);
        // _climb.updateState(this._currenState);
    }

    public void updateStates(RobotStates newState) {
        this._currenState = newState;
    }
}
