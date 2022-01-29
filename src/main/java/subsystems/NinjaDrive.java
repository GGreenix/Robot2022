package subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;



class NinjaDrive extends NinjaSubsystem {

    WPI_TalonSRX _FL,_RL,_FR,_RR;
    Joystick _j;
    MecanumDrive _drive;
    
    @Override
    protected void initSubsystem() {
        
        _j = new Joystick(0);

        _FL = new WPI_TalonSRX(0);
        _RL = new WPI_TalonSRX(0);
        _FR = new WPI_TalonSRX(0);
        _RR = new WPI_TalonSRX(0);

        _FR.setInverted(true);
        _RR.setInverted(true);

        _drive = new MecanumDrive(_FL,_RL,_FR,_RR);
        super.initSubsystem();
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
