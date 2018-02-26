package userAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import shopWork.Factory;
import shopWork.Shop;
import shopWork.ShopFactory;

public class Eater {
  String shopName;

  protected int choseShop() {

    List<String> shopNames = new ArrayList<String>();

    shopNames.add("突然ステーキ");
    shopNames.add("ラーメン四郎");
    shopNames.add("あかまるうどん");

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    int totalFee = 0;

    while(continueFlg){
      System.out.println("\r\nお好きな店舗を選び、番号を入力してください\r\n");

      //選択肢の表示
      int number = 1;
      for(String showName : shopNames) {
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

        if(shopNames.size() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          //お店を正しく選択した場合
          String choseName = shopNames.get(choseNumber-1);
          Factory factory = new ShopFactory();
          //お店のクラスを作成
          Shop selectShop = factory.create(choseName);
          if (selectShop == null) {

          }else {
            totalFee += selectShop.work();
          }
        }
      }
    }
    return totalFee;
  }

  private static String getInputData() {
    Scanner scan = new Scanner(System.in);
    String input = scan.next();

    if(input.isEmpty()) {
      input = "b";
    }
//    scan.close();
    return input;

  }
}
