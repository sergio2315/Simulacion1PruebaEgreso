package com.example.simulacin1pruebaegreso.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.nio.channels.spi.AbstractSelectionKey

@Entity(tableName = "books_table")
data class Books (@PrimaryKey val id: Int,
                  @SerializedName("author")
                  val author: String,
                  @SerializedName("country")
                  val country: String,
                  @SerializedName("image")
                  val imageLink: String,
                  @SerializedName("language")
                  val language: String,
                  @SerializedName("title")
                  val title: String)