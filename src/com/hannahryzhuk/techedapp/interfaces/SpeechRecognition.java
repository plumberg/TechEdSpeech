package com.hannahryzhuk.techedapp.interfaces;

import com.codename1.system.NativeInterface;

public interface SpeechRecognition extends NativeInterface {
    void startListening();
    String getResult();
}
