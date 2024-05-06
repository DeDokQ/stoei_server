package com.zhukovich.stoei_server.repositories;

import com.zhukovich.stoei_server.models.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
//    List<Newsletter> findOrdersByUserID(Long id);
    List<Newsletter> findNewslettersByUserID(Long id);
}