package com.example.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupShowAlert1ButtonOnClickListener()
        setupShowAlert2ButtonOnClickListener()
    }

    private fun setupShowAlert1ButtonOnClickListener() {
        showAlert1Button.setOnClickListener { view ->
            val showAlertDTO = AlertManager.ShowAlertDTO(this, "Title", "Some message")
            AlertManager.showAlert(showAlertDTO, okCompletion = {
                print("done")
            })
        }
    }

    private fun setupShowAlert2ButtonOnClickListener() {
        showAlert2Button.setOnClickListener {
            val showAlertDTO = AlertManager.ShowAlertDTO(this, "Title", "Some message")
            AlertManager.showAlert(dto = showAlertDTO, okCompletion = {
                print("")
            }, cancelCompletion = {
                print("")
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
