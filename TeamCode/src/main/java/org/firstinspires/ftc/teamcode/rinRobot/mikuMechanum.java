package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.Object;
import java.time.Duration;
//import com.qualcomm.robotcore.hardware.DcMotorEx;*/

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class mikuMechanum extends OpMode {
        private boolean tetoToggle = false;
        private boolean tetoStatePrevious = false;
        private boolean mikuToggle = false;
        private boolean mikuStatePrevious = false;

   private DcMotor leftBackMotor;
    private DcMotor leftFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotor rightFrontMotor;
    private DcMotor tetoIntake;
    private DcMotor mikuOuttake;
    private Servo mikuServo;
    private Servo tetoServo;
    @Override
    public void init() {
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
         leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
         rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
         rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
         tetoIntake = hardwareMap.get(DcMotor.class, "tetoIntake");
         mikuOuttake = hardwareMap.get(DcMotor.class, "tetoOuttake");
        mikuServo = hardwareMap.get(Servo.class, "mikuServo");
        tetoServo = hardwareMap.get(Servo.class, "tetoServo");
        tetoServo.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x * 1.1;
        double y = -gamepad1.left_stick_y;
        double z = gamepad1.right_stick_x;

        double leftFrontPow = Math.pow(x + y + z, 3);
        double leftbackPow = Math.pow(-x + y + z, 3);
        double rightFrontPow = Math.pow(-x + y - z, 3);
        double rightBackPow = Math.pow(x + y - z, 3);
        boolean tetoStateCurrent = gamepad1.dpad_down;
        boolean mikuStateCurrent = gamepad1.b;

        leftFrontMotor.setPower(leftFrontPow);
        leftBackMotor.setPower(leftbackPow);
        rightFrontMotor.setPower(rightFrontPow);
        rightBackMotor.setPower(rightBackPow);

        if (tetoStateCurrent && !tetoStatePrevious) {
            tetoToggle = !tetoToggle;
        }
        tetoStatePrevious = tetoStateCurrent;
        if (tetoToggle) {
            tetoIntake.setPower(1);

        } else {
            tetoIntake.setPower(0);
        }

        if (mikuStateCurrent && !mikuStatePrevious) {
            mikuToggle = !mikuToggle;
        }
        mikuStatePrevious= mikuStateCurrent;
        if (mikuToggle) {
            mikuOuttake.setPower(-.8);

        } else {
            mikuOuttake.setPower(0);
        }
        if (gamepad1.right_trigger > .5) {
            mikuServo.setPosition(.25);
            tetoServo.setPosition(.25);
        }
        else {

            mikuServo.setPosition(0);
            tetoServo.setPosition(0);
        }
    }
}
