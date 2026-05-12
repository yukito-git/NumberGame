import java.util.Scanner;
import java.util.Random;

public class NumberGame{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

    while(true){

        int guess = -1;
        int count = 0;
        int maxAttempts = 0;

        System.out.println("難易度を選択してください");
        System.out.println("1：簡単(1～10)");
        System.out.println("2：普通(1～100)");
        System.out.println("3：難しい(1～1000)");

        int max = 0;

        System.out.print("選択肢:");
        int select = sc.nextInt();

        while(1 > select || select > 3){
            System.out.println("もう一度難易度を選択してください");
            System.out.print("選択肢:");
            select = sc.nextInt();
        }

        if(select == 1){
            max = 10;
            maxAttempts = 5;
        }else if(select == 2){
            max = 100;
            maxAttempts = 7;
        }else{
            max = 1000;
            maxAttempts = 10;

        }
        
        int answer = rand.nextInt(max) + 1;

        System.out.println("1～" + max + "の数字を当ててください");

        while(count < maxAttempts){

            System.out.print("数字を入力:");
            guess = sc.nextInt();
            
            if(guess < 1 || guess > max){
                System.out.println("1～" + max + "の数字を入力してください");
                continue;
            }


            count++;


            int diff = Math.abs(answer - guess);

            if(diff <= 3 && guess != answer){
                System.out.println("かなり近い!");
            }else if(guess < answer){
                System.out.println("もっと大きいです");
            }else if(guess > answer){
                System.out.println("もっと小さいです");
            }else{
                System.out.println("正解です。");
                System.out.println(count + "回で当てました。");
                break;
            }

            System.out.println("残り" + (maxAttempts - count) + "回です");
            
        }

        if(guess != answer){
            System.out.println("ゲームオーバー！");
            System.out.println("正解は" + answer + "でした");
        }

        System.out.println("もう一回やりますか？");
        System.out.println("1:はい");
        System.out.println("2:いいえ");
        System.out.print("選択肢:");

        
        int again = sc.nextInt();

        if(again == 2){
            break;
        }
    }
        sc.close();
    }
}
