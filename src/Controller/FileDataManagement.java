package Controller;

import Model.Account;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Model.EmployeeInfo;
import Model.ServiceCustomer;

public class FileDataManagement {

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    static List<EmployeeInfo> employees = new ArrayList<>();
    static Account infoAcc = new Account();
    static EconomyManagement ctr = new EconomyManagement();
    static Date date = new Date();
    static Recruitment_Info recruitment = new Recruitment_Info();
    static List<ServiceCustomer> serviceStm = new ArrayList<>();
    static ServiceCustomer serviceCustomer = new ServiceCustomer();


    public FileWriter getFileWriter() {
        return fileWriter;
    }
    static List<Account> infoAccount = new ArrayList<>();

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public Scanner getScanner() {
        return scanner;
    }
    public void OpenFileToWrite(String fileName){

        try{
            fileWriter = new FileWriter(fileName,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWriter(){
        try{
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName){
        try {
            scanner = new Scanner(Paths.get(fileName));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead(){
        scanner.close();
    }

    public Account CreateAccountFromData(String data){
        String[] datas = data.split("\\|");
        Account acc = new Account(datas[0], datas[1], datas[2], datas[3], Long.parseLong(datas[4]), Float.parseFloat(datas[5]), datas[6] , datas[7]);
        return acc;
    }

    public List<Account> ReadAccountFromFile(String fileName){
        OpenFileToRead(fileName);
        List<Account> list = new ArrayList<>();

        while(scanner.hasNext()){
            String data = scanner.nextLine();
            Account acc = CreateAccountFromData(data);
            list.add(acc);
        }
        CloseFileAfterRead();
        return list;
    }
    //Account
    public void WriteAccountToFile(String file , Account acc){
        OpenFileToWrite(file);
        getPrintWriter().println(acc.getName() +"|"+ acc.getAge()+"|" + acc.getAddress()
                +"|"+ acc.getPhoneNb() +"|"+acc.getAmountOfMoney() +"|"+acc.getHourOfPlay()
                +"|"+ acc.getUserName() +"|"+ acc.getPassword() + " - " + date);
        CloseFileAfterWriter();
    }
    public void UpdateAccountToFile(List<Account> infoAccountList ,String fileName){

        ReadAccountFromFile(fileName);
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(Account acc : infoAccount){
            printWriter.println(acc.getName() + "|" + acc.getAge() +"|" + acc.getAddress()+"|" + acc.getPhoneNb()+"|"
                    + acc.getAmountOfMoney()+"|" + acc.getHourOfPlay() + "|" + acc.getUserName() +"|"+ acc.getPassword());
        }
        CloseFileAfterWriter();
    }

}
