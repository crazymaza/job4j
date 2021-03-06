package ru.job4j.benchmark;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoSegmentsTest {
    @Test
    public void whenTwoSegmentsTogether() {
        TwoSegments twoSegments = new TwoSegments();
        int[] arr1 = {4, 1, 2, 6};
        boolean result = twoSegments.beOrNot(arr1);
        assertThat(result, is(true));
    }

//    @Test
//    public void whenTwoSegmentsNotTogether() {
//        TwoSegments twoSegments = new TwoSegments();
//        int[] arr1 = {5, 1, 4, 7};
//        boolean result = twoSegments.beOrNot(arr1);
//        assertThat(result, is(false));
//    }

    @Test
    public void whenOneSegmentIsCompletelyInAnotherSegment() {
        TwoSegments twoSegments = new TwoSegments();
        int[] arr1 = {8, 1, 3, 7};
        boolean result = twoSegments.beOrNot(arr1);
        assertThat(result, is(true));
    }
}
