package com.example.webapp03.domain.user

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*

@NoArgsConstructor
@AllArgsConstructor
@Data
class UserEntity {

    var id: Int
    var user_cognito_id: String
    var name: String
    val email: String
    val created_at: Date
    val updated_at: Date

    init {
        id = 0
        user_cognito_id = ""
        name = ""
        email = ""
        created_at = Date()
        updated_at = Date()
    }
}