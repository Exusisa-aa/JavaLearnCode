package com.self.more_API.SimpleDateFormatExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager{
    People xj = new People("小贾","2023年11月11日 00:01:18");
    People xp = new People("小皮","2023年11月11日 00:10:51");
    String start = "2023年11月11日 00:00:00";
    String end = "2023年11月11日 00:10:00";

    public void start() throws ParseException {
        Activity a = new Activity() {
            @Override
            public void participate(People p) throws ParseException {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                Date date = format.parse(p.getTime());
                if(date.getTime() > format.parse(start).getTime() && date.getTime() < format.parse(end).getTime()){
                    System.out.println("参与成功");
                }else {
                    System.out.println("参与失败");
                }
            }
        };
        a.participate(xp);
    }
}
