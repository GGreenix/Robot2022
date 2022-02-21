package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.NinjaUtils.NinjaUtils;

import frc.robot.constants.SystemConstants;

    public class Climb extends NinjaSubsystem {
    
    private TalonSRX _angle_climber, _piston_master;
    private VictorSPX _piston_slave;
    private ClimbSequancer _climbSequancer;
    @Override
    public void initSubsystem() {
        // TODO Auto-generated method stub
        _climbSequancer = new ClimbSequancer();
        
        _angle_climber = new TalonSRX(SystemConstants._angle_climb);
        _piston_master = new TalonSRX(SystemConstants._piston_master);
        _piston_slave = new VictorSPX(SystemConstants._piston_slave);

        NinjaUtils.configTalon(_angle_climber, 0, 0, 0, 0, 0);
        NinjaUtils.configTalon(_piston_master, 0, 0, 0, 0, 0);
        _piston_slave.follow(_piston_master);
        
        _angle_climber.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.QuadEncoder,0,0);
        _piston_master.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.QuadEncoder,0,0);
        _climbSequancer.initSequancer();

    }

    private boolean angleSetPos(int newPos) {

        _angle_climber.set(TalonSRXControlMode.Position, newPos);
        return _angle_climber.getClosedLoopError() < 100;
    }

    private boolean pistonSetPos(int newPos) {

        _piston_master.set(TalonSRXControlMode.Position, newPos);
        return _piston_master.getClosedLoopError() < 100;
        

    }

    private boolean staic() {
        
        return angleSetPos(0) && pistonSetPos(0);
    }

    private boolean retract() {
        return angleSetPos(0) && pistonSetPos(0);
    }

    private boolean start() {
        return angleSetPos(0) && pistonSetPos(0);
    }

    private boolean extend() {
        return angleSetPos(0) && pistonSetPos(0);

    }

    private boolean targetAngle() {
        return angleSetPos(0) && pistonSetPos(0);
        
    }

    @Override
    public void eject() {
        // TODO Auto-generated method stub
        staic();

    }

    @Override
    public void climb() {
        
        switch (_climbSequancer.getCurrentCommand()) {
            case START:
                _climbSequancer.sequanceHandler(false, start());

            case EXTEND:
                _climbSequancer.sequanceHandler(false, extend());
                
            case RETRACT:
                _climbSequancer.sequanceHandler(false, retract());
                
            case STATIC:
                _climbSequancer.sequanceHandler(false, staic());
                
            case TARGETAGNLE:
            _climbSequancer.sequanceHandler(false, targetAngle());
            default:
                staic();
        }

    }

    @Override
    public void neutral() {
        // TODO Auto-generated method stub
        staic();
    }

    @Override
    public void collect() {
        // TODO Auto-generated method stub
        staic();
    }

    @Override
    public boolean isAtState() {
        // TODO Auto-generated method stub
        return false;
    }

}
