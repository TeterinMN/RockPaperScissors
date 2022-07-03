fun main() {
    val options = arrayOf("Камень", "Ножницы", "Бумага")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        println("Введите  ваш выбор: ")
        for (item in optionsParam) println("$item ")
        println(">>")
        val inputUser = readLine()
        if (inputUser != null && inputUser in optionsParam) {
            isValidChoice = true
            userChoice = inputUser
        }
        if (!isValidChoice) println("Введите корректное значение!")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String =
        if (userChoice == gameChoice) "НИЧЬЯ" else if ((userChoice == "Ножницы" && gameChoice == "Бумага") ||
            (userChoice == "Камень" && gameChoice == "Ножницы") || (userChoice == "Бумага" && gameChoice == "Камень")
        ) "ВЫ ПОБЕДИЛИ!!!" else "ВЫ ПРОИГРАЛИ!"
    println("Ваш выбор был: $userChoice, мой выбор: $gameChoice - $result")
}