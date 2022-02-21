package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.constants.SystemConstants;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.SPILink;

public class NinjaDrive extends NinjaSubsystem {

    

    private WPI_TalonSRX _FL, _RL, _FR, _RR;
    private Joystick _j;
    private MecanumDrive _drive;

    private PIDController pid_x = new PIDController(0,0,0);
    private PIDController pid_y = new PIDController(0,0,0);
    private PIDController pid_rot = new PIDController(0,0,0);

    private Pixy2 pixy;
    // PhotonCamera _camera;// check name
    

    @Override
    public void initSubsystem() {

        _j = new Joystick(SystemConstants._joystick);

        _FL = new WPI_TalonSRX(SystemConstants._FL);
        _RL = new WPI_TalonSRX(SystemConstants._RL);
        _FR = new WPI_TalonSRX(SystemConstants._FR);
        _RR = new WPI_TalonSRX(SystemConstants._RR);

        _FR.setInverted(true);
        _RR.setInverted(true);

        _drive = new MecanumDrive(_FL, _RL, _FR, _RR);
        pixy = Pixy2.createInstance(new SPILink());
        pixy.init();
        

    }
   
    void driveImgProcCollect(){
        final int  x_setpoint = 0;
        final int  y_setpoint = 0;
        final int rot_setpoint = 0;
        
        
        pixy.getCCC().getBlocks();
        Block f = pixy.getCCC().getBlockCache().get(0);
        
        _drive.driveCartesian(pid_y.calculate(f.getHeight()*f.getWidth(),y_setpoint), pid_x.calculate(f.getX(), x_setpoint), pid_rot.calculate(f.getAngle(), rot_setpoint));
        
    }
    
    void drive() {
        
        if (super.execute_command) {
            driveImgProcCollect();
        } // add values of limelight/vision sensor
        else {
            _drive.driveCartesian(_j.getY(), _j.getX(), _j.getZ());
        }

    }

    

    @Override
    public void eject() {
        drive();

    }

    @Override
    public void climb() {
        drive();
    }

    @Override
    public void neutral() {
        drive();
    }

    @Override
    public void collect() {
        drive();
    }

    @Override
    public boolean isAtState() {
        // TODO Auto-generated method stub
        return false;
    }

}
