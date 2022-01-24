package Controller;

import Model.EditInformation;
import Model.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceManagement implements EditInformation {
    static Scanner sc = new Scanner(System.in);
    static ServiceManagement managerSr ;
    static Service service = new Service();
    static List<Service> list = new ArrayList<>();

    public void InitializationService(){
        if(list.size() > 1) return;
        list.add(new Service("DV1","Gà Rán",25000 , "1 suất"));
        list.add(new Service("DV2","Mì Tôm Trứng",1000, "1 suất"));
        list.add(new Service("DV3","Cơm Rang",20000, "1 suất"));
        list.add(new Service("DV4","Mì Xào",15000, "1 suất"));
        list.add(new Service("DV5","String",10000, "1 lon"));
        list.add(new Service("DV6","Bò Húc",12000, "1 lon"));
        list.add(new Service("DV7","NumberOne",10000, "1 lon"));
        list.add(new Service("DV8","Phòng Vip",200000 , "1 giờ"));
        list.add(new Service("DV9","Phòng hạng trung",150000 , "1 giờ"));
        list.add(new Service("DV10","Phòng bình dân",100000 , "1 giờ"));
    }
    public boolean CheckIdService(String ID){
        for(int i = 0 ; i < list.size() ; i++){
            if(ID.compareTo(list.get(i).getIdService()) == 0) {
                return false;
            }
        }
        return true;
    }
    public String NameById(String id){
        InitializationService();
        for(int i = 0 ; i < list.size() ; i++) {
            if(id.compareTo(list.get(i).getIdService()) == 0){
                return list.get(i).getNameService();
            }
        }
        return null;
    }

    public int PriceById(String id){
        for(int i = 0 ; i < list.size() ; i++) {
            if (id.compareTo(list.get(i).getIdService()) == 0) {
                return list.get(i).getPriceService();
            }
        }
        return 0;
    }
    public void title_Service(){
        System.out.printf("%-15s %-25s %-15s %-12s\n", "ID SERVICE" ,"NAME SERVICE","PRICE " ,"UNIT");
    }
    public void ListService(){
        InitializationService();
        title_Service();
        list.forEach(i->{
            System.out.printf("%-15s %-25s %-15s %-12s\n", i.getIdService() ,i.getNameService(),i.getPriceService() ,i.getUnit());
        });
    }

    @Override
    public void addInformation() {
        service = new Service();
        String id;
        do {
            System.out.print(" Enter Id service you want add : ");
            id = sc.nextLine();
            if(!CheckIdService(id)){
                System.out.print("IdService duplicate , Please enter ");
            }
        }while(!CheckIdService(id));
        service.setIdService(id);

        System.out.print(" Enter name service you want add : ");
        service.setNameService(sc.nextLine());

        System.out.print(" Enter price of service you want add : ");
        service.setPriceService(sc.nextInt());sc.nextLine();

        System.out.print(" Enter unit of service : ");
        service.setUnit(sc.nextLine());
        list.add(service);
    }

    @Override
    public void RemoveInformation() {
        System.out.print(" Enter Id you want to remove : ");
        String id = sc.nextLine();
        if (CheckIdService(id) == true) {
            System.out.println(" This id dose not exit in stock ");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (id.compareTo(list.get(i).getIdService()) == 0) {
                    list.remove(i); break;
                }
            }
        }
    }

    @Override
    public void UpdateReplace() {
        System.out.print(" Enter Id you want to replace : ");
        String id = sc.nextLine();
        if (CheckIdService(id) == true) {
            System.out.println(" This id dose not exit in stock ");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (id.compareTo(list.get(i).getIdService()) == 0) {
                    System.out.print(" Enter name service : ");
                    String service = sc.nextLine();
                    list.get(i).setNameService(service);
                    System.out.print(" Enter price service : ");
                    int price = sc.nextInt();
                    list.get(i).setPriceService(price);
                    System.out.print("Enter unit service : ");
                    String unit = sc.nextLine();
                    list.get(i).setUnit(unit);
                    break;
                }
            }
        }
    }
}