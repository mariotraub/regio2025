package kt.regio.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "title", nullable = false, length = 50)
    val title: String,

    @Column(name = "description", nullable = true, length = 255)
    val description: String?,

    @Column(name = "due_date", nullable = true)
    val dueDate: LocalDate?,

    @Column(name = "status", nullable = false)
    var status: Boolean = false,
)

