package org.firstinspires.ftc.teamcode.rinRobot;

/*import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.Object;
import java.time.Duration;
//import com.qualcomm.robotcore.hardware.DcMotorEx;*/

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class mikuMechanum extends LinearOpMode {
    sFMikiServo tetoMiku = new sFMikiServo();
    private boolean tetoToggle = false;
    private boolean tetoStatePrevious = false;
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        DcMotor tetoIntake = hardwareMap.get(DcMotor.class, "tetoIntake");
        DcMotor mikuOuttake = hardwareMap.get(DcMotor.class, "tetoOuttake");
        tetoMiku.init(hardwareMap);

        waitForStart();
        while(opModeIsActive()){
            double x = gamepad1.left_stick_x * 1.1;
            double y = -gamepad1.left_stick_y;
            double z = gamepad1.right_stick_x;

            double leftFrontPow = Math.pow(-x + y + z, 3);
            double leftbackPow = Math.pow(x + y + z, 3);
            double rightFrontPow = Math.pow(x + y - z, 3);
            double rightBackPow = Math.pow(-x + y - z, 3);
            boolean tetoStateCurrent = gamepad1.dpad_down;
            double mikuStateCurrent = gamepad1.right_trigger;

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

            if (mikuStateCurrent > .5) {
                mikuOuttake.setPower(-.8);
                sleep(1000);
                tetoMiku.setTetoServoPosition(.25);
                tetoMiku.setMikuServoPosition(-.25);
            } else {
                mikuOuttake.setPower(0);
                sleep(1000);
                tetoMiku.setTetoServoPosition(0);
                tetoMiku.setMikuServoPosition(0);
            }
        }
    }
}
/*@TeleOp
public class mikuMechanum extends OpMode {
    sFMikiServo tetoMiku = new sFMikiServo();
    private DcMotor tetoIntake;
    private DcMotor mikuOuttake;
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
        tetoIntake = hardwareMap.get(DcMotor.class, "tetoIntake");
        mikuOuttake = hardwareMap.get(DcMotor.class, "tetoOuttake");
        tetoMiku.init(hardwareMap);

    }

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x * 1.1;
        double y = -gamepad1.left_stick_y;
        double z = gamepad1.right_stick_x;

        double leftFrontPow = Math.pow(-x + y + z, 3);
        double leftbackPow = Math.pow(x + y + z, 3);
        double rightFrontPow = Math.pow(x + y - z, 3);
        double rightBackPow = Math.pow(-x + y - z, 3);
        boolean tetoStateCurrent = gamepad1.dpad_down;
        double mikuStateCurrent = gamepad1.right_trigger;

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

        if (mikuStateCurrent > .5) {
            mikuOuttake.setPower(-.8);
            tetoMiku.setTetoServoPosition(.25);
            tetoMiku.setMikuServoPosition(-.25);
        } else {
            mikuOuttake.setPower(0);

            tetoMiku.setTetoServoPosition(0);
            tetoMiku.setMikuServoPosition(0);
        }
    }
}*/
