package com.zhukovich.stoei_server.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsletterRequest {
    private String title;
    private String description;
    private String under;
    private String uploadDate;
    private String endEvent;
    private String userId;
}
