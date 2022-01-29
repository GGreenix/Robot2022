package subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.constants.SystemConstants;



class NinjaDrive extends NinjaSubsystem {

    private WPI_TalonSRX _FL,_RL,_FR,_RR;
    Joystick _j;
    private MecanumDrive _drive;

    @Override
    protected void initSubsystem() {
        
        _j = new Joystick(SystemConstants._joystic);

        _FL = new WPI_TalonSRX(SystemConstants._FL);
        _RL = new WPI_TalonSRX(SystemConstants._RL);
        _FR = new WPI_TalonSRX(SystemConstants._FR);
        _RR = new WPI_TalonSRX(SystemConstants._RR);

        _FR.setInverted(true);
        _RR.setInverted(true);
        
        _drive = new MecanumDrive(_FL,_RL,_FR,_RR);
        
    }

    

    void drive(boolean _img_proc){
        
        if(_img_proc){_drive.driveCartesian(_j.getY(), _j.getX(), _j.getZ());} //add values of limelight/vision sensor
        else{_drive.driveCartesian(_j.getY(), _j.getX(), _j.getZ());}
        
        
    }

    void drive(){
        _drive.driveCartesian(_j.getY(), _j.getX(), _j.getZ());
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
