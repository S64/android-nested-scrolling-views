/*
 * Copyright (C) 2017 Shuma Yoshioka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.s64.android.nestedscrollingviews.support25;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.view.View;

public class NestedCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild {

    private NestedScrollingChildHelper mHelper;

    public NestedCoordinatorLayout(Context context) {
        this(context, null);
    }

    public NestedCoordinatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        {
            mHelper = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
        }
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        boolean executedSuper = super.onStartNestedScroll(child, target, nestedScrollAxes);
        return startNestedScroll(nestedScrollAxes) || executedSuper;
    }

    @Override
    public void onStopNestedScroll(View target) {
        super.onStopNestedScroll(target);
        stopNestedScroll();
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        int[] consumedSuper = new int[2], consumedNest = new int[2];
        {
            super.onNestedPreScroll(target, dx, dy, consumedSuper);
            dispatchNestedPreScroll(dx, dy, consumedNest, null);
        }
        {
            consumed[0] = consumedSuper[0] + consumedNest[0];
            consumed[1] = consumedSuper[1] + consumedNest[1];
        }
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, null);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        boolean executedSuper = super.onNestedPreFling(target, velocityX, velocityY);
        return dispatchNestedPreFling(velocityX, velocityY) || executedSuper;
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        boolean executedSuper = super.onNestedFling(target, velocityX, velocityY, consumed);
        return dispatchNestedFling(velocityX, velocityY, consumed) || executedSuper;
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        super.setNestedScrollingEnabled(enabled);
        mHelper.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        boolean executedSuper = super.isNestedScrollingEnabled();
        return mHelper.isNestedScrollingEnabled() || executedSuper;
    }

    @Override
    public boolean startNestedScroll(int axes) {

        boolean executedSuper = super.startNestedScroll(axes);
        return mHelper.startNestedScroll(axes) || executedSuper;
    }

    @Override
    public void stopNestedScroll() {
        super.stopNestedScroll();
        mHelper.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        boolean executedSuper = super.hasNestedScrollingParent();
        return mHelper.hasNestedScrollingParent() || executedSuper;
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        boolean executedSuper = super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
        return mHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow) || executedSuper;
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        boolean executedSuper = super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
        return mHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow) || executedSuper;
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        boolean executedSuper = super.dispatchNestedFling(velocityX, velocityY, consumed);
        return mHelper.dispatchNestedFling(velocityX, velocityY, consumed) || executedSuper;
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        boolean executedSuper = super.dispatchNestedPreFling(velocityX, velocityY);
        return mHelper.dispatchNestedPreFling(velocityX, velocityY) || executedSuper;
    }

}
