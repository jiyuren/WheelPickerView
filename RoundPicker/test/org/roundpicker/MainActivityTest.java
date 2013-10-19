/*
 * MainActivityTest.java
 * Creation at : 17 oct. 2013 23:38:46
*/
package org.roundpicker;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

/**
 * @author Valentin BASTIEN
 *
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new MainActivity().getResources().getString(R.string.hello_world);
        assertThat(hello, equalTo("Hello world!"));
    }
}
