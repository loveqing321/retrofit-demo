package cn.meepai.study;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

import java.util.Map;

/**
 * @author lzx
 * @date 2020/12/15 11:59 AM
 */
public interface Service {

    @Headers({"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36"})
    @GET("/api/v1/auth/isAdmin")
    Call<Map<String, Object>> isAdmin(@Header("token") String token);

}
