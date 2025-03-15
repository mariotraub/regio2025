package kt.regio.controller;

import kt.regio.entity.Template
import kt.regio.repository.TemplateRepository;
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*

@Controller
class TemplateController(val templateRepository: TemplateRepository) {
    @GetMapping("/templates")
    fun getAllTemplates(model:Model): String {
        model.addAttribute("templates", templateRepository.findAll())
        return "templates"
    }

    @PostMapping("/template")
    fun addTemplate(@ModelAttribute template: Template, model: Model): String {
        templateRepository.save(template)
        model.addAttribute("template", template)
        return "template"
    }

    @GetMapping("/add_template")
    fun addTemplate(): String {
        return "add_template"
    }

    @DeleteMapping("/template/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTemplateById(@PathVariable id: Long) {
        templateRepository.deleteById(id)
    }
}
