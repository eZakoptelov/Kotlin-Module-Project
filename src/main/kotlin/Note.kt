import java.util.Scanner

data class Note(
    var name: String = "",
    var content: String = ""
)

fun createNote(scanner: Scanner, notesList: MutableList<Note>) {
    println("Введите название заметки: ")
    val noteName = scanner.nextLine()
    println("Введите содержание заметки: ")
    val noteContent = scanner.nextLine()
    notesList.add(Note(noteName, noteContent))
    println("Заметка успешно создана.")
}

fun viewNotes(notesList: List<Note>) {
    if (notesList.isEmpty()) {
        println("Нет созданных заметок.")
    } else {
        println("Список заметок:")
        for (note in notesList) {
            println("Название: ${note.name}\nСодержание: ${note.content}\n")
        }
    }
}
