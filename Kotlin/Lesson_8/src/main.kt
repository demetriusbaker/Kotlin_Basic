fun main(){
    val car = MyCar()
    car.move()
    car.stop()
    car.turn(EDiraction.LEFT)

    println()

    val car2 = DelegationCar()
    car2.move()
    car2.stop()
    car2.turn(EDiraction.RIGHT)

    println()

    val car3 = DelegationCar2()
    car3.move()
    car3.stop()
    car3.turn(EDiraction.LEFT)

    println()

    val delegationMap = DelegationMap()
    delegationMap.put("first", 1)
    delegationMap.put("second", 2)
    delegationMap.put("third", 3)

    println("size = ${delegationMap.size}")
    println("get first = ${delegationMap["first"]}")
    println("size = ${delegationMap.size}")
    println("temp = ${delegationMap.tempPair}")

    println()

    val articleMap = ArticleMap()
    articleMap.setArticle("article", "article..................")
    articleMap.setArticle("author", "Jim, Bob.................")
    articleMap.setArticle("description", "description..........")
    println(articleMap.article)
    println(articleMap.author)
    println(articleMap.description)

    println()

    val note = ArticleSimple()
    note.article = "article"
    note.description = "description"
    println("Article: ${note.article}, description: ${note.description}")

    val note2 = ArticleSimple()
    note2.article = "article2"
    note2.description = "description2"
    println("Article: ${note2.article}, description: ${note2.description}")

    val note3 = ArticleSimple()
    note3.article = "article3"
    note3.description = "description3"
    println("Article: ${note3.article}, description: ${note3.description}")

    println()

    val note4 = ArticleSimple()
    note4.article = "article"
    note4.description = "description"
    println("Article: ${note4.article}, description: ${note4.description}")

    val note5 = ArticleSimple()
    note5.article = "article2"
    note5.description = "description2"
    println("Article: ${note5.article}, description: ${note5.description}")

    val note6 = ArticleSimple()
    note6.article = "article3"
    note6.description = "description3"
    println("Article: ${note6.article}, description: ${note6.description}")

    println()

    createFile()
    val articleLazy = ArticleLazy()
    println(articleLazy.article)
    val articleLazyKotlin = ArticleLazyKotlin()
    println(articleLazyKotlin.article)
}