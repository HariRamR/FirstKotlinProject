package com.hari.firstkotlinproj

import com.hari.firstkotlinproj.data.DataClass
import com.hari.firstkotlinproj.object_cass.User
import java.util.*

class Test (s:String): Test2(), TestInterface{

    private constructor(): this(""){}

    constructor(s1: String, s2:String): this(""){}

    companion object SecondaryConst{ // secondary constructor has no parameters but it is private so to init it we use companion object

        fun create(): Test{ // factory method
            return Test()
        }
    }

    override fun testing(vararg string: String?){
        
        val s: String? = null; // nullable
//        println(s)

        mutableListOf("hghg*s", "e", "--------", null)
            .filterNotNull()
//            .filter{ it.contains("*") }
            .forEach{str->
                when(str){
                    "e" -> println("its $str")
                    "hghg*s" -> println("its $str")
                }
            }

        val map = mapOf("a" to "no", "b" to 2, 2 to "yes", "end" to "--------")
        map.forEach{ (k, v) -> println(" $k, $v")
        }

        string.forEach {
            str-> println(str)
        }
    }

    override fun sayHi(s: String) {

        println("$s Hi --------")
    }
}

fun main(){

//    val test: Test = Test.create()

    /*val test: Test = Test.create()

    test.testing()

    val arr = arrayOf("a", "b", "--------", null)
    test.testing(*arr) // will send a, b, ---------, null -> all values as single vararg type

    test.sayHi("Hari")

    //enum
    var s = EnumTest.Easy

    val s1 = when(s){
        EnumTest.Easy -> "Easy"
        EnumTest.MEDIUM -> "MEDIUM"
        EnumTest.Hard -> "Hard"
    }
    test.sayHi(s1)

    for(ins in 2..10 step 2){

        println(ins)
    }
    for(ins in 10 downTo 2 step 2){

        println(ins)
    }

    println(BuildConfig.KEY_VALUE)*/

    // data class
    /*val dataClass: DataClass = DataClass("Hari", 10)
    println("Age of ${dataClass.name} is ${dataClass.age}")*/

    //object class
//    User.printObject("Hari", 11)

    // Sealed class
    /*val value = SealedClassEx.getOutput("success")
    when(value){
        is SealedClassEx.Error -> println(value.error)
        is SealedClassEx.Success -> println(value.data)
        SealedClassEx.Loading -> Unit
    }*/

    /*var j = 2; //4
    var currentNo = 0; //6
    for (i in 1..6){
//        println((i*(i+1))/2)
        if(i > 1){
            currentNo += j
            j++
        }else{
            currentNo = 1
        }
        println(currentNo) //1,3,6,10, 15
    }*/

    val str = "welcome to ".lowercase(Locale.getDefault())
    println(str capitalized "my repo")

}

infix fun String.capitalized(destination: String): String =
     this.replaceFirstChar {
            ch-> if(ch.isLowerCase()){
        ch.titlecase(Locale.getDefault())
    }else this
    } + destination


