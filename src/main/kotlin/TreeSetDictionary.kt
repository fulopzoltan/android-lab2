import java.io.File
import java.util.TreeSet

object TreeSetDictionary:IDictionary {
    private val words: TreeSet<String> = TreeSet<String>()

    init {
        println("Tree Dict")
        File(this::class.java.getResource("dict.txt").file).readLines().forEach { words.add(it) };
    }

    override fun add(item: String): Boolean = words.add(item)

    override fun find(item: String): Boolean = words.contains(item)

    override fun size(): Int = words.size
}