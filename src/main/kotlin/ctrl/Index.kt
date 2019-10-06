package ctrl

import com.lembryo.ougi.http.Response
import com.lembryo.ougi.http.default.Controller

class Index : Controller() {

    // http://localhost/ アクセス時に呼ばれるメソッド
    fun index(): Response {
        return view("index.html")
    }
}
