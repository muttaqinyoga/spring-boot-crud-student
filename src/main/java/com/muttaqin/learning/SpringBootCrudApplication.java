package com.muttaqin.learning;

import com.muttaqin.learning.model.Student;
import com.muttaqin.learning.model.Study;
import com.muttaqin.learning.repository.StudentRepository;
import com.muttaqin.learning.repository.StudyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootCrudApplication /*implements CommandLineRunner*/  {
//	private final Logger LOG = LoggerFactory.getLogger(SpringBootCrudApplication.class);
//
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@Autowired
//	private StudyRepository studyRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

//	@Override
//	public void run(String... args){
//		List<Student> students = studentRepository.findAll();
//		LOG.info("Data mahasiswa = "+ students);
//
//		Study s1 = new Study();
//		s1.setNama_jurusan("Teknik Konversi Energi");
//		studyRepository.save(s1);
//
//		Study s2 = new Study();
//		s2.setNama_jurusan("Teknik Komputer");
//		studyRepository.save(s2);
//
//
//		Study study = studyRepository.getOne((long) 1);
//		Student nurtria = new Student();
//		nurtria.setNama_mahasiswa("Nurtria Ningsih");
//		nurtria.setNim("1803108042");
//		nurtria.setAlamat_mahasiswa("Pasar 5b Kec. Hinai");
//		nurtria.setJurusan_id(study);
//		studentRepository.save(nurtria);
//
//		Study study2 = studyRepository.getOne((long) 2);
//		Student yoga = new Student();
//		yoga.setNama_mahasiswa("Muhammad Surya Yoga Muttaqin");
//		yoga.setNim("1605112042");
//		yoga.setAlamat_mahasiswa("Pasar 4 Kec. Hinai");
//		yoga.setJurusan_id(study2);
//		studentRepository.save(yoga);
//	}
}
