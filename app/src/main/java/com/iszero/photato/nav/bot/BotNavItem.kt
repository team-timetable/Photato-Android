package com.iszero.photato.nav.bot

import com.iszero.photato.R

sealed class BotNavItem(
    val title: Int, val icon: Int, val screenRoute: String
) {
    object Home : BotNavItem(R.string.home, R.drawable.home, "HOME")
    object My : BotNavItem(R.string.my, R.drawable.my, "MY")
}