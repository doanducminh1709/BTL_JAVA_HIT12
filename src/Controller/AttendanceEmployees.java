package Controller;
import Model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceEmployees {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();
    static Employee employee;

    public void ListEmployee(){
        if(employeeList.size() > 0) return;
        employeeList.add(new Employee("Nguyễn Quang Tuấn" , "23" , "Bắc Ninh" , "0987563412" , "MDT012" , "Account"));
        employeeList.add(new Employee("Trần Lâm Minh" , "24" , "Thanh Hóa" , "0984212409" , "MDT013" , "Employee"));
        employeeList.add(new Employee("Đỗ Quốc Trọng" , "25" , "Quảng Ngãi" , "0987543412" , "MDT014" , "Employee"));
        employeeList.add(new Employee("Trịnh Quốc Đạt" , "24" , "Ninh Bình" , "0247563412" , "MDT015" , "Clear"));
        employeeList.add(new Employee("Lê Tú Huy" , "22" , "Hà Nội" , "0987363412" , "MDT016" , "Employee"));
        employeeList.add(new Employee("Trần Thành Đạt" , "26" , "Bắc Giang" , "0947565312" , "MDT017" , "Manager"));
        employeeList.add(new Employee("Đoàn Quang Thành" , "28" , "Nghệ An" , "0327565412" , "MDT018" , "Employee"));

    }
    public void attendanceForEmployees(){
        ListEmployee();
        String id; int cnt=0;
        System.out.print(" Enter your ID : ");
        id = scanner.nextLine();
        for(int i = 0 ; i < employeeList.size() ; i++){
            if(id.compareTo(employeeList.get(i).getIdEmployee()) == 0){
                System.out.println("===> ATTENDANCE SUCCESSFULLY.");
                break;
            }else cnt++;
        }
        if(cnt == employeeList.size()){
            System.out.println(" ID DOSE NOT EXIT ! PLEASE , CHECK AGAIN !");
        }
    }

    public void ShowListEmployee(){
        ListEmployee();
        System.out.printf("%-20s %-10s %-20s %-20s %-15s %-20s\n", "NAME" , "AGE" , "ADDRESS" , "PHONE" , "ID" , "JOB");
        for (Employee employee : employeeList){
            System.out.printf("%-20s %-10s %-20s %-20s %-15s %-20s\n" , employee.getName(),employee.getAge(),
                    employee.getAddress() , employee.getPhoneNb() , employee.getIdEmployee() , employee.getJob());
        }
    }
}
