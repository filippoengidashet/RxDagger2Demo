package org.dalol.rxdaggerdemo.dependencies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 3/19/2016
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
