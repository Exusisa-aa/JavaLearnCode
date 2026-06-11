package com.self.test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Random;

public class GenerateDateForMySQl {
    public static Integer count = 0;
    private static final Random random = new Random();
    private static final String[] SURNAMES = {"王","李","张","刘","陈","杨","赵","黄","周","吴"};
    private static final String[] NAMES = {"伟","芳","娜","强","磊","敏","静","杰","丽","涛"};
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // 字段生成逻辑

    private static String serialID(){
        count++;
        return count.toString();
    }
    private static String randomUsername() {
        return "user_" + randomString(8) + random.nextInt(10000);
    }

    private static String randomPassword() {
        return "pw_" + randomString(12);
    }

    private static String randomName() {
        return SURNAMES[random.nextInt(SURNAMES.length)] + NAMES[random.nextInt(NAMES.length)];
    }

    private static String randomBirthday() {
        int year = 1970 + random.nextInt(36); // 1970-2005
        int dayOfYear = random.nextInt(365) + 1;
        return LocalDate.ofYearDay(year, dayOfYear).toString();
    }

    private static String randomSex() {
        return random.nextBoolean() ? "M" : "F";
    }

    private static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    // 主生成方法
    public static void main(String[] args) throws Exception {
        final int total = 16000000;
        final int batchSize = 10_000; // 每批次写入量‌:ml-citation{ref="1,4" data="citationList"}

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("HomeWorks\\src\\src\\com\\self\\data.sql"))) {
            for (int i = 1; i <= total; i++) {
                // 生成单条记录
                String record = String.join(",",
                        serialID(),
                        randomUsername(),
                        randomPassword(),
                        randomName(),
                        randomBirthday(),
                        randomSex()
                );

                writer.write(record);
                writer.newLine();

                // 分批刷新缓冲区‌:ml-citation{ref="1,4" data="citationList"}
                if (i % batchSize == 0) {
                    writer.flush();
                    System.out.printf("已生成 %d 条数据 (%.1f%%)%n", i, (i * 100.0 / total));
                }
            }
            writer.flush();
        }
        System.out.println("数据生成完成");
    }

}
