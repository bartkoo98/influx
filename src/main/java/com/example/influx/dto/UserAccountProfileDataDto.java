package com.example.influx.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserAccountProfileDataDto {
    private String firstName;
    private String lastName;
    private String companyName;
    private String shortDescription;

}
