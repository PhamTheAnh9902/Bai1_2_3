package Xfile;

import Constants.Constant;
import Model.Student;

import java.io.*;
import java.util.List;

public class Xfile {

    public  synchronized void writeFile(List<Student> studentList){
        try {
            OutputStream os = new FileOutputStream(Constant.PATH);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(studentList);
            oos.flush();
            oos.close();
            os.close();
            System.out.println("Xong");
        }
        catch (Exception e){
            System.err.println("Thất bại");
        }
    }

    public synchronized List<Student> readFile() throws FileNotFoundException {
        List<Student>  list = null;
        try {
            InputStream is = new FileInputStream(Constant.PATH);
            ObjectInputStream ois = new ObjectInputStream(is);
            list = (List<Student>) ois.readObject();
            ois.close();
            is.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return list;

    }
}
