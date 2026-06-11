package com.self.cinema.WorkerManage.Workers;



public class Maintainer extends Worker{
    public Maintainer(String workType, String workCode, String name, String gender, String phone, String password, double salary){
        super(workType,workCode,name,gender,phone,password,salary);
    }

    @Override
    public void printWorkInfo() {
        super.printWorkInfo();
    }
}
