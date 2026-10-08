package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
@TeleOp
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
            tetoIntake.setVelocity(800);
        } else {
            tetoIntake.setVelocity(0);
        }

        if (gamepad1.a) {
            tetoServo.setMikuServoPosition(.25);
            mikuServo.setTetoServoPosition(-.25);
        }
        else{
            tetoServo.setTetoServoPosition(0);
            mikuServo.setMikuServoPosition(0);
        }
    }
}
