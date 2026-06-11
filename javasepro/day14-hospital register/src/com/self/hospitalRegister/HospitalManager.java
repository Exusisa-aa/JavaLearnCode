package com.self.hospitalRegister;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class HospitalManager {
    private final ArrayList<Department> allDepartments = new ArrayList<>();

    public void start(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("=====欢迎进入仁爱医院信息管理与患者挂号系统=====");
            System.out.println("1.科室管理-添加科室");
            System.out.println("2.科室管理-删除科室");
            System.out.println("3.科室管理-修改科室");
            System.out.println("4.医生管理-录入医生");
            System.out.println("5.医生管理-调取医生到其他科室"); 
            System.out.println("6.医生管理-解雇医生");
            System.out.println("7.医生管理-医生坐诊设置或修改(可设置或修改当天与未来六天的排班与坐诊情况)");
            System.out.println("8.医生管理-搜索某个医生的坐诊详情(当前与未来六天的坐诊详情)");
            System.out.println("9.患者管理-挂号预约");
            System.out.println("10.退出系统");
            System.out.println("请输入操作指令：");
            String command = sc.next();
            switch (command){
                case "1":
                    addDepartment(allDepartments);
                    break;
                case "2":
                    deleteDepartment(allDepartments);
                    break;
                case "3":
                    changeDepartment(allDepartments);
                    break;
                case "4":
                    addDoctor(allDepartments);
                    break;
                case "5":
                    changeDoctor(allDepartments);
                    break;
                case "6":
                    deleteDoctor(allDepartments);
                    break;
                case "7":
                    setDoctorSchedule(allDepartments);
                    break;
                case "8":
                    searchDoctorInformation(allDepartments);
                    break;
                case "9":
                    appoint(allDepartments);
                    break;
                case "10":
                    return;
                default:
                    System.out.println("您输入的指令不正确");
                    break;
            }
        }
    }

    public void addDepartment(ArrayList<Department> allDepartments){
        Scanner sc = new Scanner(System.in);
        OUT1:
        while (true) {
            Department newDepartment = new Department();
            System.out.println("请输入科室名称：");
            String DepartmentName = sc.next();
            for (Department department : allDepartments) {
                if(Objects.equals(DepartmentName,department.getName())){
                    System.out.println("该科室已存在");
                    continue OUT1;
                }
            }
            newDepartment.setName(DepartmentName);
            allDepartments.add(newDepartment);
            System.out.println("添加成功！");
            return;
        }
    }

    public void addDoctor(ArrayList<Department> allDepartments){
        Scanner sc = new Scanner(System.in);
        int remember;
        Doctor newDoctor = new Doctor();
        if(allDepartments.isEmpty()){
            System.out.println("当前还没有科室,请创建科室");
            return;
        }

        OUT1:
        while (true) {
            System.out.println("请输入科室的名字：");
            String departmentName = sc.next();
            for (int i = 0; i < allDepartments.size(); i++) {
                if(Objects.equals(departmentName,allDepartments.get(i).getName())){
                    remember = i;
                    newDoctor.setDepartmentName(departmentName);
                    break OUT1;
                }
                if(i == allDepartments.size()-1){
                    System.out.println("不存在该科室");
                    continue OUT1;
                }
            }
        }

        System.out.println("请输入医生姓名：");
        String doctorName = sc.next();
        newDoctor.setName(doctorName);
        System.out.println("请输入年龄：");
        int doctorAge;
        try {
            doctorAge = sc.nextInt();
        } catch (Exception e) {
            System.out.println("只能输入数字");
            return;
        }
        newDoctor.setAge(doctorAge);
        while (true) {
            System.out.println("请输入性别：");
            String doctorGender = sc.next();
            if (Objects.equals(doctorGender,"男" )|| Objects.equals(doctorGender,"女")){
                newDoctor.setGender(doctorGender);
                break;
            }else {
                System.out.println("您输入有误");
            }
        }
        System.out.println("请输入科室专长：");
        String doctorSpeciality = sc.next();
        newDoctor.setSpeciality(doctorSpeciality);
        while (true) {
            try {
                inputJoinTime(newDoctor);
                break;
            } catch (Exception e) {
                System.out.println("输入有误，请重新输入~~");
            }
        }

        String doctorId = randomId();
        OUT2:
        while (true) {
            for (int i = 0; i < allDepartments.size(); i++) {
                if(allDepartments.get(i).getDoctors().isEmpty()){
                    if(i == allDepartments.size()-1){
                        break OUT2;
                    }
                    continue;
                }
                for (int j = 0; j < allDepartments.get(i).getDoctors().size(); j++) {
                    if(Objects.equals(doctorId,allDepartments.get(i).getDoctors().get(j).getDoctorId())){
                        doctorId = randomId();
                        continue OUT2;
                    }
                    if(j == allDepartments.get(i).getDoctors().size()-1){
                        break;
                    }
                }
                if(i == allDepartments.size()-1){
                    break OUT2;
                }
            }
        }
        newDoctor.setDoctorId(doctorId);
        allDepartments.get(remember).getDoctors().add(newDoctor);
        System.out.println("医生添加成功！" + newDoctor.getName() + "的唯一id为" + newDoctor.getDoctorId());
    }

    public void inputJoinTime(Doctor newDoctor){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("请输入入职时间(yyyy-MM-dd):");
        String doctorJoinDate = sc.next();
        newDoctor.setJoinDate(LocalDate.parse(doctorJoinDate,formatter));
    }


    public String randomId(){
        Random r = new Random();
        int number;
        StringBuilder randomId = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            number = r.nextInt(10);
            randomId.append(number);
        }
        return randomId.toString();
    }

    public void changeDepartment(ArrayList<Department> allDepartments){
        Scanner sc = new Scanner(System.in);
        int remember;
        if(allDepartments.isEmpty()){
            System.out.println("当前还没有科室,请创建科室");
            return;
        }
        OUT1:
        while (true) {
            System.out.println("请输入科室的名字：");
            String departmentName = sc.next();
            for (int i = 0; i < allDepartments.size(); i++) {
                if(Objects.equals(departmentName,allDepartments.get(i).getName())){
                    remember = i;
                    break OUT1;
                }
                if(i == allDepartments.size()-1){
                    System.out.println("不存在该科室");
                    continue OUT1;
                }
            }
        }

        OUT2:
        while (true) {
            System.out.println("请输入该科室修改后的名字：");
            String newDepartmentName = sc.next();
            for (int i = 0; i < allDepartments.size(); i++) {
                if(Objects.equals(newDepartmentName,allDepartments.get(i).getName())){
                    System.out.println("该科室已存在,请重新输入：");
                    continue OUT2;
                }
                if(i == allDepartments.size()-1){
                    allDepartments.get(remember).setName(newDepartmentName);
                    System.out.println("修改成功！");
                    break OUT2;
                }
            }
        }
    }

    public void deleteDepartment(ArrayList<Department> allDepartments){
        Scanner sc = new Scanner(System.in);
        if(allDepartments.isEmpty()){
            System.out.println("当前还没有科室,请创建科室");
            return;
        }

        OUT1:
        while (true) {
            System.out.println("请输入科室的名字：");
            String departmentName = sc.next();
            for (int i = 0; i < allDepartments.size(); i++) {
                if(Objects.equals(departmentName,allDepartments.get(i).getName())){
                    if (!allDepartments.get(i).getDoctors().isEmpty()){
                        System.out.println("该科室还有医生,不能删除！");
                        return;
                    }else {
                        allDepartments.remove(allDepartments.get(i));
                        System.out.println("删除成功！");
                        break OUT1;
                    }
                }
                if(i == allDepartments.size()-1){
                    System.out.println("不存在该科室");
                    continue OUT1;
                }
            }
        }
    }

    public void deleteDoctor(ArrayList<Department> allDepartments){
        Scanner sc = new Scanner(System.in);
        int emptyNumber = 0;
        for (Department department : allDepartments) {
            if (department.getDoctors().isEmpty()) {
                emptyNumber++;
            }
        }
        if (emptyNumber == allDepartments.size()) {
            System.out.println("还没有添加医生,请添加医生");
            return;
        }

        System.out.println("请输入想要解雇医生的id：");
        String doctorId = sc.next();
        for (int i = 0; i < allDepartments.size(); i++) {
            if(allDepartments.get(i).getDoctors().isEmpty() && i == allDepartments.size()-1){
                System.out.println("未找到该id");
                return;
            }
            for (int j = 0; j < allDepartments.get(i).getDoctors().size(); j++) {
                if(Objects.equals(doctorId,allDepartments.get(i).getDoctors().get(j).getDoctorId())){
                    System.out.println("已解雇医生" + allDepartments.get(i).getDoctors().get(j).getName());
                    allDepartments.get(i).getDoctors().remove(allDepartments.get(i).getDoctors().get(j));
                    return;
                }
                if(i == allDepartments.size()-1){
                    if (j == allDepartments.get(i).getDoctors().size()-1){
                        System.out.println("未找到该id");
                        return;
                    }
                }
            }
        }
    }

    public void changeDoctor(ArrayList<Department> allDepartments){
        Scanner sc = new Scanner(System.in);
        int emptyNumber = 0;
        int remember1 = 0;
        int remember2 = 0;
        Doctor newDoctor = new Doctor();
        for (Department department : allDepartments) {
            if (department.getDoctors().isEmpty()) {
                emptyNumber++;
            }
        }
        if (emptyNumber == allDepartments.size()) {
            System.out.println("还没有添加医生,请添加医生");
            return;
        }

        if(allDepartments.size() == 1){
            System.out.println("目前只有一个科室,无法进行调取操作");
            return;
        }

        System.out.println("请输入想要调取医生的id：");
        String doctorId = sc.next();
        OUT2:
        for (int i = 0; i < allDepartments.size(); i++) {
            if(allDepartments.get(i).getDoctors().isEmpty() && i == allDepartments.size()-1){
                System.out.println("未找到该id");
                return;
            }
            for (int j = 0; j < allDepartments.get(i).getDoctors().size(); j++) {
                if(Objects.equals(doctorId,allDepartments.get(i).getDoctors().get(j).getDoctorId())){
                    remember1 = i;
                    remember2 = j;
                    newDoctor = allDepartments.get(i).getDoctors().get(j);
                    break OUT2;
                }
                if(i == allDepartments.size()-1){
                    if (j == allDepartments.get(i).getDoctors().size()-1){
                        System.out.println("未找到该id");
                        return;
                    }
                }
            }
        }

        OUT1:
        while (true) {
            System.out.println("请输入科室的名字：");
            String departmentName = sc.next();
            for (int i = 0; i < allDepartments.size(); i++) {
                if(Objects.equals(departmentName,allDepartments.get(i).getName())){
                    allDepartments.get(remember1).getDoctors().remove(allDepartments.get(remember1).getDoctors().get(remember2));
                    System.out.println("重置了该医生的专长,请重新输入该医生的专长：");
                    String newSpeciality = sc.next();
                    newDoctor.setSpeciality(newSpeciality);
                    allDepartments.get(i).getDoctors().add(newDoctor);
                    System.out.println("已调取该医生信息至科室" + allDepartments.get(i).getName());
                    break OUT1;
                }
                if(i == allDepartments.size()-1){
                    System.out.println("不存在该科室");
                    continue OUT1;
                }
            }
        }
    }

    public void setDoctorSchedule(ArrayList<Department> allDepartments){
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        int emptyNumber = 0;
        int remember1 = 0;
        int remember2 = 0;
        int addNewDate = 0;
        for (Department department : allDepartments) {
            if (department.getDoctors().isEmpty()) {
                emptyNumber++;
            }
        }
        if (emptyNumber == allDepartments.size()) {
            System.out.println("还没有添加医生,请添加医生");
            return;
        }

        System.out.println("请输入想要设置坐诊医生信息的id：");
        String doctorId = sc.next();
        OUT1:
        for (int i = 0; i < allDepartments.size(); i++) {
            if(allDepartments.get(i).getDoctors().isEmpty() && i == allDepartments.size()-1){
                System.out.println("未找到该id");
                return;
            }
            for (int j = 0; j < allDepartments.get(i).getDoctors().size(); j++) {
                if(Objects.equals(doctorId,allDepartments.get(i).getDoctors().get(j).getDoctorId())){
                    remember1 = i;
                    remember2 = j;
                    addNewDate = updateTheDate(allDepartments.get(i).getDoctors().get(j));//给医生加七天schedule对象
                    break OUT1;
                }
                if(i == allDepartments.size()-1){
                    if (j == allDepartments.get(i).getDoctors().size()-1){
                        System.out.println("未找到该id");
                        return;
                    }
                }
            }
        }

        if (allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().size() == 7){
            String date;
            if(addNewDate == 0){
                for (int i = 0; i < 7; i++) {
                    date = formatterDate.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getToday());
                    while (true) {
                        System.out.println(date + "的排班:");
                        System.out.println("上午是否排班？y/n");
                        String isMorningUpdate = sc.next();
                        if (isMorningUpdate.equals("n")) {
                            System.out.println("上午休息");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningIsUpdate(false);
                            break;
                        }else if (isMorningUpdate.equals("y")) {
                            System.out.println("上午上班");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningIsUpdate(true);
                            break;
                        }else {
                            System.out.println("输入有误");
                        }

                    }


                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorningIsUpdate()){
                        while (true) {
                            System.out.println("上午是否看诊？y/n");
                            String IsMorning = sc.next();
                            if(IsMorning.equals("y")){
                                System.out.println("上午要看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorning(true);
                                break;
                            }else if(IsMorning.equals("n")){
                                System.out.println("上午不看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorning(false);
                                break;
                            }else {
                                System.out.println("输入有误");
                            }
                        }
                    }

                    //排班不看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorningIsUpdate() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorning()){
                        String morningStartTime;
                        while (true){
                            System.out.println("请输入上午排班开始时间(HH:mm:ss)：");
                            morningStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningStartTime.startsWith("0") || morningStartTime.startsWith("1")){
                                if (morningStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningStartTime.startsWith("2")) {
                                if (morningStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningStartTime(LocalTime.parse(morningStartTime,formatterTime));
                        String morningEndTime;
                        while (true){
                            System.out.println("请输入上午排班结束时间(HH:mm:ss)：");
                            morningEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningEndTime.startsWith("0") || morningEndTime.startsWith("1")){
                                if (morningEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningEndTime.startsWith("2")) {
                                if (morningEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningEndTime(LocalTime.parse(morningEndTime,formatterTime));
                        System.out.println("已排班，且当天不用看诊~~");
                    }

                    //排班看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorningIsUpdate() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorning()){
                        String morningStartTime;
                        while (true){
                            System.out.println("请输入上午排班开始时间(HH:mm:ss)：");
                            morningStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningStartTime.startsWith("0") || morningStartTime.startsWith("1")){
                                if (morningStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningStartTime.startsWith("2")) {
                                if (morningStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningStartTime(LocalTime.parse(morningStartTime,formatterTime));
                        String morningEndTime;
                        while (true){
                            System.out.println("请输入上午排班结束时间(HH:mm:ss)：");
                            morningEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningEndTime.startsWith("0") || morningEndTime.startsWith("1")){
                                if (morningEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningEndTime.startsWith("2")) {
                                if (morningEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningEndTime(LocalTime.parse(morningEndTime,formatterTime));
                        System.out.println("已排班，且要看诊~~");
                    }

                    while (true) {
                        System.out.println("下午是否排班？y/n");
                        String isAfternoonUpdate = sc.next();
                        if (isAfternoonUpdate.equals("n")) {
                            System.out.println("下午休息");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonIsUpdate(false);
                            break;
                        }else if (isAfternoonUpdate.equals("y")) {
                            System.out.println("下午上班");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonIsUpdate(true);
                            break;
                        }else {
                            System.out.println("输入有误");
                        }

                    }


                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoonIsUpdate()){
                        while (true) {
                            System.out.println("下午是否看诊？y/n");
                            String IsAfternoon = sc.next();
                            if(IsAfternoon.equals("y")){
                                System.out.println("下午要看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoon(true);
                                break;
                            }else if(IsAfternoon.equals("n")){
                                System.out.println("下午不看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoon(false);
                                break;
                            }else {
                                System.out.println("输入有误");
                            }
                        }
                    }

                    //排班不看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoonIsUpdate() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoon()){
                        String AfternoonStartTime;
                        while (true){
                            System.out.println("请输入下午排班开始时间(HH:mm:ss)：");
                            AfternoonStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonStartTime.startsWith("0") || AfternoonStartTime.startsWith("1")){
                                if (AfternoonStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonStartTime.startsWith("2")) {
                                if (AfternoonStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonStartTime(LocalTime.parse(AfternoonStartTime,formatterTime));
                        String AfternoonEndTime;
                        while (true){
                            System.out.println("请输入下午排班结束时间(HH:mm:ss)：");
                            AfternoonEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonEndTime.startsWith("0") || AfternoonEndTime.startsWith("1")){
                                if (AfternoonEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonEndTime.startsWith("2")) {
                                if (AfternoonEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonEndTime(LocalTime.parse(AfternoonEndTime,formatterTime));
                        System.out.println("已排班，且不用看诊~~");
                    }

                    //排班看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoonIsUpdate() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoon()){
                        String AfternoonStartTime;
                        while (true){
                            System.out.println("请输入下午排班开始时间(HH:mm:ss)：");
                            AfternoonStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonStartTime.startsWith("0") || AfternoonStartTime.startsWith("1")){
                                if (AfternoonStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonStartTime.startsWith("2")) {
                                if (AfternoonStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonStartTime(LocalTime.parse(AfternoonStartTime,formatterTime));
                        String AfternoonEndTime;
                        while (true){
                            System.out.println("请输入下午排班结束时间(HH:mm:ss)：");
                            AfternoonEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonEndTime.startsWith("0") || AfternoonEndTime.startsWith("1")){
                                if (AfternoonEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonEndTime.startsWith("2")) {
                                if (AfternoonEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonEndTime(LocalTime.parse(AfternoonEndTime,formatterTime));
                        System.out.println("已排班，且要看诊~~");
                    }
                }
            }else {
                for (int i = 7-addNewDate; i < 7; i++) {
                    date = formatterDate.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getToday());
                    while (true) {
                        System.out.println(date + "的排班:");
                        System.out.println("上午是否排班？y/n");
                        String isMorningUpdate = sc.next();
                        if (isMorningUpdate.equals("n")) {
                            System.out.println("上午休息");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningIsUpdate(false);
                            break;
                        }else if (isMorningUpdate.equals("y")) {
                            System.out.println("上午上班");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningIsUpdate(true);
                            break;
                        }else {
                            System.out.println("输入有误");
                        }

                    }


                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorningIsUpdate()){
                        while (true) {
                            System.out.println("上午是否看诊？y/n");
                            String IsMorning = sc.next();
                            if(IsMorning.equals("y")){
                                System.out.println("上午要看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorning(true);
                                break;
                            }else if(IsMorning.equals("n")){
                                System.out.println("上午不看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorning(false);
                                break;
                            }else {
                                System.out.println("输入有误");
                            }
                        }
                    }

                    //排班不看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorningIsUpdate() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorning()){
                        String morningStartTime;
                        while (true){
                            System.out.println("请输入上午排班开始时间(HH:mm:ss)：");
                            morningStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningStartTime.startsWith("0") || morningStartTime.startsWith("1")){
                                if (morningStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningStartTime.startsWith("2")) {
                                if (morningStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningStartTime(LocalTime.parse(morningStartTime,formatterTime));
                        String morningEndTime;
                        while (true){
                            System.out.println("请输入上午排班结束时间(HH:mm:ss)：");
                            morningEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningEndTime.startsWith("0") || morningEndTime.startsWith("1")){
                                if (morningEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningEndTime.startsWith("2")) {
                                if (morningEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningEndTime(LocalTime.parse(morningEndTime,formatterTime));
                        System.out.println("已排班，且当天不用看诊~~");
                    }

                    //排班看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorningIsUpdate() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorning()){
                        String morningStartTime;
                        while (true){
                            System.out.println("请输入上午排班开始时间(HH:mm:ss)：");
                            morningStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningStartTime.startsWith("0") || morningStartTime.startsWith("1")){
                                if (morningStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningStartTime.startsWith("2")) {
                                if (morningStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningStartTime(LocalTime.parse(morningStartTime,formatterTime));
                        String morningEndTime;
                        while (true){
                            System.out.println("请输入上午排班结束时间(HH:mm:ss)：");
                            morningEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(morningEndTime.startsWith("0") || morningEndTime.startsWith("1")){
                                if (morningEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (morningEndTime.startsWith("2")) {
                                if (morningEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setMorningEndTime(LocalTime.parse(morningEndTime,formatterTime));
                        System.out.println("已排班，且要看诊~~");
                    }

                    while (true) {
                        System.out.println("下午是否排班？y/n");
                        String isAfternoonUpdate = sc.next();
                        if (isAfternoonUpdate.equals("n")) {
                            System.out.println("下午休息");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonIsUpdate(false);
                            break;
                        }else if (isAfternoonUpdate.equals("y")) {
                            System.out.println("下午上班");
                            allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonIsUpdate(true);
                            break;
                        }else {
                            System.out.println("输入有误");
                        }

                    }


                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoonIsUpdate()){
                        while (true) {
                            System.out.println("下午是否看诊？y/n");
                            String IsAfternoon = sc.next();
                            if(IsAfternoon.equals("y")){
                                System.out.println("下午要看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoon(true);
                                break;
                            }else if(IsAfternoon.equals("n")){
                                System.out.println("下午不看诊");
                                allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoon(false);
                                break;
                            }else {
                                System.out.println("输入有误");
                            }
                        }
                    }

                    //排班不看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoonIsUpdate() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoon()){
                        String AfternoonStartTime;
                        while (true){
                            System.out.println("请输入下午排班开始时间(HH:mm:ss)：");
                            AfternoonStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonStartTime.startsWith("0") || AfternoonStartTime.startsWith("1")){
                                if (AfternoonStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonStartTime.startsWith("2")) {
                                if (AfternoonStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonStartTime(LocalTime.parse(AfternoonStartTime,formatterTime));
                        String AfternoonEndTime;
                        while (true){
                            System.out.println("请输入下午排班结束时间(HH:mm:ss)：");
                            AfternoonEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonEndTime.startsWith("0") || AfternoonEndTime.startsWith("1")){
                                if (AfternoonEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonEndTime.startsWith("2")) {
                                if (AfternoonEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonEndTime(LocalTime.parse(AfternoonEndTime,formatterTime));
                        System.out.println("已排班，且不用看诊~~");
                    }

                    //排班看诊
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoonIsUpdate() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoon()){
                        String AfternoonStartTime;
                        while (true){
                            System.out.println("请输入下午排班开始时间(HH:mm:ss)：");
                            AfternoonStartTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonStartTime.startsWith("0") || AfternoonStartTime.startsWith("1")){
                                if (AfternoonStartTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonStartTime.startsWith("2")) {
                                if (AfternoonStartTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonStartTime(LocalTime.parse(AfternoonStartTime,formatterTime));
                        String AfternoonEndTime;
                        while (true){
                            System.out.println("请输入下午排班结束时间(HH:mm:ss)：");
                            AfternoonEndTime = sc.next();
                            // 00:00:00 - 23:59:59
                            if(AfternoonEndTime.startsWith("0") || AfternoonEndTime.startsWith("1")){
                                if (AfternoonEndTime.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                                    break;
                                } else {
                                    System.out.println("您输入时间错误");
                                }
                            } else if (AfternoonEndTime.startsWith("2")) {
                                if (AfternoonEndTime.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                                    break;
                                }else {
                                    System.out.println("您输入时间错误");
                                }
                            }else {
                                System.out.println("您输入的时间有误");
                            }
                        }
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).setAfternoonEndTime(LocalTime.parse(AfternoonEndTime,formatterTime));
                        System.out.println("已排班，且要看诊~~");
                    }
                }
            }
        }
    }

    public int updateTheDate(Doctor doctor){
        int addNewDate = 0;
        int last = doctor.getSchedules().size()-1;//记住该医生对象最后一天的索引
        if(doctor.getSchedules().isEmpty()){//若医生没有旧的坐诊日期，则新建坐诊日期
            for (int i = 0; i < 7; i++) {
                Schedule newSchedule = new Schedule();
                newSchedule.setToday(LocalDate.now().plusDays(i));
                doctor.getSchedules().add(newSchedule);
            }
        } else if (!doctor.getSchedules().isEmpty() && LocalDate.now().isAfter(doctor.getSchedules().get(last).getToday())) {
            for (int i = 6; i >= 0; i--) {
                doctor.getSchedules().remove(doctor.getSchedules().get(i));
            }
            for (int i = 0; i < 7; i++) {
                Schedule newSchedule = new Schedule();
                newSchedule.setToday(LocalDate.now().plusDays(i));
                doctor.getSchedules().add(newSchedule);
            }//如果休假一周  七天都是旧的信息  那么从今天开始增加日期
        } else{
            int remember1 = 0;
            for (int i = 0; i < 7; i++) {
                if (LocalDate.now().equals(doctor.getSchedules().get(i).getToday())){
                    remember1 = i;
                }
            }

            int deleteOldDate = 0;
            int first = 0;
            while (deleteOldDate < remember1){
                doctor.getSchedules().remove(doctor.getSchedules().get(first));
                deleteOldDate++;
            }//删除今天之前的旧日期

            while (addNewDate < remember1){
                Schedule newSchedule = new Schedule();
                newSchedule.setToday(doctor.getSchedules().get(last).getToday().plusDays(addNewDate+1));
                doctor.getSchedules().add(newSchedule);
                addNewDate++;
            }//以最后一天为单位新增日期
        }
        return addNewDate;
    }

    public void searchDoctorInformation(ArrayList<Department> allDepartments){
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        int emptyNumber = 0;
        int remember1 = 0;
        int remember2 = 0;
        for (Department allDepartment : allDepartments) {
            if (allDepartment.getDoctors().isEmpty()) {
                emptyNumber++;
            }
        }
        if (emptyNumber == allDepartments.size()) {
            System.out.println("还没有添加医生,请添加医生");
            return;
        }

        System.out.println("请输入想要设置坐诊医生信息的id：");
        String doctorId = sc.next();
        OUT1:
        for (int i = 0; i < allDepartments.size(); i++) {
            if (allDepartments.get(i).getDoctors().isEmpty() && i == allDepartments.size() - 1) {
                System.out.println("未找到该id");
                return;
            }
            for (int j = 0; j < allDepartments.get(i).getDoctors().size(); j++) {
                if (Objects.equals(doctorId, allDepartments.get(i).getDoctors().get(j).getDoctorId())) {
                    remember1 = i;
                    remember2 = j;
                    break OUT1;
                }
                if (i == allDepartments.size() - 1) {
                    if (j == allDepartments.get(i).getDoctors().size() - 1) {
                        System.out.println("未找到该id");
                        return;
                    }
                }
            }
        }


        String date;
        String startTime;
        String endTime;
        if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().isEmpty()){
            System.out.println("该医生还未排班,请前往排班~~");
        }else {
            System.out.println("================该医生的排班信息如下================");
            for (int i = 0; i < 7; i++) {
                date = formatterDate.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getToday());
                System.out.println(date + "上午的排班:");
                if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorningIsUpdate()){
                    startTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningStartTime());
                    endTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningEndTime());
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorning()){
                        System.out.println("看诊还要上班~~");
                        System.out.println("上班时间为：" + startTime + "至" + endTime);
                        if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningPeople().isEmpty()){
                            System.out.println("已预约0人");
                        }else {
                            System.out.println("已预约" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningPeople().size() + "人");
                        }
                    }else {
                        System.out.println("不看诊但是要上班~~");
                        System.out.println("上班时间为：" + startTime + "至" + endTime);
                    }
                }else {
                    System.out.println("上午休息~~");
                }

                System.out.println(date + "下午的排班:");
                if (allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoonIsUpdate()){
                    startTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonStartTime());
                    endTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonEndTime());
                    if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoon()){
                        System.out.println("看诊还要上班~~");
                        System.out.println("上班时间为：" + startTime + "至" + endTime);
                        if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonPeople().isEmpty()){
                            System.out.println("已预约0人");
                        }else {
                            System.out.println("已预约" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonPeople().size() + "人");
                        }
                    }else {
                        System.out.println("不看诊但是要上班~~");
                        System.out.println("上班时间为：" + startTime + "至" + endTime);
                    }
                }else {
                    System.out.println("下午休息~~");
                }
            }
        }


        int emptyCount = 0;
        for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().size(); i++) {
            if (allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningPeople().isEmpty() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonPeople().isEmpty()){
                emptyCount++;
            }
        }
        if(emptyCount == 7){
            System.out.println("还没有人预约该医生,无法查询");
            return;
        }

        String secureDate;
        int remember3;
        OUT2:
        while (true){
            System.out.println("请输入时间查询当日的患者信息(yyyy-MM-dd)：");
            secureDate = sc.next();
            for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().size(); i++) {
                String dating = formatterDate.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getToday());
                if (Objects.equals(secureDate,dating) && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningPeople().isEmpty() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonPeople().isEmpty()){
                    System.out.println("今天没有人预约哦~~");
                    continue OUT2;
                }
                if(Objects.equals(secureDate,dating)){
                    remember3 = i;
                    break OUT2;
                }
                if (i == allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().size() - 1) {
                    System.out.println("未找到该日期~~");
                    continue OUT2;
                }
            }
        }

        String time;

        while (true) {
            System.out.println("您想要查询上午还是下午呢：");
            time = sc.next();
            if (Objects.equals(time,"上午") && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().isEmpty() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().isEmpty()){
                //上午有人下午没人
                for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().size(); i++) {
                    System.out.println((i + 1) + "." + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getUserName());
                }
                morningFind(allDepartments,remember1,remember2,remember3);
                break;
            } else if (Objects.equals(time,"上午") && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().isEmpty() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().isEmpty()) {
                System.out.println("上午没人预约哦~~");
                //上午没人下午有人
            } else if (Objects.equals(time,"上午") && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().isEmpty() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().isEmpty()) {
                //上午下午都有人
                for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().size(); i++) {
                    System.out.println((i + 1) + "." + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getUserName());
                }
                morningFind(allDepartments,remember1,remember2,remember3);
                break;
            }

            if (Objects.equals(time,"下午") && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().isEmpty() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().isEmpty()){
                System.out.println("下午没人预约哦~~");
                //上午有人下午没人
            } else if (Objects.equals(time,"下午") && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().isEmpty() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().isEmpty()) {
                //上午没人下午有人
                for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().size(); i++) {
                    System.out.println((i + 1) + "." + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().get(i).getUserName());
                }
                afternoonFind(allDepartments,remember1,remember2,remember3);
                break;
            } else if (Objects.equals(time,"下午") && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().isEmpty() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().isEmpty()) {
                //上午下午都有人
                for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().size(); i++) {
                    System.out.println((i + 1) + "." + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().get(i).getUserName());
                }
                afternoonFind(allDepartments,remember1,remember2,remember3);
                break;
            }

            if (!Objects.equals(time,"上午") && !Objects.equals(time,"下午")){
                System.out.println("您输入有误~");
            }
        }

    }

    public void morningFind(ArrayList<Department> allDepartments,int remember1,int remember2,int remember3){
        Scanner sc = new Scanner(System.in);
        String innerName;
        OUT:
        while (true){
            System.out.println("请输入想要咨询对象的名称：");
            innerName = sc.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time;
            for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().size(); i++) {
                if(Objects.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getUserName(),innerName)){
                    System.out.println("姓名：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getUserName());
                    System.out.println("性别：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getSex());
                    System.out.println("年龄：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getAge());
                    System.out.println("病情：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getDescription());
                    time = formatter.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getAppointmentDateTime());
                    System.out.println("就诊时间：" + time);
                    break OUT;
                }
                if(i == allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().size() - 1){
                    System.out.println("没有哦这个人~");
                    continue OUT;
                }
            }
        }
    }

    public void afternoonFind(ArrayList<Department> allDepartments,int remember1,int remember2,int remember3){
        Scanner sc = new Scanner(System.in);
        String innerName;
        OUT:
        while (true){
            System.out.println("请输入想要咨询对象的名称：");
            innerName = sc.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time;
            for (int i = 0; i < allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().size(); i++) {
                if(Objects.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().get(i).getUserName(),innerName)){
                    System.out.println("姓名：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().get(i).getUserName());
                    System.out.println("性别：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().get(i).getSex());
                    System.out.println("年龄：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().get(i).getAge());
                    System.out.println("病情：" + allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().get(i).getDescription());
                    time = formatter.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().get(i).getAppointmentDateTime());
                    System.out.println("就诊时间：" + time);
                    break OUT;
                }
                if(i == allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().size() - 1){
                    System.out.println("没有哦这个人~");
                    continue OUT;
                }
            }
        }
    }



    public void appoint(ArrayList<Department> allDepartments){
        Scanner sc = new Scanner(System.in);
        int remember1;
        int remember2;
        int remember3 = 0;
        int emptyNumber = 0;
        String id;
        String department;

        for (Department allDepartment : allDepartments) {
            if (allDepartment.getDoctors().isEmpty()) {
                emptyNumber++;
            }
        }
        if (emptyNumber == allDepartments.size()) {
            System.out.println("还没有添加医生,请添加医生");
            return;
        }

        System.out.println("==========科室信息如下==========");
        for (int i = 0; i < allDepartments.size(); i++) {
            System.out.println((i + 1) + "." + allDepartments.get(i).getName());
        }
        System.out.println((allDepartments.size() + 1) + ".退出挂号预约");

        OUT1:
        while (true) {
            System.out.println("请输入科室的名字或退出指令：");
            String departmentName = sc.next();
            if (Objects.equals(departmentName,"退出挂号预约")){
                return;
            }
            for (int i = 0; i < allDepartments.size(); i++) {
                if(Objects.equals(departmentName,allDepartments.get(i).getName())){
                    remember1 = i;
                    break OUT1;
                }
                if(i == allDepartments.size()-1){
                    System.out.println("不存在该科室");
                    continue OUT1;
                }
            }
        }

        if (allDepartments.get(remember1).getDoctors().isEmpty()){
            System.out.println("该科室还没有医生,请录入医生");
            return;
        }else {
            for (int i = 0; i < allDepartments.get(remember1).getDoctors().size(); i++) {
                System.out.println((1+i) + "." + allDepartments.get(remember1).getDoctors().get(i).getName() + "医生：" + allDepartments.get(remember1).getDoctors().get(i).getSpeciality());
            }
            System.out.println(allDepartments.get(remember1).getDoctors().size() + 1 + ".返回上一级");
        }


        OUT2:
        while (true) {
            System.out.println("请输入您要挂号预约的医生或返回上一级:");
            String doctorName = sc.next();
            if (Objects.equals(doctorName,"返回上一级")){
                appoint(allDepartments);
                return;
            }else {
                for (int i = 0; i < allDepartments.get(remember1).getDoctors().size(); i++) {
                    if(Objects.equals(doctorName,allDepartments.get(remember1).getDoctors().get(i).getName()+"医生")){
                        remember2 = i;
                        id = allDepartments.get(remember1).getDoctors().get(i).getDoctorId();
                        department = allDepartments.get(remember1).getName();
                        break OUT2;
                    }
                    if(i == allDepartments.get(remember1).getDoctors().size()-1){
                        System.out.println("未找到该医生");
                        continue OUT2;
                    }
                }
            }
        }

        Appointment appointment = new Appointment();
        System.out.println("请输入患者名字:");
        String appointmentName = sc.next();
        appointment.setUserName(appointmentName);
        System.out.println("请输入患者年龄:");
        int appointmentAge;
        try {
            appointmentAge = sc.nextInt();
        } catch (Exception e) {
            System.out.println("只能输入数字~~");
            return;
        }
        appointment.setAge(appointmentAge);
        while (true) {
            System.out.println("请输入患者性别：");
            String appointmentSex = sc.next();
            if (Objects.equals(appointmentSex ,"男" )|| Objects.equals(appointmentSex ,"女")){
                appointment.setSex(appointmentSex);
                break;
            }else {
                System.out.println("您输入有误");
            }
        }
        System.out.println("请输入患者症状:");
        String appointmentDescription = sc.next();
        appointment.setDescription(appointmentDescription);
        appointment.setDoctorId(id);
        appointment.setDepartmentName(department);


        System.out.println("==========您所预约的医生排班时间如下==========");
        String date;
        String startTime;
        String endTime;
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 7; i++) {
            date = formatterDate.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getToday());
            System.out.println(date + ":");
            if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isMorning()){
                startTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningStartTime());
                endTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getMorningEndTime());
                System.out.println("该医生上午可预约时间为：" + startTime + "至" + endTime);
            }else {
                System.out.println("上午不可预约~~");
            }

            if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).isAfternoon()){
                startTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonStartTime());
                endTime = formatterTime.format(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getAfternoonEndTime());
                System.out.println("该医生下午可预约时间为：" + startTime + "至" + endTime);
            }else {
                System.out.println("下午不可预约~~");
            }
        }


        LocalDate comfirmLocalDate;
        while (true) {
            LocalDate appointmentDating;
            while (true) {
                try {
                    appointmentDating = inputAppointDate();
                    break;
                } catch (Exception e) {
                    System.out.println("您输入有误，请重新输入~~");
                }
            }
            if(appointmentDating.isBefore(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(6).getToday()) && appointmentDating.isAfter(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(0).getToday())){
                comfirmLocalDate = appointmentDating;
                break;
            } else if (appointmentDating.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(0).getToday()) || appointmentDating.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(6).getToday())) {
                comfirmLocalDate = appointmentDating;
                break;
            }else {
                System.out.println("不在该医生的工作日期内");
            }

        }
        for (int i = 0; i < 7; i++) {
            if(comfirmLocalDate.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(i).getToday())){
                remember3 = i;
            }
        }
        if(!allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).isMorning() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).isAfternoon()){
            System.out.println("不在该医生的工作日期内");
            return;
        }





        LocalTime comfirmLocalTime;
        while (true) {
            LocalTime appointmentTiming;
            while (true) {
                try {
                    appointmentTiming = inputAppointTime();
                    break;
                } catch (Exception e) {
                    System.out.println("您输入有误，请重新输入~~");
                }
            }
            if(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).isMorning() && !allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).isAfternoon()){
                if(appointmentTiming.isAfter(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningStartTime()) && appointmentTiming.isBefore(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningEndTime())){
                    comfirmLocalTime = appointmentTiming;
                    appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                    allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().add(appointment);
                    System.out.println("预约成功！！");
                    break;
                } else if (appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningStartTime()) || appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningEndTime())) {
                    comfirmLocalTime = appointmentTiming;
                    appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                    allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().add(appointment);
                    System.out.println("预约成功！！");
                    break;
                } else {
                    System.out.println("不在该医生的工作时间内");
                }
            } else if (!allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).isMorning() && allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).isAfternoon()) {
                if (appointmentTiming.isAfter(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonStartTime()) && appointmentTiming.isBefore(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonEndTime())) {
                        comfirmLocalTime = appointmentTiming;
                        appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                        allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().add(appointment);
                        System.out.println("预约成功！！");
                        break;
                } else if (appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonStartTime()) || appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonEndTime())) {
                    comfirmLocalTime = appointmentTiming;
                    appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                    allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().add(appointment);
                    System.out.println("预约成功！！");
                    break;
                } else {
                    System.out.println("不在该医生的工作时间内");
                }
            } else {
                if(appointmentTiming.isAfter(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningStartTime()) && appointmentTiming.isBefore(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningEndTime())){
                    comfirmLocalTime = appointmentTiming;
                    appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                    allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().add(appointment);
                    System.out.println("预约成功！！");
                    break;
                } else if (appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningStartTime()) || appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningEndTime())) {
                    comfirmLocalTime = appointmentTiming;
                    appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                    allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getMorningPeople().add(appointment);
                    System.out.println("预约成功！！");
                    break;
                } else if (appointmentTiming.isAfter(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonStartTime()) && appointmentTiming.isBefore(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonEndTime())) {
                    comfirmLocalTime = appointmentTiming;
                    appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                    allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().add(appointment);
                    System.out.println("预约成功！！");
                    break;
                } else if (appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonStartTime()) || appointmentTiming.equals(allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonEndTime())) {
                    comfirmLocalTime = appointmentTiming;
                    appointment.setAppointmentDateTime(LocalDateTime.of(comfirmLocalDate, comfirmLocalTime));
                    allDepartments.get(remember1).getDoctors().get(remember2).getSchedules().get(remember3).getAfternoonPeople().add(appointment);
                    System.out.println("预约成功！！");
                    break;
                } else {
                    System.out.println("不在该医生的工作时间内");
                }
            }
        }
    }

    public LocalDate inputAppointDate(){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("请输入想要预约的日期(yyyy-MM-dd):");
        String appointmentDate = sc.next();
        return LocalDate.parse(appointmentDate, formatterDate);
    }

    public LocalTime inputAppointTime(){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("请输入想要预约的时间(HH:mm:ss):");
        String appointmentTime = sc.next();
        return LocalTime.parse(appointmentTime, formatterTime);
    }
}
