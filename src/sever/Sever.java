/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sever;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import robotcontrollers.MotorControllers;

/**
 *
 * @author junxin
 */
public class Sever {

    public static void main(String[] args) throws IOException {
        //MotorControllers ms = new MotorControllers(-1);
        int motorData = 1;
        ServerSocket listener = new ServerSocket(9090);
        Socket socket = null;
        boolean done = false;
        while (!done) {
            socket = listener.accept();
            done = true;
        }
        PrintWriter out;
        while (true) {
            //motorData=ms.getMotorData();
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(motorData);
            motorData++;
        }
    }
}
