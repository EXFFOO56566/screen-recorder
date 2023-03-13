package com.tochy.screenrecorder.uiterfacec.settings.sub;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u0007\u00a8\u0006\u001e"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/settings/sub/SettingsQualitysFragment;", "Lcom/tochy/screenrecorder/uiterfacec/settings/basesetting/MainBaseSettingsFragment;", "()V", "audioBitRatePref", "Lcom/afollestad/rxkprefs/Pref;", "", "getAudioBitRatePref", "()Lcom/afollestad/rxkprefs/Pref;", "audioBitRatePref$delegate", "Lkotlin/Lazy;", "frameRatePref", "getFrameRatePref", "frameRatePref$delegate", "recordAudioPref", "", "getRecordAudioPref", "recordAudioPref$delegate", "videoBitRatePref", "getVideoBitRatePref", "videoBitRatePref$delegate", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "setupAudioBitRatePref", "setupFrameRatePref", "setupResolutionPref", "setupVideoBitRatePref", "app_release"})
public final class SettingsQualitysFragment extends com.tochy.screenrecorder.uiterfacec.settings.basesetting.MainBaseSettingsFragment {
    private final kotlin.Lazy frameRatePref$delegate = null;
    private final kotlin.Lazy videoBitRatePref$delegate = null;
    private final kotlin.Lazy audioBitRatePref$delegate = null;
    private final kotlin.Lazy recordAudioPref$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Integer> getFrameRatePref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Integer> getVideoBitRatePref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Integer> getAudioBitRatePref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> getRecordAudioPref() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    private final void setupFrameRatePref() {
    }
    
    private final void setupResolutionPref() {
    }
    
    private final void setupVideoBitRatePref() {
    }
    
    private final void setupAudioBitRatePref() {
    }
    
    public SettingsQualitysFragment() {
        super();
    }
}