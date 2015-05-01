package com.practicalunittesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by otsukanov on 24.02.2015.
 */
public class DigitSequenceExtractorTest {

    private DigitSequenceExtractor sequenceExtractor;

    @Before
    public void setUp() throws Exception {
        sequenceExtractor = new DigitSequenceExtractor();
    }

    @Test(expected = NullPointerException.class)
    public void testNPEShouldBeThrownWhenSourceIsNull() throws Exception {
        sequenceExtractor.extract(null);
    }

    @Test
    public void testExtractTwo3DigitSequencesFromSource() throws Exception {
        String sourceWithTwo3DigitSequences = "Serial 123-%May908";
        List<String> digitSequences = sequenceExtractor.extract(sourceWithTwo3DigitSequences);
        Assert.assertEquals("Unexpected digit sequences size:", 2, digitSequences.size());
        Assert.assertEquals("123", digitSequences.get(0));
        Assert.assertEquals("908", digitSequences.get(1));
    }

    @Test
    public void testExtractTwo2DigitSequencesFromSource() throws Exception {
        String sourceWithTwo2DigitSequences = "Serial 12-%May90";
        List<String> digitSequences = sequenceExtractor.extract(
                sourceWithTwo2DigitSequences
        );
        Assert.assertEquals(0, digitSequences.size());
    }

    @Test
    public void testExtractTwo4DigitSequencesFromSource() throws Exception {
        String sourceWithTwo4DigitSequencesAndOne2DigitSequence = "Serial 1234-%May9087_77";
        List<String> digitSequences = sequenceExtractor.extract(
                sourceWithTwo4DigitSequencesAndOne2DigitSequence
        );
        Assert.assertEquals("Unexpected digit sequences size:", 2, digitSequences.size());
        Assert.assertEquals("1234", digitSequences.get(0));
        Assert.assertEquals("9087", digitSequences.get(1));
    }
}
