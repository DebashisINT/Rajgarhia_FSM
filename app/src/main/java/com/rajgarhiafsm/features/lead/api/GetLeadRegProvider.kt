package com.rajgarhiafsm.features.lead.api

import com.rajgarhiafsm.features.NewQuotation.api.GetQuotListRegRepository
import com.rajgarhiafsm.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}