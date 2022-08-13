package com.example.nsf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private val rotateOpen : Animation by Lazy { AnimationUtils.loadAnimation(context:this, R.anim.rotate_open_anim)}
    private val rotateClose: Animation by Lazy { AnimationUtils.loadAnimation(context:this, R.anim.rotate_close_anim)}
    private val fromBottom: Animation by Lazy { AnimationUtils.loadAnimation(context:this, R.anim.from_bottom_anim)}
    private val toBottom: Animation by Lazy { AnimationUtils.loadAnimation(context:this, R.anim.to_bottom_anim)}

    private var clicked = false


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn.setOnClickListener {
            it:
            View !
                    onAddButtonClicked()
        }
        notes_btn.setOnClickListener {
            it:
            View !
                    Toast.makeText(context:this, text:"Notes button clicked", Toast.LENGTH_SHORT).
            show()

        }
        password_btn.setOnClickListener {
            it:
            View !
                    Toast.makeText(context:this, text:"password button clicked", Toast.LENGTH_SHORT).
            show()

        }
        finance_btn.setOnClickListener {
            it:
            View !
                    Toast.makeText(context:this, text:"finance button clicked", Toast.LENGTH_SHORT).
            show()

        }
    }

    private void onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked:Boolean) {
        if (!clicked) {
            notes_btn.visibility = View.VISIBLE
            password_btn.visibility = View.VISIBLE
            finance_btn.visibility = View.VISIBLE
        } else {
            notes_btn.visibility = View.INVISIBLE
            password_btn.visibility = View.INVISIBLE
            finance_btn.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked:Boolean) {
        if (!clicked) {
            notes_btn.startAnimation(fromBottom)
            password_btn.startAnimation(fromBottom)
            finance_btn.startAnimation(fromBottom)
            add_btn.startAnimation(rotateOpen)
        } else {
            notes_btn.startAnimation(toBottom)
            password_btn.startAnimation(toBottom)
            finance_btn.startAnimation(toBottom)
            add_btn.startAnimation(rotateClose)
        }
    }

}


















