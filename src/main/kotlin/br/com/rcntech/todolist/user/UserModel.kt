package br.com.rcntech.todolist.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "tb_users")
class UserModel () {
    @Id
    @GeneratedValue(generator = "UUID")
    lateinit var id: UUID

    @Column(unique = true)
    lateinit var username: String

    lateinit var name: String
    lateinit var password: String

    @CreationTimestamp
    lateinit var createdAt: LocalDateTime
}
