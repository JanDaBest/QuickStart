package org.firstinspires.ftc.teamcode.Code;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class FlywheelTunerTut extends OpMode {

    public DcMotorEx flyWheelMotor;

    public double highVelocity = 1500;
    public double lowVelocity = 900;

    double curTargetVelocity = highVelocity;

    double F = 0;

    double P = 0;

    double[] stepSizes = {10.0, 1.0, 0.1, 0.01, 0.001, 0.0001}; // The amounts that we can switch the velocity by. The sensitivity.

    double stepIndex = 1;

    @Override
    public void init() {
        flyWheelMotor = hardwareMap.get(DcMotorEx.class, "flyWheelMotor");
        flyWheelMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        flyWheelMotor.setDirection(DcMotorEx.Direction.REVERSE);// By default the direction that the flywheel spins with a positive value for velocity is the wrong way so we reverse it.

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flyWheelMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);

        telemetry.addLine("Init Complete"); // for adding only text
    }

    @Override
    public void loop() {

    }
}
