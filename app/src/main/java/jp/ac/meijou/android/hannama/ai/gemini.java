package jp.ac.meijou.android.hannama.ai;

import android.os.Build;
import android.util.Log;

import  com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jp.ac.meijou.android.hannama.BuildConfig;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

// AI Gemini APIを使うためのクラス
public class gemini {
    public static String GEMgetcontent() {
        Client client = Client.builder().apiKey(BuildConfig.GOOGLE_API_KEY).build();
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "ちんちんがかゆいーな",
                        null);
        return response.text();

    }
}
