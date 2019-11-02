import com.lembryo.ougi.http.default.*

val head =
    Head(array = arrayOf(
        Meta(mapOf("charset" to "UTF-8")),
        Title(
            element = Text("ougi")
        )
    ))

Html(mapOf("lang" to "ja"), array = arrayOf(
    head,
    Body(element =
        Text("Hello ougi World!")
    )
))
