import java.util.Scanner

val scanner = Scanner(System.`in`)
var archives = mutableListOf<Archive>()

fun main() {
    while (true) {
        println("\nДобро пожаловать в приложение <<ЗАМЕТКИ>>\n")
        println("Меню по работе с архивами:\n1. Создать архив\n2. Это уже созданные архивы\n3. Выход")
        val command = readCommand("Введите команду:")

        when (command) {
            1 -> {
                val newArchive = Archive.create(scanner)
                if (newArchive != null) {
                    archives.add(newArchive)
                    println("Архив успешно создан.")
                }
            }

            2 -> {
                val selectedArchive = selectArchive()
                if (selectedArchive != null) {
                    while (true) {
                        println("\nРабота с архивом \"${selectedArchive.name}\":\n1. Создать заметку\n2. Просмотреть заметки\n3. Назад")
                        val subCommand = readCommand("Введите команду:")

                        when (subCommand) {
                            1 -> {
                                val newNote = Note.create(scanner)
                                if (newNote != null) {
                                    selectedArchive.addNote(newNote)
                                }
                            }

                            2 -> selectedArchive.listNotes()
                            3 -> break
                            else -> println("Неверная команда.")
                        }
                    }
                }
            }

            3 -> break

            else -> println("Неправильная команда. Повторите попытку.")
        }
    }

    println("Приложение закрыто.")
}

fun readCommand(prompt: String): Int {
    while (true) {
        println(prompt)
        val input = scanner.nextLine()
        try {
            return input.toInt()
        } catch (_: NumberFormatException) {
            println("Введено некорректное значение. Введите число.")
        }
    }
}

fun selectArchive(): Archive? {
    if (archives.isEmpty()) {
        println("Нет созданных архивов.")
        return null
    }

    println("Выберите архив:")
    for ((index, archive) in archives.withIndex()) {
        println("${index + 1}. ${archive.name}")
    }

    val choice = readCommand("Введите номер архива:")
    if (choice > 0 && choice <= archives.size) {
        return archives[choice - 1]
    } else {
        println("Выбранный номер архива не существует.")
        return null
    }
}
