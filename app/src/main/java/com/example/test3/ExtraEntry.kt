package com.example.test3

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.core.os.HandlerCompat
import androidx.core.os.HandlerCompat.postDelayed
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule
import kotlin.math.exp

class ExtraEntry(var isCovered: Boolean = true, var isFlag: Boolean = false, var numOfMine: Int = 0, var numOfEntry: Int = 0) {
}

