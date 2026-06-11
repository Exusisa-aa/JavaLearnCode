package newATM;

import java.io.IOException;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            ATM atm = new ATM();
            atm.start();
        } catch (Exception e) {
            if (ATM.oos != null){
                try {
                    ATM.oos.close();
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }
            if (ATM.ois != null){
                try {
                    ATM.ois.close();
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }
        }
    }
}
