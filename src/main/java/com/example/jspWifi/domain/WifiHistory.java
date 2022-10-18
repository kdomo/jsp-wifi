package com.example.jspWifi.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WifiHistory {
    private Long id;
    private String x;
    private String y;
    private String date;
}
