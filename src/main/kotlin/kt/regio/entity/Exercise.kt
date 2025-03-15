package kt.regio.entity

import jakarta.persistence.*

@Entity
@Table(name = "exercise")
data class Exercise (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "type")
    val type: String,
)