package kt.regio.controller

import kt.regio.entity.Workout
import kt.regio.service.WorkoutService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class WorkoutController(val service: WorkoutService) {
    @GetMapping("/")
    fun getAll(model: Model): String {
        model.addAttribute("workouts", service.getAll())
        return "index"
    }

    @DeleteMapping("/workout/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteById(@PathVariable id: Long) {
        service.deleteById(id)
    }

    @PostMapping("/workout")
    fun addWorkout(@ModelAttribute workout: Workout, model: Model): String {
        service.add(workout)
        model.addAttribute("workout", workout)
        return "workout"
    }

    @GetMapping("/add_workout")
    fun addWorkout(model: Model): String {
        return "add_workout"
    }

    @GetMapping("/edit_workout/{id}")
    fun editWorkout(@PathVariable id: Long, model: Model): String {
        val workout = service.getById(id)
        model.addAttribute("workout", workout)
        return "edit_workout"
    }

    @PutMapping("/workout/{id}")
    fun updateWorkout(@ModelAttribute workout: Workout, model: Model): String {
        val workout = service.update(workout)
        model.addAttribute("workout", workout)
        return "workout"
    }

    @GetMapping("/view_workout/{id}")
    fun viewWorkout(@PathVariable id: Long, model: Model): String {
        val workout = service.getById(id)
        model.addAttribute("workout", workout)
        return "view_workout"
    }
}