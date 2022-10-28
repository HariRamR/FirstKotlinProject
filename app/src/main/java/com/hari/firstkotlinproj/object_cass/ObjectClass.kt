package com.hari.firstkotlinproj.object_cass

object User{
    val name: String = ""
    var age:Int = 0 // properties must be initialized

    fun printObject(name:String, age:Int){
        println("Age of $name is $age")
    }
}