import java.util.Scanner

fun main() {
    val arhiveList: MutableList<Arhive> = arrayListOf()
    val notesList: MutableList<Note> = mutableListOf()
    val scanner = Scanner(System.`in`)

    while (true) {
        printMenu()

        val command = readCommand(scanner, "Введите команду:")

        when (command) {
            1 -> {
                while (true) {
                    println("1. Создать архив\n2. Посмотреть архивы\n3. Назад")
                    val subCommand = readCommand(scanner, "Введите команду:")

                    when (subCommand) {
                        1 -> createArchive(scanner, arhiveList)
                        2 -> viewArchives(arhiveList)
                        3 -> break
                        else -> println("Неверное число. Введите корректное число :")
                    }
                }
            }

            2 -> {
                while (true) {
                    println("1. Создать заметку\n2. Посмотреть заметки\n3. Назад")
                    val subCommand = readCommand(scanner, "Введите команду :")

                    when (subCommand) {
                        1 -> createNote(scanner, notesList)
                        2 -> viewNotes(notesList)
                        3 -> break
                        else -> println("Неверное число. Введите корректное число:")
                    }
                }
            }

            3 -> break
            else -> println("Такое число не существует. Введите корректное число :")
        }
    }
}

fun printMenu() {
    println(
        """
        Меню:
        1. Архив
        2. Заметки
        3. Выход
    """.trimIndent()
    )
}


private fun readCommand(scanner: Scanner, messageCommand: String): Int {
    while (true) {
        println(messageCommand)
        val input = scanner.nextLine().trim()
        try {
            return input.toInt()
        } catch (_: NumberFormatException) {
            println("Вы ввели не число. Пожалуйста введите число.")
        }
    }
}