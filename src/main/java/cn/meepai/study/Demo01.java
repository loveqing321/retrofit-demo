package cn.meepai.study;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author lzx
 * @date 2020/12/15 11:51 AM
 */
public class Demo01 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://aurora-srv.baidu.com")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        Service service = retrofit.create(Service.class);

        String token = "3ebb5de392463957dcdbe9133ea1cc2a";
        Response<Map<String, Object>> response = service.isAdmin(token).execute();
        System.out.println(Arrays.asList(response.body().values().toArray()));
    }
}
