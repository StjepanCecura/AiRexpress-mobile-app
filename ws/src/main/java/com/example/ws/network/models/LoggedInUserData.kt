package com.example.ws.network.models

import com.google.gson.annotations.SerializedName

class LoggedInUserData (
    @SerializedName("success") var success: Boolean = true,
    @SerializedName("email") var email: String? = null,
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("lastName") var jwt: String? = null,
)