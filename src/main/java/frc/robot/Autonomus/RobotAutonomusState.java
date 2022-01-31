package frc.robot.Autonomus;

public class RobotAutonomusState {
    private static final double kMaxVelocity = 0;
    public double timeMS;
    double velocityMetersPerSecond;
    private double heading;
    private double holonomicDegrees;

    RobotAutonomusState(double ntimeMS,
    double nvelocityMetersPerSecond,
     double nheading,
     double nholonomicDegrees){
         this.timeMS = ntimeMS;
         this.heading = nheading + 180;
         this.velocityMetersPerSecond = nvelocityMetersPerSecond;
         this.holonomicDegrees = nholonomicDegrees;
     }


    private double getMagnitude(){
        return velocityMetersPerSecond / kMaxVelocity;
    }

    private  double getHeadingFLRR(){
        return Math.sin(Math.toRadians(heading) - (1/4 * Math.PI));
        
    }
    private  double getHeadingFRRL(){
        return Math.sin(Math.toRadians(heading) - (1/4 * Math.PI));
        
    }
    private double calculateVelocity(double heading) {
        return heading * getMagnitude();
    }

    public double _FRRLvelocities(){
        return calculateVelocity(getHeadingFRRL());
    }

    public double _FLRRvelocities(){
        return calculateVelocity(getHeadingFLRR());
    }
}
