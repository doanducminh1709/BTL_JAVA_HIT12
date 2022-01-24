package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recruitment_Info {

    private String Job;
    private String IdJob;
    public Recruitment_Info(String job, String idJob) {
        Job = job;
        IdJob = idJob;
    }

    public Recruitment_Info() {
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getIdJob() {
        return IdJob;
    }

    public void setIdJob(String idJob) {
        IdJob = idJob;
    }
}
