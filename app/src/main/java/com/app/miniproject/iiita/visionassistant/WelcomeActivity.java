package com.app.miniproject.iiita.visionassistant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.app.miniproject.iiita.visionassistant.databinding.ActivityWelcomeBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Locale;

public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding binding;
    private TextToSpeech textToSpeech;
    private SharedPreferences preferences;
    private static final String PREF_NAME = "VisionAssistantPrefs";
    private static final String KEY_OFFLINE_MODE = "offline_mode";
    private boolean isOfflineMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        // Initialize SharedPreferences
        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        isOfflineMode = preferences.getBoolean(KEY_OFFLINE_MODE, false);

        initTextToSpeech();
        setupUI();
    }

    private void initTextToSpeech() {
        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.setLanguage(Locale.ENGLISH);
                textToSpeech.setSpeechRate(0.8f);
                speakWelcomeMessage();
            }
        }, "com.google.android.tts");
    }

    private void setupUI() {
        // Setup mode switch
        SwitchCompat modeSwitch = binding.modeSwitch;
        modeSwitch.setChecked(isOfflineMode);
        updateModeSwitchText(isOfflineMode);

        modeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isOfflineMode = isChecked;
            updateModeSwitchText(isChecked);
            preferences.edit().putBoolean(KEY_OFFLINE_MODE, isChecked).apply();
            
            String message = isChecked ? "Switched to offline mode" : "Switched to online mode";
            speak(message);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });

        binding.yoloV3Mb.setOnClickListener(view -> launchYoloActivity());
    }

    private void updateModeSwitchText(boolean isOffline) {
        binding.modeSwitch.setText(isOffline ? "Offline Mode" : "Online Mode");
    }

    private void launchYoloActivity() {
        if (!isOfflineMode && !isNetworkAvailable()) {
            showNetworkDialog();
            return;
        }

        Intent intent = new Intent(WelcomeActivity.this, YoloV3Activity.class);
        intent.putExtra("offline_mode", isOfflineMode);
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        startActivity(intent);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    private void showNetworkDialog() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("No Internet Connection")
                .setMessage("Please enable mobile data/Wi-Fi or switch to offline mode")
                .setPositiveButton("Switch to Offline", (dialog, which) -> {
                    isOfflineMode = true;
                    binding.modeSwitch.setChecked(true);
                    preferences.edit().putBoolean(KEY_OFFLINE_MODE, true).apply();
                    speak("Switched to offline mode");
                })
                .setNegativeButton("Check Settings", (dialog, which) -> {
                    startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                })
                .show();
        
        speak("No internet connection. Please enable mobile data or Wi-Fi, or switch to offline mode");
    }

    private void speakWelcomeMessage() {
        String message = "Welcome to Vision Assistant. " + 
                        (isOfflineMode ? "You are in offline mode" : "You are in online mode");
        speak(message);
    }

    private void speak(String text) {
        if (textToSpeech != null) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}