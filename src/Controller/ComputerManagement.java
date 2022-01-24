package Controller;

import Model.Computer;
import Model.EditInformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerManagement implements EditInformation {

    static Scanner sc = new Scanner(System.in);
    static List<Computer> cmp = new ArrayList<>();
    static Computer computer;


    public void ComputerAvailable(){
        if(cmp.size() > 0)return;
        cmp.add(new Computer("MT1","PC HACOM 021" ,"ASUS" , "GOOD"));
        cmp.add(new Computer("MT2","PC HACOM 021" ,"ASUS" , "MEDIUM"));
        cmp.add(new Computer("MT3","PC HACOM 021" ,"ASUS" , "GOOD"));
        cmp.add(new Computer("MT4","PC HACOM 021" ,"ASUS " , "GOOD"));
        cmp.add(new Computer("MT5","PC AORUS XTREME" ,"ASUS" , "MEDIUM"));
        cmp.add(new Computer("MT6","PC AORUS XTREME" ,"DELL" , "GOOD"));
        cmp.add(new Computer("MT7","PC AORUS XTREME" ,"DELL" , "GOOD"));
        cmp.add(new Computer("MT8","PC ENTHUSIAST " ,"DELL" , "MEDIUM"));
        cmp.add(new Computer("MT9","PC ENTHUSIAST" ,"DELL " , "GOOD"));
        cmp.add(new Computer("MT10","PC ENTHUSIAST" ,"DELL " , "GOOD"));

    }
    @Override
    public void addInformation(){

        computer = new Computer();
        String Id = null;
        do{
            System.out.print("\n\tEnter computer id : ");
            Id = sc.nextLine();
            if(!CheckDuplicateId(Id)){
                System.out.println("\tThis id is duplicate. Retype!");
            }
        }while(!CheckDuplicateId(Id));
        computer.setIdComputer(Id);
        System.out.print("\tEnter computer name : ");
        computer.setComputerName(sc.nextLine());

        System.out.print("\tEnter brand name : ");
        computer.setBrandName(sc.nextLine());

        System.out.print("\tEnter status: ");
        computer.setStatus(sc.nextLine());

        System.out.println("=====> SUCCESSFULLY ADDED <====== ");
        cmp.add(computer);
    }
    //Remove data
    @Override
    public void RemoveInformation(){
        ComputerAvailable();
        if(cmp.isEmpty()){
            System.out.println(" Empty list!");
            return;
        }
        System.out.print("\n\tEnter computer id you want remove : ");
        String ComputerId = sc.nextLine();
        int cnt=0;
        for(int i = 0 ; i < cmp.size() ; i++)
            if (cmp.get(i).getIdComputer().compareTo(ComputerId) == 0) {
                cmp.remove(i);
                System.out.println("=====> SUCCESSFULLY DELETED <====== ");
                break;
            }else{
                cnt++;
            }
        if(cnt == cmp.size()){
            System.out.println("THIS ID COMPUTER DOESN'T EXIT");
        }
    }

    @Override
    public void UpdateReplace() {
        ComputerAvailable();
        String computerNameReplace;
        String brandNameReplace;
        String statusReplace;
        System.out.print(" Enter computer id you want replace : ");
        String ComputerId;
        ComputerId = sc.nextLine();

        int cnt = 0;
        for (int i = 0; i < cmp.size(); i++) {
            if (cmp.get(i).getIdComputer().compareTo(ComputerId) == 0) {
                System.out.print(" Enter Computer Name : ");
                computerNameReplace = sc.nextLine();
                cmp.get(i).setComputerName(computerNameReplace);

                System.out.print(" Enter Brand Name : ");
                brandNameReplace = sc.nextLine();
                cmp.get(i).setBrandName(brandNameReplace);

                System.out.print(" Enter Status : ");
                statusReplace = sc.nextLine();
                cmp.get(i).setStatus(statusReplace);
                System.out.println(" SUCCESSFULLY REPLACE !");
            } else {
                cnt++;
            }
        }
        if (cnt == cmp.size()) {
            System.out.println(" There is no machine with this id !");
            return;
        }
    }
    public void FindInfoComputer(){
        ComputerAvailable();
        if(cmp.isEmpty()){
            System.out.println(" Empty list!");
            return;
        }
        System.out.print(" Enter computer id you want find : ");
        String ComputerId = sc.nextLine();
        int count[] ={0};
        cmp.forEach(i -> {
            if(i.getIdComputer().compareTo(ComputerId) == 0){
                System.out.printf("%-17s %-17s %-15s %-15s\n" ,"COMPUTER ID" ,"COMPUTER NAME" , "BRAND NAME" , "STATUS");
                System.out.printf("%-17s %-17s %-15s %-15s\n" , i.getIdComputer() , i.getComputerName() , i.getBrandName() , i.getStatus());
            }else count[0]++;
        });
        if(count[0] == cmp.size()){
            System.out.println(" The product with this ID does not exist");
        }
    }

    public void ShowDataComputer(){
        ComputerAvailable();
        if(cmp.isEmpty()){
            System.out.println(" Empty list!");
            return;
        }
        System.out.printf("%-17s %-24s %-15s %-15s\n" ,"COMPUTER ID" ,"COMPUTER NAME" , "BRAND NAME" , "STATUS");
        cmp.forEach(i ->{
            System.out.printf("%-17s %-24s %-15s %-15s\n" , i.getIdComputer() , i.getComputerName() , i.getBrandName() , i.getStatus());
        });
    }

    public boolean CheckDuplicateId(String Id){
        for ( Computer i: cmp) {
            if(Id.compareTo(i.getIdComputer()) == 0) return false;
        }
        return true;
    }
}

