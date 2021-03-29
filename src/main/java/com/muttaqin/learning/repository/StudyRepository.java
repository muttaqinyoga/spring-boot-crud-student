package com.muttaqin.learning.repository;

import com.muttaqin.learning.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
