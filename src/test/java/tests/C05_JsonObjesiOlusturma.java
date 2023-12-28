package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonObjesiOlusturma {

    @Test
    public void test01(){
        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":{
                      "checkin":"2018-01-01",
                      "checkout":"2019-01-01"
                        },
        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown"
        }
         */
        // objeler innerdan outher ea doğru objeler oluştulmalı

        JSONObject objInner = new JSONObject();
        objInner.put("checkin","2018-01-01");
        objInner.put("checkout","2019-01-01");

        JSONObject objOut = new JSONObject();
        objOut.put("firstname","Jim");
        objOut.put("additionalneeds","Breakfast");
        objOut.put("bookingdates",objInner);
        objOut.put("totalprice",111);
        objOut.put("depositpaid",true);
        objOut.put("lastname","Brown");

        System.out.println(objOut);
        // {"firstname":"Jim",
        // "additionalneeds":"Breakfast",
        // "bookingdates":
        //                 {
        //                 "checkin":"2018-01-01",
        //                 "checkout":"2019-01-01"
        //                 },
        // "totalprice":111,
        // "depositpaid":true,
        // "lastname":"Brown"}
    }
}
