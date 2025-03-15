package kt.regio.repository

import kt.regio.entity.Template
import org.springframework.data.jpa.repository.JpaRepository

interface TemplateRepository : JpaRepository<Template, Long> {
}