package frc.robot.subsystems;

public interface RobotStatesCommands {
    abstract boolean isAtState();

    abstract void eject();

    abstract void climb();

    abstract void neutral();

    abstract void collect();
}
