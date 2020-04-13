package com.example.lab3

import android.os.Parcel
import android.os.Parcelable

class Car(val model:String?, val year:Int, val price:String?, val photo:Int, val state:String?) : Parcelable {

    //Class Designer
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {}


    //A method that transmits data
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(model)
        parcel.writeInt(year)
        parcel.writeString(price)
        parcel.writeInt(photo)
        parcel.writeString(state)
    }

    //Mandatory override functions
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Car> {
        override fun createFromParcel(parcel: Parcel): Car {
            return Car(parcel)
        }

        override fun newArray(size: Int): Array<Car?> {
            return arrayOfNulls(size)
        }
    }
}