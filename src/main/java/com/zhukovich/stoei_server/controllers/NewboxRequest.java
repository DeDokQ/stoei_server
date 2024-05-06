package com.zhukovich.stoei_server.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewboxRequest {
    private String title;
    private String sub_title;
    private String main_text;
    private String description;
    private String under;
}

