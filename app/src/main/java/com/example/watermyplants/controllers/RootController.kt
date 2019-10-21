package com.example.watermyplants.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.example.watermyplants.R

class RootController: Controller {

    constructor(): super()
    constructor(args: Bundle?) : super(args)

    // Inflate Login Layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.login_layout, container, false)
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        // When "Register" button is clicked, the registration_layout will inflate from the RegisterController
        view?.findViewById<Button>(R.id.btn_register)?.setOnClickListener {
            router.pushController(
                RouterTransaction.with(RegisterController(args))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )
        }

        // When "Login" button is clicked, the plant_list will inflate from the PlantListController
        view?.findViewById<Button>(R.id.btn_login)?.setOnClickListener {
            router.pushController(
                RouterTransaction.with(PlantListController(args))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )
        }
    }
}