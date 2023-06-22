package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.ApiKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ApiKeyDaoImpl implements ApiKeyDao{
    EntityManager manager;
    ApiKeyDaoImpl(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public ApiKey getApiKeyById(int id) {
        return manager.find(ApiKey.class, id);
    }

    @Override
    public void setApiKey(ApiKey apiKey) {
        manager.persist(apiKey);
    }

    @Override
    @Transactional
    public void deleteApiKeyById(int id){
        ApiKey tempKey = manager.find(ApiKey.class, id);
        manager.remove(tempKey);
    }

    @Override
    @Transactional
    public ApiKey updateApiKey(ApiKey apiKey) {
        return manager.merge(apiKey);
    }

    @Override
    @Transactional
    public void deleteApiKey(ApiKey apiKey) {
        deleteApiKeyById(apiKey.getId());
    }

    @Override
    public ApiKey findApiKeyByApiKeyString(String apiKey) {
        TypedQuery<ApiKey> query = manager.createNamedQuery("SELECT FROM ApiKey WHERE key =:key", ApiKey.class);
        query.setParameter("key", apiKey);
        return query.getSingleResult();
    }
}
