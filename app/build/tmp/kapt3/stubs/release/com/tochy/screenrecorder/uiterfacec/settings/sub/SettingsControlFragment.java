package com.tochy.screenrecorder.uiterfacec.settings.sub;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0003J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/settings/sub/SettingsControlFragment;", "Lcom/tochy/screenrecorder/uiterfacec/settings/basesetting/MainBaseSettingsFragment;", "Lcom/tochy/screenrecorder/capturescrn/capturepermission/OverlayExplanationCallback;", "()V", "alwaysShowControlsPref", "Lcom/afollestad/rxkprefs/Pref;", "", "getAlwaysShowControlsPref", "()Lcom/afollestad/rxkprefs/Pref;", "alwaysShowControlsPref$delegate", "Lkotlin/Lazy;", "stopOnScreenOffPref", "getStopOnScreenOffPref", "stopOnScreenOffPref$delegate", "stopOnShakePref", "getStopOnShakePref", "stopOnShakePref$delegate", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onShouldAskForOverlayPermission", "setupAlwaysShowControlsPref", "setupStopOnScreenOffPref", "setupStopOnShakePref", "Companion", "app_release"})
public final class SettingsControlFragment extends com.tochy.screenrecorder.uiterfacec.settings.basesetting.MainBaseSettingsFragment implements com.tochy.screenrecorder.capturescrn.capturepermission.OverlayExplanationCallback {
    private final kotlin.Lazy stopOnScreenOffPref$delegate = null;
    private final kotlin.Lazy alwaysShowControlsPref$delegate = null;
    private final kotlin.Lazy stopOnShakePref$delegate = null;
    private static final int DRAW_OVER_OTHER_APP_PERMISSION = 68;
    public static final com.tochy.screenrecorder.uiterfacec.settings.sub.SettingsControlFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> getStopOnScreenOffPref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> getAlwaysShowControlsPref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> getStopOnShakePref() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    private final void setupAlwaysShowControlsPref() {
    }
    
    @java.lang.Override()
    public void onShouldAskForOverlayPermission() {
    }
    
    private final void setupStopOnScreenOffPref() {
    }
    
    private final void setupStopOnShakePref() {
    }
    
    public SettingsControlFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/settings/sub/SettingsControlFragment$Companion;", "", "()V", "DRAW_OVER_OTHER_APP_PERMISSION", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}