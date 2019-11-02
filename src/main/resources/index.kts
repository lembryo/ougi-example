import com.lembryo.ougi.http.html.*

/*
 * Renderer.html の第2引数に渡した Map の内容が bindings にバインドされている
 * mapOf("title" to "タイトル") は bindings["title"] に "タイトル" が入る
 * オブジェクトインスタンスを渡した場合はキャストする
 */
val title = bindings["title"]
val data = bindings["data"] as Map<String, String>

// データをテーブル内のタグに変換する
val elements = mutableListOf<Tags>()
data.map {
    val datetime = it.key
    val text = it.value
    elements.add(element = Tr(elements = arrayOf(
        Td(element = Text(datetime)),
        Td(element = Text(text))
    )))
}

// ヘッダ部分を作成
val head =
    Head(elements = arrayOf(
        Meta(mapOf("charset" to "UTF-8")),
        Title(
            element = Text(title)
        ),
        Link(attributes = mapOf(
            "href" to "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css",
            "rel" to "stylesheet"
        ))
    ))

// ボディ部分を作成
val table = arrayOf<Tags>(
    Table(
        attributes = mapOf("class" to "table table-striped table-sm"),
        elements = arrayOf(
            Thead(attributes = mapOf("class" to "text-center"), element = Tr(elements = arrayOf(
                Td(element = Text("日付")),
                Td(element = Text("テキスト"))
            ))),
            Tbody(attributes = mapOf("class" to "text-center"), elements = elements.toTypedArray())
        )
    )
)

val body = arrayOf<Tags>(
    Div(attributes = mapOf("class" to "container"), elements = arrayOf(
        Div(attributes = mapOf("class" to "container"), elements = table)
    ))
)

// スクリプト部分を作成
val script = arrayOf(
    Script(attributes = mapOf(
        "src" to "https://code.jquery.com/jquery-3.3.1.slim.min.js"
    )),
    Script(attributes = mapOf(
        "src" to "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    )),
    Script(attributes = mapOf(
        "src" to "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    ))
)

// HTML作成部分
Html(mapOf("lang" to "ja"), elements = arrayOf(
    head,
    Body(elements = body.plus(script))
))
