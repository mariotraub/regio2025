package kt.regio.controller

import kt.regio.entity.Task
import kt.regio.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class TaskController(val service: TaskService) {

    @GetMapping("/")
    fun getAll(model: Model): String {
        model.addAttribute("tasks", service.getAll())
        return "index"
    }

    @PostMapping("/")
    fun addTask(@ModelAttribute task: Task, model: Model): String {
        service.add(task)
        model.addAttribute("task", task)
        return "task"
    }

    @PutMapping("/toggle/{id}")
    fun toggleTask(@PathVariable id: Long, model: Model): String {
        val task = service.toggle(id)

        model.addAttribute("task", task)
        return "task"
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTask(@PathVariable id: Long) {
        service.deleteById(id)
    }

    @PutMapping("/update/{id}")
    fun updateTask(@ModelAttribute task: Task, model: Model): String {
        val task = service.update(task)

        model.addAttribute("task", task)
        return "task"
    }

    @GetMapping("/edit/{id}")
    fun editTask(@PathVariable id: Long, model: Model): String {
        val task = service.getById(id)
        model.addAttribute("task", task)
        return "edit"
    }

    @GetMapping("/task/{id}")
    fun getTaskById(@PathVariable id: Long, model: Model): String {
        val task = service.getById(id)

        model.addAttribute("task", task)
        return "task"
    }
}