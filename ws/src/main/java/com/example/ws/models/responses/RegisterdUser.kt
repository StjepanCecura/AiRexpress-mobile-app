package com.example.ws.models.responses

import com.google.gson.annotations.SerializedName

class RegisterdUser (
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
)