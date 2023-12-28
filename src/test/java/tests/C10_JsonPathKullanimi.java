package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {
    @Test
    public void test01(){

        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject adresBilgileriObj = new JSONObject();

        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelObj = new JSONObject();
        JSONObject evTelObj = new JSONObject();

        cepTelObj.put("type", "iPhone");
        cepTelObj.put("number", "0123-4567-8888");
        evTelObj.put("type", "home");
        evTelObj.put("number", "0123-4567-8888");
        telefonBilgileriArr.put(cepTelObj);
        telefonBilgileriArr.put(evTelObj);

        adresBilgileriObj.put("streetAddress", "naist street");
        adresBilgileriObj.put("city", "Nara");
        adresBilgileriObj.put("postalCode", "630-0192");

        kisiBilgileriJsonObj.put("firstName", "John");
        kisiBilgileriJsonObj.put("lastName", "doe");
        kisiBilgileriJsonObj.put("age", 26);
        kisiBilgileriJsonObj.put("address",adresBilgileriObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);
    }
}
