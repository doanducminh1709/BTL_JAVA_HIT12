package Model;

public class Recruitment_job {
    private String Job;
    private String IdJob;

    public  Recruitment_job() {
    }
    public  Recruitment_job(String job, String idJob) {
        Job = job;
        IdJob = idJob;
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
