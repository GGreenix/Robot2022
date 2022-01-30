package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.photonvision.PhotonCamera;
import org.photonvision.common.hardware.VisionLEDMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.constants.SystemConstants;

public class NinjaDrive extends NinjaSubsystem {

    private final int _neutralCameraPipelineIndex = 0;
    private final int _collectCameraPipelineIndex = 0;
    private final int _ejectCameraPipelineIndex = 0;

    private WPI_TalonSRX _FL, _RL, _FR, _RR;
    private Joystick _j;
    private MecanumDrive _drive;

    PhotonCamera _camera;// check name

    @Override
    public void initSubsystem() {

        _j = new Joystick(SystemConstants._joystic);

        _FL = new WPI_TalonSRX(SystemConstants._FL);
        _RL = new WPI_TalonSRX(SystemConstants._RL);
        _FR = new WPI_TalonSRX(SystemConstants._FR);
        _RR = new WPI_TalonSRX(SystemConstants._RR);

        _FR.setInverted(true);
        _RR.setInverted(true);

        _drive = new MecanumDrive(_FL, _RL, _FR, _RR);

        _camera = new PhotonCamera("LimeLight 2+");

    }

    void drive(boolean _img_proc) {
        _camera.setDriverMode(true);
        if (_img_proc) {
            _drive.driveCartesian(_j.getY(), _j.getX(), _j.getZ());
        } // add values of limelight/vision sensor
        else {
            _drive.driveCartesian(_j.getY(), _j.getX(), _j.getZ());
        }

    }

    void drive() {
        _drive.driveCartesian(_j.getY(), _j.getX(), _j.getZ());
    }

    @Override
    public void eject() {
        _camera.setPipelineIndex(_ejectCameraPipelineIndex);
        _camera.setLED(VisionLEDMode.kOn);

    }

    @Override
    public void climb() {

    }

    @Override
    public void neutral() {
        _camera.setPipelineIndex(_neutralCameraPipelineIndex);
        _camera.setLED(VisionLEDMode.kOff);
    }

    @Override
    public void collect() {
        _camera.setPipelineIndex(_collectCameraPipelineIndex);
        _camera.setLED(VisionLEDMode.kBlink);
    }

}
