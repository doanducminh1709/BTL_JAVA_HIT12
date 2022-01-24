package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Account;
import Model.Economy;
public class EconomyManagement {

    static Scanner sc = new Scanner(System.in);
    static float PrimeOneHour = 5000;
    static int Promotion = 5;
    static Economy economy = new Economy();
    static Account acc = new Account();
    static List<Economy> listEconomy = new ArrayList<>();
    public void Default(){
        economy.setPromotion(Promotion);
        economy.setHourlyRate(PrimeOneHour);
        listEconomy.add(new Economy(PrimeOneHour , Promotion));
    }

    public void Increase_price_money() {
        Default();
        System.out.println("  Original price : " + listEconomy.get(0).getHourlyRate()+"VND/1H");
        int newHourlyRate = 0;
        do {
            System.out.print("  Import new price : ");
            newHourlyRate = sc.nextInt();
            if (newHourlyRate <= economy.getHourlyRate()) {
                System.out.println(" The amount after increase must be greater than the original amount  , Enter pack! ");
            }
        } while (newHourlyRate <= economy.getHourlyRate());
        System.out.println("\n       =====< SUCCESSFULLY CHANGED >====== ");
        economy.setHourlyRate(newHourlyRate);
        listEconomy.get(0).setHourlyRate(newHourlyRate);
        System.out.println("===> New hour rate after inscrease : " + economy.getHourlyRate() + " VND/1H");
    }
    public  void Discount_Money_Every_hour(){
        System.out.println("  Original price : " + listEconomy.get(0).getHourlyRate()+"VND/1H");
        int newHourlyRate = 0;
        do {
            System.out.print("  Import new price : ");
            newHourlyRate = sc.nextInt();
            if (newHourlyRate >= economy.getHourlyRate()) {
                System.out.println(" the amount after reduction must be less than the original amount , Enter pack! ");
            }
        } while (newHourlyRate >= economy.getHourlyRate());
        System.out.println("\n       =====< SUCCESSFULLY CHANGED >====== ");
        economy.setHourlyRate(newHourlyRate);
        listEconomy.get(0).setHourlyRate(newHourlyRate);
        System.out.println("===> New hour rate after discount : " + economy.getHourlyRate() +" VND/1H");
    }
    public boolean checkVipGuests(long amountOfDeposit){
        if(amountOfDeposit >= Math.pow(10,6)){
            return true;
        }
        return false;
    }
    public float Promotion_VIP_Guest(){
        EditPromotion();
        economy.setPromotion(Promotion);
        return economy.getPromotion()/100;
    }
    public void EditPromotion(){
        int percent;
        do{
            System.out.print(" Enter value you want to change : ");
            percent = sc.nextInt();
            if(percent < 0){
                System.out.println(" Invalid value re-enter ");
            }
        }while (percent < 0);
        Promotion = percent;
        economy.setPromotion(percent);
    }
public void topUpAccount(){
           Default();
            long amountOfDeposit;
            do{
                System.out.print("Import into load money : ");
                amountOfDeposit = sc.nextLong();
                if(amountOfDeposit < economy.getHourlyRate()){
                    System.out.println("Invalid deposit amount, re-enter");
                }else break;
            }while (amountOfDeposit < economy.getHourlyRate());
                acc.setAmountOfMoney(amountOfDeposit);
            float hourPlay;
            if(!checkVipGuests(amountOfDeposit)){
                hourPlay = (float) amountOfDeposit/(economy.getHourlyRate());
                acc.setHourOfPlay(hourPlay);
                System.out.println(" =====> Your respective playtime is : " + acc.getHourOfPlay()+"H\n");
            }else{
                hourPlay = (float) (amountOfDeposit/(economy.getHourlyRate()));
                float promotion = ((economy.getPromotion()/100)*amountOfDeposit)/(economy.getHourlyRate());
                acc.setHourOfPlay(hourPlay+promotion);
                System.out.println(" =====> Your respective playtime is : "
                +hourPlay+ "H and awarded " + promotion +"H promotion\n");
            }
     }
}
