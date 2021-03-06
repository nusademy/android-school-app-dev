import com.google.gson.annotations.SerializedName
data class DataLogin(
    @SerializedName("jwt")
    val jwt: String = "",
    @SerializedName("user")
    val user: User = User()
) {
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
        val blocked: Boolean = false,
        @SerializedName("role")
        val role: Role = Role(),
        @SerializedName("created_at")
        val createdAt: String = "",
        @SerializedName("updated_at")
        val updatedAt: String = "",
        @SerializedName("top_talent")
        val topTalent: Any? = null,
        @SerializedName("full_name")
        val fullName: String = "",
        @SerializedName("school")
        val school: School = School(),
        @SerializedName("teacher")
        val teacher: Any? = null,
        @SerializedName("mbti_result")
        val mbtiResult: Any? = null,
        @SerializedName("assignToRole")
        val assignToRole: Any? = null,
        @SerializedName("narration_videos")
        val narrationVideos: List<Any> = listOf(),
        @SerializedName("guest_teacher_requests")
        val guestTeacherRequests: List<Any> = listOf(),
        @SerializedName("temporary_teacher_requests")
        val temporaryTeacherRequests: List<Any> = listOf(),
        @SerializedName("guest_teacher_jobs")
        val guestTeacherJobs: List<Any> = listOf(),
        @SerializedName("temporary_teacher_jobs")
        val temporaryTeacherJobs: List<Any> = listOf()
    ) {
        data class Role(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("name")
            val name: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("type")
            val type: String = ""
        )

        data class School(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("name")
            val name: String = "",
            @SerializedName("headmaster")
            val headmaster: String = "",
            @SerializedName("address")
            val address: String = "",
            @SerializedName("phone_number")
            val phoneNumber: String = "",
            @SerializedName("website")
            val website: String = "",
            @SerializedName("creator")
            val creator: Int = 0,
            @SerializedName("created_at")
            val createdAt: String = "",
            @SerializedName("updated_at")
            val updatedAt: String = ""
        )
    }
}