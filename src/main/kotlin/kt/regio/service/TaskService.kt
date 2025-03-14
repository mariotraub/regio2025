package kt.regio.service

import kt.regio.entity.Task
import kt.regio.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(val repository: TaskRepository) {

    fun getById(id: Long) = repository.findById(id).get()

    fun getAll(): List<Task> {
        return repository.findAll()
    }

    fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    fun update(task: Task): Task {
        return repository.save(task)
    }

    fun toggle(id: Long): Task {
        val task = repository.findById(id).get()
        return repository.save(task.copy(status = !task.status))
    }

    fun add(task: Task): Task {
        return repository.save(task)
    }
}