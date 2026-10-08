package org.firstinspires.ftc.teamcode.rinRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class sFMikiServo {
    private Servo mikuServo;
    private CRServo mikuSerSpin;
    public void init(HardwareMap hwMap) {
        mikuServo = hwMap.get(Servo.class, "mikuServo");
        mikuSerSpin = hwMap.get(CRServo.class, "mikuSerSpin");
        //mikuServo.scaleRange(.5,1.0); gives the certain range
        //mikuServo.setDirection(Servo.Direction.REVERSE); does the direction
    }
    public void loop() {

    }

    public void setServoPosition(double angle) {
            mikuServo.setPosition(angle);
        }

    public void setServoSpin (double power) {
        mikuSerSpin.setPower(power);
    }
}
