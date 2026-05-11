import javax.swing.*;

public class NumberGameGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("数字当てゲーム");

        JTextField textField = new JTextField(10);
        JButton button = new JButton("判定");
        JLabel label = new JLabel("1〜100で当ててください");

        int answer = (int)(Math.random() * 100) + 1;

        int[] count = {7};

        frame.setLayout(new java.awt.FlowLayout());

        frame.add(textField);
        frame.add(button);
        frame.add(label);

        button.addActionListener(e -> {
            String input = textField.getText();
            int guess;
            try{
                guess= Integer.parseInt(input);
            } catch (NumberFormatException ex){
                label.setText("数字を入力して下さい!");
                textField.setText("");  //入力リセット
                return; //ここで処理終了
            }

            if (guess < 1 || guess > 100) {
               label.setText("1〜100の間で入力して！");
                textField.setText("");
                return;
            }
            count[0]--;

            if (guess > answer) {
                label.setText("もっと小さい！ 残り" + count[0] + "回");
            } else if (guess < answer) {
                label.setText("もっと大きい！残り" + count[0] + "回");
            } else {
                label.setText("正解！！");
                button.setEnabled(false);
                return;
            }

            if(count[0] == 0){
                label.setText("ゲームオーバー！答えは" + answer);
                button.setEnabled(false);
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}