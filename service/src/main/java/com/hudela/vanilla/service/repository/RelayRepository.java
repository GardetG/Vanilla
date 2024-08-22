package com.hudela.vanilla.service.repository;

import com.hudela.vanilla.service.domain.Relay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelayRepository extends JpaRepository<Relay, Integer> {

}
