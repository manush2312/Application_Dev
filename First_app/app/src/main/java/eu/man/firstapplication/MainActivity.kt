package eu.man.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickMe = findViewById<Button>(R.id.mybutton)   // here we got access to the button
        val tvMytextView = findViewById<TextView>(R.id.textView)  // access to text
        var timesClicked = 0
        btnClickMe.text = "Aa Gaye.."  // here we overwrote text of the button
        btnClickMe.setOnClickListener {  // set an action on click to the button..
            btnClickMe.text = "HAha u clicked me!"  // overwrite the text again
            timesClicked += 1

            // setOnClickListener is basically waiting for us to click the buuton

            tvMytextView.text = "How are you??"+"\nYou clicked button:"+timesClicked.toString()
            Toast.makeText(this, "hey Manush",Toast.LENGTH_LONG).show() // shows
            // little message at the bottom of the screen.
        }
    }
}