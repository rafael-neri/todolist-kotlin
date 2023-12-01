package br.com.rcntech.todolist.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController  {

    @Autowired
    private lateinit var userRepository: IUserRepository

    @GetMapping
    fun create(@RequestBody userModel: UserModel): ResponseEntity<UserModel> {
        val user = this.userRepository.findByUsername(userModel.username)

        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }

        val userCreated = this.userRepository.save(userModel)
        return ResponseEntity.ok(userCreated)
    }

}