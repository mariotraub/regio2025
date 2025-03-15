package kt.regio.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.Duration
import java.time.format.DateTimeFormatter


val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")

@Entity
@Table(name = "workout")
data class Workout(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long?,

    @Column(name = "name")
    val name: String,

    @Column(name = "start_time")
    val startTime: LocalDateTime,

    @Column(name = "end_time")
    val endTime: LocalDateTime,
) {
    val duration: Duration
        get() = Duration.between(startTime, endTime)

    val formattedStartTime: String
        get() = startTime.format(formatter)

    val formattedEndTime: String
        get() = endTime.format(formatter)
}
