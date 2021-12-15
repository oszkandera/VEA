package com.VEA.TestWeb.Interface.Service;

public interface SavableService<TEntity, TViewModel> {
    public TEntity save(TViewModel model) throws Exception;
}
