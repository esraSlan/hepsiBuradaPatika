package tests;


import jdk.jfr.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;


public class SepeteUrunEkleme {

    private static Logger logger = LogManager.getLogger(SepeteUrunEkleme.class);
    HepsiBuradaPage hBPage=new HepsiBuradaPage();




    @Test(priority = 1, description = "Giris Yaparak Urun Secme ve Dogrulama Senaryosu")
    @Description("Giris Yaparak Urun Secme ve Dogrulama Senaryosu")
    public void girisYaparakSepeteUrunEkleme() {

        logger.info("Hepsi Burada anasayfasına gidilir");
        hBPage.anasayfayaGit();
        logger.info("Kullanıcı Bilgileri İle Giriş Yapılır");
        hBPage.login();
        logger.info("Kullanıcı Girişi Yaptığını Doğrular");
        hBPage.girisiDogrula();
        logger.info("İki tane ürün seçilip sepete eklenir");
        hBPage.urunSec();
        logger.info("ürünlerin doğru seçilen ürün oldukları doğrulanır");
        hBPage.urunuDogrula();
        logger.info("Hesaptan Çıkış Yapılır");
        hBPage.cıkısYap();
        logger.info("Windows Kapatılır");
        hBPage.windowsKapat();


    }
    @Test(priority = 2, description = "Giris Yapmadan Urun Secme ve Dogrulama Senaryosu")
    @Description("Giris Yapmadan Urun Secme ve Dogrulama Senaryosu")

    public void girisYapmadanSepeteUrunEkleme() {
        logger.info("Hepsi Burada'ya gidilir");
        hBPage.anasayfayaGit();
        logger.info("Farklı İki Firmadan Aynı Ürün Seçilir");
        hBPage.ıkıUrunSec();
        logger.info("Secilen Urunler Dogrulanır");
        hBPage.secilenIkıUrrunDogrulanır();
        logger.info("Windows Kapatılır");
        hBPage.windowsKapat();





    }
    
}
