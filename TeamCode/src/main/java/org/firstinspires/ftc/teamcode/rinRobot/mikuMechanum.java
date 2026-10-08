package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class mikuMechanum extends OpMode {
    sFMikiServo tetoServo = new sFMikiServo();
    sFMikiServo mikuServo = new sFMikiServo();
    private DcMotorEx tetoIntake;
    private DcMotor leftBackMotor;
    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    private DcMotor rightBackMotor;
    private boolean tetoToggle = false;
    private boolean tetoStatePrevious = false;

    @Override
    public void init() {
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        tetoIntake = hardwareMap.get(DcMotorEx.class, "tetoIntake");
        tetoServo.init(hardwareMap);
        mikuServo.init(hardwareMap);

    }

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x * 1.1;
        double y = -gamepad1.left_stick_y;
        double z = gamepad1.right_stick_x;

        double leftFrontPow = Math.pow(-x + y - z, 3);
        double leftbackPow = Math.pow(x + y + z, 3);
        double rightFrontPow = Math.pow(-x + y + z, 3);
        double rightBackPow = Math.pow(x + y - z, 3);
        boolean tetoStateCurrent = gamepad1.dpad_down;

        leftFrontMotor.setPower(leftFrontPow);
        leftBackMotor.setPower(leftbackPow);
        rightFrontMotor.setPower(rightFrontPow);
        rightBackMotor.setPower(rightBackPow);

        if (tetoStateCurrent && !tetoStatePrevious) {
            tetoToggle = !tetoToggle;
        }
        tetoStatePrevious = tetoStateCurrent;
        if (tetoToggle) {
            tetoIntake.setVelocity(1866.67);
        } else {
            tetoIntake.setVelocity(0);
        }

        if (gamepad1.a) {
            tetoServo.setServoPosition(.5);
            mikuServo.setServoPosition(-.5);
        }
        else{
            tetoServo.setServoPosition(0);
            mikuServo.setServoSpin(0);
        }
    }
}
