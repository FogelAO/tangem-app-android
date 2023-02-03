package com.tangem.tap.common.analytics.events

import com.tangem.core.analytics.AnalyticsEvent

/**
 * Created by Anton Zhilenkov on 23.01.2023.
 */
sealed class SignIn(
    event: String,
    params: Map<String, String> = mapOf(),
    error: Throwable? = null,
) : AnalyticsEvent("Sign In", event, params, error) {

    class ScreenOpened : SignIn(event = "Sing In Screen Opened")
    class CardWasScanned : SignIn(event = "Card Was Scanned")

    class ButtonBiometricSignIn : SignIn(event = "Button - Biometric Sign In")
    class ButtonCardSignIn : SignIn(event = "Button - Card Sign In")
}
