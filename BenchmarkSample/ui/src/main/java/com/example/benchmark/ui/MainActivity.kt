package com.example.benchmark.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.venator85.aklompbase64java.AklompBase64Java

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		Log.e("Test", String(AklompBase64Java.decode("Q2lhbyAgbW9uZG8=")));
	}
}
