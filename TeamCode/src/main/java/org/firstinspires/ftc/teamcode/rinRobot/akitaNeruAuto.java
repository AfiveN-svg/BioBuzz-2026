package org.firstinspires.ftc.teamcode.rinRobot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class akitaNeruAuto extends LinearOpMode {
    private DcMotor rightBackMotor;
    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    // private sFMikiServo tetoKS = new sFMikiServo();
    private DcMotorEx tetoIntake;
    ElapsedTime runtime;
    double tetoTurn = 1;
    double mikuForward = .5;

    @Override
    public void runOpMode() {
        DcMotor leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        DcMotorEx tetoIntake = hardwareMap.get(DcMotorEx.class, "tetoIntake");
        runtime = new ElapsedTime();
        waitForStart();

        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightBackMotor.setPower(0);
        rightFrontMotor.setPower(0);
        double tetoIntakePow = 0;

        while (opModeIsActive() && (runtime.seconds() <= 2)) {
            leftFrontMotor.setPower(mikuForward);
            leftBackMotor.setPower(mikuForward);
            rightBackMotor.setPower(mikuForward);
            rightFrontMotor.setPower(mikuForward);
        }
       // while (opModeIsActive() && runtime.seconds() >=2 && (runtime.seconds() <=3));
    }
}
