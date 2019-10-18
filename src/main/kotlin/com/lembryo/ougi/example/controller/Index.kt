package com.lembryo.ougi.example.controller

import com.lembryo.ougi.http.Controller
import com.lembryo.ougi.http.Response

class Index : Controller() {

    // http://localhost/ アクセス時に呼ばれるメソッド
    fun index(): Response {
        return view("index.html")
    }
}
