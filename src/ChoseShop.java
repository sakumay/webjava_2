import java.util.List;
import java.util.Scanner;

public class ChoseShop {

  public int shose(List<String> shopName) {

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;

    while(continueFlg){
      System.out.println("\r\nお好きな店舗を選び、番号を入力してください\r\n");

      int number = 1;
      for(String showName : shopName) {
        System.out.print(number+"）"+showName+"\r\n");
        number++;
      }
      System.out.print("e）選択を終了する\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }

      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        continueFlg = false;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }

      if(shopName.size() < choseNumber || choseNumber == 0) {
        errorMassageFlg = true;
      }else {
        continueFlg = false;
      }
      }
    }
    return choseNumber-1;

  }

  private static String getInputData() {
    Scanner scan = new Scanner(System.in);
    String input = scan.next();

    if(input.isEmpty()) {
      input = "b";
    }
    return input;
  }

}
