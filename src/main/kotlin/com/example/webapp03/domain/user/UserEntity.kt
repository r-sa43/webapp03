package com.example.webapp03.domain.user

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*

@NoArgsConstructor
@AllArgsConstructor
@Data
class UserEntity {

    var id: Int = 0
    var user_cognito_id: String = ""
    var name: String = ""
    val email: String = ""
    val created_at: Date = Date()
    val updated_at: Date = Date()
}
