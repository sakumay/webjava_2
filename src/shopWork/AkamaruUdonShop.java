package shopWork;

import productData.AdditionalMenuData;
import productData.MenuData;
import productData.SelectionMenuData;

public class AkamaruUdonShop extends Shop {

  AkamaruUdonShop(String shopName) {
    super(shopName);
  }

  @Override
  public int work() {
    //あかまるうどんの処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");

    MenuData menuData = new MenuData();
    AdditionalMenuData additionalData = new AdditionalMenuData();
    SelectionMenuData selectionMenuData = new SelectionMenuData();

    menuData.addData("かけ小", 300);
    menuData.addData("かけ中", 400);
    menuData.addData("かけ大", 500);
    menuData.addData("ざる小", 300);
    menuData.addData("ざる中", 400);
    menuData.addData("ざる大", 500);

    selectionMenuData.addData("かま玉", 0);
    selectionMenuData.addData("明太おろし", 0);
    selectionMenuData.addData("カレーうどん", 130);

    additionalData.addData("コロッケ", 120);
    additionalData.addData("かき揚げ", 140);
    additionalData.addData("鶏の唐揚げ", 100);
    additionalData.addData("ちくわ磯部揚げ", 110);
    additionalData.addData("おにぎり", 120);
    additionalData.addData("おいなり", 100);

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    int fee = 0;

    //うどんの種類を確認
    while(continueFlg){
      System.out.println("\r\nお好きなうどんの種類を選び、番号を入力してください\r\n");

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

    //うどんのお好みを確認
    continueFlg = true;
    errorMassageFlg = false;
    while (continueFlg) {
      System.out.println("\r\nうどんのお好みを選び、番号を入力してください\r\n");

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

    //追加メニューの確認
    continueFlg = true;
    errorMassageFlg = false;
    while(continueFlg){
      System.out.println("\r\nお好きな追加メニューを選び、番号を入力してください\r\n");

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
    System.out.println("小計　｜"+fee+"円");
    int consumptionTax = (int)(fee * 0.08);
    System.out.println("消費税｜"+consumptionTax+"円");
    System.out.println("合計　｜"+(fee+consumptionTax)+"円");
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
