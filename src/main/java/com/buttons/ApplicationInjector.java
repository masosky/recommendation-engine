package com.buttons;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApplicationInjector {

    private static Injector injector;

    static {
        injector = Guice.createInjector();
    }

    private ApplicationInjector() {

    }

    public static Injector getInjector() {
        return injector;
    }
}
