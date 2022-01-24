package Controller;

import Model.Account;
import Model.Economy;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountManagement {

        // REGEX
        static final String Address = "^([a-zA-Z0-9.\\s]+)$";
        static final String Username = "^[\\w]{6,}$";
        static final String ageUser = "^[0-9]{1,}$";
        static final String Password = "^((?=.*[A-Z]).(?=.*[a-z])(?=.*[0-9])(?=.*[&^*%!$#@])).{8,}$";
        static final String Phone = "^[\\d]{10}$";

        static Scanner sc = new Scanner(System.in);
        static List<Account> info = new ArrayList<>();
        static Account infoAccount = new Account();
        static Date date = new Date();
        static FileDataManagement fileData = new FileDataManagement();
        static Economy economy = new Economy();
        static EconomyManagement economyManager = new EconomyManagement();
        //DATATYPE

        public void AccountAdmin(){
            info.add(new
                    Account("Đoàn Hữu Minh" ,
                    "20" ,
                    "Thanh Hóa" ,
                    "0327597972",
                    0 ,
                    0,
                    "Admin12345" ,
                    "Minh123456789@"));
        }
        public void InitializeCustomerInfo(){
            if(info.size() > 1) return;
            info.add(new Account("Trần Đăng Khoa" , "17" , "Hưng Yên" , "0987887654"
                    ,3233000, 646,"KhoaPug" , "Khoa12345##"));
            info.add(new Account("Đinh Tấn Hưng" , "18" , "Yên Bái" , "0983887654"
                    ,1230000, 246,"HungChicken" , "HungChicken1##"));
            info.add(new Account("Ngô Sỹ Kiên" , "19" , "Hải Dương" , "0987547654"
                    ,2314000, 462,"SiKien1234" , "SiKien1234##"));
            info.add(new Account("Lưu Viết Nghĩa" , "18" , "Bắc Giang" , "0986587654"
                    ,2358940, 471,"NghiaCute" , "NghiaCute2##"));
            info.add(new Account("Phạm Văn Nhất" , "19" , "Bắc Giang" , "0987860654"
                    ,3424000, 684,"MkLaNhat" , "MkLaNhat12#"));
            info.add(new Account("Đặng Duy Hưng" , "18" , "Thanh Hóa" , "0987543654"
                    ,3340000 ,668,"HungAi" , "HungAi12##"));
            info.add(new Account("Nguyễn Thế Phương" , "18" , "Thanh hóa" , "0985387654"
                    ,1552200 , 310,"PhuongNguyen" , "PhuongThe123#@"));
            info.add(new Account("Ngô Ngọc Sáng" , "21" , "Hà Nội" , "0897465123"
                    ,3210000 , 642,"SangNgoNgoc" , "SangNgoNgoc#@"));
            info.add(new Account("Nguyễn Đình Huân" , "21" , "Điện Biên" , "0539465123"
                    ,1243500 , 249,"Huannd0101" , "Huannd0101@"));
            info.add(new Account("Vy Văn Hùng" , "21" , "Bắc Giang" , "0478098123"
                    ,4243000 , 848,"HungVyVan" , "Hungvy$123"));
            WriteToFileOfList("AccountCustomer.txt");

        }
    public void WriteToFileOfList(String file){
        if(info.size() > 1) return;
        InitializeCustomerInfo();
        fileData.OpenFileToWrite(file);
        for(Account i : info) {
            if (i.getUserName().compareTo("Admin12345") != 0) {
                fileData.getPrintWriter().println(i.getName() + "|" + i.getAge() + "|" + i.getAddress()
                        + "|" + i.getPhoneNb() + "|" + i.getAmountOfMoney() + "|" + i.getHourOfPlay() + "|" + i.getUserName() + "|" + i.getPassword() + " - " + date);
            }
        }
        fileData.CloseFileAfterWriter();
    }

        public void ForgotPassWord(){
            InitializeCustomerInfo();
//USER NAME
            Pattern pattern1;
            Matcher matcher1;
            String users;
            do {
                System.out.print("   Enter your user : ");
                users = sc.nextLine();
                pattern1 = Pattern.compile(Username);
                matcher1 = pattern1.matcher(users);
                if(!matcher1.find()){
                    System.out.println(" User name format is not correct!\n(Note : From 6 characters or more including letters and numbers without special characters)");
                } else{
                    break;
                }
            }while (!matcher1.find());
            //PHONE
            String phone;
            Pattern pattern;
            Matcher matcher;
            do{
                System.out.print("   Enter your phone login : ");
                phone = sc.nextLine();
                pattern = Pattern.compile(Phone);
                matcher = pattern.matcher(phone);
                if(!matcher.find()){
                    System.out.println(" Phone format is not correct!\n(Note : Only 10 digits no special characters)");
                }else break;
            }while(!matcher.find());
            int cnt=0;
            for(int i = 0 ; i < info.size() ; i++){
             if(phone.compareTo(info.get(i).getPhoneNb()) == 0){
                 break;
             }else cnt++;
            }
            if(cnt == info.size()){
                System.out.println("====> This phone number dose not exit. <====\n");
                return;
            }

             int CoreRandom  = (int)(Math.random()*(999999-111111+1)+111111);
             System.out.println("   Verification code is : "+ CoreRandom);
             System.out.print("    Re-enter the confirmation code sent to your phone number :");
             int Re_enterCore = sc.nextInt(); sc.nextLine();
             int count = 0;
             for(int i = 0 ; i < info.size() ; i++){
                         if(Re_enterCore == CoreRandom
                         && users.compareTo(info.get(i).getUserName()) == 0
                         && phone.compareTo(info.get(i).getPhoneNb()) == 0){
                         System.out.println("\n ====> Your password is : " + info.get(i).getPassword()+"\n");
                       break;
                 }else{
                     count++;
                 }
             }
             if(count == info.size()){
                 System.out.println(" The information entered is incorrect, please check again!");
             }else{
                 int select;
                 String chose=null;
                 do{
                     System.out.println(" Do you want to change your password again ");
                     System.out.println("\t 1.Change password");
                     System.out.println("\t 2.Don't change , keep the old password");
                     select = EnterChose(chose);
                     switch (select){
                         case 1:{
                             changePassword(users);
                             System.out.println("\t =====> SUCCESSFULLY CHANGE PASSWORD <=====");
                             return;
                         }
                         case 2:{
                             break;
                         }
                         default: {
                             System.out.println("Function does not exist, please choose again");
                             break;
                         }
                     }
                 }while (select != 2);
             }
        }
        long SumCustomerLoadGame(){
            long sum = 0;
            for (int i = 0 ; i < info.size() ; i++){
                sum+= info.get(i).getAmountOfMoney();
            }
            return sum;
        }
        public boolean CheckDuplicateUser(String user){
            for (Account i:
                    info) {
                if(user.compareTo(i.getUserName()) == 0) return false;
            }
            return true;
        }
        public String ReturnNameCustomer(String userName){
            for(int i = 0 ; i < info.size() ; i++){
                String s = info.get(i).getName();
                if(userName.compareTo(info.get(i).getUserName()) == 0) return s;
            }
            return null;
        }
        public String ReturnAge(String userName){
            for(int i = 0 ; i < info.size() ; i++) {
                String age = info.get(i).getAge();
                if(userName.compareTo(info.get(i).getUserName()) == 0) return age;
            }
            return null;
        }
        public String ReturnPhone(String userName){
            for(int i = 0 ; i < info.size() ; i++){
                String s = info.get(i).getPhoneNb();
                if(userName.compareTo(info.get(i).getUserName()) == 0) return s;
            }
            return null;
        }
        public String ReturnAddress(String userName){
            for(int i = 0 ; i < info.size() ; i++){
                String s = info.get(i).getAddress();
                if(userName.compareTo(info.get(i).getUserName()) == 0) return s;
            }
            return null;
        }
        public String ReturnUser(){
//USER NAME
            String username;
            Pattern pattern;
            Matcher matcher;
            do {
                System.out.print("\n   Enter your user : ");
                username = sc.nextLine();
                pattern = Pattern.compile(Username);
                matcher = pattern.matcher(username);
                if (!matcher.find()) {
                    System.out.println(" User name format is not correct!\n(Note : From 6 characters or more including letters and numbers without special characters)");
                } else break;
            } while (!matcher.find());
            return username;
        }
        public String  ReturnPassWord(){
            String password;
            Pattern pattern1;
            Matcher matcher1;
            do {
                System.out.print("   Enter your password : ");
                password = sc.nextLine();
                pattern1 = Pattern.compile(Password);
                matcher1 = pattern1.matcher(password);
                if (!matcher1.find()) {
                    System.out.println(" Password format is not correct!\n(From 8 characters or more including letters, numbers and special characters.");
                } else break;
            } while (!matcher1.find());
            return password;
        }
        public int LogInAccount(String username , String password) {
            AccountAdmin();
            InitializeCustomerInfo();

            for (int i = 0; i < info.size(); i++) {
                if (username.compareTo("Admin12345") == 0
                        && info.get(0).getPassword().compareTo(password) == 0) {
                    return 0;
                }
                if (username.compareTo("Admin12345") !=0 && username.compareTo(info.get(i).getUserName()) ==0
                        && info.get(i).getPassword().compareTo(password) == 0) {
                    return 1;
                }
            }
            return -1;
        }

        public void EditInformationCustomer(){

                System.out.print("   Enter your name : ");
                infoAccount.setName(sc.nextLine());

            Pattern patterAge;
            Matcher matcherAge;
            do {
                System.out.print("   Enter your age : ");
                infoAccount.setAge(sc.nextLine());
                patterAge = Pattern.compile(ageUser);
                matcherAge = patterAge.matcher(infoAccount.getAge());
                if(!matcherAge.find()){
                    System.out.println(" Age format is not correct.\n(Note : Only 2 numbers with no special characters)");
                }else break;
            }while(!matcherAge.find());

//ADDRESS
            Pattern pattern3 = Pattern.compile(Address);
            System.out.print("   Enter your address : ");
            infoAccount.setAddress(sc.nextLine());
//PHONE
            Pattern pattern4;
            Matcher matcher4;
            do{
                System.out.print("   Enter your phone : ");
                infoAccount.setPhoneNb(sc.nextLine());
                pattern4 = Pattern.compile(Phone);
                matcher4 = pattern4.matcher(infoAccount.getPhoneNb());
                if(!matcher4.find()){
                    System.out.println("  Phone format is not correct!\n   (Note : Only 10 digits no special characters)");
                }else break;
            }while(!matcher4.find());
        }
        public void CreateAccount(){

            infoAccount = new Account();
                System.out.print("   Enter your name : ");
                infoAccount.setName(sc.nextLine());

            Pattern patterAge;
            Matcher matcherAge;
            do {
                System.out.print("   Enter your age : ");
                infoAccount.setAge(sc.nextLine());
                patterAge = Pattern.compile(ageUser);
                matcherAge = patterAge.matcher(infoAccount.getAge());
                if(!matcherAge.find()){
                    System.out.println(" Age format is not correct.\n(Note : Only 2 numbers with no special characters)");
                }else break;
            }while(!matcherAge.find());

//ADDRESS
            Pattern pattern3 = Pattern.compile(Address);
            System.out.print("   Enter your address : ");
            infoAccount.setAddress(sc.nextLine());
//PHONE
            Pattern pattern4;
            Matcher matcher4;
            do{
                System.out.print("   Enter your phone : ");
                infoAccount.setPhoneNb(sc.nextLine());
                pattern4 = Pattern.compile(Phone);
                matcher4 = pattern4.matcher(infoAccount.getPhoneNb());
                if(!matcher4.find()){
                    System.out.println(" Phone format is not correct!\n(Note : Only 10 digits no special characters)");
                }else break;
            }while(!matcher4.find());

//USER NAME
            Pattern pattern5;
            Matcher matcher5;
            String users;
            do {
                System.out.print("   Enter your user : ");
                users = sc.nextLine();
                pattern5 = Pattern.compile(Username);
                matcher5 = pattern5.matcher(users);
                if(!matcher5.find()){
                    System.out.println(" User name format is not correct!\n(Note : From 6 characters or more including letters and numbers without special characters)");
                }
                else if(CheckAccountAdmin(users) == false){
                    System.out.println("   User duplicate re-enter");
                }else if(matcher5.find() && CheckAccountAdmin(users) == true){
                    break;
                }
            }while (!matcher5.find() && !CheckAccountAdmin(users));
            infoAccount.setUserName(users);

//PASSWORD
            Pattern pattern6 ;
            Matcher matcher6;
            do{
                System.out.print("   Enter your password : ");
                infoAccount.setPassword(sc.nextLine());
                pattern6 = Pattern.compile(Password);
                matcher6 = pattern6.matcher(infoAccount.getPassword());
                if(!matcher6.find()){
                    System.out.println(" Password format is not correct !\n(From 8 characters or more including letters, numbers and special characters.)");
                }else break;
            }while(!matcher6.find());

//CONFIRM PASSWORD
            String join_in_password;
            do {
                System.out.print("  Please , Re-enter the password again to confirm : ");
                join_in_password = sc.nextLine();
            }while (!(infoAccount.getPassword().compareTo(join_in_password) == 0));
            System.out.println("ACCOUNT SETUP SUCCESSFULLY!\n");
            info.add(infoAccount);
            WriteToFileOfList("AccountCustomer.txt");
        }
        public boolean CheckAccountAdmin(String username) {
            AccountAdmin();
            InitializeCustomerInfo();
            for (int i = 0; i < info.size(); i++) {
                if(info.get(i).getUserName().compareTo(username) == 0){
                    return false;
                }
            }
            return true;
        }
        public void TitleOfTheBallot(){
            System.out.printf("%-20s %-10s %-18s %-15s %-20s %-20s %-20s %-20s\n","NAME " ,"AGE" , "ADDRESS",
                    "PHONE" , "AMOUNT OF MONEY" ,"HOUR OF PLAY", "USER NAME" , "PASSWORD\n");
        }

        public String ReturnName(){
            String user = infoAccount.getUserName();
            for(int i = 0 ; i < info.size() ; i++){
                String s = info.get(i).getName();
                if(user.compareTo(info.get(i).getUserName()) ==  0)
                    return s;
            }
            return null;
        }
    public void UpdateAccountToFile(List<Account> infoAccountList ,String fileName){

        fileData.ReadAccountFromFile(fileName);
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        fileData.OpenFileToWrite(fileName);
        for(Account acc : info) {
            if (acc.getUserName().compareTo("Admin12345") != 0) {
                fileData.getPrintWriter().println(acc.getName() + "|" + acc.getAge() + "|" + acc.getAddress() + "|" + acc.getPhoneNb() + "|"
                        + acc.getAmountOfMoney() + "|" + acc.getHourOfPlay() + "|" + acc.getUserName() + "|" + acc.getPassword() + "-" + date);
            }
        }
        fileData.CloseFileAfterWriter();
    }

        public void changePassword(String user){
            Pattern pattern6 ;
            Matcher matcher6;
            String newPassWord;
            do{
                System.out.print("   Enter your password : ");
                newPassWord = sc.nextLine();
                pattern6 = Pattern.compile(Password);
                matcher6 = pattern6.matcher(newPassWord);
                if(!matcher6.find()){
                    System.out.println(" Password format is not correct!\n(From 8 characters or more including letters, numbers and special characters.");
                }else break;
            }while(!matcher6.find());

            String password_confirmation;
            do {
                System.out.print("   Re-enter password to confirm : ");
                password_confirmation = sc.nextLine();
                if (!(password_confirmation.compareTo(newPassWord) == 0)) {
                    System.out.println(" Wrong password confirmation ");
                } else break;
            }while(!(password_confirmation.compareTo(newPassWord) == 0));
            infoAccount.setPassword(password_confirmation);

            for (int i = 0 ; i < info.size() ;i++){
                if(info.get(i).getUserName().compareTo(user) == 0){
                    info.get(i).setPassword(password_confirmation);
                    break;
                }
            }

            UpdateAccountToFile(info ,"AccountCustomer.txt");
        }

        public void findInfoCustomer() {
            System.out.print(" Find information customer by user : ");
            String userName = sc.nextLine();
            int[] cnt = {0};

            info.forEach(i -> {
                if (i.getUserName().compareTo(userName) == 0) {
                    TitleOfTheBallot();
                    System.out.printf("%-20s %-10s %-18s %-15s %-20d %-20f %-20s %-20s\n",
                            i.getName(), i.getAge(), i.getAddress(), i.getPhoneNb(),
                            i.getAmountOfMoney(),i.getHourOfPlay(), i.getUserName(), i.getPassword());
                } else {
                    cnt[0]++;
                }
            });
            if (cnt[0] == info.size()) {
                System.out.println("\nUser dose not exit! ");
                return;
            }
        }
    public int EnterIdCore(String chose){
        Pattern patterChose;
        Matcher matcherChose;
        do {
            System.out.print(" Enter id core you want to recruitment : ");
            chose = sc.nextLine();
            patterChose = Pattern.compile(ageUser);
            matcherChose = patterChose.matcher(chose);
            if(!matcherChose.find()){
                System.out.println(" Id Core format is not correct.\n(Note: Numbers [1-9] with no special characters)");
            }else break;
        }while(!matcherChose.find());
        int yourChose = Integer.parseInt(chose);
        return yourChose;
    }
        public int EnterChose(String chose){
            Pattern patterChose;
            Matcher matcherChose;
            do {
                System.out.print("\nEnter your chose : ");
                chose = sc.nextLine();
                patterChose = Pattern.compile(ageUser);
                matcherChose = patterChose.matcher(chose);
                if(!matcherChose.find()){
                    System.out.println(" Chose format is not correct.\n(Note : Numbers [1-9] with no special characters)");
                }else break;
            }while(!matcherChose.find());
            int yourChose = Integer.parseInt(chose);
            return yourChose;
        }
    public int EnterStart(String chose){
        Pattern patterChose;
        Matcher matcherChose;
        do {
            System.out.print("  Enter of start [1-5] you want to late : ");
            chose = sc.nextLine();
            patterChose = Pattern.compile(ageUser);
            matcherChose = patterChose.matcher(chose);
            if(!matcherChose.find()){
                System.out.println(" Start format is not correct.\n(Note : Numbers [1-5] with no special characters)");
            }else break;
        }while(!matcherChose.find());
        int yourChose = Integer.parseInt(chose);
        return yourChose;
    }
    public int EnterCountCus(String chose){
        Pattern patterChose;
        Matcher matcherChose;
        do {
            System.out.print(" Enter time or count : ");
            chose = sc.nextLine();
            patterChose = Pattern.compile(ageUser);
            matcherChose = patterChose.matcher(chose);
            if(!matcherChose.find()){
                System.out.println(" Chose format is not correct.\n(Note : Numbers [1-9] with no special characters)");
            }else break;
        }while(!matcherChose.find());
        int yourChose = Integer.parseInt(chose);
        return yourChose;
    }
    public void ShowInfoCustomer() {
        InitializeCustomerInfo();
        TitleOfTheBallot();
        info.forEach(i->{
            if (!(i.getUserName().compareTo("Admin12345") == 0)) {
                System.out.printf("%-20s %-10s %-18s %-15s %-20d %-20.2f %-20s %-20s\n",
                        i.getName(), i.getAge(), i.getAddress(), i.getPhoneNb() , i.getAmountOfMoney()
                        ,i.getHourOfPlay(), i.getUserName(), i.getPassword());
            }
        });
    }
        public void AscByDepositMoney(){

            Collections.sort(info, new Comparator<Account>() {
                @Override
                public int compare(Account o1, Account o2) {
                    return (int) (o1.getAmountOfMoney() - o2.getAmountOfMoney());
                }
            });
            System.out.println(" \t\t\t     ==========> LIST OF CUSTOMERS BY INCREASING AMOUNT <============");
            ShowInfoCustomer();
        }

        public void DescByDepositMoney(){
            Collections.sort(info, new Comparator<Account>() {
                @Override
                public int compare(Account o1, Account o2) {
                    return (int) (o2.getAmountOfMoney()  - o1.getAmountOfMoney());
                }
            });
            System.out.println(" \t\t\t      ==========>LIST OF CUSTOMERS BY DECREASING AMOUNT <============");
            ShowInfoCustomer();
        }
    }

