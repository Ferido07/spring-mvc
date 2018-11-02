package com.fyzapps.springmvc.services;

import com.fyzapps.springmvc.domain.DomainObject;

import java.util.*;

public abstract class AbstractMapService {

    protected Map<Integer,DomainObject> map;

    public AbstractMapService() {
        map = new HashMap<>();
        loadDomainObjects();
    }

    public List<DomainObject> listAll(){
        return new ArrayList<>(map.values());
    }

    public DomainObject getById(Integer id){
        return map.get(id);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject){
        if(domainObject != null){
            if(domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            map.put(domainObject.getId(),domainObject);
            return domainObject;
        }
        else throw new RuntimeException("Object can not be null");
    }

    private Integer getNextKey() {
        return Collections.max(map.keySet()) + 1;
    }

    public void delete(Integer id){
        map.remove(id);
    }

    protected abstract void loadDomainObjects();
}
