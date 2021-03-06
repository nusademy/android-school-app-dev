package com.nusademy.school.ui.profile

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.developer.kalert.KAlertDialog
import com.nusademy.nusademy.dataapi.RetrofitClient
import com.nusademy.nusademy.storage.SharedPrefManager
import com.nusademy.school.R
import com.nusademy.school.dataapi.DataProfileSchool
import com.nusademy.school.databinding.ActivityProfileBinding
import com.nusademy.school.ui.home.HomeActivity
import com.nusademy.school.ui.tempteacherrequest.TempTeacherRequestActivity
import com.nusademy.school.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val token= SharedPrefManager.getInstance(this).Getuser.token
    private val id= SharedPrefManager.getInstance(this).Getuser.idschool


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(R.drawable.profile_null)
            .into(binding.ivTeacher)

        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.hide()
        GetSchoolProfile(id, token)

        binding.btnback.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity ::class.java)
            startActivity(intent)
        })

        binding.btnChangeprofil.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this, ProfileEditActivity::class.java)
                startActivity(intent)
            }
        )
        binding.btnChangeAccount.setOnClickListener {
            val intent = Intent(this, ProfileUserEditActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {
            SharedPrefManager.getInstance(applicationContext).setLogin(false)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        GetSchoolProfile(id, token)
    }

    fun GetSchoolProfile(id: String, token: String) {
        val pDialog = KAlertDialog(this, KAlertDialog.PROGRESS_TYPE)
        pDialog.progressHelper.barColor = Color.parseColor("#A5DC86")
        pDialog.titleText = "Loading"
        pDialog.setCancelable(false)
        pDialog.show()
        RetrofitClient.instanceUserApi.getProfileSchool(id, "Bearer " + token)
            .enqueue(object : Callback<DataProfileSchool> {
                override fun onResponse(
                    call: Call<DataProfileSchool>,
                    response: Response<DataProfileSchool>
                ) {
                    pDialog.hide()
                    // Cek Koneksi API Behasil
                    if (response.code().toString() == "200") {
                        //Cek Output Json
                        Log.d("School", response.body().toString())

                        //Set data JSON ke tampilan
                        val data = response.body()
                        binding.tvNameSchoolProfil.text = data?.name.toString()
                        binding.tvEmailSchoolProfil.text = data?.headmaster.toString()
                        binding.tvWebsiteSchoolProfil.text = data?.website.toString()
                        binding.tvLocationSchoolProfil.text = data?.address.toString()
                        binding.tvPhoneSchoolProfil.text = data?.phoneNumber.toString()

                        // Cek Koneksi API Gagal
                    } else {
                        Toast.makeText(applicationContext, "Gagal Mendapatkan Data", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(calls: Call<DataProfileSchool>, ts: Throwable) {
                    pDialog.hide()
                    Log.d("Error", ts.message.toString())
                }
            })
    }
}

