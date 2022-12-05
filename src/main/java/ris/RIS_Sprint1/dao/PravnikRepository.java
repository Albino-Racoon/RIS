package ris.RIS_Sprint1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ris.RIS_Sprint1.models.Pravnik;

import java.util.Optional;

@Repository
public interface PravnikRepository extends JpaRepository<Pravnik, Long> {
   // @Query("select p From Pravnik p Where p.email = ?1")
    Optional<Pravnik> findPravnikByEmail(String email);
}


