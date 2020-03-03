package com.multithreading.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectionService extends Thread {

    public void run() {
        try {
            while (!Config.getisShutDown()) {
                String ip = Config.queueTake();
                System.out.println(" [ Pinging  " + ip + " ]");
                try {
                    ping(ip);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); }
        finally{
            if (!Config.getisShutDown())
                run();

        }
    }

    public void ping (String ipAddress) throws IOException
    {
        System.out.println("Entered Ping");
        System.out.println("[ Pinging " + ipAddress + " ]");
        try {
            String[] command = {"/bin/bash", "-c", "ping -i 2 -W 2 -t 2 -c 3 " + ipAddress};
            ProcessBuilder build = new ProcessBuilder(command);
            Process process = build.start();
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader Error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String s = null;
            System.out.println("Standard output: ");
            while ((s = input.readLine()) != null) {
                System.out.println(s);
            }
            if ((s = Error.readLine()) != null) {
                while ((s = Error.readLine()) != null) {
                    System.out.println(s);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}