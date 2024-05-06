package com.zhukovich.stoei_server.controllers;

import com.zhukovich.stoei_server.services.NewboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class NewboxController {
    private final NewboxService newslettersubService;

//    private final CargoService cargoService;

    @PostMapping("/newCargo")
    public ResponseEntity<?> authenticationResponseResponseEntity(
            @RequestBody NewboxRequest newslettersubRequest
    ) {
        newslettersubService.createCargo(newslettersubRequest);
        return null;
    }
}