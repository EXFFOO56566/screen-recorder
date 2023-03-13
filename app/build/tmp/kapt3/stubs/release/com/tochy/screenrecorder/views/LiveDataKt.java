package com.tochy.screenrecorder.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n\u001a \u0010\u000b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a \u0010\r\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"asBackgroundTint", "", "Landroidx/lifecycle/LiveData;", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "asEnabled", "", "Landroid/view/View;", "asIcon", "asText", "asVisibility", "app_release"})
public final class LiveDataKt {
    
    /**
     * Emissions from the receiving LiveData are set as the [view]'s icon.
     */
    public static final void asIcon(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.lang.Integer> $this$asIcon, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    com.google.android.material.floatingactionbutton.FloatingActionButton view) {
    }
    
    /**
     * Emissions from the receiving LiveData are set as the [view]'s background tint.
     */
    public static final void asBackgroundTint(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.lang.Integer> $this$asBackgroundTint, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    com.google.android.material.floatingactionbutton.FloatingActionButton view) {
    }
    
    /**
     * Emissions from the receiving LiveData are set as the [view]'s text.
     */
    public static final void asText(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.lang.Integer> $this$asText, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner) {
    }
    
    /**
     * Emissions from the receiving LiveData are set as the [view]'s enabled state.
     */
    public static final void asEnabled(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.lang.Boolean> $this$asEnabled, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * Emissions from the receiving LiveData are set as the [view]'s visibility (visible or gone).
     */
    public static final void asVisibility(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.lang.Boolean> $this$asVisibility, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
}