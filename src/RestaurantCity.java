import java.util.ArrayList;
import java.util.List;

public class RestaurantCity {

  public static void main(String[] args) {

    int totalFee = 0;
    Factory factory = new RestaurantStores();

    System.out.println("◆◆　RestaurantCity　◆◆");
    System.out.println("◆◆飲食店街へようこそ◆◆");

    List<String> shopNames = new ArrayList<String>();

    shopNames.add("突然ステーキ");
    shopNames.add("ラーメン四郎");
    shopNames.add("あかまるうどん");

    boolean continueFlg = true;
    while(continueFlg){
    ChoseShop choseShop = new ChoseShop();


    int choseNumber = choseShop.shose(shopNames);
    if(choseNumber == -1) {
      System.out.println("◆◆飲食店街を終了します◆◆\r\n");
      System.out.println("◆◇ 合計利用金額："+totalFee+"円 ◇◆\r\n\r\n");

      break;
    }
    System.out.print("\r\n\r\n");

    String choseName = shopNames.get(choseNumber);

    //お店のクラスを作成
    Restaurant restaurant1 = factory.create(choseName);

    MenuData menuData = new MenuData();
    AdditionalMenuData additionalData = new AdditionalMenuData();
    SelectionMenuData selectionMenuData = new SelectionMenuData();
    switch(choseNumber) {
      case 0:
        menuData.addData("リブロース", 7);
        menuData.addData("ヒレ", 9);
        menuData.addData("国産牛サーロイン", 10);

        selectionMenuData.addData("スープセット", 180);
        selectionMenuData.addData("ライスセット", 200);
        selectionMenuData.addData("サラダセット", 250);
        selectionMenuData.addData("ライル&スモールサラダセット", 350);
        selectionMenuData.addData("スープ&スモールサラダセット", 350);
        selectionMenuData.addData("ライル&スープ&スモールサラダセット", 530);

        totalFee += restaurant1.work(menuData, selectionMenuData);
        break;

      case 1:
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

        totalFee += restaurant1.work(menuData,additionalData);
        break;

      case 2:
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

        totalFee += restaurant1.work(menuData,selectionMenuData,additionalData);
        break;

        default:
          break;
    }
  }
    System.out.println("◆◆　お腹いっぱいになりましたか？　◆◆");
    System.out.println("◆◆またのお越しをお待ちしております◆◆");

  }

}
