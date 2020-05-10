package ru.mospolytech.mypolytech.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment

/**
 * isFinishing impl is stolen from MvpAppCompatFragment
 */
abstract class BaseFragment : MvpAppCompatFragment() {

    private var hasSavedState: Boolean = false

    abstract val layoutRes: Int

    /**
     * Should be used to clear existing components upon exit.
     */
    open fun onFinish() {}

    override fun onStart() {
        super.onStart()

        hasSavedState = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onResume() {
        super.onResume()

        hasSavedState = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        hasSavedState = true
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing()) onFinish()
    }

    /**
     * Equivalent to Activity's isFinishing()
     */
    @Suppress("ReturnCount")
    private fun isFinishing(): Boolean {
        // We leave the screen and respectively all fragments will be destroyed
        if (requireActivity().isFinishing) {
            return true
        }

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        if (hasSavedState) {
            hasSavedState = false
            return false
        }

        // See https://github.com/Arello-Mobile/Moxy/issues/24
        var anyParentIsRemoving = false
        var parent = parentFragment
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving
            parent = parent.parentFragment
        }

        if (isRemoving || anyParentIsRemoving) {
            return true
        }

        return false
    }
}
