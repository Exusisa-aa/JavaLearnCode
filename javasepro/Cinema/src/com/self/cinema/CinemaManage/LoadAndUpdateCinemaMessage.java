package com.self.cinema.CinemaManage;

import com.self.cinema.CinemaManage.Devices.Device;
import com.self.cinema.CinemaManage.Hall.Hall;
import com.self.cinema.CinemaManage.ScreenDays.ScreenDay;
import com.self.cinema.CinemaManage.ScreenDays.ScreenTimes.ScreenTime;
import com.self.cinema.CustomerManage.CinemaCustomerManagement;
import com.self.cinema.CustomerManage.Customer.Customer;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.FilePath;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.LockForThread;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class LoadAndUpdateCinemaMessage {
    //由于要多次读  为了避免覆盖上次的数据  只允许赋值给Document和SAXReader一次 ！！！！！
    private static Document cachedDocument = null;
    public static void LoadCinemaMessageMethod(){

        try {
            LockForThread.INSTANCE.getLock().lock();
            //Hall
            String hallName;
            int totalSeats;


            //Device
            String screenName = null;
            String projectorName = null;
            String seatName = null;
            String airConditionName = null;
            String lightsName = null;
            boolean isFixed = false;
            String mark = null;

            //ScreenDay
            LocalDate dateInfo;

            //ScreenTime
            LocalTime startTime = null;
            LocalTime endTime = null;
            String movieName = null;
            String movieType = null;
            String dimension = null;
            String director = null;
            String actors = null;
            String language = null;
            int lastTime = 0;
            double price = 0;
            double rate = 0.0;

            //seats
            LinkedHashMap<Integer, Customer> seats = null;

            try {

                CinemaManagerManagement.cinema.clear();


                //一定要判断是否为空，防止重复创建，导致上次的数据丢失
                //获取reader和document
                if (cachedDocument == null) {
                    //获取reader和document
                    SAXReader reader = new SAXReader();
                    cachedDocument = reader.read(LoadAndUpdateCinemaMessage.class.getResourceAsStream("Logs\\Cinema.xml"));
                }


                //获取根节点halls
                Element element = cachedDocument.getRootElement();
                //获取一级节点hall
                List<Element> elementsForHall = element.elements();
                for (Element element1 : elementsForHall) {

                    //创建Hall对象，赋值厅名字与总座位数
                    totalSeats = Integer.parseInt(element1.element("totalSeats").getText());
                    hallName = element1.attributeValue("hallName");
                    Hall hall = new Hall(hallName,totalSeats);
                    //获取devices节点
                    Element elementsForDevice = element1.element("devices");
                    //获取devices节点下的元素
                    List<Element> elementsForDeviceMessage = elementsForDevice.elements();
                    //device对象的初始化
                    for (Element ele : elementsForDeviceMessage) {
                        if(ele.getName().equals("screenName")){
                            screenName = ele.getText();
                        } else if (ele.getName().equals("projectorName")){
                            projectorName = ele.getText();
                        } else if (ele.getName().equals("seatName")) {
                            seatName = ele.getText();
                        } else if (ele.getName().equals("airConditionName")) {
                            airConditionName = ele.getText();
                        } else if (ele.getName().equals("lightsName")) {
                            lightsName = ele.getText();
                        } else if (ele.getName().equals("isFixed")) {
                            if(ele.getText().equals("false")){
                                isFixed = false;
                            }else if (ele.getText().equals("true")){
                                isFixed = true;
                            }
                        } else if (ele.getName().equals("mark")) {
                            mark = ele.getText();
                        }
                    }
                    Device device = new Device(screenName, projectorName, seatName, airConditionName, lightsName, isFixed, mark);
                    //为hall对象的集合赋值
                    hall.setDevice(device);

                    //获取所有screenDay
                    List<Element> elementsForDays = element1.elements("screenDays");
                    for (Element elementsForDay : elementsForDays) {
                        dateInfo = LocalDate.parse(elementsForDay.attributeValue("dateInfo"));
                        //创建screenDay对象，赋值日期
                        ScreenDay screenDay = new ScreenDay(dateInfo);
                        //获取所有screenTime
                        List<Element> elementsForTimes = elementsForDay.elements();
                        for (Element elementsForTime : elementsForTimes) {
                            ////获取所有screenTime下的所有一级子元素
                            List<Element> elementsForTimeMessages = elementsForTime.elements();
                            for (Element elementsForTimeMessage : elementsForTimeMessages) {
                                if(elementsForTimeMessage.getName().equals("startTime")){
                                    startTime = LocalTime.parse(elementsForTimeMessage.getText());
                                } else if (elementsForTimeMessage.getName().equals("endTime")) {
                                    endTime = LocalTime.parse(elementsForTimeMessage.getText());
                                } else if (elementsForTimeMessage.getName().equals("movieName")) {
                                    movieName = elementsForTimeMessage.getText();
                                } else if (elementsForTimeMessage.getName().equals("movieType")) {
                                    movieType = elementsForTimeMessage.getText();
                                } else if (elementsForTimeMessage.getName().equals("dimension")) {
                                    dimension = elementsForTimeMessage.getText();
                                } else if (elementsForTimeMessage.getName().equals("director")) {
                                    director = elementsForTimeMessage.getText();
                                } else if (elementsForTimeMessage.getName().equals("actors")) {
                                    actors = elementsForTimeMessage.getText();
                                } else if (elementsForTimeMessage.getName().equals("language")) {
                                    language = elementsForTimeMessage.getText();
                                } else if (elementsForTimeMessage.getName().equals("lastTime")) {
                                    lastTime = Integer.parseInt(elementsForTimeMessage.getText());
                                } else if (elementsForTimeMessage.getName().equals("price")) {
                                    price = Double.parseDouble(elementsForTimeMessage.getText());
                                } else if (elementsForTimeMessage.getName().equals("rate")) {
                                    rate = Double.parseDouble(elementsForTimeMessage.getText());
                                } else if (elementsForTimeMessage.getName().equals("seats")) {
                                    Element elementForSeats = elementsForTime.element("seats");
                                    seats = new LinkedHashMap<>();
                                    List<Element> elementForSeatMessages = elementForSeats.elements();
                                    for (int i = 0; i < elementForSeatMessages.size(); i++) {
                                        if(Objects.equals(elementForSeatMessages.get(i).getText(),"null")){
                                            seats.put(i, null);
                                        }else {
                                            for (Customer customer : CinemaCustomerManagement.customers) {
                                                if(Objects.equals(customer.getUUID(),elementForSeatMessages.get(i).getText())){
                                                    seats.put(i, customer);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            //创建ScreenTime对象，赋值信息
                            ScreenTime screenTime = new ScreenTime(startTime, endTime, movieName, movieType, dimension, director, actors, language, lastTime, price, rate);
                            screenTime.getSeats().putAll(seats);
                            screenDay.getScreenTimes().add(screenTime);
                        }
                        //把每六天装进一个hall里
                        hall.getScreenDays().add(screenDay);
                    }


                    //把装好的hall对象装进cinema集合中
                    CinemaManagerManagement.cinema.add(hall);



                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }






    public static void updateDeviceInfo(boolean fixed,String mark,int hallIndex){//只有单线程调用不需要上锁
        try{
            //一定要判断是否为空，防止重复创建，导致上次的数据丢失
            if (cachedDocument == null) {
                //获取reader和document
                SAXReader reader = new SAXReader();
                cachedDocument = reader.read(LoadAndUpdateCinemaMessage.class.getResourceAsStream("Logs\\Cinema.xml"));
            }
            //获取根节点halls
            Element element = cachedDocument.getRootElement();
            //获取一级节点hall
            List<Element> elementsForHall = element.elements();
            elementsForHall.get(hallIndex - 1).element("devices").elements().get(5).setText(String.valueOf(fixed));
            elementsForHall.get(hallIndex - 1).element("devices").elements().get(6).setText(mark);



            //将数据写进xml
            XMLWriter writer = new XMLWriter(new FileWriter(FilePath.CINEMA_PATH_TO_XML.getPath()));
            writer.write(cachedDocument);
            writer.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public static void updateSeatInfo(String place,LocalDate date,LocalTime time,int seatIndex,Customer customer,boolean isCancel){
        try {
            LockForThread.INSTANCE.getLock().lock();
            try{
                //一定要判断是否为空，防止重复创建，导致上次的数据丢失
                if (cachedDocument == null) {
                    //获取reader和document
                    SAXReader reader = new SAXReader();
                    cachedDocument = reader.read(LoadAndUpdateCinemaMessage.class.getResourceAsStream("Logs\\Cinema.xml"));
                }


                //获取根节点halls
                Element element = cachedDocument.getRootElement();
                //获取一级节点hall
                List<Element> elementsForHall = element.elements();
                OUT:
                for (Element elementForHall : elementsForHall) {
                    if(Objects.equals(elementForHall.attributeValue("hallName"),place)){
                        //获取二级节点screenDays
                        List<Element> elementsForDays = elementForHall.elements("screenDays");
                        for (Element elementsForDay : elementsForDays) {
                            if(Objects.equals(elementsForDay.attributeValue("dateInfo"),date.toString())){
                                //获取三级节点screenTimes
                                List<Element> elementsForTimes = elementsForDay.elements();
                                for (Element elementsForTime : elementsForTimes) {
                                    if(Objects.equals(elementsForTime.element("startTime").getText(),time.toString() + ":00")){
                                        if(!isCancel){
                                            elementsForTime.element("seats").elements().get(seatIndex - 1).setText(customer.getUUID());
                                            break OUT;
                                        }else {
                                            elementsForTime.element("seats").elements().get(seatIndex - 1).setText("null");
                                            break OUT;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }



                //将数据写进xml
                XMLWriter writer = new XMLWriter(new FileWriter(FilePath.CINEMA_PATH_TO_XML.getPath()));
                writer.write(cachedDocument);
                writer.close();
            }catch (Exception e){
                e.getStackTrace();
            }
        } finally {
            LockForThread.INSTANCE.getLock().unlock();
        }
    }

}
