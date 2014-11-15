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
        MotorControllers ms = new MotorControllers(-1);
        String motorData="";
        ServerSocket listener = new ServerSocket(9090);
        while (true) {
            motorData=ms.getMotorData();
            Socket socket = listener.accept();
            PrintWriter out
                    = new PrintWriter(socket.getOutputStream(), true);
            out.println(motorData);
        }
    }

}
