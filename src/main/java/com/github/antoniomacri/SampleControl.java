package com.github.antoniomacri;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@ApplicationScoped
public class SampleControl {
    public CompletionStage<String> getProtected() {
        return CompletableFuture.completedFuture("{}");
    }

    public CompletionStage<String> getForAnyUser() {
        return CompletableFuture.completedFuture("{}");
    }
}
