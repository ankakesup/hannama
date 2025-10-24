package jp.ac.meijou.android.hannama.ai;

import android.os.Build;
import android.util.Log;

import  com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.ac.meijou.android.hannama.BuildConfig;

// AI Gemini APIを使うためのクラス
public class gemini {

    private static final Logger log = LoggerFactory.getLogger(gemini.class);

    public static void GEMgetcontent() {
        Client client = Client.builder().apiKey(BuildConfig.GOOGLE_API_KEY).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "Explain how AI works in a few words",
                        null);

        System.out.println(response.text());
    }
}
