import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Kazuate{
    
    public static void main(String[] args){
        Kazuate k = new Kazuate();
        int num,ans,count = 1;
        boolean isTrue;
        ans = k.genRandom();
        //debugprint
        //System.out.println("answer:"+ans);
        System.out.println("数当てゲームを開始します,5回以内に当ててください");
        do{
            System.out.println(count+"回目の挑戦");
            System.out.println("2桁の正の数を入力してください");
            num = k.inputNumber();
            isTrue = k.judge(num,ans);
            count++;
        }while(count<6 && isTrue==false);

        if(isTrue==false){
            System.out.println("YOU LOSE!");
        } else{
            System.out.println("YOU WIN!");
        }

    }

    
    //数字を入力する関数
    public int inputNumber() {
		int number;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
            number = Integer.parseInt(line);
            if(9 < number && number < 100){
            } else{
                System.err.println("2桁の正の数を入力してください, もう一度");
                number = inputNumber(); // 再帰呼び出し
            }
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			number = inputNumber(); // 再帰呼び出し
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = inputNumber(); // 再帰呼び出し
		}
		return number;
    }

    //答えとなる数を生成する関数
    public int genRandom() {
        int randam_num;
        Random random = new Random();
        randam_num = random.nextInt(90)+10;
        return randam_num;
    }

    //判定して正解ならtrue,不正解ならfalseを返す関数
    public boolean judge(int input,int ans){
        if(input==ans){
            System.out.println("当たり"); 
            return true;     
        }
        else{
            if(input-ans>0){
                System.out.println("外れ,入力した数字は答えより大きいです。"); 
            }
            else{
                System.out.println("外れ,入力した数字は答えより小さいです。"); 
            }
            //差が20より大きければ表示
            if(Math.abs(ans-input)>20){
                System.out.println("予想した数字と答えの差は20以上あります。");
            }
            return false;
        }
    }
    
}

