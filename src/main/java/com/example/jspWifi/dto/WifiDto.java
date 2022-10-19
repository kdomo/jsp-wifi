package com.example.jspWifi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class WifiDto {
    private String no;
    private String gu;
    private String name;
    private String address1;
    private String address2;
    private String instLocation;
    private String instType;
    private String instAgency;
    private String serviceType;
    private String networkType;
    private String instYear;
    private String inOutType;
    private String accessType;
    private String x;
    private String y;
    private String date;
    private String distance;
}
