package subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.NinjaUtils.NinjaUtils;
import frc.robot.constants.SystemConstants;



 class Intake extends NinjaSubsystem {
    
    
    private TalonSRX _angle;
    private VictorSPX _intake;

    private final int kCollecting_angle = 0;
    private final int kEjecting_angle = 0;

    private final int kCollecting_intake = 0;
    private final int kEjecting_intake = 0;

    private final double kNeutral_angle = 0;
    private final double kNeutral_intake = 0;

    @Override
    protected void initSubsystem() {
        // TODO Auto-generated method stub
        _angle = new TalonSRX(SystemConstants._angle_intake);
        _intake = new VictorSPX(SystemConstants._intake);
        
        
        
        
        NinjaUtils.configTalon(_angle,0,0,0,0,0);
        
    }

    

    @Override
    public void collect(){
        _angle.set(TalonSRXControlMode.Position,kCollecting_angle);
        _intake.set(VictorSPXControlMode.PercentOutput,kCollecting_intake);
    }

    @Override
    public void eject(){
        _angle.set(TalonSRXControlMode.Position,kEjecting_angle);
        _intake.set(VictorSPXControlMode.PercentOutput, kEjecting_intake);
    }

    @Override
    public void neutral(){
        _angle.set(TalonSRXControlMode.Position,kNeutral_angle);
        _intake.set(VictorSPXControlMode.PercentOutput, kNeutral_intake);
    }

    @Override
    public void climb() {
        // TODO Auto-generated method stub
        
    }
}
