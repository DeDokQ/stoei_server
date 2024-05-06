package com.zhukovich.stoei_server.services;

import com.zhukovich.stoei_server.controllers.NewboxRequest;
import com.zhukovich.stoei_server.models.Newsletter;
import com.zhukovich.stoei_server.models.Newbox;
import com.zhukovich.stoei_server.repositories.NewsletterRepository;
import com.zhukovich.stoei_server.repositories.NewboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewboxService {
    private final NewboxRepository newslettersubRepository;
    private final NewsletterRepository newsletterRepository;

    public void createCargo(NewboxRequest request) {
        List<Newsletter> test = newsletterRepository.findAll();
        Long newLastId = test.get(test.size() - 1).getId();

        var newCargo = Newbox.builder()
                .title(request.getTitle())
                .sub_title(request.getSub_title())
                .main_text(request.getMain_text())
                .description(request.getDescription())
                .under(request.getUnder())
                .newID(newLastId)
                .build();
        newslettersubRepository.save(newCargo);
    }
}