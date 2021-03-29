package com.muttaqin.learning.service;

import com.muttaqin.learning.model.Student;
import com.muttaqin.learning.model.Study;
import com.muttaqin.learning.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {
    @Autowired
    private StudyRepository studyRepository;

    @Override
    public List<Study> findAllStudies() {
        return studyRepository.findAll();
    }

    @Override
    public Study findById(Long id) {
        return studyRepository.findById(id).orElse(new Study());
    }

    @Override
    public Study saveOrUpdate(Study study) {
        return studyRepository.save(study);
    }

    @Override
    public void deleteStudy(Long id) {
        Study study = studyRepository.findById(id).orElse(new Study());
        studyRepository.delete(study);
    }
}
