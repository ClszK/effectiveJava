package org.item03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class UniqueIdGeneratorTest {

    @Test
    void enumeration_singletonInstanceIsSame() {
        UniqueIdGenerator first = UniqueIdGenerator.INSTANCE;
        UniqueIdGenerator second = UniqueIdGenerator.INSTANCE;

        assertSame(first, second);
    }

    @Test
    void generator_initailAndSubsequentValues() {
        assertEquals(1, UniqueIdGenerator.INSTANCE.generate());
        assertEquals(2, UniqueIdGenerator.INSTANCE.generate());
        assertEquals(3, UniqueIdGenerator.INSTANCE.generate());

    }
}
