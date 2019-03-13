package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DeveloperController{

    var developers = mutableListOf<Developer>()
    
    @Value("\${VERSION}")
    val version: String

    @GetMapping("/developers")
    fun list():List<Developer>{
        return developers
    }

    @PostMapping("/developers")
    fun create(@RequestBody developer: Developer):String
    {
        developers.add(developer)
        return "created from version $version"
    }
}

data class Developer(val id:String, val name:String)
