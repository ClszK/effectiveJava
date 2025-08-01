package org.item03;

import org.junit.jupiter.api.Test;

public class UniqueIdGeneratorTest {

    @Test
    void enumeration_singletonInstanceIsSame() {
        UniqueIdGenerator first = UniqueIdGenerator.INSTANCE;
        UniqueIdGenerator second = UniqueIdGenerator.INSTANCE;

        assertSame(first, second);
    }
}
