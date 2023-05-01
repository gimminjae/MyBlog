package com.bo.base.util;

import java.util.Optional;

public class Ut {
    public static <T> T getObjectElseException(Optional<T> optionalObject) {
        if(optionalObject.isPresent()) {
            return optionalObject.get();
        } else {
            throw new NullPointerException("데이터가 존재하지 않습니다.");
        }
    }
}
