package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@TeleOp
public class MecanumFieldOrientatedOpMode extends OpMode {

    MecanumDrive drive = new MecanumDrive();

    double forward, strafe, rotate;


    @Override
    public void init() {
        drive.init(hardwareMap);

    }
    
    @Override
    public void loop() {

        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        double newForward = forward * Math.abs(forward); // square inputs to improve precision in small adjustments
        double newStrafe = strafe * Math.abs(strafe);
        double newRotate = rotate * Math.abs(rotate);

        drive.driveFieldRelative(newForward, newStrafe, newRotate);

        telemetry.addData("Stick Forward", forward);
        telemetry.addData("Stick Strafe", strafe);
        telemetry.addData("Stick Turn", rotate);

        // scaled
        telemetry.addData("Drive Forward", newForward);
        telemetry.addData("Drive Strafe", newStrafe);
        telemetry.addData("Drive Turn", newRotate);

    }

}
