package subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.NinjaUtils.NinjaUtils;
import frc.robot.constants.SystemConstants;

public class Climb extends NinjaSubsystem{

    private TalonSRX _angle_climber, _piston_master;
    private VictorSPX _piston_slave;

    @Override
    protected void initSubsystem() {
        // TODO Auto-generated method stub
        _angle_climber = new TalonSRX(SystemConstants._angle_climb);
        _piston_master = new TalonSRX(SystemConstants._piston_master);
        _piston_slave = new VictorSPX(SystemConstants._piston_slave);

        NinjaUtils.configTalon(_angle_climber,0,0,0,0,0);
        NinjaUtils.configTalon(_piston_master,0,0,0,0,0);
        _piston_slave.follow(_piston_master);
        
    }

    @Override
    public void eject() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void climb() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void neutral() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void collect() {
        // TODO Auto-generated method stub
        
    }

    
    
}
