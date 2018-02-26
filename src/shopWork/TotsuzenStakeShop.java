package shopWork;

import java.util.Scanner;
import productData.MenuData;
import productData.SelectionMenuData;

public class TotsuzenStakeShop extends Shop {

  TotsuzenStakeShop(String shopName) {
    super(shopName);
  }

  @Override
  public int work() {
    // 突然ステーキの処理を記載
    System.out.println("◆◆" + shopName + "へようこそ◆◆");


    MenuData menuData = new MenuData();
    SelectionMenuData selectionMenuData = new SelectionMenuData();

    menuData.addData("リブロース", 7);
    menuData.addData("ヒレ", 9);
    menuData.addData("国産牛サーロイン", 10);

    selectionMenuData.addData("スープセット", 180);
    selectionMenuData.addData("ライスセット", 200);
    selectionMenuData.addData("サラダセット", 250);
    selectionMenuData.addData("ライル&スモールサラダセット", 350);
    selectionMenuData.addData("スープ&スモールサラダセット", 350);
    selectionMenuData.addData("ライル&スープ&スモールサラダセット", 530);

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    int fee = 0;
    int meatFee = 0;

    //肉の種類を確認
    while (continueFlg) {
      System.out.println("\r\nお好きな肉の種類を選び、番号を入力してください\r\n");

      SelectItemPrice selectItem = new SelectItemPrice();
      if(selectItem.select(menuData,errorMassageFlg)) {
        if(selectItem.getPrice() < 0) {
          return 0;
        }else {
          meatFee = selectItem.getPrice();
          continueFlg = false;
        }
      }else {
        errorMassageFlg = true;
      }
    }

    //肉のグラム数を確認
    continueFlg = true;
    errorMassageFlg = false;
    while (continueFlg) {
      System.out.println("◆◆お好みのグラム数をお選びください◆◆");
      if (errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\nグラム数を入力してください　＞ ");
      String input = getInputData();

      try {
        choseNumber = Integer.parseInt(input);
      } catch (NumberFormatException error) {
        errorMassageFlg = true;
      }
      if (0 == choseNumber) {
        errorMassageFlg = true;
      } else {
        continueFlg = false;
        fee += meatFee * choseNumber;
      }
    }

    //セットメニューを確認
    continueFlg = true;
    errorMassageFlg = false;
    while (continueFlg) {
      System.out.println("\r\nお好きなセットメニューを選び、番号を入力してください\r\n");

      SelectItemPrice selectItem = new SelectItemPrice();
      if(selectItem.select(selectionMenuData,errorMassageFlg)) {
        if(selectItem.getPrice() < 0) {
          continueFlg = false;
        }else {
          fee += selectItem.getPrice();
          continueFlg = false;
        }
      }else {
        errorMassageFlg = true;
      }

    }

    //会計
    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("小計　｜" + fee + "円");
    int consumptionTax = (int) (fee * 0.08);
    System.out.println("消費税｜" + consumptionTax + "円");
    System.out.println("合計　｜" + (fee + consumptionTax) + "円");
    System.out.println("となります");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆" + shopName + "へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return fee + consumptionTax;
  }

  private String getInputData() {
    Scanner scan = new Scanner(System.in);
    String input = scan.next();

    if (input.isEmpty()) {
      input = "b";
    }
    return input;
  }

}
