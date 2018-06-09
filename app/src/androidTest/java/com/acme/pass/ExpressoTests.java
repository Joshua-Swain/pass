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

import org.junit.runner.RunWith;
import org.junit.Rule;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExpressoTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void weakPW() {
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
