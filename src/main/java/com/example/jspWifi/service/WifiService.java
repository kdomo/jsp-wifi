package com.example.jspWifi.service;

import com.example.jspWifi.domain.Wifi;
import com.example.jspWifi.repository.WifiRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class WifiService {
    private final WifiRepository wifiRepository = new WifiRepository();

    public int saveAll() {

        int totalCount = getContentSize();
        int saveCount = 0;
        for (int i = 0; i < ((totalCount / 1000) + 1) * 1000; i += 1000) {
            OkHttpClient client = new OkHttpClient();
            int start = i;
            int end = i + 999;
            JSONParser parser = new JSONParser();
            ArrayList<Wifi> wifis = new ArrayList<>();
            String url = "http://openapi.seoul.go.kr:8088/564a63736a646f6e38396b78735254/json/TbPublicWifiInfo/" + start + "/" + end + "/";
            Request wifiRequest = new Request.Builder()
                    .url(url)
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .build();
            try {
                Response wifiRespone = client.newCall(wifiRequest).execute();
                JSONObject obj = (JSONObject) parser.parse(wifiRespone.body().string());
                JSONObject TbPublicWifiInfo = (JSONObject) obj.get("TbPublicWifiInfo");
                JSONArray items = (JSONArray) TbPublicWifiInfo.get("row");
                for (int j = 0; j < items.size(); j++) {
                    JSONObject item = (JSONObject) items.get(j);
                    Wifi wifi = Wifi.builder()
                            .no(item.get("X_SWIFI_MGR_NO").toString())
                            .gu(item.get("X_SWIFI_WRDOFC").toString())
                            .name(item.get("X_SWIFI_MAIN_NM").toString())
                            .address1(item.get("X_SWIFI_ADRES1").toString())
                            .address2(item.get("X_SWIFI_ADRES2").toString())
                            .instLocation(item.get("X_SWIFI_INSTL_FLOOR").toString())
                            .instType(item.get("X_SWIFI_INSTL_TY").toString())
                            .instAgency(item.get("X_SWIFI_INSTL_MBY").toString())
                            .serviceType(item.get("X_SWIFI_SVC_SE").toString())
                            .networkType(item.get("X_SWIFI_CMCWR").toString())
                            .instYear(item.get("X_SWIFI_CNSTC_YEAR").toString())
                            .inOutType(item.get("X_SWIFI_INOUT_DOOR").toString())
                            .accessType(item.get("X_SWIFI_REMARS3").toString())
                            .lat(item.get("LAT").toString())
                            .lnt(item.get("LNT").toString())
                            .date(item.get("WORK_DTTM").toString())
                            .build();
                    wifis.add(wifi);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return saveCount;
            }
            saveCount += wifiRepository.saveAll(wifis);
            wifis.clear();
        }
        return saveCount;
    }

    public int getContentSize() {
        OkHttpClient client = new OkHttpClient();
        Response wifiRespone = null;
        Gson gson = new GsonBuilder().create();
        JSONParser parser = new JSONParser();
        ArrayList<Wifi> wifis = new ArrayList<>();
        Request wifiRequest = null;
        int totalCount = -1;
        String url = "http://openapi.seoul.go.kr:8088/564a63736a646f6e38396b78735254/json/TbPublicWifiInfo/0/1/";
        wifiRequest = new Request.Builder()
                .url(url)
                .build();

        try {
            wifiRespone = client.newCall(wifiRequest).execute();
            JSONObject obj = (JSONObject) parser.parse(wifiRespone.body().string());
            JSONObject TbPublicWifiInfo = (JSONObject) obj.get("TbPublicWifiInfo");
            totalCount = Integer.parseInt(TbPublicWifiInfo.get("list_total_count").toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (wifiRespone != null) {
                wifiRespone.close();
            }
        }
        return totalCount;
    }

}
