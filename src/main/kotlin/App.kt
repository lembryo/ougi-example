import com.lembryo.ougi.http.WebServer
import com.lembryo.ougi.http.default.ParamsMiddleware
import com.lembryo.ougi.http.default.Renderer
import com.lembryo.ougi.http.default.ResponseMiddleware
import com.lembryo.ougi.http.default.RoutingMiddleware

fun main(argv: Array<String>) {

    val app = WebServer(8080) // 組み込みのウェブサーバーを生成する

    app.use(ParamsMiddleware()) // GET / POST のパラメータを解析
    app.use(ResponseMiddleware()) // レスポンスに Date や Content-Length などを付加
    app.use(RoutingMiddleware {
        get {
            Renderer.html("index.kts")
        }
    })

    app.run() // サーバーを実行
}
