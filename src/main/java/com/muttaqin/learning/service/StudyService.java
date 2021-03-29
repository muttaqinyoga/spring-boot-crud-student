package com.muttaqin.learning.service;

import com.muttaqin.learning.model.Study;

import java.util.List;

public interface StudyService {
    List<Study> findAllStudies();
    Study findById(Long id);
    Study saveOrUpdate(Study study);
    void deleteStudy(Long id);
}
