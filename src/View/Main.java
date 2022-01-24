package View;
import Controller.AttendanceEmployees;
import Controller.LoginManagement;
import Controller.AccountManagement;
import Controller.Recruitment_Info;

public class Main {
    static AccountManagement account = new AccountManagement();
    static LoginManagement login = new LoginManagement();
    static Recruitment_Info recruitment = new Recruitment_Info();
    static AttendanceEmployees attendance = new AttendanceEmployees();
    public static void main(String[] args) {

        int select1 , select2;
        String chose = null;
        System.out.println("\n\t\t\tELECTRONIC SPORTS ENTERTAINMENT COMPANY");
        System.out.println("\t\t\t     The ideal destination of gamers\n");
        do {
    System.out.println("=======================================\n"
                    + "||        ======>MENU<======        ||\n"
                    + "||   1.Log in                       ||\n"
                    + "||   2.Forgot password              ||\n"
                    + "||   3.Create new account           ||\n"
                    + "||   4.Employment information       ||\n"
                    + "||                                  ||\n"
                    + "=======================================");
            select1 = account.EnterChose(chose);
            switch (select1){
                case 1:{
                    login.LogIn();
                    break;
                }
                case 2:{
                    account.ForgotPassWord();
                    break;
                }
                case 3:{
                    account.CreateAccount();
                    break;
                }
                case 4:{
                    do{
                        System.out.println( "++++++++++++++++++++++++++++++++++++\n"
                                           +"||   1.Info recruitment           ||\n"
                                           +"||   2.Attendance employees       ||\n"
                                           +"||   3.Exit                       ||\n"
                                           +"++++++++++++++++++++++++++++++++++++\n");
                        select2 = account.EnterChose(chose);
                        switch (select2){
                            case 1:{
                                recruitment.EnterYourInfo();
                                break;
                            }
                            case 2:{
                                attendance.attendanceForEmployees();
                                break;
                            }
                            case 3: {
                                break;
                            }
                        }
                    }while (select2 != 3);
                }
            }
        }while (true);
    }
}
