package com.lembryo.ougi.controller

import com.lembryo.ougi.http.Controller
import com.lembryo.ougi.http.Response
import com.lembryo.ougi.http.html.view

class Home : Controller() {

    fun index(id: Int, name: String): Response {
        val data = mapOf(
            "id" to id,
            "name" to name)
        return view("index", data)
    }
}