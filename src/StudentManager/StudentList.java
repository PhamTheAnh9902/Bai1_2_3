package StudentManager;

import Constants.Constant;
import Model.Student;

import java.util.*;

public class StudentList   {
    private final  List<Student> list = new ArrayList<>();
    private static  final Scanner sc = new Scanner(System.in);

    public StudentList() {
    }


    public String classify(Student student){
        if (student.getMark() < 5) return Constant.POOR;
        else if (student.getMark() >=5 && student.getMark() < 6.5) {
            return Constant.AVERAGE;
        } else if (student.getMark() >=6.5 && student.getMark() < 7.5) {
            return Constant.FAIRLY_GOOD;
        } else if (student.getMark() >= 7.5 && student.getMark() < 9) {
            return Constant.GOOD;
        }else if (student.getMark() >= 9 && student.getMark() <= 10){
            return Constant.EXCELENT;
        }
        else return "Điểm không hợp lệ";
    }

    //Them ds hoc vien
    public void importList(){
        int n;
        System.out.println("Nhập số lượng học viên: ");
        n = sc.nextInt();
        for (int i = 0; i<n;i++){
            Student student = new Student();
            System.out.println("Sinh viên thứ "+(i+1)+" :");
            student.nhap1hv();
            student.setCode((i+1));
            list.add(student);
        }
    }
    // Xuat ds hoc vien
    public void exportList(){
        System.out.printf("%-12s%-12s%-15s%-15s\n","Name","Mark","Email","Academic");
        for (Student student : list) {
            student.xuat1hv();
            System.out.println("\t" + classify(student));
        }
    }
    public void exportList(List<Student> studentList){
        for (Student student : studentList) {
            student.xuat1hv();
            System.out.println("\t" + classify(student));
        }
    }

    // tim kiem theo khoang diem
    public List<Student> searchMark(){
        double minmark, maxmark;
            while (true){
                try{
                    System.out.println("Nhập khoảng điểm muốn tìm kiếm học viên");
                    System.out.print("NHập Khoảng điểm đầu : ");
                    minmark = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập khoảng điểm cuối: ");
                    maxmark = Double.parseDouble(sc.nextLine());
                    if(minmark < Constant.MIN_MARK || minmark > Constant.MAX_MARK
                            || maxmark < Constant.MIN_MARK || maxmark > Constant.MAX_MARK ){
                        System.err.println("Nhập điểm trong khoảng từ 0 đến 10");
                        continue;
                    }
                    break;
                }
                catch (Exception e){
                    System.err.println("Không được nhập kí tự");
                }
            }
        if (minmark > maxmark){
            double tg = minmark;
            minmark = maxmark;
            maxmark = tg;
        }
        List<Student> listfindmark = new LinkedList<>();
        for(Student student : list){
            if ( student.getMark() >= minmark && student.getMark() <= maxmark){
                listfindmark.add(student);
            }
        }
        if(listfindmark.isEmpty()){
            System.out.println("Không có học viên nào có điểm trong khoảng từ "+minmark+" đến "+maxmark);
        }
        return listfindmark;
    }
    // tim kiem theo hoc luc
    public List<Student> searchClassify(){
        Scanner input = new Scanner(System.in);
        ArrayList<Student> dshocluc = new ArrayList<>();
        System.out.println("Nhập loại học lực cần tìm: ");
         String classify = input.nextLine();
        for (Student student : list) {
            if (classify(student).equalsIgnoreCase(classify)) {
                dshocluc.add(student);
            }
        }
        if(dshocluc.isEmpty()){
            System.out.println("Không có học viên nào có học lực "+classify);
        }
        return dshocluc;
    }

    // Sua thong tin theo id
    public void searchId(){
        System.out.println("Nhập mã số học viên muốn cập nhật thông tin: ");
        int id  = sc.nextInt();
        sc.nextLine();
        List<Student> students = new LinkedList<>();
        for (int i = 0; i< list.size(); i++){
            if(list.get(i).getCode() == id){
                students.add(list.get(i));
                System.out.println("Nhập họ và tên mới :");
                String name = sc.nextLine();
                System.out.println("Nhập email mới: ");
                String email = sc.nextLine();
                System.out.println("Nhập điểm mới");
                double mark = sc.nextDouble();
                for (Student student : list) {
                    if (student.getCode() == id) {
                        student.setName(name);
                        student.setEmail(email);
                        student.setMark(mark);
                        break;
                    }
                }
            }

        }
        if(students.isEmpty()){
            System.out.println("Không tìm thấy học viên");
        }
    }
    // sap xep
    public void sort(){
        Collections.sort(list);
        System.out.println("Danh sách học viên sau khi sắp xếp:");
        for (Student student : list) {
            student.xuat1hv();
            System.out.println("\t" + classify(student));
        }
    }

    // 5 hoc vien co diem cao nhat
    public void studentHighestScores(){
        Collections.sort(list);
        if(list.size() < 5){
            for (Student student : list) {
                student.xuat1hv();
                System.out.println("\t" + classify(student));
            }
        }
        else {
            for(int i = 0; i< 5; i++){
                list.get(i).xuat1hv();
                System.out.println("\t"+classify(list.get(i)));
            }
        }
    }

    // diem trung binh
    public double pointAverage(){
        double tong = 0;
        for (Student student : list) {
            tong += student.getMark();
        }
        return tong/list.size();
    }

    // ds hoc vien tren diem trung binh
    public void dsTrenTrungBinh(){
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (student.getMark() > pointAverage()) {
                students.add(student);
            }
        }
        for (Student student : students) {
            student.xuat1hv();
            System.out.println("\t" + classify(student));
        }
    }

    // tong hoc vien theo hoc luc
    public  void total(){
        int yeu = 0;
        int trungbinh = 0;
        int kha = 0;
        int gioi = 0;
        int xuatxac = 0;
        for (Student student : list) {
            if (classify(student).equalsIgnoreCase(Constant.POOR)) {
                yeu += 1;
            } else if (classify(student).equalsIgnoreCase(Constant.AVERAGE)) {
                trungbinh += 1;
            } else if (classify(student).equalsIgnoreCase(Constant.FAIRLY_GOOD)) {
                kha += 1;
            } else if (classify(student).equalsIgnoreCase(Constant.GOOD)) {
                gioi += 1;
            } else if (classify(student).equalsIgnoreCase(Constant.EXCELENT)) {
                xuatxac += 1;
            }
        }
        System.out.printf("%-6s%-12s%-6s%-6s%-6s\n","Yếu","trung bình","khá","giỏi","xuất xắc");
        System.out.printf("%-6d%-12d%-6d%-6d%-6d\n",yeu,trungbinh,kha,gioi,xuatxac);

    }


}
