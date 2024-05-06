package com.zhukovich.stoei_server.controllers;

import com.zhukovich.stoei_server.models.Newsletter;
import com.zhukovich.stoei_server.models.Newbox;
import com.zhukovich.stoei_server.repositories.NewsletterRepository;
import com.zhukovich.stoei_server.repositories.NewboxRepository;
import com.zhukovich.stoei_server.services.NewsletterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class NewsletterController {
    private final NewsletterService newsletterService;
    private final NewsletterRepository newsletterRepository;

    private final NewboxRepository newslettersubRepository;

    @PostMapping("/newOrder")
    public ResponseEntity<?> authenticationResponseResponseEntity(
            @RequestBody NewsletterRequest newsletterRequest
    ) {
        newsletterService.createOrder(newsletterRequest);
        return null;
    }

    @GetMapping("/myOrders")
    public ResponseEntity<?> getMyOrder(
            @RequestHeader Long userId
    ) {
        List<Newsletter> newsletters = newsletterRepository.findNewslettersByUserID(userId);

        for (Newsletter newsletter : newsletters) {
            List<Newbox> temp_newssubs = newslettersubRepository.findNewsletter_subsByNewID(newsletter.getId());
            newsletter.setNewssubs(temp_newssubs);
        }

        return ResponseEntity.ok(newsletters);
    }

}

