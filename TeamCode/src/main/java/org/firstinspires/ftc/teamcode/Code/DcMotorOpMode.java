package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;


@TeleOp
public class DcMotorOpMode extends OpMode {

    TestBench bench = new TestBench(); // new instance


    @Override
    public void init() {
        bench.init(hardwareMap); // the init method form TestBench
    }

    @Override
    public void loop() {
        if (!bench.touchSensorIntakeReleased()) {
            bench.setMotorSpeed(0.5);
        }
        else {
            bench.setMotorSpeed(0);
        }

        if (gamepad1.a) {
            bench.changeMotorZeroMode(DcMotor.ZeroPowerBehavior.BRAKE);

        }

        else if (gamepad1.b) {

            bench.changeMotorZeroMode(DcMotor.ZeroPowerBehavior.FLOAT);
        }


        telemetry.addData("Motor Revs", bench.getMotorRevs());
    }
}