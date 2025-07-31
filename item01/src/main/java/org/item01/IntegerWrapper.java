package org.item01;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IntegerWrapper implements NumberWrapper {

    private final int value;

}
