package kt.regio.controller

import kt.regio.service.ExerciseService
import kt.regio.entity.Exercise
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class ExerciseController(val service: ExerciseService) {
    @GetMapping("/exercises")
    fun getAll(model: Model): String {
        model.addAttribute("exercises", service.getAll())
        return "exercises"
    }

    @PostMapping("/import")
    fun import(@RequestBody exercises: List<Exercise>) {
        service.import(exercises)
    }
}