package com.nusademy.school.dataapi
import com.google.gson.annotations.SerializedName
import com.nusademy.school.dataapi.ListDataTeacher.ListDataTeacherItem

class ListDataTeacher : ArrayList<ListDataTeacherItem>(){
    data class ListDataTeacherItem(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("last_education")
        val lastEducation: String = "",
        @SerializedName("campus")
        val campus: String = "",
        @SerializedName("major")
        val major: String = "",
        @SerializedName("ipk")
        val ipk: Double = 0.0,
        @SerializedName("short_brief")
        val shortBrief: String = "",
        @SerializedName("video_branding")
        val videoBranding: String? = null,
        @SerializedName("linkedin")
        val linkedin: String = "",
        @SerializedName("domicilie")
        val domicilie: Domicilie = Domicilie(),
        @SerializedName("spesialitation")
        val spesialitation: Spesialitation? = null,
        @SerializedName("user")
        val user: User = User(),
        @SerializedName("published_at")
        val publishedAt: String = "",
        @SerializedName("created_at")
        val createdAt: String = "",
        @SerializedName("updated_at")
        val updatedAt: String = ""
    ) {
        data class Domicilie(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("Name")
            val name: String = "",
            @SerializedName("created_at")
            val createdAt: String = "",
            @SerializedName("updated_at")
            val updatedAt: String = ""
        )

        data class Spesialitation(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("Name")
            val name: String = "",
            @SerializedName("Category")
            val category: String = "",
            @SerializedName("created_at")
            val createdAt: String = "",
            @SerializedName("updated_at")
            val updatedAt: String = ""
        )

        data class User(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("username")
            val username: String = "",
            @SerializedName("email")
            val email: String = "",
            @SerializedName("provider")
            val provider: String = "",
            @SerializedName("confirmed")
            val confirmed: Boolean = false,
            @SerializedName("blocked")
            val blocked: Any? = null,
            @SerializedName("role")
            val role: Int = 0,
            @SerializedName("created_at")
            val createdAt: String = "",
            @SerializedName("updated_at")
            val updatedAt: String = "",
            @SerializedName("top_talent")
            val topTalent: Any? = null,
            @SerializedName("full_name")
            val fullName: String = "",
            @SerializedName("school")
            val school: Any? = null,
            @SerializedName("teacher")
            val teacher: Int = 0,
            @SerializedName("mbti_result")
            val mbtiResult: Any? = null,
            @SerializedName("assignToRole")
            val assignToRole: Int = 0
        )
    }
}