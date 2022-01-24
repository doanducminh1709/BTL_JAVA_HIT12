package Controller;
import Model.ServiceCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class ServiceCustomerManagement {

    static ServiceCustomer serviceCustomer;
    static AccountManagement account = new AccountManagement();
    static Scanner sc = new Scanner(System.in);
    static ServiceManagement serviceManagement = new ServiceManagement();
    static List<ServiceCustomer> serviceStm = new ArrayList<>();
    static FileDataManagement fileData = new FileDataManagement();
    static Date date = new Date();


    public void ChoseService(String userCustomer){
        serviceManagement.ListService();
        serviceCustomer = new ServiceCustomer();
        serviceCustomer.setName(account.ReturnNameCustomer(userCustomer));
        serviceCustomer.setAge(account.ReturnAge(userCustomer));
        serviceCustomer.setPhoneNb(account.ReturnPhone(userCustomer));
        serviceCustomer.setAddress(account.ReturnAddress(userCustomer));
        String id;
        do {
            System.out.print("\n Enter id of service : ");
            id = sc.nextLine();
            if(serviceManagement.CheckIdService(id) ) {
                System.out.println(" Service dose not exit! ");
            }else break;
        }while(serviceManagement.CheckIdService(id));
        serviceCustomer.setIdService(id);
//NAME
        serviceCustomer.setNameService(serviceManagement.NameById(id));

//TIME OR COUNT
        int timeorcount;
        String str=null;
        do{
            timeorcount = account.EnterCountCus(str);
            if(timeorcount < 0){
                System.out.println(" Data does not match , re-enter");
            }
        }while (timeorcount < 0);
        serviceCustomer.setCountOrTime(timeorcount);
        serviceCustomer.setServiceCost(timeorcount
                * serviceManagement.PriceById(id));
        serviceStm.add(serviceCustomer);
        System.out.println("   SERVICE HAS BEEN SUCCESSFULLY BOOKED   ");
    }
    long SumOfMoneyService(){
        int sum = 0;
        for(int i = 0 ; i < serviceStm.size() ; i++){
            sum += serviceStm.get(i).getServiceCost();
        }
        return sum;
    }
    public void BillService(){
        String fileCusBill = "CustomerBill.txt";
        if(serviceStm.isEmpty()){
            System.out.println("You have not used any service yet !\n");
            return;
        }
        int SumMoney = 0;
        for ( ServiceCustomer sr:
                serviceStm) {
            SumMoney += sr.getServiceCost();

        }
        System.out.println("\n\t\t\t\t CUSTOMER INVOICE ");
        System.out.println("   CUSTOMER NAME : " + serviceCustomer.getName());
        System.out.println("   AGE : " + serviceCustomer.getAge());
        System.out.println("   PHONE NUMBER : " + serviceCustomer.getPhoneNb());
        System.out.println("   ADDRESS : " + serviceCustomer.getAddress());
        System.out.printf("%-20s %-20s %-20s %-15s\n" ,"ID SERVICE","SERVICE NAME","COUNT OR TIME","SERVICE COST");
        serviceStm.forEach(sr->{
            System.out.printf("%-20s %-20s %-20d %-15d\n" ,
                    sr.getIdService() , sr.getNameService(), sr.getCountOrTime() , sr.getServiceCost());

        });
        System.out.println("\n\t\t\t\t Result Money : " + SumMoney +"VND");
        System.out.println("\t\t\t\t Time : " + date+ "\n");

       WriteBillOfCustomer(fileCusBill);
    }

    public void WriteBillOfCustomer(String fileName){
        if(serviceStm.isEmpty()){
            return;
        }
        int SumMoney = 0;
        for ( ServiceCustomer sr: serviceStm) {
            SumMoney += sr.getServiceCost();
        }
        fileData.OpenFileToWrite(fileName);
        fileData.getPrintWriter().println("\n\t\t\t\t CUSTOMER INVOICE ");
        fileData.getPrintWriter().println("   CUSTOMER NAME : " + serviceCustomer.getName());
        fileData.getPrintWriter().println("   AGE : " + serviceCustomer.getAge());
        fileData.getPrintWriter().println("   PHONE NUMBER : " + serviceCustomer.getPhoneNb());
        fileData.getPrintWriter().println("   ADDRESS : " + serviceCustomer.getAddress());
        fileData.getPrintWriter().printf("%-20s %-20s %-20s %-15s\n" ,"ID SERVICE","SERVICE NAME","COUNT OR TIME","SERVICE COST");
        for(ServiceCustomer sr : serviceStm){
            fileData.getPrintWriter().printf("%-20s %-20s %-20d %-15d\n" ,
                    sr.getIdService() , sr.getNameService(),sr.getCountOrTime(),sr.getServiceCost());
        }
        fileData.getPrintWriter().println("\n\t\t\t\tResult Money : " + SumMoney +"VND");
        fileData.getPrintWriter().println("\t\t\t\tTime : " + date + "\n");
        fileData.CloseFileAfterWriter();
    }

}
