import java.util.Scanner;
public class Game{
    public static void main(String[] args){
        //単語を入力し、その単語を当てる
        //入力
        System.out.print("英単語を入力");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        //1文字ずつ配列に入れる
        char[] charArray = input.toCharArray();

        //答えを入力(繰り返し)
        int hantei = 1;
        while (hantei == 1){
            System.out.print("答えだと思う英単語を入力  文字数は"+charArray.length+"です");
            String answer = sc.next();

            // 文字数チェック
            if (answer.length() != charArray.length) {
                System.out.println("文字数が違います！");
                continue;
            }

            char[] answerchar = answer.toCharArray();
            int sum = 0;

            for (int i = 0 ; i < charArray.length ; i++) {
                if (charArray[i] == answerchar[i]) {
                    sum++;
                }
            }
            System.out.println(sum+"文字合っています");
            if (sum == answerchar.length){
                hantei = 0;
            }
        }
        System.out.println("正解！");

    }
}
