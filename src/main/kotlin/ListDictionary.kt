import java.io.File

object ListDictionary : IDictionary {
    private val words: MutableList<String> = mutableListOf<String>()

    init {
        println("List Dict")
        File(this::class.java.getResource("dict.txt").file).readLines().forEach { words.add(it) };
    }

    override fun add(item: String): Boolean = words.add(item)

    override fun find(item: String): Boolean = words.contains(item)

    override fun size(): Int = words.size
}