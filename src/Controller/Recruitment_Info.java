package Controller;

import Model.EmployeeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recruitment_Info {

    static Scanner sc = new Scanner(System.in);
    static List<EmployeeInfo> employees = new ArrayList<>();
    static AccountManagement acc = new AccountManagement();
    static EmployeeInfo employee;
    static ListJob listJob = new ListJob();
    static FileDataManagement fileData = new FileDataManagement();

    final static int max = 999990;
    final static int min = 111111;
public void ListEmployeeRecruit(){
    if(employees.size() > 0) return;
    employees.add(new EmployeeInfo("Trịnh Văn Lộc" , "24" , "Thanh Hóa" , "0897645312" , 765893 , "Manager" , "Cử nhân đại học"));
    employees.add(new EmployeeInfo("Lê Huy Đạt" , "25" , "Hà Nội" , "0975545312" , 965893 , "Accountant" , "Cử nhân đại học"));
    employees.add(new EmployeeInfo("Trần Quang Mạnh" , "27" , "Hải Phòng" , "0897645312" , 260931 , "Guard" , "Tốt nghiệp cấp 3"));
    employees.add(new EmployeeInfo("Lê Huy Toàn" , "22" , "Ninh Bình" ,  "0877649812" , 897539 , "Employee" , "Tốt nghiệp cao đẳng"));
    employees.add(new EmployeeInfo("Nguyễn Gia Bảo" , "28" , "Nghê An" , "0768943124" , 983422 , "Cleaner" , "Tốt nghiệp cấp 3"));

}
    public void EnterYourInfo(){
        employee = new EmployeeInfo();
        System.out.println("\n\t\t\tCOMPLETE YOUR INFORMATION ON THE VOLUME\n");
        System.out.print("Enter name : ");
        employee.setName(sc.nextLine());
        System.out.print("Enter age : ");
        employee.setAge(sc.nextLine());
        System.out.print("Enter address : ");
        employee.setAddress(sc.nextLine());
        System.out.print("Enter phone : ");
        employee.setPhoneNb(sc.nextLine());
        int random_int = (int)(Math.random()*(max - min + 1) + min);
        employee.setIdCore(random_int);
        System.out.print("Enter your education level : ");
        employee.setLevel(sc.nextLine());
        listJob.ShowDataJob();
        String id_Job;
        do{
            System.out.print("\nEnter ID_Job you to do : ");
            id_Job = sc.nextLine();
            if(!listJob.checkIdJob(id_Job)){
                System.out.println(" Id Core dose not exits , re-enter");
            }else break;
        }while(!listJob.checkIdJob(id_Job));

        employee.setWantTodo(listJob.ReturnJob(id_Job));
        employees.add(employee);
        System.out.println("\n========< THANKS FOR FILLING OUT THE INFORMATION . HAVE A NICE DAY >========\n");
    }
//    public void TitleList(){
//        System.out.printf("%-20s %-10s %-20s %-20s %-15s %-20s %-20s\n"
//                ,"NAME", "AGE" , "ADDRESS" , "PHONE" , "ID CORE"
//                ,"EDUCATION LEVEL" , "WANT TO DO");
//    }
    public void ListEmployeeRecruitment(){
        ListEmployeeRecruit();
        if(employees.isEmpty()){
            System.out.println("\n There are not applications yet !\n");
            return;
        }
        employees.forEach(i -> {
            System.out.printf("%-20s %-10s %-20s %-20s %-15d %-20s %-20s\n"
                    ,i.getName() , i.getAge() , i.getAddress() , i.getPhoneNb() , i.getIdCore()
                    ,i.getLevel() , i.getWantTodo());
        });
    }
    public boolean CheckIdCore(int id){
        for (int i = 0 ; i < employees.size() ; i++){
            if(id == employees.get(i).getIdCore()){
                return true;
            }
        }
        return false;
    }
    public void titel_ListJob(){
        String file= "Employee.txt";
        fileData.OpenFileToWrite(file);
        fileData.getPrintWriter().printf("%-20s %-10s %-20s %-20s %-15s %-20s %-20s\n"
                ,"NAME", "AGE" , "ADDRESS" , "PHONE" , "ID CORE"
                ,"EDUCATION LEVEL" , "WANT TO DO");
        fileData.CloseFileAfterWriter();
    }
    public void WriteToFileRecruitment(String file){
        if(employees.isEmpty()){
            System.out.println("\n There are not applications yet !\n");
            return;
        }
        fileData.OpenFileToWrite(file);
        String idCore = null;
        int id = acc.EnterIdCore(idCore);
        for (int i = 0 ; i < employees.size() ; i++){
            if (CheckIdCore(id) == true){
                fileData.getPrintWriter().printf("%-20s %-10s %-20s %-20s %-15d %-20s %-20s\n", employees.get(i).getName(),
                        employees.get(i).getAge(), employees.get(i).getAddress(), employees.get(i).getPhoneNb(), employees.get(i).getIdCore()
                        , employees.get(i).getLevel(), employees.get(i).getWantTodo());
                System.out.println("\n ====> SUCCESSFULLY RECRUITMENT <====\n ");
                employees.remove(i);
                break;
            }
        }
        fileData.CloseFileAfterWriter();
    }
    public void ShowData(){
        employees.forEach(i->{
            System.out.println(i.getIdCore() + " "+ i.getName() +" " +  i.getAge() +" "+ i.getAddress() + "  " +
                    i.getPhoneNb() + " " + i.getLevel() + " " + i.getWantTodo());
        });
    }
}
