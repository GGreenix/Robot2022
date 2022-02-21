package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.NinjaUtils.NinjaUtils;
import frc.robot.constants.SystemConstants;

public class Intake extends NinjaSubsystem {

    private TalonSRX _angle;
    private VictorSPX _angle_slave;

    private VictorSPX _intake_upper;
    private VictorSPX _intake_bottom;

    private final int kCollecting_angle = 0;
    private final int kEjecting_angle = 0;

    private final int kCollecting_intake = 0;
    private final int kEjecting_intake = 0;

    private final double kNeutral_angle = 0;
    private final double kNeutral_intake = 0;
    private double kClosed_loop_threshold = 10;
    
    @Override
    public void initSubsystem() {
        // TODO Auto-generated method stub
        _angle = new TalonSRX(SystemConstants._angle_intake);
        _angle_slave = new VictorSPX(SystemConstants._angle_intake_slave);
        
        _intake_upper = new VictorSPX(SystemConstants._intake_upper);
        _intake_bottom = new VictorSPX(SystemConstants._intake_bottom);

        _angle_slave.follow(_angle);
        _intake_bottom.follow(_intake_upper);
        
        _angle.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.Analog,0,20);
        
        NinjaUtils.configTalon(_angle, 0, 0, 0, 0, 0);

    }
    

    @Override
    public void collect() {
        
        _angle.set(TalonSRXControlMode.Position, kCollecting_angle);
        if(isAtState())
            _intake_upper.set(VictorSPXControlMode.PercentOutput, super.execute_command?kCollecting_intake:0);
        else
            _intake_upper.set(VictorSPXControlMode.PercentOutput,0);
        
    }

    @Override
    public void eject() {
        
        _angle.set(TalonSRXControlMode.Position, kEjecting_angle);
        if(isAtState())
            _intake_upper.set(VictorSPXControlMode.PercentOutput, super.execute_command?kEjecting_intake:0);
        else
             _intake_upper.set(VictorSPXControlMode.PercentOutput,0);
    }

    @Override
    public void neutral() {
        _angle.set(TalonSRXControlMode.Position, kNeutral_angle);
        _intake_upper.set(VictorSPXControlMode.PercentOutput, kNeutral_intake);
    }

    @Override
    public void climb() {
        
        neutral();
    }


    @Override
    public boolean isAtState() {
        
        return _angle.getClosedLoopError() > kClosed_loop_threshold;
    }
}
