package com.hari.firstkotlinproj

import android.content.Intent
import com.hari.firstkotlinproj.data.DataClass

class ScopeFunctions {



    fun scopeMethod(){

        // 'let' is used to handle non null block of code
        val sampleData: DataClass?= null
        val sam = sampleData?.let {

            val age =sampleData.age
            val name =sampleData.name
            DataClass(name, age)
        }

        // 'also' is similar to 'let' but used when we need to do something with the result of leftside expression
        val i = (2*3).also {
            it/2
        }

        // apply is used when we want to do lot of changes to a single object returns same object itself
        val intent = Intent().apply {
            putExtra("", "")
            putExtra("", "")
            putExtra("", "")
            action = ""
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }

        // 'run' is similar to apply but return last line as output like 'let'
        val intent1 = Intent().run {
            putExtra("", "")
            putExtra("", "")
            putExtra("", "")
            action = ""
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            this
        }

        //with is also similar to apply but not used often
        val intent2 = with(Intent()) {
            putExtra("", "")
            putExtra("", "")
            putExtra("", "")
            action = ""
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            this
        }
    }

}