package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.ApiKey;

public interface ApiKeyDao {
    ApiKey getApiKeyById(int id);

    void setApiKey(ApiKey apiKey);

    ApiKey updateApiKey(ApiKey apiKey);

    void deleteApiKey(ApiKey apiKey);

    ApiKey findApiKeyByApiKeyString(String apiKey);

    void deleteApiKeyById(int id);


}
