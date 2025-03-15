package kt.regio.entity

import jakarta.persistence.*

@Entity
@Table(name = "template")
data class Template (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String
)
