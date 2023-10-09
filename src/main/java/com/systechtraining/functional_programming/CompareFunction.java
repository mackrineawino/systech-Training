package com.systechtraining.functional_programming;

@FunctionalInterface
public interface CompareFunction<T,P,R> {
    R compare(T t, P p);
}
