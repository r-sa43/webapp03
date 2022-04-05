package com.example.webapp03.domain.user

import java.util.*

class UserEntity {

    var id: Int = 0
    var password: String = ""
    var userCognitoId: String = ""
    var name: String = ""
    val email: String = ""
    val createdAt: Date = Date()
    val updatedAt: Date = Date()
}
