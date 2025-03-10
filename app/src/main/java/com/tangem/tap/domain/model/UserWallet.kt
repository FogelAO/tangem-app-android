package com.tangem.tap.domain.model

import com.tangem.domain.common.ScanResponse
import com.tangem.domain.common.util.UserWalletId

/**
 * Represents user's wallet which stored in app persistence
 * @param name User wallet name
 * @param walletId User wallet [UserWalletId]
 * @param artworkUrl User wallet card artwork URL
 * @param cardsInWallet List of cards IDs assigned with this user's wallet
 * @param isMultiCurrency Indicates whether this user wallet can work with more than one currency
 * @param scanResponse [ScanResponse] of primary user's wallet card.
 * TODO: Replace with [com.tangem.domain.common.CardDTO]
 * @property cardId ID of user's wallet primary card
 * @property hasAccessCode Indicates if the user's wallet primary card has access code
 * @property isLocked Indicates if this primary card has no currency wallets
 * */
data class UserWallet(
    val name: String,
    val walletId: UserWalletId,
    val artworkUrl: String,
    val cardsInWallet: Set<String>,
    val isMultiCurrency: Boolean,
    val scanResponse: ScanResponse,
) {
    val cardId: String
        get() = scanResponse.card.cardId

    val hasAccessCode: Boolean
        get() = scanResponse.card.isAccessCodeSet

    val isLocked: Boolean
        get() = scanResponse.card.wallets.isEmpty()
}
