package kt.regio.repository

import kt.regio.entity.Workout
import org.springframework.data.jpa.repository.JpaRepository

interface WorkoutRepository : JpaRepository<Workout, Long> {
}