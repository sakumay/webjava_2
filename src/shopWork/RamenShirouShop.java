package shopWork;

import productData.AdditionalMenuData;
import productData.MenuData;

public class RamenShirouShop extends Shop {

  RamenShirouShop(String shopName) {
    super(shopName);
  }

  @Override
  public int work() {
    //ラーメン四郎の処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");

    MenuData menuData = new MenuData();
    AdditionalMenuData additionalData = new AdditionalMenuData();

    menuData.addData("小(小ラーメン)", 700);
    menuData.addData("小豚(小ラーメンチャーシュー増し)", 800);
    menuData.addData("大(大ラーメン)", 800);
    menuData.addData("大豚(大ラーメンチャーシュー増し)", 900);

    additionalData.addData("ニンニク", 0);
    additionalData.addData("ヤサイ", 0);
    additionalData.addData("アブラ", 0);
    additionalData.addData("カラメ", 0);
    additionalData.addData("煮玉子", 100);
    additionalData.addData("うずら(5個)", 100);
    additionalData.addData("チーズ", 100);
    additionalData.addData("魚粉", 50);

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    int fee = 0;

    //ラーメンの種類の確認
    while(continueFlg){
      System.out.println("\r\nお好きなラーメンの種類を選び、番号を入力してください\r\n");

      SelectItemPrice selectItem = new SelectItemPrice();
      if(selectItem.select(menuData,errorMassageFlg)) {
        if(selectItem.getPrice() < 0) {
          return 0;
        }else {
          fee += selectItem.getPrice();
          continueFlg = false;
        }
      }else {
        errorMassageFlg = true;
      }
    }

    //トッピングの確認
    continueFlg = true;
    errorMassageFlg = false;
    while(continueFlg){
      System.out.println("\r\nお好きなトッピングを選び、番号を入力してください\r\n");

      SelectItemPrice selectItem = new SelectItemPrice();
      if(selectItem.select(additionalData,errorMassageFlg)) {
        if(selectItem.getPrice() < 0) {
          continueFlg = false;
        }else {
          fee += selectItem.getPrice();
          errorMassageFlg = false;
        }
      }else {
        errorMassageFlg = true;
      }

    }

    //会計
    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("合計（税込）｜"+fee+"円");
    System.out.println("となります");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆"+shopName+"へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return fee;
  }
}
