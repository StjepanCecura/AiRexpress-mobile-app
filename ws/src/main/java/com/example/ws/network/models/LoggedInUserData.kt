package com.example.ws.network.models

import com.google.gson.annotations.SerializedName

class LoggedInUserData (
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("email") var email: String? = null,
)