package newATM;


import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class TranslateToRegisterLog {
    public static void registerLog() {
        if (new File("day09-ATMProject\\src\\newATM\\Logs\\accounts.txt").length() != 0) {
            try (
                    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("day09-ATMProject\\src\\newATM\\Logs\\accounts.txt")));
                    BufferedWriter bos = new BufferedWriter(new FileWriter("day09-ATMProject\\src\\newATM\\Logs\\RegisterLog.xml",false))
            ){
                ArrayList<Account> accounts = (ArrayList<Account>) ois.readObject();
                bos.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
                bos.newLine();
                bos.write("<accounts>");
                bos.newLine();
                for (int i = 0 ; i < accounts.size() ; i++) {
                    bos.write("\t<account id=" + "\"" + (i+1) + "\"" + ">");
                    bos.newLine();
                    bos.write("\t\t<userName>" + accounts.get(i).getUserName() + "</userName>");
                    bos.newLine();
                    bos.write("\t\t<sex>" + accounts.get(i).getSex() + "</sex>");
                    bos.newLine();
                    bos.write("\t\t<cardId>" + accounts.get(i).getCardId() + "</cardId>");
                    bos.newLine();
                    bos.write("\t\t<password>" + accounts.get(i).getPassword() + "</password>");
                    bos.newLine();
                    bos.write("\t\t<Time>" + accounts.get(i).getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</Time>");
                    bos.newLine();
                    bos.write("\t\t<Money>" + accounts.get(i).getMoney() + "</Money>");
                    bos.newLine();
                    bos.write("\t\t<QuotaMoney>" + accounts.get(i).getQuotaMoney() + "</QuotaMoney>");
                    bos.newLine();
                    bos.write("\t</account>");
                    bos.newLine();
                }
                bos.write("</accounts>");
            }catch (Exception e){
                e.getStackTrace();
            }
        }
    }
}
