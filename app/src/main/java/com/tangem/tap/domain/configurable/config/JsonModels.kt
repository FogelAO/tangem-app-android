package com.tangem.tap.domain.configurable.config

import com.tangem.tap.common.chat.ZendeskConfig
import com.tangem.tap.common.shop.shopify.ShopifyShop
import com.tangem.tap.features.onboarding.products.wallet.saltPay.SaltPayConfig

/**
 * Created by Anton Zhilenkov on 12/11/2020.
 */

class FeatureModel(
    val isWalletPayIdEnabled: Boolean,
    val isTopUpEnabled: Boolean,
    val isSendingToPayIdEnabled: Boolean,
    val isCreatingTwinCardsAllowed: Boolean,
)

@Suppress("LongParameterList")
class ConfigValueModel(
    val coinMarketCapKey: String,
    val mercuryoWidgetId: String,
    val mercuryoSecret: String,
    val moonPayApiKey: String,
    val moonPayApiSecretKey: String,
    val blockchairApiKeys: List<String>,
    val blockchairAuthorizationToken: String?,
    val quiknodeSubdomain: String,
    val quiknodeApiKey: String,
    val bscQuiknodeSubdomain: String,
    val bscQuiknodeApiKey: String,
    val nowNodesApiKey: String,
    val getBlockApiKey: String,
    val blockcypherTokens: Set<String>?,
    val infuraProjectId: String?,
    val appsFlyer: AppsFlyer,
    val shopifyShop: ShopifyShop?,
    val zendesk: ZendeskConfig?,
    val saltPay: SaltPayConfig,
    val tronGridApiKey: String,
    val amplitudeApiKey: String,
    val swapReferrerAccount: SwapReferrerAccount?,
)

data class AppsFlyer(
    val appsFlyerDevKey: String,
    val appsFlyerAppID: String,
)

data class SwapReferrerAccount(
    val address: String,
    val fee: String,
)

class ConfigModel(
    val features: FeatureModel?,
    val configValues: ConfigValueModel?,
) {
    companion object {
        fun empty(): ConfigModel = ConfigModel(null, null)
    }
}
