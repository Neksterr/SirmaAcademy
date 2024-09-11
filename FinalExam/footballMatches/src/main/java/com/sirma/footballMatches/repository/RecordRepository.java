package com.sirma.footballMatches.repository;

import com.sirma.footballMatches.model.entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Records,Long> {

}
