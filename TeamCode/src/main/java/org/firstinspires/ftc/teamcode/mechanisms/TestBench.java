package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {

    private DcMotor motor; // motor should usually be named by the actual motors name. Ex: "linearSlideMotor1"

    private double ticksPerRev; // ticks per revolution (a revolution is a single spin around itself)

    private DigitalChannel touchSensorIntake; // the hardware is isolated from the OpMode classes so it is private.


    public void init(HardwareMap hwMap) {

        // Touch sensor
        touchSensorIntake = hwMap.get(DigitalChannel.class, "Touch_Sensor_Intake"); // This tells the system exactly which motor it is. You type the same exact name that is in the configuration file for that motor.
        touchSensorIntake.setMode(DigitalChannel.Mode.INPUT);

        // DC Motor
        motor = hwMap.get(DcMotor.class, "linearSlideMotor1");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // this makes it so that when we set the motor power to zero
        motor.setDirection(DcMotorSimple.Direction.FORWARD);         // to stop the robot, it doesn't just make the power given
        /* we would have set the DcMotor direction to reverse        // to the motor zero but it actually brakes to stop the motor
         if we had plugged them in reverse as quickly as possible. */

        ticksPerRev = motor.getMotorType().getTicksPerRev(); // how many ticks of the encoder are in one revolution?
    }



    public boolean getTouchSensorIntake() {

        return !touchSensorIntake.getState(); /* we are returning the opposite value of
                                                 the boolean touch sensor intake
                                                 by using ! because in default,
                                                 NOT pressing it is true while pressing it is false. */

    }

    public boolean touchSensorIntakeReleased() {
        return touchSensorIntake.getState();

    }

/*____________________________________________________________________________________________________________________
    Code For DC Motor Video (There is some code for the "DC Motor Video" above as well) */

    public void setMotorSpeed(double speed) {
        // accepts values form -1.0 to 1.0
        motor.setPower(speed);
    }

    public double getMotorSpeed() {
        return motor.getPower();
    }

    public double getMotorRevs() // gets the total amount of revolutions that the motor did.
     {
        return motor.getCurrentPosition() / ticksPerRev; /* getCurrentPosition gets the total amount of ticks, so by dividing
                                                         by ticksPerRev which is how many ticks are in one revolution, we get
                                                         the total amount of revolutions that the motor did. */

    }

    public void changeMotorZeroMode(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }
    
}