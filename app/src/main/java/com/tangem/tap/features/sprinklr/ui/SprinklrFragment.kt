package com.tangem.tap.features.sprinklr.ui

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.tangem.core.analytics.Analytics
import com.tangem.core.ui.fragments.ComposeFragment
import com.tangem.tap.common.analytics.events.Chat

internal class SprinklrFragment : ComposeFragment<SprinklrScreenState>() {
    private val viewModel by viewModels<SprinklrViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Analytics.send(Chat.ScreenOpened())
    }

    @Composable
    override fun provideState(): State<SprinklrScreenState> {
        return viewModel.state.collectAsState()
    }

    @Composable
    override fun ScreenContent(modifier: Modifier, state: SprinklrScreenState) {
        BackHandler(onBack = state.onNavigateBack)
        SprinklrScreenContent(
            modifier = modifier
                .systemBarsPadding()
                .imePadding(),
            state = state,
        )
    }
}
