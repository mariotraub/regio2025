package kt.regio.service

import kt.regio.entity.Workout
import kt.regio.repository.WorkoutRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class WorkoutService(val repository: WorkoutRepository) {
    fun getAll(): List<Workout> = repository.findAll()

    fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    fun add(workout: Workout): Workout {
        return repository.save(workout)
    }

    fun getById(id: Long): Workout {
        return repository.findById(id).get()
    }

    fun update(workout: Workout): Workout {
        return repository.save(workout)
    }
}