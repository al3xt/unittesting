package com.practicalunittesting.legacy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;

/**
 * Created by Alexey on 09.08.2015.
 */
@PrepareForTest(MySut.class)
@RunWith(PowerMockRunner.class)
public class MySutTest {
    @Test
    public void testMyMethod() throws Exception {
        MySut sut = new MySut();
        MyCollaborator collaborator = mock(MyCollaborator.class);
        PowerMockito.whenNew(MyCollaborator.class).withNoArguments().thenReturn(collaborator);
        // normal test using Mockito's syntax
        // e.g. Mockito.when(collaborator.someMethod()).thenReturn(...)
    }
}
