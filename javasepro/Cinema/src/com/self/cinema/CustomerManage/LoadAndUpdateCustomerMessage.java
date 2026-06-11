package com.self.cinema.CustomerManage;

import com.self.cinema.CustomerManage.Customer.Customer;
import com.self.cinema.CustomerManage.Records.Record;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.FilePath;
import com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath.LockForThread;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadAndUpdateCustomerMessage {
    //由于要多次读  为了避免覆盖上次的数据  只允许赋值给Document和SAXReader一次 ！！！！！
    private static Document cachedDocument = null;

    public static void LoadCustomersMessageMethod() {
        try {
            LockForThread.INSTANCE.getLock().lock();
            //解析时间
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            //分离非数字与数字
            Pattern pattern = Pattern.compile("\\d+");
            var ref = new Object() {
                int index;
            };


            File file = new File(FilePath.CUSTOMER_PATH_TO_XML.getPath());

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
            //获得根节点customers
            Element rootElement = cachedDocument.getRootElement();
            //遍历customers
            if (!CinemaCustomerManagement.customers.isEmpty()) {
                for (Customer customer : CinemaCustomerManagement.customers) {
                    //customer
                    Element elementForCustomer = rootElement.addElement("customer");
                    elementForCustomer.addAttribute("UUID", customer.getUUID());
                    elementForCustomer.addElement("name").setText(customer.getName());
                    elementForCustomer.addElement("gender").setText(customer.getGender());
                    elementForCustomer.addElement("phone").setText(customer.getPhone());
                    elementForCustomer.addElement("userName").setText(customer.getUserName());
                    elementForCustomer.addElement("password").setText(customer.getPassword());
                    elementForCustomer.addElement("money").setText(String.valueOf(customer.getMoney()));
                    elementForCustomer.addElement("ip").setText(String.valueOf(customer.getIp()));
                    //comment
                    Element elementForComments= elementForCustomer.addElement("comments");
                    if(!customer.getComment().isEmpty()){
                        customer.getComment().forEach((k,v)->{
                            Element elementForComment = elementForComments.addElement("comment");
                            Matcher matcher = pattern.matcher(k);
                            if(matcher.find()){
                                ref.index = matcher.start();
                            }
                            elementForComment.addElement("movieName").setText(k.substring(0,ref.index));
                            elementForComment.addElement("content").setText(v.getContent());
                            elementForComment.addElement("time").setText(formatter.format(v.getTime()));
                        });
                    }
                    //friends
                    if(!customer.getFriends().isEmpty()){
                        Element elementForFriends = elementForCustomer.addElement("friends");
                        for (String friend : customer.getFriends()) {
                            elementForFriends.addElement("friend").setText("UUID" + friend);
                        }
                    }
                    //records
                    if(!customer.getRecords().isEmpty()){
                        Element elementForRecords = elementForCustomer.addElement("records");
                        for (Record record : customer.getRecords()) {
                            Element elementForRecord = elementForRecords.addElement("record");
                            elementForRecord.addElement("date").setText(record.getDate().toString());
                            elementForRecord.addElement("startTime").setText(record.getStartTime().toString());
                            elementForRecord.addElement("endTime").setText(record.getEndTime().toString());
                            elementForRecord.addElement("place").setText(record.getPlace());
                            elementForRecord.addElement("movieName").setText(record.getMovieName());
                            elementForRecord.addElement("movieType").setText(record.getMovieType());
                            elementForRecord.addElement("dimension").setText(record.getDimension());
                            elementForRecord.addElement("director").setText(record.getDirector());
                            elementForRecord.addElement("actors").setText(record.getActors());
                            elementForRecord.addElement("rate").setText(String.valueOf(record.getRate()));
                            elementForRecord.addElement("language").setText(record.getLanguage());
                            elementForRecord.addElement("lastTime").setText(String.valueOf(record.getLastTime()));
                            elementForRecord.addElement("price").setText(String.valueOf(record.getPrice()));
                            elementForRecord.addElement("others").setText(record.getOthers());
                            elementForRecord.addElement("seatNumber").setText(String.valueOf(record.getSeatNumber()));
                            elementForRecord.addElement("isCancel").setText(String.valueOf(record.isCancel()));
                        }
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
