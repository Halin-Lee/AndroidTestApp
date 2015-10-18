package halin.me.testapp.Developer.YQTRACK.translate;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

/**
 * Created by halin on 9/23/15.
 */
public class TokenManager {

    /*public void getToken(){

        String bingTokenURL = new String(BING_TOKEN_URL);
        StringRequest queryBingToken = new StringRequest(bingTokenURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!GetBingTokenFromJson(response))
                {
                    String errorMessage = "获取Token出错。Response:" + response;
                    Logger.logE(errorMessage);
                    callBack.TranslateFailure(errorMessage);
                }
                else
                {
                    translateResult = new ArrayList<>();
                    translateWithToken(translateContentArray1, array1LanguageCode);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = "获取Token出错" + error.getMessage();
                Logger.logE(errorMessage);
                callBack.TranslateFailure(errorMessage);
            }
        });

        VolleyController.getInstance().addToRequestQueue(queryBingToken);}*/
}
