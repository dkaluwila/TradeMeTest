package com.din.trademe.data.network

import okhttp3.Interceptor
import okhttp3.Response

class TradeMeAuthInterceptor : Interceptor {
    /**
     * Keys are provided by Trade Me for their sandbox environment.
     * For production, these should be loaded securely, for example from a local.properties file
     * which is not checked into version control, and then exposed via BuildConfig.
     */
    private val consumerKey = "A1AC63F0332A131A78FAC304D007E7D1"
    private val consumerSecret = "EC7F18B17A062962C6930A8AE88B16C7"

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // Construct the OAuth authorization header value
        val authHeader = "OAuth oauth_consumer_key=\"$consumerKey\", " +
                "oauth_signature_method=\"PLAINTEXT\", " +
                "oauth_signature=\"$consumerSecret&\""

        val newRequest = originalRequest.newBuilder()
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("Authorization", authHeader)
            .build()

        return chain.proceed(newRequest)
    }
}