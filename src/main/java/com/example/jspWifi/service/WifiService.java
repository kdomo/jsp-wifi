package com.example.jspWifi.service;

import com.example.jspWifi.domain.Wifi;
import com.example.jspWifi.repository.WifiRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

public class WifiService {
    private final WifiRepository wifiRepository = new WifiRepository();

    public int saveAll(){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder().create();
        JSONParser parser = new JSONParser();
        ArrayList<Wifi> wifis = new ArrayList<>();
        String url = "http://openapi.seoul.go.kr:8088/564a63736a646f6e38396b78735254/json/TbPublicWifiInfo/1/2/";
        Request wifiRequest = new Request.Builder()
                .url(url)
                .build();

        try (Response wifiRespone = client.newCall(wifiRequest).execute()){
            JSONObject obj = (JSONObject)parser.parse(wifiRespone.body().string());
            JSONObject TbPublicWifiInfo = (JSONObject)obj.get("TbPublicWifiInfo");
            JSONArray items = (JSONArray)TbPublicWifiInfo.get("row");
            int totalCount = Integer.parseInt(TbPublicWifiInfo.get("list_total_count").toString());

            //totalCount / 1000 만큼 반복하면서 진행
            for (int i = 0; i < items.size(); i++) {
                JSONObject item = (JSONObject)items.get(i);
                Wifi wifi = new Wifi();
                wifi.setNo(item.get("X_SWIFI_MGR_NO").toString());
                wifi.setGu(item.get("X_SWIFI_WRDOFC").toString());
                wifi.setName(item.get("X_SWIFI_MAIN_NM").toString());
                wifi.setAddress1(item.get("X_SWIFI_ADRES1").toString());
                wifi.setAddress2(item.get("X_SWIFI_ADRES2").toString());
                wifi.setInstLocation(item.get("X_SWIFI_INSTL_FLOOR").toString());
                wifi.setInstType(item.get("X_SWIFI_INSTL_TY").toString());
                wifi.setInstAgency(item.get("X_SWIFI_INSTL_MBY").toString());
                wifi.setServiceType(item.get("X_SWIFI_SVC_SE").toString());
                wifi.setNetworkType(item.get("X_SWIFI_CMCWR").toString());
                wifi.setInstYear(item.get("X_SWIFI_CNSTC_YEAR").toString());
                wifi.setInOutType(item.get("X_SWIFI_INOUT_DOOR").toString());
                wifi.setAccessType(item.get("X_SWIFI_REMARS3").toString());
                wifi.setLat(item.get("LAT").toString());
                wifi.setLnt(item.get("LNT").toString());
                wifi.setDate(item.get("WORK_DTTM").toString());
                wifis.add(wifi);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return wifiRepository.saveAll(wifis);
    }
}
