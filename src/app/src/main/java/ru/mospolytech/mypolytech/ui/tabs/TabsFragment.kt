package ru.mospolytech.mypolytech.ui.tabs

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_tabs.*
import kotlinx.android.synthetic.main.fragment_tabs.view.*
import kotlinx.android.synthetic.main.fragment_tabs.view.viewPager
import kotlinx.android.synthetic.main.toolbar.*
import ru.mospolytech.mypolytech.R
import ru.mospolytech.mypolytech.di.example.TabsComponent
import ru.mospolytech.mypolytech.di.main.flow.MainFlowComponent
import ru.mospolytech.mypolytech.ui.base.BaseFragment
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry.get
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry.replaceComponentIfExists

class TabsFragment : BaseFragment(), TabsView {

    override val layoutRes = R.layout.fragment_tabs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initToolbar()
        initPager()
    }

    private fun initToolbar() {
        toolbar.title = getString(R.string.app_name)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun initPager() {
        viewPager.adapter = TabsPagerAdapter(childFragmentManager, ::getString)
    }
}