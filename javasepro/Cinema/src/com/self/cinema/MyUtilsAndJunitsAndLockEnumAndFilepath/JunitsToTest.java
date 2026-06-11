package com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath;

import com.self.cinema.CinemaManage.CinemaManagerManagement;
import com.self.cinema.CinemaManage.Hall.Hall;
import com.self.cinema.CinemaManage.LoadAndUpdateCinemaMessage;
import com.self.cinema.CustomerManage.CinemaCustomerManagement;
import com.self.cinema.CustomerManage.Customer.Customer;
import com.self.cinema.CustomerManage.Feedbacks.Feedback;
import com.self.cinema.CustomerManage.Records.Record;
import com.self.cinema.StartWorker.StartWorker;
import com.self.cinema.WorkerManage.CinemaWorkerManagement;
import com.self.cinema.WorkerManage.WorkDays.WorkDay;
import com.self.cinema.WorkerManage.Workers.Cleaner;
import com.self.cinema.WorkerManage.Workers.Worker;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class JunitsToTest {
    @Test
    public void ManagerShowHallInfo(){
        //查看厅信息
        CinemaManagerManagement cinemaManagerManagement = new CinemaManagerManagement();
        for (Hall hall : CinemaManagerManagement.cinema) {
            cinemaManagerManagement.printHallInfo(hall);
        }
    }

    @Test
    public void ManagerDeclareDevice(){
        //有关设备维修等
        LoadAndUpdateCinemaMessage.updateDeviceInfo(true,"坏了",6);
        LoadAndUpdateCinemaMessage.updateDeviceInfo(false,"NULL",6);
    }

    @Test
    public void ManagerDealWithWorker(){
        //添加员工
        Worker worker = new Cleaner("前台","12345678","清洁工A","男","15384238051","22222",10000);
        StartWorker.proxyForWorker.updateWorker("前台",worker,false);
        for (int i = 0; i < 7; i++) {
            WorkDay workDay = new WorkDay(LocalDate.now().plusDays(i),false);
            worker.getWorkDays().add(workDay);
        }
        CinemaWorkerManagement.workers.add(worker);

        //加薪
        worker.setSalary(worker.getSalary() + 1000);

        //打印员工信息
        worker.printWorkInfo();

        //请假
        worker.getLeaveApplications().put(1,"申请中,理由:" + "发烧" + ",申请的日期:" + LocalDate.now());
        worker.getLeaveApplications().put(1,"已批准,理由:" + "发烧" + ",申请的日期:" + LocalDate.now());

        //员工改密码
        worker.setPassword("33333");

        //炒鱿鱼
        CinemaWorkerManagement.workers.remove(worker);
    }

    @Test
    public void customerTest(){
        //添加顾客
        Customer customer = null;
        try {
            customer = new Customer(InetAddress.getByName("192.168.1.5"),0,"123456","123456789","15384238051","男","test","12345678");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        CinemaCustomerManagement.customers.add(customer);

        //查看个人信息
        new CinemaCustomerManagement().showMoneyAndInfo(customer);

        //充值
        customer.setMoney(customer.getMoney() + 1000);

        //评论
        Feedback feedback = new Feedback("这个电影很棒", LocalDateTime.now());
        customer.getComment().put("星际穿越",feedback);
        customer.getComment().remove("星际穿越");

        //添加好友
        customer.getFriends().add("11111111");
        customer.getFriends().remove("11111111");

        //买票
        Record record = new Record();
        customer.getRecords().add(record);

        //查看买票记录
        new CinemaCustomerManagement().printRecord(customer);

        //退票
        customer.getRecords().remove(record);
    }
}
