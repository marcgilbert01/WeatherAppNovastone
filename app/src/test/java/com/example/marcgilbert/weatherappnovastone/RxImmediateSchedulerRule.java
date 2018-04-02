package com.example.marcgilbert.weatherappnovastone;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class RxImmediateSchedulerRule implements TestRule {

    private final Scheduler immediate = new Scheduler() {
        @Override
        public Worker createWorker() {
            return new ExecutorScheduler.ExecutorWorker(new ScheduledThreadPoolExecutor(1) {
                @Override
                public void execute(@NonNull Runnable runnable) {
                    runnable.run();
                }
            });
        }
    };

    @Override
    public Statement apply(final Statement base, Description d) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull Scheduler scheduler) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
                RxJavaPlugins.setComputationSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull Scheduler scheduler) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
                RxJavaPlugins.setNewThreadSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull Scheduler scheduler) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
                RxJavaPlugins.setSingleSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull Scheduler scheduler) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
                RxAndroidPlugins.setMainThreadSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@NonNull Scheduler scheduler) throws Exception {
                        return immediate;
                    }
                });

                try {
                    base.evaluate();
                } finally {
                    RxJavaPlugins.reset();
                    RxAndroidPlugins.reset();
                }
            }
        };
    }
}
