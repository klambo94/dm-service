package com.klambo94.dm_service.repositories;

import com.klambo94.dm_service.domain.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
// see https://www.digitalocean.com/community/tutorials/jpa-entitymanager-hibernate to use hibernate
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public List<Integer> fetchPlayersPassWisdomInCampaign(Long campaignId){
//
//    }
}
