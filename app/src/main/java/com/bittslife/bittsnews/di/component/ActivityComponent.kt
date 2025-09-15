package com.bittslife.bittsnews.di.component

import com.bittslife.bittsnews.di.ActivityScope
import com.bittslife.bittsnews.di.module.ActivityModule
import com.bittslife.bittsnews.ui.activity.NewsActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: NewsActivity)

}