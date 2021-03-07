
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.RecognitionListener;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import java.util.ArrayList;
import java.util.Locale;
import com.codename1.impl.android.AndroidNativeUtil;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Rectangle;
import generated.StateMachineBase;

public class SpeechRecognitionImpl {

    static String message = "";
    static String speech = "";
    private SpeechRecognizer sr;

    public void startListening() {
        final Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        //number of guesses
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
        //Speechrecognition must be run on main Thread

        Activity activity = AndroidNativeUtil.getActivity();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                sr = SpeechRecognizer.createSpeechRecognizer(AndroidNativeUtil.getActivity());
                sr.setRecognitionListener(new listener());
                sr.startListening(intent);
            }
        });
    }

    public String getResult() {
        return speech;
    }

    public boolean isSupported() {
        return true;
    }
}

class listener implements RecognitionListener {

    public void onReadyForSpeech(Bundle params) {
        message = "onReadyForSpeech";
    }

    public void onBeginningOfSpeech() {
        message =  "onBeginningOfSpeech";
    }

    public void onRmsChanged(float rmsdB) {
        message =  "onRmsChanged";
    }

    public void onBufferReceived(byte[] buffer) {
        message =  "onBufferReceived";
    }

    public void onEndOfSpeech() {
        message =  "onEndofSpeech";
    }

    public void onError(int error) {
        message =  "error " + error;
    }

    public void onResults(Bundle results) {
        //here you have what google understand from the speech
        //maybe only save the first guess, which would have the highest
        //possibility
        speech += "on results";
        String str = "";

        ArrayList data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        for (int i = 0; i < data.size(); i++) {

            str += data.get(i)+";";
        }
        speech += str;
    }

    public void onPartialResults(Bundle partialResults) {
        message =  "onPartialResults";

    }

    public void onEvent(int eventType, Bundle params) {

        message =  "onEvent " + eventType;
    }
}
