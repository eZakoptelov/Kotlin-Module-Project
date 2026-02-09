import java.util.Scanner

data class Note(var name: String = "", var content: String = "") {
    companion object {
        fun create(scanner: Scanner): Note? {
            println("Введите название заметки:")
            val title = scanner.nextLine()
            if (title.isBlank()) {
                println("Ошибка: Название заметки не может быть пустым!")
                return null
            }

            println("Введите содержание заметки:")
            val content = scanner.nextLine()
            if (content.isBlank()) {
                println("Ошибка: Содержание заметки не может быть пустым!")
                return null
            }

            return Note(title, content)
        }
    }
}