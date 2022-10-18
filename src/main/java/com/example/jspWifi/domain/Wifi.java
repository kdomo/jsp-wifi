package com.example.jspWifi.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Wifi {
    private String no;          //    X_SWIFI_MGR_NO": "ARI00001",
    private String gu;          //    "X_SWIFI_WRDOFC": "서대문구",
    private String name;        //    "X_SWIFI_MAIN_NM": "상수도사업본부",
    private String address1;    //    "X_SWIFI_ADRES1": "서소문로 51",
    private String address2;    //    "X_SWIFI_ADRES2": "본관 1F",
    private String instLocation; //    "X_SWIFI_INSTL_FLOOR": "",
    private String instType;            //    "X_SWIFI_INSTL_TY": "7-1. 공공 - 행정",
    private String instAgency;           //    "X_SWIFI_INSTL_MBY": "서울시(AP)",
    private String serviceType;         //    "X_SWIFI_SVC_SE": "공공WiFi",
    private String networkType;         //    "X_SWIFI_CMCWR": "수도사업소자가망",
    private String instYear;            //    "X_SWIFI_CNSTC_YEAR": "2014",
    private String inOutType;            //    "X_SWIFI_INOUT_DOOR": "실내",
    private String accessType;            //    "X_SWIFI_REMARS3": "",
    private String x;               //  "LNT": "37.561924",
    private String y;           //  "LAT": "126.96675",
    private String date;    //    "WORK_DTTM": "2022-10-17 10:58:03.0"

}
