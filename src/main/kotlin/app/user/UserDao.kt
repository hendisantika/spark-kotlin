package app.user

import java.util.concurrent.atomic.AtomicInteger

class UserDao {

    // "Initialize" with a few users
    // This demonstrates type inference, map-literals and named parameters
    val users = hashMapOf(
            0 to User(name = "Naruto", email = "naruto@konohagakure.com", id = 0),
            1 to User(name = "Sasuke", email = "sasuke@konohagakure.com", id = 1),
            2 to User(name = "Sakura", email = "sakura@konohagakure.com", id = 2),
            3 to User(name = "Kakashi", email = "kakashi@konohagakure.com", id = 3)
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)

    fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users.put(id, User(name = name, email = email, id = id))
    }

    fun findById(id: Int): User? {
        return users[id]
    }

    fun findByEmail(email: String): User? {
        return users.values.find { it.email == email } // == is equivalent to java .equals() (referential equality is checked by ===)
    }

    fun update(id: Int, name: String, email: String) {
        users.put(id, User(name = name, email = email, id = id))
    }

    fun delete(id: Int) {
        users.remove(id)
    }

}