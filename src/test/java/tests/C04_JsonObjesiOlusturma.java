package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonObjesiOlusturma {

    /*
                                        JSON OBJECT OLUSTURMA
                    PUT / POST VE PATCH SORGUSU RESPONSE BILGILERININ TEST EDILMESI
                             OTOMASYON ILE PUT / POST VE PATCH SORGUSU YAPMA

              NOT : PUT, POST ve PATCH request’leri yapilirken server’a olusturulmasi /
             degistirilmesini istedigimiz yeni bilgileri gondermek zorundayiz.

             Bunun icin farkli data tipleri ile body olusturulabilir.
             Olusturma kolayligi ve data tiplerini kabul esnekligi acisindan en cok kullanilan body turu Json
             oldugundan biz de ilk basta Json objesi olusturup bunu body olarak request’imize ekleyecegiz.
             Ilerleyen zamanlarda Map, Pojo ve Mapper turunden objeler de olusturup testlerimizde kullanacagiz.

             JSON (Java Script Object Notation) Nedir ?

            {
            "firstname“ : "Eric",
            "lastname“ : "Wilson",
            "totalprice“ : 712,
            "depositpaid“ : false,
            }
            JSON formati JS ile olusturulan web uygulamalarinda data saklamak
            ve uygulamalar arasinda data alisverisi
            yapmak (Request/Response) icin en cok tercih edilen formattir.
            JSON formatindaki bir data icin uc temel bolum vardir.

            1- Suslu parantezler : JSON formatindaki bir datanin nerede baslayip,
             nerede bittigini gosterir. Ihtiyac
            oldugunda NESTED (ic ice) JSON datalari olusturulabilir
            2- Keys : JSON datalari icinde bulunan variable isimleridir.
            3- Values : JSON datalari icinde bulunan variable’lara atanan degerlerdir.
            Keys ve Values arasinda : kullanilir.
            JSON kullandigi key – value yapisi ile Java’dan bildigimiz Map’e cok benzemektedir.

            JSON Vs Map

            API kullaniminda Key – Value yapisi oldugundan en cok kullanilan
            data yapilari Map ve JSONObject’tir.
            Map olusturulurken kullanacagimiz key – value icin
            data turleri belirtilmek zorundadir, ancak JSONObject
            icin data turlerinin belirtilmesine gerek yoktur.
            Map olusturulurken belirttigimiz data turleri disinda data kullandigimizda
            Compile Time Error CTE olusur,
            JSONObject icin data turlerinin bir onemi yoktur dolayisiyla da kullanim acisindan esnektir.




     */
    @Test
    public  void  test01(){

        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":1
            }

         */

        JSONObject obj = new JSONObject();
        obj.put("title","Ahmet");
        obj.put("body","Merhaba");
        obj.put("userId",1);

        System.out.println(obj);
        // {"title":"Ahmet","body":"Merhaba","userId":1}
    }
}
