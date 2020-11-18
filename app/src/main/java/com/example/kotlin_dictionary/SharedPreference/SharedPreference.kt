package com.example.kotlin_dictionary.SharedPreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreference : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener, AdapterView.OnItemSelectedListener {
    val Pref_table = "table"
    val Key_name = "name"
    val Key_age = "age"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        val pref = getSharedPreferences(Pref_table, Context.MODE_PRIVATE)

        val spinner = findViewById(R.id.spinner_key) as Spinner

        ArrayAdapter.createFromResource(
            this, R.array.key,
            android.R.layout.simple_spinner_dropdown_item )
            .also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.setSelection(0)
        spinner.onItemSelectedListener = this

        //pref.edit().clear().apply()
        data_text.setText(pref.getString("Name:" + Key_name, "Default"))
        data_age.setText(pref.getString("Age:" + Key_age, "Default"))

        data_button.setOnClickListener {

            if(spinner.selectedItemPosition == 0)
            {
                pref.edit().putString(Key_name, Person.text.toString()).apply()
                onSharedPreferenceChanged(pref, Key_name)
            } else if(spinner.selectedItem == "key"){
                pref.edit().putString(Key_age, Person.text.toString()).apply()
                onSharedPreferenceChanged(pref, Key_age)
            }
        }
    }

    // https://developer.android.com/guide/topics/ui/settings/use-saved-values?hl=ko
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String) {
        if (key.equals("name")){
            var name_value = sharedPreferences!!.getString(key, "Default")
            data_text.setText("Name:" + name_value)
        } else if(key.equals("age")){
            var age_value = sharedPreferences!!.getString(key, "Default")
            data_age.setText("Age:" + age_value)
        }
    }

    // https://developer.android.com/guide/topics/ui/controls/spinner?hl=ko
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            println(parent.getItemAtPosition(position))
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}