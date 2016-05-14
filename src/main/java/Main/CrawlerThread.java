package Main;

import java.io.IOException;

public class CrawlerThread implements Runnable  {
    //switch()

    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Thread run!");
                MainFrame.processor.process();
                Thread.sleep(60000);
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

