package br.com.rcntech.todolist.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface IUserRepository : JpaRepository<UserModel, UUID> {

    fun findByUsername(username: String) : UserModel?

}