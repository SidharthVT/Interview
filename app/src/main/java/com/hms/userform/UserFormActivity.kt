package com.hms.userform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hms.dto.UserFormDto
import kotlinx.android.synthetic.main.activity_user_form.*

class UserFormActivity : AppCompatActivity(), UserFormView {

    override fun onSuccess() {

        Toast.makeText(this, getString(R.string.form_validation_success), Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(errorMsg:String) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.alert_title))
        builder.setMessage(errorMsg)
        builder.setPositiveButton(getString(R.string.alert_btn_ok), { dialog, which ->
            dialog.cancel()
        })

        builder.show()
    }

    private var userFormPresenter: UserFormPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_form)

        initialzeUI()
    }

    private fun initialzeUI() {

        userFormPresenter = UserFormPresenterImpl.getNewInstance(this)

        btnSubmit.setOnClickListener {

            userFormPresenter?.onValidate(getFormRequest())
        }
    }

    private fun getFormRequest():UserFormDto {

        val userFormDto = UserFormDto(et_firstName.text.toString(),
                                        et_lastName.text.toString(),
                                        et_email.text.toString())

        return userFormDto
    }
}
