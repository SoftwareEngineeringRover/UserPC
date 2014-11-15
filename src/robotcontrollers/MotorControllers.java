/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrollers;

/**
 *
 * @author junxnhe
 */
public class MotorControllers extends RobotControllers{
    String type="Motor";
    int speed=0;
    int degree;
    int maxSpeed=-200;
    
    
    public MotorControllers(int avoidIndex) {
        super(avoidIndex);
        super.searchForControllers();
        if(isEmpty()){
            System.out.println(type + " joystick connected!");
        }else{
            System.out.println("Unable to find extra joystick for "+type+" controller");
        }
    }
    
    public String getMotorData(){
        super.getData();
        getSpeed();
        getRotation();
        return 0+" "+speed+" "+degree;
    }
    
    private void getSpeed(){
        speed=(int)(zAxis*maxSpeed);
        //send to robot
    }
    
    private void getRotation(){
        degree=(int)Math.toDegrees(Math.atan2(-yAxis, xAxis));
        if(degree<-90){
            degree+=270;
        }else{
            degree-=90;
        }
        //send to robot
    }
}
