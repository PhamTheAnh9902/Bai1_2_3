package Thread;

import Xfile.Xfile;

import java.io.FileNotFoundException;

public class threadTwo implements Runnable{
    Xfile xfile = new Xfile();
    @Override
    public void run() {

        try {
            System.out.println("Số lượng sinh viên : "+xfile.readFile().size());
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
