package com.chooseulike.utils;

public interface ILock {
    boolean tryLock(long timeoutSec);

    void unlock();
}
