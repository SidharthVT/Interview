package com.hms.userform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hms.dto.UserFormDto
import kotlinx.android.synthetic.main.activity_user_form.*

class UserFormActivity : AppCompatActivity(), UserFormView {

    // For success of Form validation

    override fun onSuccess() {
        showPopup(getString(R.string.alert_success_title), getString(R.string.form_validation_success))
    }

    // For showing the validation errors in popup

    override fun onFailure(errorMsg:String) {

       showPopup(getString(R.string.alert_error_title), errorMsg)
    }

    private var userFormPresenter: UserFormPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_form)

        initialzeUI()
    }

    //For initializing the UI views

    private fun initialzeUI() {

        userFormPresenter = UserFormPresenterImpl.getNewInstance(this)

        btnSubmit.setOnClickListener {

            userFormPresenter?.onValidate(getFormRequest())
        }
    }

    // Creating the form request

    private fun getFormRequest():UserFormDto {

        val userFormDto = UserFormDto(et_firstName.text.toString(),
                                        et_lastName.text.toString(),
                                        et_email.text.toString())

        return userFormDto
    }

    private fun showPopup(title: String, msg:String) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setPositiveButton(getString(R.string.alert_btn_ok), { dialog, which ->
            dialog.cancel()
        })

        builder.show()
    }
}
