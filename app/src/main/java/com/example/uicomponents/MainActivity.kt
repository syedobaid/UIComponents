package com.example.uicomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import com.example.uicomponents.MainActivity.*
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity(), IAnything {
    var radioGroup: RadioGroup? = null
    var radioButton: RadioButton? = null
    var checkBox: CheckBox? = null
    var toggleButton: ToggleButton? = null
    var switch: Switch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById<RadioGroup>(R.id.radio_group)

        radioGroup?.let { radiogroup ->
            radiogroup.setOnCheckedChangeListener { radioGroup, radioBtnId ->
                radioButton = findViewById(radioBtnId)
                val buttonName = radioButton?.text

                //radiogroup.childCount

                Toast.makeText(this, "$buttonName is clicked " + radiogroup.childCount , Toast.LENGTH_SHORT).show()

            }
        }
        checkBox = findViewById(R.id.checkBox)
        checkBox?.setOnClickListener {
            if (checkBox?.isChecked!!)
                Toast.makeText(this, "checkbox selected" , Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "checkbox unselected" , Toast.LENGTH_SHORT).show()

        }

        toggleButton = findViewById(R.id.toggleButton)
        toggleButton?.setOnClickListener {
            if (toggleButton?.isChecked!!)
                Toast.makeText(this, "toggleButton ON" , Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "toggleButton OFF" , Toast.LENGTH_SHORT).show()
        }

        switch = findViewById(R.id.switch1)
        switch?.setOnClickListener {
            if (switch?.isChecked!!) {
                //switch?.isChecked = false
                //switch?.isEnabled = false
                showAlert(switch!!)
            }
            else
                Toast.makeText(this, "No Combo!" , Toast.LENGTH_SHORT).show()
        }

        val chipGroup = findViewById<ChipGroup>(R.id.chip_group)

        chipGroup.check(R.id.chip8)



        chipGroup.checkedChipId
        Toast.makeText(this, chipGroup.checkedChipId.toString() , Toast.LENGTH_SHORT).show()

        chipGroup.setOnClickListener {
            Toast.makeText(this, "clicked chip" , Toast.LENGTH_SHORT).show()

        }
        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = findViewById<Chip>(checkedId)
            Toast.makeText(this, chip.text , Toast.LENGTH_SHORT).show()
        }

        var city: Array<String> = arrayOf("Markham", "Toronto", "Pickering", "Oshawa", "Missisuaga", "Brampton")

        var spinner: Spinner = findViewById(R.id.spinner)

        var arr: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,city)

        spinner.adapter = arr

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }

    private fun showAlert(switch: Switch) {
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)

        alertDialogBuilder
            .setTitle("Add Combo")
            .setMessage("Do you want to make it Combo")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialogInterface, i ->
                Toast.makeText(this, "Updated to Combo!" , Toast.LENGTH_SHORT).show()
                switch.isChecked = true
            }
            .setNegativeButton("No") {
                    dialogInterface, i ->
                dialogInterface.cancel()
                Toast.makeText(this, "No Combo!" , Toast.LENGTH_SHORT).show()
                switch.isChecked = false
            }
            .create()
            .show()
    }

    override fun abc() {
        TODO("Not yet implemented")
    }

    override fun bcd() {
        TODO("Not yet implemented")
    }

}

interface IAnything {
    fun abc()
    fun bcd()
}