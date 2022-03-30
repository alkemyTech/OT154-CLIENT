package com.melvin.ongandroid.view.fragments.about_us.interfaces


import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.MembersModel


interface ListenerOnClick {
    fun navigateToMemberDetailsFragment(member: MembersModel)
}