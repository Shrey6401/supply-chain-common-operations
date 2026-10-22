package com.fsc.supply_chain_common_operations.Service;

public interface EntityService<T>{
    public T saveOrUpdate(T object);

}
