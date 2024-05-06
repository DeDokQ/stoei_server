package com.zhukovich.stoei_server.services;

import com.zhukovich.stoei_server.controllers.NewsletterRequest;
import com.zhukovich.stoei_server.models.Newsletter;
import com.zhukovich.stoei_server.repositories.NewsletterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class NewsletterService {
    private final NewsletterRepository newsletterRepository;

    public void createOrder(NewsletterRequest request) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        var newOrder = Newsletter.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .under(request.getUnder())
                .uploadDate(LocalDate.parse(request.getUploadDate(), formatter))
                .endEvent(LocalDate.parse(request.getEndEvent(), formatter))
                .userID(Long.parseLong(request.getUserId()))
                .build();

        newsletterRepository.save(newOrder);
    }
}