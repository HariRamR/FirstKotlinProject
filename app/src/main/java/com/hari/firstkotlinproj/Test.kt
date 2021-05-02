package com.hari.firstkotlinproj

class Test (s:String): Test2(), TestInterface{

    private constructor(): this(""){}

    constructor(s1: String, s2:String): this(""){}

    companion object SecondaryConst{ // secondary constructor has no parameters but it is private so to init it we use companion object

        fun create(): Test{
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

    val test: Test = Test.create()

    test.testing()

    val arr = arrayOf("a", "b", "--------", null)
    test.testing(*arr)

    test.sayHi("Hari")

    var s = EnumTest.Easy

    val s1 = when(s){
        EnumTest.Easy -> "Easy"
        EnumTest.MEDIUM -> "MEDIUM"
        EnumTest.Hard -> "Hard"
    }
    test.sayHi(s1)

}