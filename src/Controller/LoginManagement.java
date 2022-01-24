package Controller;

public class LoginManagement {

    static AccountManagement account = new AccountManagement();
    static ComputerManagement computer = new ComputerManagement();
    static EconomyManagement economyManager = new EconomyManagement();
    static ServiceManagement serviceManagement = new ServiceManagement();
    static Recruitment_Info recruitment_info = new Recruitment_Info();
    static EvaluateContentCus evaluateContentCus = new EvaluateContentCus();
    static ServiceCustomerManagement customerManagement = new ServiceCustomerManagement();
    static AttendanceEmployees attendanceEmployees = new AttendanceEmployees();
    public void LogIn() {
        int  chose2, chose3, chose4, chose6, chose7, chose8;
        String chose = null;
        String fileEmployee = "Employee.txt";
        String fileCusBill = "CustomerBill.txt";
                    String username, password;
                    username = account.ReturnUser();
                    password = account.ReturnPassWord();
                    if (account.LogInAccount(username, password) == 0) {

                        System.out.println("\n"
                                +"__________________________________________________\n"
                                +"||    ===> LOGIN SUCCESSFUL, WELCOME BOSS <===  ||\n"
                                +"--------------------------------------------------\n");
                        do {
                            System.out.println("======================================\n"
                                            +"||   1.Manage computer               ||\n"
                                            +"||   2.Manage economy                ||\n"
                                            +"||   3.Manage service                ||\n"
                                            +"||   4.Manage account                ||\n"
                                            +"||   5.Manage employee               ||\n"
                                            +"||   6.Exit                          ||\n"
                                            +"======================================");

                            chose2 = account.EnterChose(chose);
                            switch (chose2) {
                                case 1: {
                                    do {
                        System.out.println( "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                                                +"||   1.Add computer                                                      ||\n"
                                                +"||   2.Remove computer                                                   ||\n"
                                                +"||   3.Replace computer                                                  ||\n"
                                                +"||   4.Show information computer you want find                           ||\n"
                                                +"||   5.Check ,show data computer                                         ||\n"
                                                +"||   6.Exit                                                              ||\n"
                                                +"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                        chose3 = account.EnterChose(chose);
                                        switch (chose3) {
                                            case 1: {
                                                computer.addInformation();
                                                break;
                                            }
                                            case 2: {
                                                computer.RemoveInformation();
                                                break;
                                            }
                                            case 3: {
                                                computer.UpdateReplace();
                                                break;
                                            }
                                            case 4: {
                                                computer.FindInfoComputer();
                                                break;
                                            }
                                            case 5: {
                                                computer.ShowDataComputer();
                                                break;
                                            }
                                            case 6: {
                                                break;
                                            }
                                            default: {
                                                System.out.println("Function does not exist, please choose again");
                                                break;
                                            }
                                        }
                                    } while (chose3 != 6);
                                    break;
                                }
                                case 2: {
                                    do {
                                        System.out.println("\n"  +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                                                                 +"||   1.Increase in price per hour of play                               ||\n"
                                                                 +"||   2.Discount money every hour of play                                ||\n"
                                                                 +"||   3.Ofter for customer who deposit large amounts(accountable by %)   ||\n"
                                                                 +"||     [Only applicable to customers who top up 1 million VND]          ||\n"
                                                                 +"||   4.View total revenue                                               ||\n"
                                                                 +"||   5.Exit                                                             ||\n"
                                                                 +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                        chose4 = account.EnterChose(chose);
                                        switch (chose4) {
                                            case 1: {
                                                economyManager.Increase_price_money();
                                                break;
                                            }
                                            case 2: {
                                                economyManager.Discount_Money_Every_hour();
                                                break;
                                            }
                                            case 3: {
                                                economyManager.Promotion_VIP_Guest();
                                                System.out.println(" SUCCESSFULLY CHANGE! ");
                                                break;
                                            }
                                            case 4: {
                                                System.out.println("\n Total amount of money for customers to top up the game : " +account.SumCustomerLoadGame() +"VND");
                                                System.out.println(" Total proceeds from services : "+customerManagement.SumOfMoneyService()+ "VND");
                                                System.out.println(" \t\t\t TOTAL REVENUE : " +(account.SumCustomerLoadGame()+ customerManagement.SumOfMoneyService())+ "VND");
                                                break;
                                            }
                                            case 5:{
                                                break;
                                            }
                                            default: {
                                                System.out.println("Function does not exist, please choose again");
                                                break;
                                            }
                                        }
                                    } while (chose4 != 5);
                                    break;
                                }
                                case 3: {
                                    do {
                                        System.out.println( "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                                                           +"||   1.Add service                                                      ||\n"
                                                           +"||   2.Delete service                                                   ||\n"
                                                           +"||   3.Show list service                                                ||\n"
                                                           +"||   4.Exit                                                             ||\n"
                                                           +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                        chose6 = account.EnterChose(chose);
                                        switch (chose6) {
                                            case 1: {
                                                serviceManagement.addInformation();
                                                break;
                                            }
                                            case 2: {
                                                serviceManagement.RemoveInformation();
                                                break;
                                            }
                                            case 3: {
                                                serviceManagement.ListService();
                                                break;
                                            }
                                            case 4: {
                                                break;
                                            }
                                            default: {
                                                System.out.println("Function does not exist, please choose again");
                                                break;
                                            }
                                        }
                                    } while (chose6 != 4);
                                    break;
                                }
                                case 4: {
                                    do {
                         System.out.println("\n"  +"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                                                +"||   1.Change password                                                 ||\n"
                                                +"||   2.Displays a list of customers by increasing amount               ||\n"
                                                +"||   3.Displays a list of customers by decreasing amount               ||\n"
                                                +"||   4.Find customer information by user                               ||\n"
                                                +"||   5.Show evaluate of customer                                       ||\n"
                                                +"||   6.Exit                                                            ||\n"
                                                +"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                        chose7 = account.EnterChose(chose);
                                        switch (chose7) {
                                            case 1: {
                                                account.changePassword(username);
                                                System.out.println("\n=====> PASSWORD HAS BEEN CHANGED, PLEASE LOG IN AGAIN <===== ");
                                                return;
                                            }
                                            case 2: {
                                                account.AscByDepositMoney();
                                                break;
                                            }
                                            case 3: {
                                                account.DescByDepositMoney();
                                                break;
                                            }
                                            case 4: {
                                                account.findInfoCustomer();
                                                break;
                                            }
                                            case 5: {
                                                evaluateContentCus.ShowEvaluate();
                                                break;
                                            }
                                            case 6:{
                                                break;
                                            }
                                            default: {
                                                System.out.println("Function does not exist, please choose again");
                                                break;
                                            }
                                        }
                                    } while (chose7 != 6);
                                    break;
                                }
                                case 5: {
                                    int chose11;
                                    do {
                                        System.out.println(  "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                                                            +"||   1.See job application                                ||\n"
                                                            +"||   2.Recruitment employee                               ||\n"
                                                            +"||   3.Show list employees                                ||\n"
                                                            +"||   4.Exit                                               ||\n"
                                                            +"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                        chose11 = account.EnterChose(chose);
                                        switch (chose11) {
                                            case 1: {
                                                recruitment_info.ListEmployeeRecruitment();
                                                break;
                                            }
                                            case 2: {
                                                recruitment_info.WriteToFileRecruitment(fileEmployee);
                                                break;
                                            }
                                            case 3: {
                                                attendanceEmployees.ShowListEmployee();
                                                break;
                                            }
                                            case 4:{
                                            break;
                                            }
                                            default: {
                                                System.out.println("Function does not exist, please choose again");
                                                break;
                                            }
                                        }
                                    } while (chose11 != 4);
                                }
                                case 6: {
                                    break;
                                }
                            }
                        } while (chose2 != 6);
                    } else if (account.LogInAccount(username, password) == 1) {

                        System.out.println("\n"
                                +"__________________________________________________\n"
                                +"|| ===> LOGIN SUCCESSFUL, WELCOME CUSTOMER <=== ||\n"
                                +"--------------------------------------------------\n");
                        do {
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                                              +"||   1.Change password                                                 ||\n"
                                              +"||   2.Edit information for me                                         ||\n"
                                              +"||   3.Deposit money into your account                                 ||\n"
                                              +"||   4.Buy food or rend a room                                         ||\n"
                                              +"||   5.See the bill                                                    ||\n"
                                              +"||   6.Your assessment of the quality of the restaurant                ||\n"
                                              +"||   7.Exit                                                            ||\n"
                                              +"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                            chose8 = account.EnterChose(chose);
                            switch (chose8) {
                                case 1: {
                                    account.changePassword(username);
                                    System.out.println("\n=====> PASSWORD HAS BEEN CHANGED, PLEASE LOG IN AGAIN <===== ");
                                    return;
                                }
                                case 2:{
                                    account.EditInformationCustomer();
                                    break;
                                }
                                case 3: {
                                       economyManager.topUpAccount();
                                       break;
                                }
                                case 4: {
                                    customerManagement.ChoseService(username);
                                    break;
                                }
                                case 5: {
                                    customerManagement.BillService();
                                    break;
                                }
                                case 6: {
                                    evaluateContentCus.EvaluateCustomer(username);
                                    break;
                                }
                                case 7:{
                                    break;
                                }
                                default: {
                                    System.out.println("Function does not exist, please choose again");
                                    break;
                                }
                            }
                        } while (chose8 != 7);
                    } else {
                        System.out.println("\n ===>LOGIN FAILURE, ACCOUNT DOSE NOT EXITS<===\n");
        }
    }
}
