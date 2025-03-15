package kt.regio.service

import kt.regio.entity.Exercise
import kt.regio.repository.ExerciseRepository
import org.springframework.stereotype.Service

@Service
class ExerciseService(val repository: ExerciseRepository) {
    fun getAll() = (
        repository.findAll()
    )

    fun import(exercises: List<Exercise>) {
        repository.saveAll(exercises)
    }
}