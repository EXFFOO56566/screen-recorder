package com.tochy.screenrecorder.uiterfacec.settings.sub;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016J \u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0010\u0010\bR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0013\u0010\b\u00a8\u0006\u001f"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/settings/sub/SettingsUiFragment;", "Lcom/tochy/screenrecorder/uiterfacec/settings/basesetting/MainBaseSettingsFragment;", "Lcom/tochy/screenrecorder/uiterfacec/settings/dialogsbox/TimeCallback;", "()V", "darkModeAutoPref", "Lcom/afollestad/rxkprefs/Pref;", "", "getDarkModeAutoPref", "()Lcom/afollestad/rxkprefs/Pref;", "darkModeAutoPref$delegate", "Lkotlin/Lazy;", "darkModeEndPref", "", "getDarkModeEndPref", "darkModeEndPref$delegate", "darkModePref", "getDarkModePref", "darkModePref$delegate", "darkModeStartPref", "getDarkModeStartPref", "darkModeStartPref$delegate", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onTimeSelected", "key", "hour", "", "minute", "app_release"})
public final class SettingsUiFragment extends com.tochy.screenrecorder.uiterfacec.settings.basesetting.MainBaseSettingsFragment implements com.tochy.screenrecorder.uiterfacec.settings.dialogsbox.TimeCallback {
    private final kotlin.Lazy darkModePref$delegate = null;
    private final kotlin.Lazy darkModeAutoPref$delegate = null;
    private final kotlin.Lazy darkModeStartPref$delegate = null;
    private final kotlin.Lazy darkModeEndPref$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> getDarkModePref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> getDarkModeAutoPref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.String> getDarkModeStartPref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.String> getDarkModeEndPref() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    @java.lang.Override()
    public void onTimeSelected(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int hour, int minute) {
    }
    
    public SettingsUiFragment() {
        super();
    }
}