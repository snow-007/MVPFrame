package com.dqm.mvpframe.dagger2.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017/10/28.
 */
@Documented
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
