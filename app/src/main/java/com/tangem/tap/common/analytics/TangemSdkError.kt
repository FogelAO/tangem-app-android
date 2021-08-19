package com.tangem.tap.common.analytics

import com.tangem.common.core.TangemSdkError

object TangemSdk {

    // This mapping is performed to group errors in FirebaseCrashlytics.
    // At the moment, the errors in Crashlytics can only be grouped by their place of creation (class and line).
    fun map(error: TangemSdkError): TangemSdkError {
        return when (error) {
            is TangemSdkError.TagLost -> TangemSdkError.TagLost()
            is TangemSdkError.ExtendedLengthNotSupported -> TangemSdkError.ExtendedLengthNotSupported()
            is TangemSdkError.SerializeCommandError -> TangemSdkError.SerializeCommandError()
            is TangemSdkError.DeserializeApduFailed -> TangemSdkError.DeserializeApduFailed()
            is TangemSdkError.EncodingFailedTypeMismatch -> TangemSdkError.EncodingFailedTypeMismatch(
                error.customMessage)
            is TangemSdkError.EncodingFailed -> TangemSdkError.EncodingFailed(error.customMessage)
            is TangemSdkError.DecodingFailedMissingTag -> TangemSdkError.DecodingFailedMissingTag(
                error.customMessage)
            is TangemSdkError.DecodingFailedTypeMismatch -> TangemSdkError.DecodingFailedTypeMismatch(
                error.customMessage)
            is TangemSdkError.DecodingFailed -> TangemSdkError.DecodingFailed(error.customMessage)
            is TangemSdkError.InvalidResponse -> TangemSdkError.InvalidResponse()
            is TangemSdkError.UnknownStatus -> TangemSdkError.UnknownStatus(error.statusWord)
            is TangemSdkError.ErrorProcessingCommand -> TangemSdkError.ErrorProcessingCommand()
            is TangemSdkError.InvalidState -> TangemSdkError.InvalidState()
            is TangemSdkError.InsNotSupported -> TangemSdkError.InsNotSupported()
            is TangemSdkError.InvalidParams -> TangemSdkError.InvalidParams()
            is TangemSdkError.NeedEncryption -> TangemSdkError.NeedEncryption()
            is TangemSdkError.FileNotFound -> TangemSdkError.FileNotFound()
            is TangemSdkError.WalletNotFound -> TangemSdkError.WalletNotFound()
            is TangemSdkError.AlreadyPersonalized -> TangemSdkError.AlreadyPersonalized()
            is TangemSdkError.CannotBeDepersonalized -> TangemSdkError.CannotBeDepersonalized()
            is TangemSdkError.AccessCodeRequired -> TangemSdkError.AccessCodeRequired()
            is TangemSdkError.CardReadWrongWallet -> TangemSdkError.CardReadWrongWallet()
            is TangemSdkError.CardWithMaxZeroWallets -> TangemSdkError.CardWithMaxZeroWallets()
            is TangemSdkError.AlreadyCreated -> TangemSdkError.AlreadyCreated()
            is TangemSdkError.MaxNumberOfWalletsCreated -> TangemSdkError.MaxNumberOfWalletsCreated()
            is TangemSdkError.PurgeWalletProhibited -> TangemSdkError.PurgeWalletProhibited()
            is TangemSdkError.AccessCodeCannotBeChanged -> TangemSdkError.AccessCodeCannotBeChanged()
            is TangemSdkError.PasscodeCannotBeChanged -> TangemSdkError.PasscodeCannotBeChanged()
            is TangemSdkError.AccessCodeCannotBeDefault -> TangemSdkError.AccessCodeCannotBeDefault()
            is TangemSdkError.NoRemainingSignatures -> TangemSdkError.NoRemainingSignatures()
            is TangemSdkError.EmptyHashes -> TangemSdkError.EmptyHashes()
            is TangemSdkError.HashSizeMustBeEqual -> TangemSdkError.HashSizeMustBeEqual()
            is TangemSdkError.WalletIsNotCreated -> TangemSdkError.WalletIsNotCreated()
            is TangemSdkError.SignHashesNotAvailable -> TangemSdkError.SignHashesNotAvailable()
            is TangemSdkError.TooManyHashesInOneTransaction -> TangemSdkError.TooManyHashesInOneTransaction()
            is TangemSdkError.ExtendedDataSizeTooLarge -> TangemSdkError.ExtendedDataSizeTooLarge()
            is TangemSdkError.NotPersonalized -> TangemSdkError.NotPersonalized()
            is TangemSdkError.NotActivated -> TangemSdkError.NotActivated()
            is TangemSdkError.WalletIsPurged -> TangemSdkError.WalletIsPurged()
            is TangemSdkError.PasscodeRequired -> TangemSdkError.PasscodeRequired()
            is TangemSdkError.VerificationFailed -> TangemSdkError.VerificationFailed()
            is TangemSdkError.DataSizeTooLarge -> TangemSdkError.DataSizeTooLarge()
            is TangemSdkError.MissingCounter -> TangemSdkError.MissingCounter()
            is TangemSdkError.OverwritingDataIsProhibited -> TangemSdkError.OverwritingDataIsProhibited()
            is TangemSdkError.DataCannotBeWritten -> TangemSdkError.DataCannotBeWritten()
            is TangemSdkError.MissingIssuerPubicKey -> TangemSdkError.MissingIssuerPubicKey()
            is TangemSdkError.CardVerificationFailed -> TangemSdkError.CardVerificationFailed()
            is TangemSdkError.WrongAccessCode -> TangemSdkError.WrongAccessCode()
            is TangemSdkError.WrongPasscode -> TangemSdkError.WrongPasscode()
            is TangemSdkError.UnknownError -> TangemSdkError.UnknownError()
            is TangemSdkError.UserCancelled -> TangemSdkError.UserCancelled()
            is TangemSdkError.Busy -> TangemSdkError.Busy()
            is TangemSdkError.MissingPreflightRead -> TangemSdkError.MissingPreflightRead()
            is TangemSdkError.WrongCardNumber -> TangemSdkError.WrongCardNumber()
            is TangemSdkError.WrongCardType -> TangemSdkError.WrongCardType()
            is TangemSdkError.CardError -> TangemSdkError.CardError()
            is TangemSdkError.NotSupportedFirmwareVersion -> TangemSdkError.NotSupportedFirmwareVersion()
            is TangemSdkError.WalletError -> TangemSdkError.WalletError()
            is TangemSdkError.WalletCannotBeCreated -> TangemSdkError.WalletCannotBeCreated()
            is TangemSdkError.UnsupportedCurve -> TangemSdkError.UnsupportedCurve()
            is TangemSdkError.UnsupportedWalletConfig -> TangemSdkError.UnsupportedWalletConfig()
            is TangemSdkError.CryptoUtilsError -> TangemSdkError.CryptoUtilsError()
            is TangemSdkError.NetworkError -> TangemSdkError.NetworkError(error.customMessage)
            is TangemSdkError.ExceptionError -> TangemSdkError.ExceptionError(error.throwable)
        }
    }

}