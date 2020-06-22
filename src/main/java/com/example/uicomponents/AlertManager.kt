package com.example.uicomponents

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

object AlertManager {
    data class ShowAlertDTO(
        val context: Context,
        val title: String,
        val message: String?
    )

    fun showAlert(dto: ShowAlertDTO, okCompletion: (() -> Unit)? = null) {
        val positiveButtonListener = DialogInterface.OnClickListener { dialog, which ->
            okCompletion?.invoke()
        }
        AlertDialog.Builder(dto.context)
            .setTitle(dto.title)
            .setMessage(dto.message)
            .setPositiveButton("OK", positiveButtonListener)
            .show()
    }

    fun showAlert(
        dto: ShowAlertDTO,
        okCompletion: (() -> Unit)? = null,
        cancelCompletion: (() -> Unit)? = null
    ) {
        val positiveButtonListener = DialogInterface.OnClickListener { dialog, which ->
            okCompletion?.invoke()
        }
        val negativeButtonListener = DialogInterface.OnClickListener { dialog, which ->
            cancelCompletion?.invoke()
        }
        AlertDialog.Builder(dto.context)
            .setTitle(dto.title)
            .setMessage(dto.message)
            .setPositiveButton("OK", positiveButtonListener)
            .setNegativeButton("Cancel", negativeButtonListener)
            .show()
    }

}

