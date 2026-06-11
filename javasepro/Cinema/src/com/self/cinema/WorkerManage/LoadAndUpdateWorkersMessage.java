package com.self.cinema.WorkerManage;

import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.FilePath;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.LockForThread;
import com.self.cinema.WorkerManage.WorkDays.WorkDay;
import com.self.cinema.WorkerManage.WorkDays.WorkTimes.WorkTime;
import com.self.cinema.WorkerManage.Workers.Worker;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;

public class LoadAndUpdateWorkersMessage {
    //由于要多次读  为了避免覆盖上次的数据  只允许赋值给Document和SAXReader一次 ！！！！！
    private static Document cachedDocument = null;

    public static void LoadWorkersMessageMethod() {
        try {
            LockForThread.INSTANCE.getLock().lock();
            File file = new File(FilePath.WORKER_PATH_TO_XML.getPath());

            //一定要判断是否为空，防止重复创建，导致上次的数据丢失
            //获取reader和document
            if (cachedDocument == null) {
                SAXReader reader = new SAXReader();
                cachedDocument = reader.read(file);
            }

            if(file.length() != 0){
                Element rootElement = cachedDocument.getRootElement();
                rootElement.elements().clear();
            }
            //获得根节点workers
            Element rootElement = cachedDocument.getRootElement();
            //遍历workers
            if (!CinemaWorkerManagement.workers.isEmpty()) {
                for (Worker worker : CinemaWorkerManagement.workers) {
                    //worker
                    Element elementForWorker = rootElement.addElement("worker");
                    elementForWorker.addAttribute("workCode", worker.getWorkCode());
                    elementForWorker.addElement("workType").setText(worker.getWorkType());
                    elementForWorker.addElement("name").setText(worker.getName());
                    elementForWorker.addElement("gender").setText(worker.getGender());
                    elementForWorker.addElement("phone").setText(worker.getPhone());
                    elementForWorker.addElement("password").setText(worker.getPassword());
                    elementForWorker.addElement("salary").setText(String.valueOf(worker.getSalary()));
                    //workDays
                    Element elementForWorkerDays = elementForWorker.addElement("workDays");
                    if(!worker.getWorkDays().isEmpty()){
                        for (WorkDay workDay : worker.getWorkDays()) {
                            Element elementForWorkerDay = elementForWorkerDays.addElement("workDay");
                            elementForWorkerDay.addAttribute("workDate", String.valueOf(workDay.getWorkDate()));
                            elementForWorkerDay.addElement("isLeave").setText(String.valueOf(workDay.isLeave()));
                            //workTimes
                            if(workDay.isLeave()){
                                elementForWorkerDay.addElement("workLeave").setText("已请假，今日无排班");
                            }else {
                                Element elementForWorkerTimes = elementForWorkerDay.addElement("workTimes");
                                for (WorkTime workTime : workDay.getWorkTimes()) {
                                    Element elementForWorkerTime = elementForWorkerTimes.addElement("workTime");
                                    elementForWorkerTime.addAttribute("workerHall", workTime.getWorkHall());
                                    elementForWorkerTime.addElement("startWorkTime").setText(String.valueOf(workTime.getStartWorkTime()));
                                    elementForWorkerTime.addElement("endWorkTime").setText(String.valueOf(workTime.getEndWorkTime()));
                                }
                            }
                        }
                    }
                    //leaveApplications
                    if(!worker.getLeaveApplications().isEmpty()){
                        Element elementForLeaveApplications = elementForWorker.addElement("leaveApplications");
                        worker.getLeaveApplications().forEach((k,v)->{
                            Element elementForLeaveApplication = elementForLeaveApplications.addElement("leaveApplication");
                            elementForLeaveApplication.addElement("index").setText(String.valueOf(k));
                            elementForLeaveApplication.addElement("message").setText(v);
                        });
                    }
                }
            }

            //写入规则(缩进 换行 字符集)
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("UTF-8");
            //缩进
            outputFormat.setIndent(true);
            //缩进长度
            outputFormat.setIndentSize(4);
            //换行
            outputFormat.setNewlines(true);

            //写入XML
            XMLWriter writer = new XMLWriter(new FileWriter(file), outputFormat);
            writer.write(cachedDocument);
            writer.close();
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }

}