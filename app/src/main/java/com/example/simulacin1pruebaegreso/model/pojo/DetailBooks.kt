package com.example.simulacin1pruebaegreso.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "detailBooks_table")
data class DetailBooks(@PrimaryKey val id: Int,
                      @SerializedName("author")
                      val author: String,
                      @SerializedName("country")
                      val country: String,
                      @SerializedName("imageLink")
                      val imageLink: String,
                      @SerializedName("language")
                      val language: String,
                      @SerializedName("title")
                      val title: String,
                      @SerializedName("pages")
                      val pages: String,
                      @SerializedName("year")
                      val year: String,
                      @SerializedName("lastPrice")
                      val lastPrice: String,
                      @SerializedName("delivery")
                      val delivery: Boolean)
