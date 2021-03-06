package com.husaynhakeem.second_dependency

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.husaynhakeem.first_dependency.Initializer1A

class Initializer2B : Initializer<Initializer2B.Dependency> {

    override fun create(context: Context): Dependency {
        Log.d(TAG, "Initializer2B#create()")
        return Dependency()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(Initializer2A::class.java, Initializer1A::class.java)
    }

    companion object {
        private const val TAG = "Initializer2B"
    }

    class Dependency {
        init {
            isInitialized = true
        }

        companion object {
            var isInitialized = false
        }
    }
}