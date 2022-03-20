package com.everest.userinfo.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.everest.userinfo.HomeActivity
import com.everest.userinfo.validations.ValidateFields
import java.security.AccessControlContext

class UserViewModel() : ViewModel() {


    private var _user: MutableLiveData<User> = MutableLiveData()


    val user: LiveData<User>
        get() = _user


    fun setUserDetails(user: User) {
        this._user.value = user
        Log.i("ViewModelClass", user.userName)
    }

    fun validateInputs(context: Context): Boolean {
        val validate = ValidateFields(context)
        Log.i("testInValidateFields","errrror")
        return user.value?.phoneNumber?.let {
            user.value?.pinCode?.let { it1 ->
                user.value?.email?.let { it2 ->
                    validate.inputs(
                        it2.trim(),
                        it, it1
                    )
                }
            }
        } == false
                &&
                user.value?.email?.let {
                    user.value?.phoneNumber?.let { it1 ->
                        user.value?.pinCode?.let { it2 ->
                            user.value?.userName?.let { it3 ->
                                user.value?.address?.let { it4 ->
                                    validate.mandatoryInputs(
                                        it,
                                        it1, it2, it3, it4
                                    )
                                }
                            }
                        }
                    }
                } == false
    }
}