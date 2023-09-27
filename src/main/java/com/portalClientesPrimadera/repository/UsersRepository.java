package com.portalClientesPrimadera.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.portalClientesPrimadera.model.UsersEntity;





@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Long>{
    @Query("select u from UsersEntity u where u.CP_username = ?1")
    Optional<UsersEntity> getCP_username(String cP_username);
}
