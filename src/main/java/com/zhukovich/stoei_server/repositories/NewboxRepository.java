package com.zhukovich.stoei_server.repositories;

import com.zhukovich.stoei_server.models.Newbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewboxRepository extends JpaRepository<Newbox, Long> {
//    List<Newsletter_sub> findCargosByOrderID(Long id);
    List<Newbox> findNewsletter_subsByNewID(Long id);
}
