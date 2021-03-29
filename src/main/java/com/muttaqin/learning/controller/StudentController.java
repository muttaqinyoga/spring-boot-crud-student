package com.muttaqin.learning.controller;


import com.muttaqin.learning.model.Student;
import com.muttaqin.learning.model.Study;
import com.muttaqin.learning.service.StudentService;
import com.muttaqin.learning.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudyService studyService;

    @GetMapping("/students")
    public String index(Model model){
        model.addAttribute("students", studentService.findAllStudents());
        return "students";
    }
    @GetMapping("/student/create")
    public String create(Student student, Model model){
        List<Study> studies = studyService.findAllStudies();
        model.addAttribute("studies", studies);
        return "student_form";
    }
    @PostMapping("/student/save")
    public String save(@Valid Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                       Model model){
        if(bindingResult.hasErrors()){
            List<Study> studies = studyService.findAllStudies();
            model.addAttribute("studies", studies);
            return "student_form";
        }
        studentService.saveOrUpdateStudent(student);
        if(student.getId_mahasiswa()!=null){
            redirectAttributes.addFlashAttribute("message", "Data mahasiswa berhasil diubah");
        } else{
            redirectAttributes.addFlashAttribute("message", "Mahasiswa baru berhasil ditambah");
        }
     return "redirect:/students";
    }
    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        List<Study> studies = studyService.findAllStudies();
        model.addAttribute("studies", studies);
        return "student_form";
    }
    @PostMapping("/student/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        studentService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("message", "Mahasiswa berhasil dihapus");

        return "redirect:/students";
    }
}
