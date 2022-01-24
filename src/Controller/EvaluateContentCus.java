package Controller;
import Model.EvaluateCustomer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvaluateContentCus {
    static Scanner sc = new Scanner(System.in);
    static List<EvaluateCustomer> evaluate = new ArrayList<>();
    static EvaluateCustomer evaluateCustomer;
    static AccountManagement account = new AccountManagement();

    public void EvaluateCustomer(String userCustomer) {
        evaluateCustomer = new EvaluateCustomer();
        evaluateCustomer.setName(account.ReturnNameCustomer(userCustomer));
        evaluateCustomer.setAge(account.ReturnAge(userCustomer));
        evaluateCustomer.setPhoneNb(account.ReturnPhone(userCustomer));
        evaluateCustomer.setAddress(account.ReturnAddress(userCustomer));
        String tmp = null;
        int start;
        do {
            start = account.EnterStart(tmp);
        } while (start < 1 || start > 5);
        evaluateCustomer.setNumberStart(start);
        System.out.print("  Enter content you want to late : ");
        evaluateCustomer.setContent(sc.nextLine());
        evaluate.add(evaluateCustomer);
        System.out.println("\t\tTHANK YOU FOR YOUR REVIEW , HAVE A NICE DAY!\n");
    }

    public void sampleEvaluate() {
        if (evaluate.size() > 1) return;
        evaluate.add(new EvaluateCustomer("Ngô Ngọc Sáng", "21", "Hà Nội", "0897465123", 5, " Chất lượng , dịch vụ tuyệt vời , nhân viên thì rất xinh"));
        evaluate.add(new EvaluateCustomer("Nguyễn Đình Huân", "21", "Điện Biên", "0539465123", 5, "Máy không những chơi game mượt , mà code rất nhanh"));
        evaluate.add(new EvaluateCustomer("Vy Văn Hùng", "21", "Bắc Giang", "0478098123", 5, "Chất lượng máy quá tuyệt , tôi sẽ ghé thăm quán chơi thường xuyên"));
    }

    public void ShowEvaluate() {
        sampleEvaluate();
        int i = 1;
        for (EvaluateCustomer evaluateCustomer : evaluate) {
            System.out.println("\t\t=====> Evaluate " + (i++) + "th");
            System.out.print("===============================================================================================\n"
                            + "||                                         CUSTOMER INVOICE                                  ||\n"
                            + "----------------------------------------------------------------------------------------------- \n");
            System.out.print("||   NAME : ");
            System.out.printf("%-81s" , evaluateCustomer.getName());
            System.out.println("||");

            System.out.print("||   AGE : ");
            System.out.printf("%-82s" , evaluateCustomer.getAge());
            System.out.println("||");

            System.out.print("||   PHONE : ");
            System.out.printf("%-80s" , evaluateCustomer.getPhoneNb());
            System.out.println("||");

            System.out.print("||   ADDRESS : ");
            System.out.printf("%-78s" , evaluateCustomer.getAddress());
            System.out.println("||");

            System.out.print("||   NUMBER START : ");
            System.out.printf("%-73d" , evaluateCustomer.getNumberStart());
            System.out.println("||");

            System.out.print("||   EVALUATE CONTENT : ");
            System.out.printf("%-69s" , evaluateCustomer.getContent());
            System.out.println("||");
            System.out.println("===============================================================================================\n");
        }
    }
}
