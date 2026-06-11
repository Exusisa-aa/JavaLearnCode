package com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath;

import com.self.cinema.WorkerManage.CinemaWorkerManagement;
import com.self.cinema.WorkerManage.Workers.Worker;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MyUtils {
    public static int intInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static double doubleInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }


    public static StringBuilder randomUUID(){
        Random r = new Random();
        String ku = "123456789";
        StringBuilder id = new StringBuilder();
        for (int i = 1; i <= 8;i++) {
            id.append(ku.charAt(r.nextInt(ku.length())));
        }

        if (CinemaWorkerManagement.workers.isEmpty()){
            return id;
        }else {
            for (Worker worker : CinemaWorkerManagement.workers) {
                if (Objects.equals(worker.getWorkCode(), id.toString())) {
                    randomUUID();
                    break;
                }
            }
        }
        return id;
    }


}
