package com.rajgarhiafsm.features.survey.api

import com.rajgarhiafsm.features.photoReg.api.GetUserListPhotoRegApi
import com.rajgarhiafsm.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}