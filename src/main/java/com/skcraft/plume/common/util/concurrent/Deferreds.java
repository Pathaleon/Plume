/*
 * SK's Minecraft Launcher
 * Copyright (C) 2010-2014 Albert Pham <http://www.sk89q.com> and contributors
 * Please see LICENSE.txt for license information.
 */

package com.skcraft.plume.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;

/**
 * Utility class for working with Deferred.
 */
public final class Deferreds {

    private Deferreds() {
    }

    /**
     * Make a new Deferred from the given future, using the same thread
     * executor as the default executor.
     *
     * @param future The future
     * @param <V> The type returned by the future
     * @return A new Deferred
     */
    public static <V> Deferred<V> makeDeferred(ListenableFuture<V> future) {
        return makeDeferred(future, MoreExecutors.newDirectExecutorService());
    }

    /**
     * Make a new Deferred from the given future.
     *
     * @param future The future
     * @param executor The default executor
     * @param <V> The type returned by the future
     * @return A new Deferred
     */
    public static <V> Deferred<V> makeDeferred(ListenableFuture<V> future, ListeningExecutorService executor) {
        return new DeferredImpl<V>(future, executor);
    }

    /**
     * Make a new Deferred from the given callable, after submitting it to the
     * given executor.
     *
     * @param callable The callable
     * @param executor The default executor
     * @param <V> The type returned by the future
     * @return A new Deferred
     */
    public static <V> Deferred<V> when(Callable<V> callable, ListeningExecutorService executor) {
        return new DeferredImpl<V>(executor.submit(callable), executor);
    }

}
