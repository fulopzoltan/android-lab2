import kotlin.random.Random

fun main() {
    // 1.
//    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)
//    println("Number of words: ${dict.size()}")
//    var word: String?
//    while(true){
//        print("What to find? ")
//        word = readLine()
//        if( word.equals("quit")){
//            break
//        }
//        println("Result: ${word?.let { dict.find(it) }}")
//    }
    //2.
    println("John Doe".monogram())
    println(listOf("apple", "pear", "melon").customSeparator("#"))
    println(listOf("apple", "pear", "melon", "strawberry").longest())
    //3.
    val dates: MutableList<Date> = mutableListOf()
    while (dates.size < 10) {
        val date = Date((1970..2030).random(), (1..12).random(), (1..31).random());
        date.isValid() && dates.add(date)
    }
    dates.forEach { date -> println(date) }
    println("Sorted");
    dates.sort()
    dates.forEach { date -> println(date) }

    println("Reversed");
    dates.reverse()
    dates.forEach { date -> println(date) }

    println("Custom");
    dates.sortWith(DateComparator())
    dates.forEach { date -> println(date) }
}

fun String.monogram() = this.split(" ").map { it[0] }.joinToString("")
fun List<String>.customSeparator(sep: String) = this.joinToString(sep)
fun List<String>.longest() = this.reduce { acc, s -> if (acc.length > s.length) acc else s }

fun Date.isLeapYear(): Boolean = this.year % 4 == 0 || (this.year % 100 == 0 && this.year % 400 == 0)
val months = listOf<Int>(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
fun Date.isValid(): Boolean {
    if (this.month == 2 && this.isLeapYear() && this.day <= 29) return true
    return this.day <= months[month - 1]
}

class DateComparator : Comparator<Date> {
    override fun compare(o1: Date?, o2: Date?): Int {
        if (o1 == null || o2 == null) return 0
        if (o1.day >= o2.day) return 1
        return -1
    }
}