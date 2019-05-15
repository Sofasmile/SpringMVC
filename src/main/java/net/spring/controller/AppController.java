package net.spring.controller;

import net.spring.entity.Student;
import net.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private StudentService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Student> listStudents = service.getAllStudents();
        model.addAttribute("listStudents", listStudents);
        return "index";
    }

    @RequestMapping("/new")
    public String createNewStudentForm(@Valid Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editStudentForm(@Valid @PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_student");
        Student student = service.getStudentById(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}
