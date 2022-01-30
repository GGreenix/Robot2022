package frc.robot.NinjaUtils;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class NinjaUtils {
    
    public static void configTalon(TalonSRX controller,int kP,int kI,int kD,int kIzone,int slot){
        controller.config_kP(slot,kP);
        controller.config_kI(slot,kI);
        controller.config_kD(slot,kD);
        controller.config_IntegralZone(slot, kIzone);
        
    }

    
}
