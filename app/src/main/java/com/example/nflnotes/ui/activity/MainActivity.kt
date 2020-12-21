package com.example.nflnotes.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nflnotes.R
import com.example.nflnotes.mvp.model.api.ApiHolder
import com.example.nflnotes.mvp.model.entity.User
import com.example.nflnotes.mvp.model.repo.RetrofitTokenRepo
import com.example.nflnotes.mvp.presenter.MainPresenter
import com.example.nflnotes.mvp.view.MainView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    val presenter = MainPresenter(this, AndroidSchedulers.mainThread(), RetrofitTokenRepo(ApiHolder.api, User()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadData()

    }

    override fun setTestText(text: String) {
        test_tv.text = text
    }
}