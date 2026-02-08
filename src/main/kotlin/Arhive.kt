import java.util.Scanner

data class Arhive(val name: String)

fun createArchive(scanner: Scanner, arhiveList: MutableList<Arhive>) {
    println("Введите название архива: ")
    val name = scanner.nextLine()
    val newArchive = Arhive(name)
    arhiveList.add(newArchive)
    println("Архив успешно создан.")
}

fun viewArchives(arhiveList: List<Arhive>) {
    if (arhiveList.isEmpty()) {
        println("Нет созданных архивов.")
    } else {
        println("Список архивов:")
        for (archive in arhiveList) {
            println("- # ${archive.name} #")
        }
    }
}