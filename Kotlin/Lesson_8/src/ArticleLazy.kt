import java.io.File

class ArticleLazy {
    private var _article: String? = null
    val article: String
        get() {
            if (_article == null)
                _article = getTextFromFile()
            return _article!!
        }
}

fun createFile(){
    File("delegation.txt").writeText("Delegation is the ass..")
}

fun getTextFromFile(): String {
    return File("delegation.txt").readText()
}

class ArticleLazyKotlin {
    val article by lazy {getTextFromFile()}
}