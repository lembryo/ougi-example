import com.lembryo.ougi.http.WebServer
import com.lembryo.ougi.http.default.ParamsMiddleware
import com.lembryo.ougi.http.default.ResponseMiddleware
import com.lembryo.ougi.http.default.RoutingMiddleware
import com.lembryo.ougi.http.html.Renderer

fun main(argv: Array<String>) {

    val app = WebServer(8080) // 組み込みのウェブサーバーを生成する

    app.use(ParamsMiddleware()) // GET / POST のパラメータを解析
    app.use(ResponseMiddleware()) // レスポンスに Date や Content-Length などを付加
    app.use(RoutingMiddleware {
        get {
            // HTMLレンダラに渡すデータを作成
            val bindings = mutableMapOf<String, Any>()
            bindings["title"] = "リスト"
            bindings["data"] = mapOf(
                "2019/11/02" to "昨日",
                "2019/11/03" to "今日",
                "2019/11/04" to "明日",
                "2019/11/05" to "明後日"
            )
            // レンダリング
            Renderer.html("index.kts", bindings)
        }
    })

    app.run() // サーバーを実行
}
