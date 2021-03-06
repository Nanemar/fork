/*
 * Copyright 2019 Apple Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.shazam.fork.runner.listeners;

import com.android.ddmlib.testrunner.ITestRunListener;
import com.android.ddmlib.testrunner.TestIdentifier;
import com.shazam.fork.model.Pool;
import com.shazam.fork.runner.PoolProgressTracker;
import com.shazam.fork.runner.ProgressReporter;

import java.util.Map;

class ProgressTestRunListener implements ITestRunListener {
    private final PoolProgressTracker poolProgressTracker;

    ProgressTestRunListener(Pool pool, ProgressReporter progressReporter) {
        poolProgressTracker = progressReporter.getProgressTrackerFor(pool);
    }

    @Override
    public void testRunStarted(String runName, int testCount) {

    }

    @Override
    public void testStarted(TestIdentifier test) {

    }

    @Override
    public void testFailed(TestIdentifier test, String trace) {
        poolProgressTracker.failedTest();
    }

    @Override
    public void testAssumptionFailure(TestIdentifier test, String trace) {

    }

    @Override
    public void testIgnored(TestIdentifier test) {

    }

    @Override
    public void testEnded(TestIdentifier test, Map<String, String> testMetrics) {
        poolProgressTracker.completedTest();
    }

    @Override
    public void testRunFailed(String errorMessage) {
        poolProgressTracker.failedTestRun();
    }

    @Override
    public void testRunStopped(long elapsedTime) {

    }

    @Override
    public void testRunEnded(long elapsedTime, Map<String, String> runMetrics) {

    }
}
