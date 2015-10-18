package halin.me.testapp.Developer.YQTRACK.translate;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

/**
 * Created by halin on 9/23/15.
 */
public class TranslateRequest extends JsonObjectRequest{
    public TranslateRequest(int method, String url, String requestBody, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
    }
}
