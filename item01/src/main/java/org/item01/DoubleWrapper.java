package org.item01;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DoubleWrapper implements NumberWrapper {

    private final double value;

}
