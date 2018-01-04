package com.dqm.mvpframe.dagger2.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017/10/28.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApp{
}
