package ru.mospolytech.mypolytech.ui.base

import android.view.Gravity
import androidx.transition.Fade
import androidx.transition.Slide

object Transitions {

    fun fromEnd(): Slide {
        return Slide(Gravity.END).apply {
            duration = TRANSITION_DURATION
        }
    }

    fun fade(): Fade {
        return Fade().apply {
            duration = TRANSITION_DURATION
        }
    }

    private const val TRANSITION_DURATION = 200L
}
