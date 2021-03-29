package com.muttaqin.learning.controller;

import com.muttaqin.learning.model.Study;
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

@Controller
public class StudyController {

    @Autowired
    private StudyService studyService;

    @GetMapping("/studies")
    public String index(Model model){
        model.addAttribute("studies", studyService.findAllStudies());
        return "studies";
    }
    @GetMapping("/study/create")
    public String create(Study study){
        return "create_study";
    }
    @PostMapping("/study/save")
    public String save(@Valid Study study, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "create_study";
        }
        studyService.saveOrUpdate(study);
        if(study.getId_jurusan()!=null){
            redirectAttributes.addFlashAttribute("message", "Data jurusan berhasil diubah");
        }else{
            redirectAttributes.addFlashAttribute("message", "Jurusan baru berhasil disimpan");
        }

        return "redirect:/studies";
    }
    @GetMapping("/study/{jurusan_id}/edit")
    public String edit(@PathVariable("jurusan_id") Long jurusan_id, Model model)
    {
        Study study = studyService.findById(jurusan_id);
        model.addAttribute("study", study );

        return "create_study";
    }
    @PostMapping("/study/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes)
    {
        studyService.deleteStudy(id);
        redirectAttributes.addFlashAttribute("message", "Jurusan berhasil dihapus");

        return "redirect:/studies";
    }
}
