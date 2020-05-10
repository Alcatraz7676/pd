package ru.mospolytech.mypolytech.ui.base

import ru.mospolytech.mypolytech.R
import ru.mospolytech.mypolytech.utils.extensions.consume
import ru.terrakok.cicerone.Router

abstract class HostFragment : BaseFragment(), OnBackClickHandler {

    protected abstract val globalRouter: Router

    override val layoutRes = R.layout.fragment_host

    override fun onBackHandle() =
        consume {
            childFragmentManager.findFragmentById(R.id.content)
                .let { it as? OnBackClickHandler }
                ?.onBackHandle()
                ?.takeIf { it } ?: globalRouter.exit()
        }
}
