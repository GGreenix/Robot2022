package frc.robot.subsystems;

import java.util.Stack;


import frc.robot.constants.ClimberStates;


public class ClimbSequancer {
    
    private ClimberStates _currentExecutedCommand;
    Stack<ClimberStates> _sequance;
    
    public void initSequancer(){

        _currentExecutedCommand = ClimberStates.STATIC;

        _sequance.push(ClimberStates.START);//climb to lvl 2
        _sequance.push(ClimberStates.STATIC);
        _sequance.push(ClimberStates.TARGETAGNLE);
        _sequance.push(ClimberStates.EXTEND);
        _sequance.push(ClimberStates.TARGETAGNLE);
        _sequance.push(ClimberStates.RETRACT);//climb to lvl 3
        _sequance.push(ClimberStates.STATIC);

        
        
    }
    
    public void sequanceHandler(boolean _executeNextStep,boolean _isCurrentCommandFinished){
        if(_isCurrentCommandFinished && _executeNextStep){
            _currentExecutedCommand = _sequance.pop();
        }
    }

    public ClimberStates getCurrentCommand(){
        return _currentExecutedCommand;
    }
}
