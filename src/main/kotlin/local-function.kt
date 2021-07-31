import java.lang.IllegalArgumentException

data class User(val id: Int, val name: String = "", val address: String = "")

fun main() {
    saveUser(User(1, "kuckjwi", "address~"))
}

fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}
