package Controller;

import Model.Recruitment_Info;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListJob {

    static List<Recruitment_Info> job = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
public void JobRecruitment(){
    if(job.size() > 0) return;
    job.add(new Recruitment_Info("Manager" , "IDCV1"));
    job.add(new Recruitment_Info("Accountant" , "IDCV2"));
    job.add(new Recruitment_Info("Receptionist" , "IDCV3"));
    job.add(new Recruitment_Info("Employee" , "IDCV4"));
    job.add(new Recruitment_Info("Cleaner" , "IDCV5"));
    job.add(new Recruitment_Info("Guard" , "IDCV6"));
}
        public void ShowDataJob(){
            JobRecruitment();
            System.out.println("\t\t\t\t\t\t          JOB THAT NEED TO BE RECRUITED \n");
            job.forEach(i->{
                System.out.print(i.getJob()+"("+i.getIdJob()+")" + "      ");
            });
        }
        public boolean checkIdJob(String Id){
            for(int i = 0 ; i < job.size() ; i++){
                if(job.get(i).getIdJob().compareTo(Id) == 0) return true;
            }
            return false;
        }
        public String ReturnJob(String Id){
            for(int i = 0 ; i < job.size() ; i++){
                String s = job.get(i).getJob();
                if(job.get(i).getIdJob().compareTo(Id) == 0)
                    return s;
            }
            return null;
        }
}
