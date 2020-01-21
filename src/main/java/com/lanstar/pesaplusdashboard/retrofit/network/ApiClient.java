package com.lanstar.pesaplusdashboard.retrofit.network;


import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import com.lanstar.pesaplusdashboard.retrofit.interceptor.AuthInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


import static com.lanstar.pesaplusdashboard.retrofit.utils.AppConstants.*;

@Component
public class ApiClient {

    private Retrofit retrofit;
    private boolean isDebug = true;
    private static String mAuthToken;

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

    /**
     * Set the {@link Retrofit} log level. This allows one to view network traffic.
     *
     * @param isDebug If true, the log level is set to
     *                {@link HttpLoggingInterceptor.Level#BODY}. Otherwise
     *                {@link HttpLoggingInterceptor.Level#NONE}.
     */
    public ApiClient setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
        return this;
    }

    /**
     * Helper method used to set the authenication Token
     *
     * @param authToken token from api
     */
    public ApiClient setAuthToken(String authToken) {
        mAuthToken = authToken;
        return this;
    }

    /**
     * Configure OkHttpClient
     *
     * @return OkHttpClient
     */
    private OkHttpClient.Builder okHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor);

        return okHttpClient;
    }

    /**
     * Return the current {@link Retrofit} instance. If none exists (first call, API key changed),
     * builds a new one.
     * <p/>
     * When building, sets the endpoint and a {@link HttpLoggingInterceptor} which adds the API key as query param.
     */
    private Retrofit getRestAdapter() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());

        if (isDebug) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        // OkHttpClient.Builder okhttpBuilder = okHttpClient();
        OkHttpClient okhttpBuilder1 = getUnsafeOkHttpClient();


//        if (mAuthToken != null && !mAuthToken.isEmpty()) {
//            okhttpBuilder.addInterceptor(new AuthInterceptor(mAuthToken));
//        }

        builder.client(getUnsafeOkHttpClient());

        retrofit = builder.build();

        return retrofit;
    }

    /**
     * Create service instance.
     */
    public ApiService getService() {
        return getRestAdapter().create(ApiService.class);
    }

    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            //add my parameters
            builder
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .addInterceptor(httpLoggingInterceptor);
            if (mAuthToken != null && !mAuthToken.isEmpty()) {
                builder.addInterceptor(new AuthInterceptor(mAuthToken));
            }


            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
