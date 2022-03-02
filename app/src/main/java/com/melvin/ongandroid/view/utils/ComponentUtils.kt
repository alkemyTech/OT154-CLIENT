package com.melvin.ongandroid.view.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ComponentUtils {
    companion object {
        fun showToast(context: Context, text: String) {
            Toast.makeText(context, text, Toast.LENGTH_LONG).show()
        }

        fun showAlert(
            context: Context,
            title: String,
            message: String,
            okButton: String,
            cancelButton: String? = null
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(message)
            //Pasar metodo en el constructor - Valderas Leandro
            builder.setPositiveButton(okButton) { dialog, which ->
                dialog.dismiss()
            }
            if (!cancelButton.isNullOrEmpty())
                builder.setNegativeButton(cancelButton) { dialog, which ->
                    dialog.dismiss()
                }
            builder.show()
        }
    }
}