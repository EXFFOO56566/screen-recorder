package com.tochy.screenrecorder.uiterfacec.settings.sub;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00048@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0015\u0010\u0007R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/settings/sub/SettingsRecordFragment;", "Lcom/tochy/screenrecorder/uiterfacec/settings/basesetting/MainBaseSettingsFragment;", "()V", "countdownPref", "Lcom/afollestad/rxkprefs/Pref;", "", "getCountdownPref", "()Lcom/afollestad/rxkprefs/Pref;", "countdownPref$delegate", "Lkotlin/Lazy;", "permissionChecker", "Lcom/tochy/screenrecorder/utilcmnuse/permissions/PermissionChecker;", "getPermissionChecker", "()Lcom/tochy/screenrecorder/utilcmnuse/permissions/PermissionChecker;", "permissionChecker$delegate", "recordAudioPref", "", "getRecordAudioPref", "recordAudioPref$delegate", "recordingsFolderPref", "", "getRecordingsFolderPref$app_debug", "recordingsFolderPref$delegate", "urlLauncher", "Lcom/tochy/screenrecorder/utilcmnuse/intents/UrlLauncher;", "getUrlLauncher", "()Lcom/tochy/screenrecorder/utilcmnuse/intents/UrlLauncher;", "urlLauncher$delegate", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "setupCountdownPref", "setupRecordAudioPref", "setupRecordingsFolderPref", "Companion", "app_debug"})
public final class SettingsRecordFragment extends com.tochy.screenrecorder.uiterfacec.settings.basesetting.MainBaseSettingsFragment {
    private final kotlin.Lazy permissionChecker$delegate = null;
    private final kotlin.Lazy urlLauncher$delegate = null;
    private final kotlin.Lazy countdownPref$delegate = null;
    private final kotlin.Lazy recordAudioPref$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy recordingsFolderPref$delegate = null;
    private static final java.lang.String HOW_TO_DEV_OPTIONS_URL = "https://developer.android.com/studio/debug/dev-options";
    public static final com.tochy.screenrecorder.uiterfacec.settings.sub.SettingsRecordFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.tochy.screenrecorder.utilcmnuse.permissions.PermissionChecker getPermissionChecker() {
        return null;
    }
    
    private final com.tochy.screenrecorder.utilcmnuse.intents.UrlLauncher getUrlLauncher() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Integer> getCountdownPref() {
        return null;
    }
    
    private final com.afollestad.rxkprefs.Pref<java.lang.Boolean> getRecordAudioPref() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.String> getRecordingsFolderPref$app_debug() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    private final void setupCountdownPref() {
    }
    
    private final void setupRecordAudioPref() {
    }
    
    private final void setupRecordingsFolderPref() {
    }
    
    public SettingsRecordFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tochy/screenrecorder/uiterfacec/settings/sub/SettingsRecordFragment$Companion;", "", "()V", "HOW_TO_DEV_OPTIONS_URL", "", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}