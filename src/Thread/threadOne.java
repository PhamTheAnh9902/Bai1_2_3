package Thread;

import Model.Student;
import Xfile.Xfile;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class threadOne extends Thread{
    static Queue<Student> queue = new LinkedList<>();
    Student student = new Student();
    public threadOne() {
    }
    public threadOne(Student student1){
        student = student1;
    }

    @Override
    public void run() {
        student.add1Student();
        queue.add(student);
        Xfile xfile = new Xfile();
        xfile.writeFile((List<Student>) queue);
//
    }
}
