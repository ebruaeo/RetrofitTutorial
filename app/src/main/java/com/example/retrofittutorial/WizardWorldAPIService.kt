package com.example.retrofittutorial

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface WizardWorldAPIService {
    @GET("/Houses")
    suspend fun getHouses(): List<House>

    @Headers("accept: text/plain")
    @GET("/Wizards")
    suspend fun getWizards(
        @Query("FirstName") firstName: String? = null,
        @Query("LastName") lastName: String? = null

    ): List<Wizard>

    @Headers("accept: text/plain", "Content-Type: application/json-patch+json")
    @POST("/Feedback")
    suspend fun submitFeedback(@Body feedback: Feedback): Response<Void>

}