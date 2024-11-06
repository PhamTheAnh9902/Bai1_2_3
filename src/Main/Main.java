package Main;


import StudentManager.*;
import Model.Student;
import Xfile.Xfile;
import Thread.threadOne;
import Thread.threadTwo;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.menu();
    }

    public  void menu() throws FileNotFoundException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int select;
        do {
            System.out.print("====================\n"
                                +"===1. Bai 1 ===\n"
                                +"===2. Bai 2 ===\n"
                                +"===3. Bai 3 ===\n"
                                +"===0. Exit  ===\n"
                                +"Option : ");
            select = scanner.nextInt();
            System.out.println("=====================");
            switch (select){
                case 1:
                    main.menu1();break;
                case 2:
                    main.menu2();break;
                case 3:
                    main.menu3();break;
                case 0:
                    System.exit(1);break;
                default:
                    System.out.println("Reselect");break;
            }
        }
        while (select > 0);
    }
    public void menu1() throws FileNotFoundException {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();
        int chon;
        do{
            System.out.print("=========================\n"
                                +"MENU\n"
                                +"1.Nhập danh sách học viên\n"
                                +"2.Xuất danh sách học viên\n"
                                +"3.Tìm kiếm học viên theo điểm\n"
                                +"4.Tìm kiếm học viên theo học lực\n"
                                +"5.Tìm kiếm học viên theo mã và cập nhật thông tin học viên\n"
                                +"6.Sắp xếp học viên theo điểm\n"
                                +"7.Xuất 5 học viên có điểm cao nhất\n"
                                +"8.Tính trung bình điểm của lớp\n"
                                +"9.Xuất danh sách học viên có điểm trên điểm trung bình của lớp\n"
                                +"10.Tổng hợp số học viên theo học lực\n"
                                +"0.Thoát chương trình\n"
                                +"Enter option: ");
            chon = sc.nextInt();
            System.out.println("==========================");
            switch (chon){
                case 0:
                      main.menu();break;
                case 1:
                    list.importList();break;
                case 2:
                    list.exportList();break;
                case 3:
                    System.out.println("Danh sách học viên cần tìm :");
                    list.exportList(list.searchMark());break;
                case 4:
                    System.out.println("Danh sách học viên cần tìm :");
                    list.exportList(list.searchClassify());break;
                case 5:
                    list.searchId();break;
                case 6:
                    list.sort();break;
                case 7:
                    list.studentHighestScores();break;
                case 8:
                    System.out.println("Điểm trung bình của lớp : "+list.pointAverage());break;
                case 9:
                    list.pointAverage();
                    list.dsTrenTrungBinh();break;
                case 10:
                    list.total();break;
                default:
                    System.out.println("Mời nhập lại");break;
            }
        }
        while (chon >0 );
    }

    public void menu2() throws FileNotFoundException {
            Main main = new Main();
            Student student = new Student();
            List<Student> studentList = new LinkedList<>();
            Xfile xfile = new Xfile();
            Scanner sc = new Scanner(System.in);
            int chon;
            do{
                System.out.println("==========MENU==========\n"
                                    +"==== 1: Add Student ====\n"
                                    +"==== 2: Show Student ===\n"
                                    +"==== 3: Exit ====\n"
                                    +"==== 0. Menu ====\n");
                System.out.print("Enter option: ");
                chon = sc.nextInt();
                switch (chon){
                    case 1:
                        System.out.println("Choose option 1");
                        System.out.println("Add new Student");
                        student.add1Student();
                        studentList.add(student);
                        xfile.writeFile(studentList);break;
                    case 2:
                        System.out.println("Choose option 2");
                        System.out.println("Show Student");
                        if(studentList == null){
                            System.out.println("there are no students");
                        }
                        else{
                            try {
                                studentList = xfile.readFile();
                                for (int i = 0; i< studentList.size(); i++){
                                    studentList.get(i).Show1Student();
                                }
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Choose option 3");
                        System.out.println("Exit");
                        System.exit(1);break;
                    case 0:
                        main.menu();break;
                    default:
                        System.out.println("reselect !!!");break;
                }
            }
            while (chon > 0);
        }

        public void menu3() throws FileNotFoundException {
            Scanner sc = new Scanner(System.in);
            Main main = new Main();
            Xfile xfile = new Xfile();
            int chon;
            do {
                System.out.println("==========MENU==========\n"
                        +"==== 1: Add Student ====\n"
                        +"==== 2: Show Student ===\n"
                        +"==== 3: Exit ====\n"
                        +"==== 0. Menu ====\n");
                System.out.print("Enter option: ");
                chon = sc.nextInt();
                sc.nextLine();
                switch (chon){
                    case 0:
                        main.menu();break;
                    case 1:
                        threadOne threadOne = new threadOne();
                        threadTwo runnable = new threadTwo();
                        System.out.println("Choose option 1");
                        System.out.println("Add new Student");
                        threadOne.start();
                        try {
                            threadOne.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Thread threadTwo = new Thread(runnable);
                        threadTwo.start();
                        try {
                            threadTwo.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        System.out.println("Choose option 2");
                        System.out.println("Show student");
                        for (int i = 0 ; i < xfile.readFile().size(); i++){
                            xfile.readFile().get(i).Show1Student();
                        }
                        break;
                    case 3:
                        System.out.println("Choose option 3");
                        System.out.println("Exit");
                        System.exit(1);break;
                    default:
                        System.out.println("reselect !!!");break;
                }
            }
            while (chon >0);
        }
    }
