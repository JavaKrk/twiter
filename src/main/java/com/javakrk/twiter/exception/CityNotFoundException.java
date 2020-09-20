package com.javakrk.twiter.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CityNotFoundException extends Throwable {

    public CityNotFoundException(String exception) {
        super(exception);
    }
}
