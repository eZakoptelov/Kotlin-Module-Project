import java.util.Scanner

class Archive(val name: String, val notes: MutableList<Note> = mutableListOf()) {

    fun addNote(note: Note) {
        this.notes.add(note)
        println("Заметка успешно добавлена в архив.")
    }

    fun listNotes() {
        if (this.notes.isEmpty()) {
            println("В данном архиве нет заметок.")
        } else {
            println("Список заметок архива \"$name\":")
            for ((index, note) in this.notes.withIndex()) {
                println("${index + 1}. Название: ${note.name}\n Содержание: ${note.content}")
            }
        }
    }

    companion object {
        fun create(scanner: Scanner): Archive? {
            println("Введите название архива:")
            val name = scanner.nextLine().trim()
            if (name.isBlank()) {
                println("Ошибка: Название архива не может быть пустым.")
                return null
            }
            return Archive(name)
        }
    }
}