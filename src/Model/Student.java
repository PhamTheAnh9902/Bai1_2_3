package Model;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable, Comparable<Student> {
    private String name,className,username,password;
    private double mark;
    private String email,address;
    private int code,age;

    public Student() {
    }
    public Student(String name, String className, double mark, String email, String address, int code, int age) {
        this.name = name;
        this.className = className;
        this.mark = mark;
        this.email = email;
        this.address = address;
        this.code = code;
        this.age = age;
    }
    public Student(String name, String email, double mark) {
        this.name = name;
        this.mark = mark;
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void nhap1hv(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ và tên: ");
        name = sc.nextLine();
        System.out.println("Nhập email: ");
        email = sc.nextLine();
        System.out.println("Nhập điểm: ");
        mark = sc.nextDouble();
    }
    public void xuat1hv(){
        System.out.printf("%-12s%-12f%-15s",name,mark,email);
    }

    @Override
    public int compareTo(Student o) {
        if(this.mark > o.mark) {
            return -1;
        } else if (this.mark < o.mark) {
            return 1;
        }else return 0;
    }

    public void add1Student(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.nextLine();
        System.out.print("Enter age: ");
        age = input.nextInt();
        System.out.print("Enter code: ");
        code = input.nextInt();
        input.nextLine();
        System.out.print("Enter classname: ");
        className = input.nextLine();
        System.out.print("Enter address: ");
        address = input.nextLine();
        System.out.print("Enter mark: ");
        mark = input.nextInt();
    }
    public void Show1Student(){
        System.out.printf("%-6s%-6s%-6s%-12s%-12s%-6s\n","Name","Age","Code","ClassName","Address","Mark");
        System.out.printf("%-6s%-6d%-6d%-12s%-12s%-6f\n",name,age,code,className,address,mark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", mark=" + mark +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", code=" + code +
                ", age=" + age +
                '}';
    }
}
