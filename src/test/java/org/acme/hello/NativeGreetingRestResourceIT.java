package org.acme.hello;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeGreetingRestResourceIT extends GreetingRestResourceTest {

    // Execute the same tests but in native mode.
}