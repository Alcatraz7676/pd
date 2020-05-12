package ru.mospolytech.mypolytech.ui.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.mospolytech.mypolytech.R
import ru.mospolytech.mypolytech.ui.ExamplePage

class TabsPagerAdapter(
    fragmentManager: FragmentManager,
    private val getStringRes: (Int) -> String
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = when (position) {
        TabsPage.EXAMPLE_1.ordinal -> ExamplePage()
        TabsPage.EXAMPLE_2.ordinal -> ExamplePage()
        TabsPage.UNIVERSITY_MAP.ordinal -> ExamplePage()
        else -> error("Unknown position = $position received")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            TabsPage.EXAMPLE_1.ordinal -> R.string.example_1_tab
            TabsPage.EXAMPLE_2.ordinal -> R.string.example_2_tab
            TabsPage.UNIVERSITY_MAP.ordinal -> R.string.university_map_tab
            else -> error("Unknown position = $position received")
        }
            .let(getStringRes)
    }

    override fun getCount() = TabsPage.values().size
}