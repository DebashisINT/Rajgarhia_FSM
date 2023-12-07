package com.rajgarhiafsm.features.document.api

import com.rajgarhiafsm.features.dymanicSection.api.DynamicApi
import com.rajgarhiafsm.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}