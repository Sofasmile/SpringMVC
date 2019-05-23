package net.spring.controller;

import lombok.RequiredArgsConstructor;
import net.spring.entity.Student;
import net.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppController {
    private final StudentService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> listStudents = service.getAllStudents();
        model.addAttribute("listStudents", listStudents);
        return "index";
    }

    @GetMapping("/new")
    public String createNewStudentForm(@Valid Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editStudentForm(@Valid @PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_student");
        Student student = service.getStudentById(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}
