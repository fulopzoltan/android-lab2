import java.io.File
import kotlin.collections.HashSet

object HashSetDictionary: IDictionary {
    private val words: HashSet<String> = HashSet<String>()

    init {
        println("Tree Dict")
        File(this::class.java.getResource("dict.txt").file).readLines().forEach { words.add(it) };
    }

    override fun add(item: String): Boolean = words.add(item)

    override fun find(item: String): Boolean = words.contains(item)

    override fun size(): Int = words.size
}