package com.acme.pass;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import android.support.test.espresso.*;
import android.support.test.espresso.matcher.ViewMatchers;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.BeforeClass;
import org.junit.Test;
import android.support.test.filters.LargeTest;
import static android.support.test.espresso.Espresso.*;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import org.junit.runner.RunWith;
import org.junit.Rule;

import com.acme.pass.Validator;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExpressoTests {
    // Input text field:    passwordInput
    // Output text:         strengthOutput
    // Button:              validateButton
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void weakPW() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        //setContentView(R.layout.activity_main);

        onView(withId(R.id.passwordInput)).perform(typeText("me"));
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.strengthOutput)).check(matches(withText("Not strong enough")));
    }

    @Test
    public void strongPW() {
        onView(withId(R.id.passwordInput)).perform(typeText("Checkmate98"));
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.strengthOutput)).check(matches(withText("Strong enough")));
    }
}
