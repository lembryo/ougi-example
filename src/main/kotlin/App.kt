package com.lembryo.ougi

import com.lembryo.ougi.controller.Home
import com.lembryo.ougi.http.WebServer
import com.lembryo.ougi.http.default.ParamsMiddleware
import com.lembryo.ougi.http.default.ResponseMiddleware
import com.lembryo.ougi.http.default.RoutingMiddleware
import com.lembryo.ougi.http.default.SessionMiddleware
import com.lembryo.ougi.http.html.view

fun main(argv: Array<String>) {

    // 組み込みのウェブサーバーを作成（デフォルトのポートは9801）
    val app = WebServer()

    // 必要なミドルウェアを組み込む
    app.middleware(
        arrayOf(
            ParamsMiddleware(), // 受け取った GET / POST のパラメータ解析用のミドルウェア
            ResponseMiddleware(), // レスポンスに日付やデータサイズを付加するミドルウェア
            SessionMiddleware(), // セッション管理を行うミドルウェア（ファイルベース）
            RoutingMiddleware() // アクセスされたURIに対して必要な関数呼び出しやクラスメソッド呼び出しを行うミドルウェア
                    // コールバック関数を指定してルーティングを定義
                    .get("/") {
                        view("index")
                    }
                    // 任意のコントローラクラスと呼び出すメソッドを指定してルーティングを定義
                    .get("/{id: Int}/{name: String}", Home::class.java, "index(id: Int, name: String)")
        )
    )

    // サーバーを実行
    app.run()
}