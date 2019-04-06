package vn.sunasterisk.moviedb_40.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Actor() : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("profile_path")
    @Expose
    var profilePath: String? = null

    @SerializedName("character")
    @Expose
    var character: String? = null

    @SerializedName("birthday")
    @Expose
    var birthday: String? = null

    @SerializedName("biography")
    @Expose
    var biography: String? = null

    @SerializedName("place_of_birth")
    @Expose
    var place: String? = null

    @SerializedName("popularity")
    @Expose
    var popularity: String? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("known_for_department")
    @Expose
    var department: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        profilePath = parcel.readString()
        character = parcel.readString()
        birthday = parcel.readString()
        biography = parcel.readString()
        place = parcel.readString()
        popularity = parcel.readString()
        gender = parcel.readString()
        department = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(profilePath)
        parcel.writeString(character)
        parcel.writeString(birthday)
        parcel.writeString(biography)
        parcel.writeString(place)
        parcel.writeString(popularity)
        parcel.writeString(gender)
        parcel.writeString(department)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Actor> {
        override fun createFromParcel(parcel: Parcel): Actor {
            return Actor(parcel)
        }

        override fun newArray(size: Int): Array<Actor?> {
            return arrayOfNulls(size)
        }
    }
}
