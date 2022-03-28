package com.melvin.ongandroid.data.local.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MembersModel(
    @SerializedName("id") val id: Int= 0,
    @SerializedName("name") val name: String?,
    @SerializedName("image")val image: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("facebookUrl") val facebookUrl: String?,
    @SerializedName("linkedinUrl") val linkedinUrl: String?,
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(description)
        parcel.writeString(facebookUrl)
        parcel.writeString(linkedinUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MembersModel> {
        override fun createFromParcel(parcel: Parcel): MembersModel {
            return MembersModel(parcel)
        }

        override fun newArray(size: Int): Array<MembersModel?> {
            return arrayOfNulls(size)
        }
    }
}

