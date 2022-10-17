package com.example.jspWifi.domain;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
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
    private String lat;                 //    "LAT": "126.96675",
    private String lnt;    //    "LNT": "37.561924",
    private String date;    //    "WORK_DTTM": "2022-10-17 10:58:03.0"

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getInstLocation() {
        return instLocation;
    }

    public void setInstLocation(String instLocation) {
        this.instLocation = instLocation;
    }

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getInstAgency() {
        return instAgency;
    }

    public void setInstAgency(String instAgency) {
        this.instAgency = instAgency;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getInstYear() {
        return instYear;
    }

    public void setInstYear(String instYear) {
        this.instYear = instYear;
    }

    public String getInOutType() {
        return inOutType;
    }

    public void setInOutType(String inOutType) {
        this.inOutType = inOutType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLnt() {
        return lnt;
    }

    public void setLnt(String lnt) {
        this.lnt = lnt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
