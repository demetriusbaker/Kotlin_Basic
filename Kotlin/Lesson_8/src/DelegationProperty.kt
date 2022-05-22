import java.io.File
import kotlin.reflect.KProperty

class ArticleMap {
    private val articleMap = hashMapOf<String, String>()

    fun setArticle(key: String, value: String){
        articleMap[key] = value
    }

    var article: String by articleMap
    var author: String by articleMap
    var description: String by articleMap
}

class ArticleSimple {
    private val delegateSimple = DelegateSimple("article")
    var article: String
        get() = delegateSimple.getValue(this)
        set(value) = delegateSimple.setValue(this, value)

    private val delegateSimple2 = DelegateSimple("description")
    var description: String
        get() = delegateSimple2.getValue(this)
        set(value) = delegateSimple2.setValue(this, value)
}

class DelegateSimple(private var property: String) {
    fun setValue(note: ArticleSimple, noteStr: String){
        File("$property$note.txt").writeText(noteStr)
    }

    fun getValue(note: ArticleSimple): String = File("$property$note.txt").readText()
}

// ****************************************************

class Article {
    var article: String by Delegate()
    var description: String by Delegate()
}

class Delegate {
    operator fun setValue(note: Article, property: KProperty<*>, noteStr: String){
        File("${property.name}$note.txt").writeText(noteStr)
    }

    operator fun getValue(note: Article, property: KProperty<*>): String{
        return File("${property.name}$note.txt").readText()
    }
}